package com.example.wecharades;

import java.util.ArrayList;

/**
 * This class is intended as the interface against the server and database of this game.
 *  The procedure to create a game should be to first check if a local copy of the word list exist,
 *  then download if necessary. The local word lists are stored in Wordlists.class
 *  
 * @author Anton Dahlström
 *
 */
public class Database {
	
	/**
	 * A method to get the current version number of the word list on the database,
	 * 	used to check against the already existing databases on the phone.
	 * 
	 * @return The current version of the global word list
	 */
	public static long getWordlistVersion(){
		return (System.currentTimeMillis()/1000L);
	}

	/**
	 * A method to retrieve the latest version from the server
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
	 * @return if the transaction was successful
	 */
	public static boolean pushTurn(Game theGame){
		return true;
	}
}
