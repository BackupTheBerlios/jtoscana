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

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Michael Greifeneder
 */
public class AllTests {

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(AllTests.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for network");
		//$JUnit-BEGIN$
		suite.addTest(new TestSuite(SimpleClientTest.class));
		suite.addTest(new TestSuite(ClientHandlerTest.class));
		suite.addTest(new TestSuite(GameControllerTest.class));
		//$JUnit-END$
		return suite;
	}
}
