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

import org.apache.log4j.Logger;

import junit.framework.TestCase;
import de.berlios.jtoscana.Log4j;

/**
 * @author Michael Greifeneder
 */
public class SimpleClientTest extends TestCase {
	private static final Logger logger = Logger.getLogger(SimpleClientTest.class);
	/**
	 * Constructor for SimpleClientTest.
	 * @param arg0
	 */
	public SimpleClientTest(String arg0) {
		super(arg0);
	}
	
	
	private int port = 56666;
	public void testConnect() throws Exception {
		Log4j.init();
		SimpleServer server = new SimpleServer(port, "Test");
		server.start();
		
		SimpleClient m = new SimpleClient();
		m.connect("localhost", port);
		assertEquals("Test", m.login("mike"));
		
		SimpleClient l = new SimpleClient();
		l.connect("localhost", port);
		assertEquals("Test", l.login("lucy"));
		
		String[] users = l.getPendingUsers();
		assertEquals("mike", users[0]);
	
		server.stop();
		
	}
	
	public void testAlreadyUser() throws Exception  {
		Log4j.init();
		SimpleServer server = new SimpleServer(port, "Test");
		server.start();
		
		SimpleClient m = new SimpleClient();
		m.connect("localhost", port);
		assertEquals("Test", m.login("mike"));
		
		SimpleClient l = new SimpleClient();
		l.connect("localhost", port);
		try {
			l.login("mike");
			fail("user already connected");
		} catch (Exception e) {
			// TODO: handle exception
		}
		server.stop();
	
	}
	
	public void testStartGame() throws Exception {
		Log4j.init();
		SimpleServer server = new SimpleServer(port, "Test");
		server.start();
		
		final SimpleClient m = new SimpleClient();
		m.connect("localhost", port);
		assertEquals("Test", m.login("mike"));
		
		new Thread(new Runnable() {
			public void run() {
				try {
					m.waitForGame();	
					m.accept();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}).start();
		
		SimpleClient l = new SimpleClient();
		l.connect("localhost", port);
		assertEquals("Test", l.login("lucy"));
		
		String[] users = l.getPendingUsers();
		assertEquals("mike", users[0]);
		
		l.startGame("mike");
	 
		server.stop();
	
	}

	public static void main(String[] args) {
	}

}
