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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Michael Greifeneder
 */
public class GameController {

	/**
	 * 
	 */
	public GameController() {
	}
	
	private HashMap gamesById = new HashMap();
	
	public Game getGameById(int id) {
		return (Game) gamesById.get(new Integer(id));
	}
	
	private static int gameId = 0;
	
	private synchronized int getNextGame(String userOne, String userTwo) {
		gameId++;
		gamesById.put(new Integer(gameId), new Game(gameId, userOne, userTwo));
		pendingUsers.remove(userOne);
		pendingUsers.remove(userTwo); 
		return gameId;
	}
	
	public synchronized void gameFinished(int id) {
		Game game = (Game) gamesById.remove(new Integer(id));
		pendingUsers.add(game.getUserOne());
		pendingUsers.add(game.getUserTwo());
	}
	
	public int requestGame(String requester, String enemy) {
		ClientHandler h = (ClientHandler)  handlerByUser.get(enemy);
		Object o = h.addResponseAndWait(new GameStartRequest(requester));
		if (o instanceof GameStartResponse) {
			GameStartResponse gsr =  (GameStartResponse) o;
			if (gsr.isAccepted()) {
				return getNextGame(requester, enemy);				
			}
		}
		return 0;
	}
	
	private HashMap handlerByUser = new HashMap();
	private ArrayList pendingUsers = new ArrayList();
	
	public void register(ClientHandler h, String user) {
		handlerByUser.put(user, h);
	}
	public String[] getPendingUsers() {
		return (String[]) pendingUsers.toArray(new String[pendingUsers.size()]);
	}
}
