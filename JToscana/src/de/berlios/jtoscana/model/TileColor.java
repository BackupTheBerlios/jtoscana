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
