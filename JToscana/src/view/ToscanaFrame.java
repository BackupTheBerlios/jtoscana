/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package view;

import java.util.Random;

import javax.swing.JFrame;

import model.Board;
import model.SimpleStock;
import model.Stock;
import model.TileColor;
import network.DummyServer;

import org.apache.log4j.Logger;

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
		final DeskView view = new DeskView( new BoardView(board), new UserList(new DummyServer()), new StockView(stock ), new StockView(stock));
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
		getContentPane().add(view);
		//this.setContentPane(view);
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
	}
	
}
