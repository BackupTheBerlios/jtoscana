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

import org.apache.log4j.Logger;


/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Board {
	private static final Logger logger = Logger.getLogger(Board.class);
	
	private TileColor[][] board = new TileColor[17][17];
	
	private Tile[][] tiles = new Tile[17][17];

	private static final int GREEN = 0;
	private static final int GREY = 1;
	private static final int RED = 2;

	public void addTile(int x, int y, Tile tile ) throws GameException {
	  //TODO: checkPosition	
	  tiles[x][y] = tile;
	  setTileColorOnBoard(x, y, tile); 
	}
	
	private void setBoard() throws GameException {
			for (int i = 0; i < 17; i++) {
				for (int j = 0; j <17; j++) {
					Tile t = tiles[i][j];
					setTileColorOnBoard(i, j, t);
				}
			}
	}

	private void setTileColorOnBoard(int x, int y, Tile t) throws GameException {
		logger.debug("x=" + x + ";y=" + y + ";Tile=" + t.getTopLeft());
		boolean[] ts = t.getTiles();
		if (t != null) {
			int c = t.getTopLeft();
			if (c == 0) {
				setBoardColor(x, y,  ts[0] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 1, y,  ts[1] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 2, y,  ts[2] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 3, y,  ts[3] ? t.getColor() : t.getOppositeColor());
							
				setBoardColor(x, y +1,  ts[4] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +1, y +1,  ts[5] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +2, y + 1,  ts[6] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +3, y + 1,  ts[7] ? t.getColor() : t.getOppositeColor());
			}
			if (c == 3) { // vert
				setBoardColor(x, y,  ts[3] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 1, y,  ts[7] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x,  y +1,  ts[2] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 1, y +1 ,  ts[6] ? t.getColor() : t.getOppositeColor());
							
				setBoardColor(x, y +2,  ts[1] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +1, y +2,  ts[5] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x, y + 3,  ts[0] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +1, y + 3,  ts[4] ? t.getColor() : t.getOppositeColor());
			}
			if (c == 4) { //vert
				setBoardColor(x, y,  ts[4] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 1, y,  ts[0] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x,  y +1,  ts[5] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 1, y +1 ,  ts[1] ? t.getColor() : t.getOppositeColor());
							
				setBoardColor(x, y +2,  ts[6] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +1, y +2,  ts[2] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x, y + 3,  ts[7] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +1, y + 3,  ts[3] ? t.getColor() : t.getOppositeColor());
			}
			if (c == 7) { //horiz
				setBoardColor(x, y,  ts[7] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 1, y,  ts[6] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 2, y,  ts[5] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x + 3, y,  ts[4] ? t.getColor() : t.getOppositeColor());
							
				setBoardColor(x, y +1,  ts[3] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +1, y +1,  ts[2] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +2, y + 1,  ts[1] ? t.getColor() : t.getOppositeColor());
				setBoardColor(x +3, y + 1,  ts[0] ? t.getColor() : t.getOppositeColor());
			}
		}
	
	}
	
	private void setBoardColor(int x, int y, TileColor color) throws GameException {
		if ( ! board[x][y].equals(TileColor.GREEN)) {
			//not grey!!!
			throw new GameException();
		}
		board[x][y] =color; 
	}	
	
	public Board() {
		init();
	}	


	private void init() {
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 17; j++) {
				board[i][j] = TileColor.GREEN;
			}
			
		}
	}
	public TileColor getField(int x, int y) {
			return board[x][y];
	}
	
	
}
