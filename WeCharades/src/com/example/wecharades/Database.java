package com.example.wecharades;

import java.util.ArrayList;

/**
 * This class is intended as the interface against the server and database of this game.
 *  The procedure to create a game should be to first check if a local copy of the word list exist,
 *  then download if necessary. The local word lists are stored in Wordlists.class
 *  
 * @author Anton Dahlstr�m
 *
 */
public class Database {
	
	/**
	 * A method to retrieve the latest version of the word list from the server
	 * 
	 * @return The server/global word list
	 */
	public static ArrayList<String> getWordlist(){
		return null;
	}
	
	/**
	 * A method to send a game and any progress to the database.
	 * 	This is called each time a turn is completed.
	 * 
	 * @throws Exception //TODO Correct exception!
	 */
	public static void pushTurn(Game theGame) throws Exception{
		/*
		 * This method should first retrieve the current turn of the gameId from the db.
		 *  Then this number should be checked against the local version (theGame.getCurrentTurn()).
		 *  
		 *  If the fist test is successful, this method should then update the turn according to this schema:
		 *  	- Update Turn data in Turns-table (theGame.getCurrentTurnInstance() for data retrieval)
		 *  		+ States from getState()
		 *  		+ video-link currently unimplemented
		 *  		+ Score from getScore()
		 *  	- Update GameData-table
		 *  		+ if turn is finished (turn.getState == Turn.FINISH), create new turn in Turns-table and increment turn att.
		 */
	}
}
