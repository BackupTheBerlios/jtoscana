/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import view.StockListener;

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
