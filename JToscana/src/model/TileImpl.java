/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;
import java.util.Arrays;
import java.util.List;

/**
 * @author mike
 *
 *
 */
public class TileImpl implements Tile {
    //Color of the true fields;
    private TileColor color;

    /**
     * 2 row with 4 columns.
     * grey is false,
     * red is true;
     */
    private boolean [] tiles = new boolean [] {
            true, true, true, true, true, true, true, true
        };

    /**
     * number of field which is in the top left corner.
     */
    private int topLeft = 0;
    private List topLefts = Arrays.asList ( new Integer [] {
                new Integer( 0 ), new Integer( 3 ), new Integer( 7 ),
                new Integer( 4 )
            } );

    /**
     * Creates a new TileImpl object.
     *
     * @param tiles DOCUMENT ME!
     * @param topleft DOCUMENT ME!
     */
    public TileImpl ( boolean [] tiles, int topleft ) {
        //TODO: Check 2/6 rate  
        this.tiles = tiles;
        this.topLeft = topleft;
    }

    /**
     * Creates a new TileImpl object.
     *
     * @param c DOCUMENT ME!
     * @param exc1 DOCUMENT ME!
     * @param exc2 DOCUMENT ME!
     */
    public TileImpl ( TileColor c, int exc1, int exc2 ) {
        this.color = c;
        tiles [ exc1 ] = false;
        tiles [ exc2 ] = false;
    }

    /**
     * @return
     */
    public boolean [] getTiles (  ) {
        return tiles;
    }

    /**
     * @return
     */
    public int getTopLeft (  ) {
        return topLeft;
    }

    /**
     * @param i
     */
    public void setTopLeft ( int i ) {
        topLeft = i;
    }

    /**
     * @return
     */
    public TileColor getColor (  ) {
        return color;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public TileColor getOppositeColor (  ) {
        if ( color.equals ( TileColor.GREY ) ) {
            return TileColor.RED;
        }
        if ( color.equals ( TileColor.RED ) ) {
            return TileColor.GREY;
        }
        return null;
    }

    /* (non-Javadoc)
     * @see model.Tile#rotateLeft()
     */
    public void rotateLeft (  ) {
        int i = topLefts.indexOf ( new Integer( topLeft ) );
        if ( i == ( topLefts.size (  ) - 1 ) ) {
            topLeft = ( ( Integer ) topLefts.get ( 0 ) ).intValue (  );
        } else {
            topLeft = ( ( Integer ) topLefts.get ( i + 1 ) ).intValue (  );
        }
    }

    /* (non-Javadoc)
     * @see model.Tile#rotateRigth()
     */
    public void rotateRight (  ) {
        int i = topLefts.indexOf ( new Integer( topLeft ) );
        if ( i == 0 ) {
            topLeft = ( ( Integer ) topLefts.get ( topLefts.size() -1 ) ).intValue (  );
        } else {
            topLeft = ( ( Integer ) topLefts.get ( i - 1 ) ).intValue (  );
        }
    }
}
