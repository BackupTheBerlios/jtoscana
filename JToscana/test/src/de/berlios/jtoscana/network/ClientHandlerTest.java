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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import junit.framework.TestCase;

/**
 * @author Michael Greifeneder
 */
public class ClientHandlerTest extends TestCase {

	/**
	 * Constructor for ClientHandlerTest.
	 * @param arg0
	 */
	public ClientHandlerTest(String arg0) {
		super(arg0);
	}
	
	public void testPendingUsers() {
		/*
		ByteArrayOutputStream tos = new ByteArrayOutputStream();
		
		ByteArrayInputStream bis = new ByteArrayInputStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		ClientHandler h = new ClientHandler("", new GameController(), bis, bos);
		*/
	}

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(ClientHandlerTest.class);
	}

}
