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
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USApackage de.berlios.jtoscana.network;
*/
package de.berlios.jtoscana.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.berlios.jtoscana.model.Board;

/**
 * @author Michael Greifeneder
 */
public class SimpleClient  {

	private Socket socket;
	private ObjectInputStream is;
	private ObjectOutputStream os;
	/**
	 * 
	 */
	public SimpleClient() {
		super();
		
	}

	/* (non-Javadoc)
	 * @see de.berlios.jtoscana.network.Client#connect(java.lang.String, int)
	 */
	public void connect(String host, int port)  throws IOException {
		socket = new Socket(host, port);
		is = new ObjectInputStream(socket.getInputStream());
		os = new ObjectOutputStream(socket.getOutputStream());
	}
	
	public String login(String username) throws IOException, ClassNotFoundException, ServerException  {
		os.writeObject(new LoginRequest(username));
		Object o = is.readObject();
		if (o instanceof LoginResponse) {
			LoginResponse lr = (LoginResponse) o;
			if (! lr.isUserAccepted()) {
				throw new ServerException("Try another username");
			}
			return lr.getServerHallo();
		}else {
			throw new ServerException("LoginResponse expected - get: " + o.getClass().getName());
		}
	}

	/* (non-Javadoc)
	 * @see de.berlios.jtoscana.network.Network#getPendingUsers()
	 */
	public String[] getPendingUsers() throws IOException, ClassNotFoundException, ServerException {
		os.writeObject(new UserRequest());
		Object o = is.readObject();
		if (o instanceof UserResponse) {
			UserResponse ur = (UserResponse) o;
			return ur.getUsers();
		}
		else {
			throw new ServerException("UserResponse expected - get:" + o.getClass().getName());
		}
		
	}

	/* (non-Javadoc)
	 * @see de.berlios.jtoscana.network.Client#startGame(java.lang.String)
	 */
	public void startGame(String user) throws IOException, ClassNotFoundException, ServerException {
		os.writeObject(new GameStartRequest(user));
		Object o = is.readObject();
		if (o instanceof GameStartResponse) {
			GameStartResponse gsr = (GameStartResponse) o;
			if (! gsr.isAccepted()) {
				throw new ServerException("User denied starting game");
			}
		}
	}
	
	public Board getBoard(int id) throws IOException, ClassNotFoundException, ServerException {
			os.writeObject(new BoardRequest(id));
			Object o = is.readObject();
			if (o instanceof BoardResponse) {
				BoardResponse br = (BoardResponse) o;
				return br.getBoard();
			}		
			throw new ServerException("Not a BoardResponse - get: " + o.getClass().getName());
	}

	private int gameId;
	
	public String waitForGame() throws IOException, ClassNotFoundException, ServerException {
		while(true) {
			os.writeObject(new StatusRequest());
			Object o = is.readObject();
			if (o instanceof EmptyResponse) {
				continue;
			}
			if (o instanceof GameStartRequest) {
				GameStartRequest gsr = (GameStartRequest) o;
				gameId = gsr.getId();
				return gsr.getUser();
			}
			throw new ServerException("Not a Empty or GameStart Anser - get: " + o.getClass().getName());
		}		
	}
	
	public void accept() throws IOException, ClassNotFoundException {
		os.writeObject(new GameStartResponse(gameId, true));
		is.readObject();
	}
	
	public void refused() throws IOException, ClassNotFoundException  {
		os.writeObject(new GameStartResponse(gameId, false));
		is.readObject();
	}

	/* (non-Javadoc)
	 * @see de.berlios.jtoscana.network.Network#isOnline()
	 */
	public boolean isOnline() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.berlios.jtoscana.network.Network#reconnect()
	 */
	public void reconnect() {
		// TODO Auto-generated method stub

	}

}
