JToscana
=====
Computer implementation of the board game 'Toscana'

The board has a 17 x 17 grid
32 tiles (16 grey, 16 red) 

1 Tile is 2x4 and has 2 squares with the colour grey or red and 6 squares of the opposite colour.


Feature:
2 Player game
Playable over the network (Game Server or  Client/Server)
On the same computer
Implemented in Java. 
Automatic counting of the area

3 Modules: 

Rules (Model)
Board (View)
Network(Controller)



Model
--------
Board
2 stocks of 16 tiles.
optional: 2 veto stones.

Tile: 8 fields,  2 rows with 4 columsn, starting with zero, and a lefthead number 0 to 7

View:
-------
All objects are canvases : desk, board, 2 stockes 
active  next tile

Menu: Start Game, Exit, Start Server, Connect to Server.


Controller: 
--------------
Network, User Interface(Desk)

Server:
----------
Options: Serverport

Client:
---------
Options: ServerName, ServerPort,


Network Infos: online users, isConnected, reconnect

Protokoll: 
-------------
commandos

USERS - lists all online users
LIST - all active games;
GAMES - list all available games
ASK  -  Wanna play
CONFIRM - join game
ACTION - send tile

STATE - client asks for server messages.




















