/*
 * Created on Dec 23, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AllTests {

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(AllTests.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for model");
		//$JUnit-BEGIN$
		suite.addTest(new TestSuite(SimpleStockTest.class));
		suite.addTest(new TestSuite(BoardTest.class));
		//$JUnit-END$
		return suite;
	}
}
