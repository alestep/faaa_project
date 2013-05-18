package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This class stores all the data available in the game.
 * @author Anton Dahlström
 *
 */
public class Model {
	private HashMap<Game, ArrayList<Turn>> gameList = new HashMap<Game, ArrayList<Turn>>();
	private HashSet<Player> storedPlayers = new HashSet<Player>();
	
	public void updateGameList(ArrayList<Game> games){
		ArrayList<Turn> tempTurns;
		ArrayList<Game> savedGames = new ArrayList<Game>(); //Used for comparison
		for(Game game : gameList.keySet()){
			savedGames.add(game);//Stores the games in a list - used for as a 
		}
		for(Game game : games){
			if(!gameList.containsKey(game)){ //If the game isn't represented in the game list
				//Creates an empty list of turns
				gameList.put(game, new ArrayList<Turn>());
			} else if(game.equals(gameList)){ //If the game has changed
				tempTurns = gameList.get(game);
				
			}
		}
	}
	
	public void putTurn(Game game, Turn turn){
		
	}
}
