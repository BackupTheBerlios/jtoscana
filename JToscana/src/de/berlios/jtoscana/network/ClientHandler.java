/** 
   This file is part of JToscana.
	JToscana is free software; you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation; either version 2 of the License, or
	(at your option) any later version.
	Foobar is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	You should have received a copy of the GNU General Public License
	along with Foobar; if not, write to the Free Software
	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USApackage network;
*/
package de.berlios.jtoscana.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import de.berlios.jtoscana.model.Board;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ClientHandler implements Runnable {

	private static final Logger logger = Logger.getLogger(ClientHandler.class);
	
	private String user;
	private InputStream is;
	private String message;
	private OutputStream os;
	private GameController controller;
	
	private static final String terminator = "\r\n"; 
	/**
	 * 
	 */
	public ClientHandler(String message, GameController controller, InputStream is, OutputStream os) {
		this.message = message;
		this.controller = controller;
		this.is = is;
		this.os = os;
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	public void run() {
		try {
			handleClient();
		} catch (Exception e) {
			logger.info("Client terminated");
		}
	}
	
	
	private void handleClient() throws IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(os);
		ObjectInputStream ois = new ObjectInputStream(is);
		while (true) {
			Object o = ois.readObject();
			if (o instanceof LoginRequest) {
				LoginRequest lr = (LoginRequest) o;
				user = lr.getUsername();
				if (controller.register(this, user)) {
					oos.writeObject(new LoginResponse(true, message));
				}
				else {
					oos.writeObject(new LoginResponse(false, "Already user with same name connected"));
				}
			}
			if (o instanceof UserRequest) {
				oos.writeObject(new UserResponse(controller.getPendingUsers()));
			}
			if (o instanceof GameStartRequest) {
				GameStartRequest gsr = (GameStartRequest) o;
				String enemy = gsr.getUser();
				int id = controller.requestGame(user, enemy); 
				if (id  != -1) {
					oos.writeObject(new GameStartResponse(id, true));
				}
				else {
					oos.writeObject(new GameStartResponse(-1, false));
				}
			}
			if (o instanceof BoardRequest) {
				BoardRequest br = (BoardRequest) o;
				int id = br.getIdOfGame();
				Board board = controller.getGameById(id).getBoard();
				oos.writeObject(new BoardResponse(board));
			}
			if (o instanceof StatusRequest) {
				oos.writeObject(getResponse());
			}
			if (o instanceof GameStartResponse) {
				GameStartResponse gsr =  (GameStartResponse)o;
				synchronized (this) {
					answer = o;
					notifyAll();
				}
				oos.writeObject(new EmptyResponse());
			}
		}
	}
	
	private ArrayList pendingResponses = new ArrayList();
	private Object answer = null;
	
	public Object addResponseAndWait(Object o) {
		synchronized(pendingResponses) {
			pendingResponses.add(o);
		}
		synchronized (this) {
			while (answer == null) {
				try {
					wait();	
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return answer;
		}
	}
	
	private synchronized Object getResponse() {
		if (pendingResponses.size() == 0 ) {
			return new EmptyResponse();
		}
		return pendingResponses.remove(0);
	}
	
}
