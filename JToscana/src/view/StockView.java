/*
 * Created on Dec 22, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package view;
import model.Stock;
import model.Tile;

import org.apache.log4j.Logger;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class StockView extends JPanel {
    private Stock stock;
    private Tile tile;
    private static final Logger logger = Logger.getLogger ( StockView.class );

    /**
     * Creates a new StockView object.
     *
     * @param stock DOCUMENT ME!
     */
    public StockView ( Stock stock ) {
        this.stock = stock;
    }

    /* (non-Javadoc)
     * @see java.awt.Component#paint(java.awt.Graphics)
     */
    public void paint ( Graphics g ) {
        super.paint ( g );
        Tile tile = stock.getVisibleTile (  );
        if ( tile != null ) {
            logger.debug ( "Painting Stock!" );
            try {
				Tool.paintTile (g, 0, 0, g.getClipBounds().width /2, tile );	
			} catch (Exception e) {
				logger.warn("", e);
			}
            
        }
    }

    /**
     * DOCUMENT ME!
     */
    public void next (  ) {
        tile = stock.getNextTile (  );
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Stock getStock (  ) {
        return stock;
    }
}
