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

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SimpleServer implements Runnable {
	private static final Logger logger = Logger.getLogger(SimpleServer.class);
	private GameController gc = new GameController();
	private int port;
	
	private ServerSocket serverSocket;
	private String message;
	private boolean finished = false;
	
	/**
	 * 
	 */
	public SimpleServer(int port, String message) {
		this.port = port;
		this.message = message;
	}
	
	public SimpleServer(int port) {
			this(port, "A hello from the JToscana Server ");
	}
	
	
	public void run()  {
		try {
			serverSocket = new ServerSocket(port);
		
			while(true) {
				Socket s = serverSocket.accept();
				ClientHandler h = new ClientHandler(message, gc, s.getInputStream(), s.getOutputStream());
				h.start();
			}
			
			
		} catch (Throwable t) {
			logger.error("Server finished with error", t);
		}
		synchronized(this) {
			finished = true;
			notifyAll();
		}
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	public void stop() {
		try {
			serverSocket.close();
		} catch (Exception e) {
			logger.warn("Stopping server failed");			
		}
		synchronized(this) {
			while (! finished) {
			  try {
					wait();
				} catch (Exception e) {
				}	
			}
		}
	}

}
