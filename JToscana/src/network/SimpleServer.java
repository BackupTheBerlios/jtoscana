/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SimpleServer implements Server {

	/**
	 * 
	 */
	public SimpleServer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see network.Server#start(int)
	 */
	public void start(int port) throws IOException {
		ServerSocket server = new ServerSocket(port);
		
		while(true) {
			Socket s = server.accept();
			
			
		}
	}

	/* (non-Javadoc)
	 * @see network.Network#getOnlineUsers()
	 */
	public String[] getOnlineUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see network.Network#isOnline()
	 */
	public boolean isOnline() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see network.Network#reconnect()
	 */
	public void reconnect() {
		// TODO Auto-generated method stub

	}

}
