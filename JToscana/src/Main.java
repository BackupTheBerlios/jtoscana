import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import view.BoardView;
import view.Tool;
import view.ToscanaFrame;

/*
 * Created on Dec 21, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author mike
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.ALL);
		Logger.getLogger(BoardView.class).setLevel(Level.INFO);;
		Logger.getLogger(Tool.class).setLevel(Level.INFO);;
		ToscanaFrame frame = new ToscanaFrame();
		frame.show();
	}
}
