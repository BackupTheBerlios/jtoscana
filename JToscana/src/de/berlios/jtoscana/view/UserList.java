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
package de.berlios.jtoscana.view;

import javax.swing.JPanel;

import org.apache.log4j.Logger;


/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserList extends JPanel {
	private static final Logger logger = Logger.getLogger(UserList.class);
	//private Server server;
	/**
	 * 
	 */
	/*
	public UserList(Server server) {
		super();
		this.server = server;
	}
	*/

	/* (non-Javadoc)
	 * @see java.awt.Component#paint(java.awt.Graphics)
	 */
	 /*
	public void paint(Graphics g) {
		super.paint(g);
		String[] user = server.getPendingUsers();
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
		g.drawString(
			buf.toString().substring(0, buf.toString().length() - 2),
			0,
			g.getClipBounds().height - 5);
	}
*/
}