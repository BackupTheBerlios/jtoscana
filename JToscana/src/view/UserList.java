/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import network.Server;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserList  extends JPanel {
	private static final Logger logger = Logger.getLogger(UserList.class);
	private Server server;
	/**
	 * 
	 */
	public UserList(Server server) {
		super();
		this.server = server;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		super.paint(g);
		String[] user = server.getOnlineUsers();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < user.length; i++) {
			String string = user[i];
			buf.append(string);
			buf.append(", ");
		}
		Font font = new Font("Dialog", Font.PLAIN, 12);
		g.setColor(Color.BLACK);  
		g.setFont(font);
		
		logger.debug(buf.toString());
		g.drawString(buf.toString().substring(0, buf.toString().length()-2), 0, g.getClipBounds().height-5);
	}

}