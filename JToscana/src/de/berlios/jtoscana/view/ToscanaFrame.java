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
package de.berlios.jtoscana.view;

import java.util.Random;

import javax.swing.JFrame;


import org.apache.log4j.Logger;

import de.berlios.jtoscana.model.Board;
import de.berlios.jtoscana.model.SimpleStock;
import de.berlios.jtoscana.model.Stock;
import de.berlios.jtoscana.model.TileColor;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ToscanaFrame extends JFrame {
	private static final Logger logger = Logger.getLogger(ToscanaFrame.class);

	private Random random = new Random();
	public ToscanaFrame() {
		super("JToscana");
		//getContentPane().setLayout(null);
		//getContentPane().add(new BoardView(new Board()));
		final Board board = new Board();
		final Stock stock = new SimpleStock(TileColor.GREY);
		//final DeskView view = new DeskView( new BoardView(board), new UserList(new DummyServer()), new StockView(stock ), new StockView(stock));
		/*
		view.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				//view.next();
				try {
					Tile t = stock.nextTile();
					t.setTopLeft(3);
					board.addTile(random.nextInt(16), random.nextInt(16), t);
					view.repaint();
						
				} catch (Exception e) {
					logger.error("", e);
				}
				
			}
		});

*/
		//getContentPane().add(view);
		//this.setContentPane(view);
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
	}
	
}
