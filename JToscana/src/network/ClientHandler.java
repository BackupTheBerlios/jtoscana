/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package network;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ClientHandler implements Runnable {

	private static final Logger logger = Logger.getLogger(ClientHandler.class);
	
	private InputStream is;
	private OutputStream os;
	private SimpleServer server;
	
	private static final String terminator = "\r\n"; 
	/**
	 * 
	 */
	public ClientHandler(SimpleServer server, InputStream is, OutputStream os) {
		this.server = server;
		this.is = is;
		this.os = os;
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	public void run() {
		try {
			answer("Toscana Server Hello! " + server.getOnlineUsers() + "online!");
			
			handleClient();
				
		} catch (Exception e) {
			logger.info("Client terminated");
		}
	}
	
	private void answer(String s) throws IOException {
		os.write((s + terminator).getBytes());
	}
	
	private void handleClient() throws IOException {
		StringBuffer buf = new StringBuffer();
		while(true) {
			int i = is.read();
			if (i == -1) {
				throw new EOFException();
			}
			if (i != '\r') {
				buf.append(i);
			}
			if (i == '\n') {
				interpret(buf.toString());
			}
		}
	}
	
	public void interpret(String line) {
		int i = line.indexOf(" ");
		if (i == -1) {
			i = line.length();
		}
		String cmd = line.substring(0, i);
		String param = "";
		if (i < line.length()) {
			param = line.substring(i+1);	
		}
		 map.get(cmd);
		 
	}
	
	private static HashMap map = new HashMap();
	
	static {
		map.put("USERS", new UserCommand());
		map.put("STATE", new StateCommand());
	}
	
	
	
	private static interface Command {
		public void interpret(ClientHandler h,  String params) throws IOException;
	}
	
	private static class UserCommand implements Command {
		public void interpret(ClientHandler h, String params) throws IOException {
			String[] users = h.server.getOnlineUsers();
			for (int i = 0; i < users.length; i++) {
				String string = users[i];
				h.answer(string);
				h.answer("");	
			}
		}
	}
	
	private static class StateCommand implements Command {
		public void interpret(ClientHandler h,  String params) throws IOException {
			h.answer("NONE");
		}
	}
}
