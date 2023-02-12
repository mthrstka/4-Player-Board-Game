# 4 Player Board Game

Team: Onion 

Members: Isaac Al-Abad, Brandon Yates, Jared Weber, Gabe Erickson, Michael Hrstka 

Game Rules:  

Each player receives a set of 3 random integers (1-20). 

Note: Players have their set displayed on their GUI. 

Players take turns guessing an additional number in a cycle. 

If a player has a superset of the 2nd player, their dot turns green on their row under the 2nd players column. 

player wins the game when all dots in their row are green. 

A match is a series of 10 games; the winner of the match is the player with the lowest number of points. 

How do we control points? 

The winner is assigned a point score – which is the numbers added during the game 

other players are given 10 points each. 

Driver: 

Initializes GUI form to select either client or host machine 

If the user selects host, then the driver will initialize the server object and then the client object. 

Note: should use a flag when initializing the client to determine if the client is also the host. Flag used to set the visibility of the start game button.  

If the user selects client, then the driver will initialize the client object. 

Once all clients have connected to the server, and start game button on the host has been clicked, then start the game object. 

Client object: 

Contains identifying information for the corresponding player. 

IP Address 

Purpose: Used to establish connections between the server and client machine(s) 

Datatype: String? 

Value(s):  

Initialize by getting the information sent to the server from the client machine.  

Player label (P1, P2, P3, P4) 

Purpose:  

Datatype: String or integer for index 

Value(s):  

Assigned on initialization based on order of connections being established.  

Points 

Purpose: Used to determine match winner.  

Datatype: Integer 

Value(s): Zero at initialization. 

Either added at end of each game or added each time a dot in the players column turns green.  

Initial number set 

Purpose: Used for to determine the green dots on the board 

Datatype: 

Value(s): 

Reinitialized at beginning of each game (10 games total) 

Set of initial number set + corresponding guesses 

Purpose: Used to establish connections between the server and client machine(s) 

Datatype: String? 

Value(s):  

Host Machine/Master: 

Sends and receives data between the players. 

Check for winner after each turn. 

Public channel used to update information to all clients. 

Ex. Public channel will be used to send the game status and updates to all client machines. 

Private channels used to send information to and from one client and the master. 

Ex. Private channel will be used for the client sending their guess to the master. 

GUI: 

Setup Screen 

Host/Client option 

Display client IP for establishing connection 

Main game board 

Column headers/labels for each player  

Ex: (P1, P2, P3, P4) 

Row headers/labels for each player  

Ex: (P1, P2, P3, P4) 

4x4 grid 

Red or Green 

Player label (P1, P2, P3, P4) and their given set on their corresponding boards. 

Display corresponding players guesses set/list. 

 