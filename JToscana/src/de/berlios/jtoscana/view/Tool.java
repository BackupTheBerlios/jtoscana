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

import java.awt.Graphics;

import org.apache.log4j.Logger;

import de.berlios.jtoscana.model.GameException;
import de.berlios.jtoscana.model.Tile;



/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Tool {
	private static final Logger logger = Logger.getLogger(Tool.class);
	/**
	 * 
	 */
	private Tool() {
	}

	public static void paintTile ( Graphics g, int startX, int startY, int width, Tile t) throws GameException{
		paintTile(g, startX, startY, width, t, false);
	}
	/**
	 * DOCUMENT ME!
	 *
	 * @param g DOCUMENT ME!
	 * @param t DOCUMENT ME!
	 */
	public static void paintTile ( Graphics g, int startX, int startY, int width, Tile t, boolean center )
	    throws GameException {
	    boolean [] cs = t.getTiles (  );
	    int w = width;
	    int topleft = t.getTopLeft (  );
	
	    int breakStep = 0;
	    int rightStep = 0;
	    int downStep = 0;
	    switch ( topleft ) {
	        case 0:
	            breakStep = 4;
	            rightStep = 1;
	            downStep = 4;
	            break;
	        case 3:
	            breakStep = 2;
	            rightStep = 4;
	            downStep = -1;
	            break;
	        case 4:
	            breakStep = 2;
	            rightStep = -4;
	            downStep = 1;
	            break;
	        case 7:
	            breakStep = 4;
	            rightStep = -1;
	            downStep = -4;
	            break;
	        default:
	            throw new GameException( "TopLeft of Tile is not 0, 3, 4 nor 7" );
	    }
	    if (center) {
	    	startX = startX - (breakStep/2) *w;
	    	startY = startY - ((6-breakStep)/2) * w;
	    	 
	    }
	    logger.debug("breakStep=" + breakStep + ";rightStep=" + rightStep + ";downStep=" + downStep);
	    for ( int i = 0; i < cs.length; i++ ) {
	        if ( logger.isDebugEnabled (  ) ) {
	            logger.debug ( "Tile no:" + i );
	        }
	        int field = topleft + 
	        	( ( i % breakStep ) * rightStep ) +
	            ( ( i / breakStep ) * downStep );
	        logger.debug("field=" + field);
	        boolean b = cs [ field ];
	        if ( b ) {
	            g.setColor ( t.getColor (  ).getPaintColor (  ) );
	        } else {
	            g.setColor ( t.getOppositeColor (  ).getPaintColor (  ) );
	        }
	        int x = startX + ( i % breakStep ) * w;
	        int y = startY + ( i / breakStep ) * w;
	        logger.debug("x=" + x + ";y=" + y);
	        g.fillRect ( x, y, w, w );
	    }
	}

}

