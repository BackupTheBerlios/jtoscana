/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import model.GameException;
import model.Tile;

/**
 * The desk has 1/2 unit border.
 * Board ist 17 units long and 17 broad. 
 *  
 *  verticial: 2 1/2 units boarder, 4 units stockes, 5 units empty, 4 unit stocks 2 1/2 units border
 * 
 * 
 *
 * @author mike
 */
public class DeskView extends JPanel implements MouseListener, MouseMotionListener {
	private static final Logger logger = Logger.getLogger(DeskView.class);
    private BoardView boardview;
    private UserList userlist;
    private StockView ownStock;
	private StockView enemyStock;
	
	private int curX;
	private int curY;
	
	private Tile curTile;

    /**
     * Creates a new DeskView object.
     *
     * @param bv DOCUMENT ME!
     * @param ul DOCUMENT ME!
     * @param stockview DOCUMENT ME!
     */
    public DeskView ( BoardView bv, UserList ul, StockView own, StockView enemy ) {
        this.boardview = bv;
        this.userlist = ul;
        
        this.ownStock = own;
        this.enemyStock = enemy;
        
        curTile = own.getStock().getNextTile();
        setBackground ( Color.DARK_GRAY );
		
		addMouseMotionListener(this);
		addMouseListener(this);

    }

	public void mouseMoved(MouseEvent e) {
			Point p = e.getPoint();
			curX = p.x;
			curY = p.y;
			repaint();
	}

    /**
     * DOCUMENT ME!
     */
    public void next (  ) {
        //ownStock.next (  );
        //repaint (  );
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    
    private int x = 0;
    public void paint ( Graphics g ) {
        super.paint ( g );
        x = defineOneUnit (g);
        boardview.paint ( g.create(x/2, x/2, x *17,  x*17));
        //userlist.paint ( g );
        enemyStock.paint ( g.create(18 *x , (int) Math.round(2.5 *x) ,  2 *x , 4 * x ));
		ownStock.paint ( g.create(18 *x , (int) Math.round(11.5 *x) ,  2 *x , 4 * x ));
		try {
			if (curTile != null)
				Tool.paintTile(g, curX, curY, x, curTile, false);	
		} catch (Exception e) {
			logger.warn("", e);
		}
				
    }
    
    

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int defineOneUnit ( Graphics g ) {
    	Rectangle r = g.getClipBounds();
    	int unit = 0;
    	if (r.width/22 < r.height/18) {
    		unit = r.width /22;
    	}
    	else {
    		unit = r.height/18;
    	}
    	return unit;
    }
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			curTile.rotateLeft();
		}
		else if(SwingUtilities.isRightMouseButton(e)) {
			//curTile.rotateRight();
			try {
				
				Point p = translate(e.getPoint().x, e.getPoint().y);
				boardview.getBoard().addTile(p.x, p.y, curTile);
				curTile = ownStock.getStock().getNextTile();
			}
 			catch (Exception ex) {
				logger.warn("", ex);
			}
		}
		repaint();
	}
	
	private Point translate(int x, int y) throws GameException {
		int px = (x - (this.x/2)) / this.x;
		int py = (y - (this.x/2)) / this.x;
		if (py > 16 || px > 16) {
			throw new GameException("Au?erhalb des Bords");
		}
		return new Point(px, py);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
