/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface Tile {
	/**
	 * @return
	 */
	public boolean[] getTiles();
	/**
	 * @return
	 */
	public int getTopLeft();
	/**
	 * @param i
	 */
	public void setTopLeft(int i);
	
	public TileColor getColor();
	public TileColor getOppositeColor();
	
	public void rotateLeft();
	public void rotateRight(); 
}