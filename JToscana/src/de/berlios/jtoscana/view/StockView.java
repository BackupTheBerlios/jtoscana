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

import org.apache.log4j.Logger;

import de.berlios.jtoscana.model.Stock;
import de.berlios.jtoscana.model.Tile;

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
