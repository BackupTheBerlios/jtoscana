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
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USApackage de.berlios.jtoscana.network;
*/
package de.berlios.jtoscana.network;

import de.berlios.jtoscana.model.Board;
import de.berlios.jtoscana.model.SimpleStock;
import de.berlios.jtoscana.model.Stock;
import de.berlios.jtoscana.model.TileColor;

/**
 * @author Michael Greifeneder
 */
public class Game {

	private int id;
	private String userOne;
	private String userTwo;
	
	private Stock stockOne;
	private Stock stockTwo;
	private Board board;
	/**
	 * 
	 */
	public Game(int id, String userOne, String userTwo) {
		this.id = id;
		this.userOne = userOne;
		this.userTwo = userTwo;
		stockOne = new SimpleStock(TileColor.GREY);
		stockTwo = new SimpleStock(TileColor.RED);
		board = new Board();
	}
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getUserTwo() {
		return userTwo;
	}

	/**
	 * @return
	 */
	public String getUserOne() {
		return userOne;
	}

	/**
	 * @return
	 */
	public Board getBoard() {
		return board;
	}

}
