/*
 * Created on Dec 22, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package de.berlios.jtoscana.model;


import java.util.List;

import junit.framework.TestCase;
import de.berlios.jtoscana.model.SimpleStock;
import de.berlios.jtoscana.model.Tile;
import de.berlios.jtoscana.model.TileColor;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SimpleStockTest extends TestCase {

	/**
	 * Constructor for SimpleStockTest.
	 * @param arg0
	 */
	public SimpleStockTest(String arg0) {
		super(arg0);
	}
	
	public void testContruct() {
		List list = SimpleStock.generateStock(TileColor.RED);
	    
	    Tile tile = (Tile) list.get(0);
	    assertEquals(false, tile.getTiles()[0]);
		assertEquals(false, tile.getTiles()[1]);
		assertEquals(true, tile.getTiles()[2]);
		assertEquals(true, tile.getTiles()[3]);
		assertEquals(true, tile.getTiles()[4]);
		assertEquals(true, tile.getTiles()[5]);
		assertEquals(true, tile.getTiles()[6]);
		assertEquals(true, tile.getTiles()[7]);
		
		tile = (Tile) list.get(1);
		assertEquals(false, tile.getTiles()[0]);
		assertEquals(true, tile.getTiles()[1]);
		assertEquals(false, tile.getTiles()[2]);
		assertEquals(true, tile.getTiles()[3]);
		assertEquals(true, tile.getTiles()[4]);
		assertEquals(true, tile.getTiles()[5]);
		assertEquals(true, tile.getTiles()[6]);
		assertEquals(true, tile.getTiles()[7]);

		tile = (Tile) list.get(2);
		assertEquals(false, tile.getTiles()[0]);
		assertEquals(true, tile.getTiles()[1]);
		assertEquals(true, tile.getTiles()[2]);
		assertEquals(false, tile.getTiles()[3]);
		assertEquals(true, tile.getTiles()[4]);
		assertEquals(true, tile.getTiles()[5]);
		assertEquals(true, tile.getTiles()[6]);
		assertEquals(true, tile.getTiles()[7]);
		
		//TODO: test all tiles
/*				
		assertEquals(, tile.getTiles()[0]);
				assertEquals(, tile.getTiles()[1]);
				assertEquals(, tile.getTiles()[2]);
				assertEquals(, tile.getTiles()[3]);
				assertEquals(, tile.getTiles()[4]);
				assertEquals(, tile.getTiles()[5]);
				assertEquals(, tile.getTiles()[6]);
				assertEquals(, tile.getTiles()[7]);
				
		assertEquals(, tile.getTiles()[0]);
				assertEquals(, tile.getTiles()[1]);
				assertEquals(, tile.getTiles()[2]);
				assertEquals(, tile.getTiles()[3]);
				assertEquals(, tile.getTiles()[4]);
				assertEquals(, tile.getTiles()[5]);
				assertEquals(, tile.getTiles()[6]);
				assertEquals(, tile.getTiles()[7]);

		assertEquals(, tile.getTiles()[0]);
				assertEquals(, tile.getTiles()[1]);
				assertEquals(, tile.getTiles()[2]);
				assertEquals(, tile.getTiles()[3]);
				assertEquals(, tile.getTiles()[4]);
				assertEquals(, tile.getTiles()[5]);
				assertEquals(, tile.getTiles()[6]);
				assertEquals(, tile.getTiles()[7]);
		assertEquals(, tile.getTiles()[0]);
				assertEquals(, tile.getTiles()[1]);
				assertEquals(, tile.getTiles()[2]);
				assertEquals(, tile.getTiles()[3]);
				assertEquals(, tile.getTiles()[4]);
				assertEquals(, tile.getTiles()[5]);
				assertEquals(, tile.getTiles()[6]);
				assertEquals(, tile.getTiles()[7]);
		assertEquals(, tile.getTiles()[0]);
				assertEquals(, tile.getTiles()[1]);
				assertEquals(, tile.getTiles()[2]);
				assertEquals(, tile.getTiles()[3]);
				assertEquals(, tile.getTiles()[4]);
				assertEquals(, tile.getTiles()[5]);
				assertEquals(, tile.getTiles()[6]);
				assertEquals(, tile.getTiles()[7]);
		assertEquals(, tile.getTiles()[0]);
				assertEquals(, tile.getTiles()[1]);
				assertEquals(, tile.getTiles()[2]);
				assertEquals(, tile.getTiles()[3]);
				assertEquals(, tile.getTiles()[4]);
				assertEquals(, tile.getTiles()[5]);
				assertEquals(, tile.getTiles()[6]);
				assertEquals(, tile.getTiles()[7]);
		assertEquals(, tile.getTiles()[0]);
				assertEquals(, tile.getTiles()[1]);
				assertEquals(, tile.getTiles()[2]);
				assertEquals(, tile.getTiles()[3]);
				assertEquals(, tile.getTiles()[4]);
				assertEquals(, tile.getTiles()[5]);
				assertEquals(, tile.getTiles()[6]);
				assertEquals(, tile.getTiles()[7]);
		assertEquals(, tile.getTiles()[0]);
				assertEquals(, tile.getTiles()[1]);
				assertEquals(, tile.getTiles()[2]);
				assertEquals(, tile.getTiles()[3]);
				assertEquals(, tile.getTiles()[4]);
				assertEquals(, tile.getTiles()[5]);
				assertEquals(, tile.getTiles()[6]);
				assertEquals(, tile.getTiles()[7]);
	
								*/							
	}

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(SimpleStockTest.class);
	}

}
