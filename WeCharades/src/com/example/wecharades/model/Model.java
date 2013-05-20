package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * This class stores all the data available in the game.
 * @author Anton Dahlström
 *
 */
public class Model {
	private HashMap<Game, ArrayList<Turn>> gameList = new HashMap<Game, ArrayList<Turn>>();
	private HashSet<Player> storedPlayers = new HashSet<Player>();
	
	//Singleton
	private static Model singleModel;
	
	private Model(){
		//TODO initiate the model: load from memory?
	}

	public Model getModelInstance(){
		if (singleModel == null){
			singleModel = new Model();
		}
		return singleModel;
	}

	//Games ---------------------------------------------------------------
	
	/**
	 * Updates a list of games. If a game is not existant, it will be added to the list. 
	 * @param games
	 */
	public void updateGameList(ArrayList<Game> games){
		for(Game game : games){
			updateGame(game);
		}
	}

	/**
	 * Updates a game in the internal list of games. Will also create new games that does not exist.
	 * @param game - the game to be updated
	 */
	public void updateGame(Game game) throws NoSuchElementException{
		//This is actually kind of fast, although it might look a bit weird.
		ArrayList<Turn> tempTurns;
		if(gameList.containsKey(game)){
			tempTurns = gameList.get(game);
			gameList.remove(game);
			gameList.put(game,tempTurns);
		} else{
			gameList.put(game, new ArrayList<Turn>(7));
		}

	}
	
	/**
	 * Return an ArrayList with current games
	 * @return - an arraylist containing games
	 */
	public ArrayList<Game> getGames(){
		return new ArrayList<Game>(gameList.keySet());
	}
	
	/**
	 * Removes a game form the model
	 * @param game - the game to be deleted
	 * @return - true if the game was in the list, false otherwise
	 */
	public boolean removeGame(Game game){
		return gameList.remove(game) != null;
	}
	
	/**
	 * Use to update a single turn of a game. This will add a turn if it does not exist,
	 * 	as well as update its state if it is existant.
	 * @param game - the game in question
	 * @param turn - the turn of the game
	 * @throws NoSuchElementException if no game is found
	 */
	public void updateTurn(Game game, Turn turn){
		if(!gameList.containsKey(game))
			throw new NoSuchElementException();
		ArrayList<Turn> listOfTurns = gameList.get(game);
		listOfTurns.remove(turn.getTurnNumber()); //Removes the old copy of the turn
		listOfTurns.add(turn.getTurnNumber(), turn); //Adds the new copy of the game
	}
	
	/**
	 * Updates a list of turns at once
	 * @param game - 
	 * @param turnList
	 * @throws NoSuchElementException if no game is found
	 */
	public void updateTurns(Game game, ArrayList<Turn> turnList) throws NoSuchElementException{
		for(Turn turn : turnList) {
			updateTurn(game, turn);
		}
	}
	
	/**
	 * Get a list of turns for a game
	 * @param game - the game
	 * @return - an arraylist of turns
	 */
	public ArrayList<Turn> getTurns(Game game){
		return gameList.get(game);
	}
	
	//Players ---------------------------------------------------------------
	//TODO Maybe we have no need for these...
	/**
	 * Puts a player in stored players 
	 * @param player - the player to be stored
	 */
	public void putPlayer(Player player){
		if(storedPlayers.contains(player)) //Updated player data
			storedPlayers.remove(player);
		storedPlayers.add(player);
	}
	
	/**
	 * Used to get a player representation from a username
	 * @param username - the player username
	 * @return a Player
	 */
	public Player getPlayer(String username){
		Player retPlayer = null;
		for(Player player : storedPlayers){
			if (player.getName().equalsIgnoreCase(username)){
				retPlayer = player;
				break; // we only have one instance in the array
			}
		}
		return retPlayer;
	}
	
	/**
	 * Called in order to check if a player exist on the internal memory
	 * @param player
	 * @return
	 */
	public boolean playerIsCached(Player player){
		return storedPlayers.contains(player);
	}
	
}
