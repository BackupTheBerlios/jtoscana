package model;

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
