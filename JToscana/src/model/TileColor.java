/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;

import java.awt.Color;


/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TileColor {

	private static final int green = 0;
	private static final int grey = 1;
	private static final int red = 2;
		
	private int color;
	
	private TileColor(int c) {
		this.color = c;
	}
	
	public static final TileColor GREEN = new TileColor(green);
	public static final TileColor GREY = new TileColor(grey);
	public static final TileColor RED  = new TileColor(red);

	public int getColor() {
		return color;
	}
	
	public static TileColor resolve(int c) {
		if (c == green) {
			return GREEN;
		}	
		if (c == grey) {
			return GREY;
		}
		if (c == red) {
			return RED;
		}
		return null;
	}

	public Color getPaintColor() {
		if (color == green) {
			return Color.GREEN;
		}	
		if (color == grey) {
			return Color.GRAY;
		}
		if (color == red) {
			return Color.RED;
		}
		return null;
	}	
	
}
