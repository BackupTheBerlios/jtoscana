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
package de.berlios.jtoscana.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import de.berlios.jtoscana.view.StockListener;


/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SimpleStock implements Stock {

	private Random random = new Random();
	private List tiles = new ArrayList();
	
	public SimpleStock(TileColor color) {
		tiles = generateStock(color);
		getNextTile();
	}
		
		
	private Tile visibleTile;
	/* (non-Javadoc)
	 * @see model.Stock#nextTile()
	 */
	public Tile getNextTile() {
		Tile ret = visibleTile;
		if (tiles.size() == 0) {
			visibleTile = null;
		}
		else {
			visibleTile =  (Tile) tiles.remove(random.nextInt(tiles.size()));
			visibleTile.setTopLeft(3);
			
		}
		return ret;
	}
	
	public Tile getVisibleTile() {
		return visibleTile;
	}
	
	
	public static List generateStock(TileColor color) {
		ArrayList tiles = new ArrayList(16);
		for (int i = 0; i < 7; i++) {
			tiles.add(new TileImpl(color, 0, i+1));
		}
		for (int i = 0; i < 5; i++) {
			tiles.add(new TileImpl(color, 1, i+2));
		}
		for (int i = 0; i < 3; i++) {
			tiles.add(new TileImpl(color, 2, i+3));
		}
		 tiles.add(new TileImpl(color, 3,4));
		return tiles;	
	}
	
	TreeSet stockListener = new TreeSet();
	
	public void addStockListener(StockListener l) {
		stockListener.add(l);
	}
	public void removeStockListener(StockListener l) {
		stockListener.remove(l);
	}
	 
}
