/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JPanel;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import model.Board;
import model.TileColor;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BoardView extends JPanel {

	private static final Logger logger = Logger.getLogger(BoardView.class);
	
	private Board board; 
	/**
	 * 
	 */	
	public BoardView(Board board) {
		super();
		this.board = board;
		setBackground(Color.WHITE);
		
	}
	
	public Board getBoard() {
		return board;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.Component#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		logger.debug("paint called");
		super.paint(g);
		Dimension dim = g.getClipBounds().getSize();
		logger.debug("width= " + dim.width);
		logger.debug("height= " + dim.height);
		
		int w = dim.width / 17;
		logger.debug("one column: " + w);
		
		int h = dim.height / 17;
		logger.debug("one row: " + h);
		
		paintGrid(g, w, h);
	
		paintTiles(g, w, h);			
	}
	
	
	private void paintGrid(Graphics g, int w, int h) {
		for (int i = 1; i <= 17; i++) {
			g.drawLine(0, h*i,  g.getClipBounds().getSize().width, h*i); //hort
			g.drawLine(w * i, 0, w * i, g.getClipBounds().getSize().height); //vert	
		}
	}
	private void paintTiles(Graphics g, int w, int h) {
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 17; j++) {
				TileColor c = board.getField(i, j);
				if ( c.equals(TileColor.GREEN) ) { 
					paintField(g, w,  h, i, j, Color.GREEN);
				}
				if ( c.equals(TileColor.GREY) ) { 
					paintField(g, w, h, i, j, Color.GRAY);
				}
				if ( c.equals(TileColor.RED) ) { 
					paintField(g, w, h, i, j, Color.RED);
				}
			}
		}
	}
	
	private void paintField(Graphics g,  int w, int h, int x, int y, Color color) { 
		logger.debug("paintField: x=" +x + "y=" + y);
		g.setColor(color);
		int a = x*w +1;
		int b = h* y + 1;
		int c =  w -1;
		int d =  h -1;
		logger.debug("a=" + a + ";b=" + b + ";c=" + c  + ";d=" + d);
		g.fillRect(a,b,c,d);
	}
	
}
