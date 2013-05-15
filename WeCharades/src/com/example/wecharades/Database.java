package com.example.wecharades;

import java.util.ArrayList;

/**
 * This class is intended as the interface against the server and database of this game.
 *  
 * @author Anton Dahlström
 *
 */
public class Database implements DBInterface{

	@Override
	public boolean pushGame(Game theGame) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Game> getGames() {
		// TODO Auto-generated method stub
		return null;
	}

}
