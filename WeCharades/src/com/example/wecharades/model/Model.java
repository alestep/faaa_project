package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import com.example.wecharades.presenter.Database;
import com.parse.ParseUser;

/**
 * This class stores all the data available in the game.
 * @author Anton Dahlström
 *
 */
public class Model {
	//Two maps for games for increased speed
	private HashMap<Game, ArrayList<Turn>> gameList = new HashMap<Game, ArrayList<Turn>>();
	private HashMap<String, Game> gameIdList = new HashMap<String, Game>();
	//Two maps for player names and id:s. The second one is used for increased speed
	private HashMap<String, Player> storedPlayers = new HashMap<String, Player>();
	private HashMap<String, String> storedPlayerNames = new HashMap<String, String>();
	private Player currentPlayer = null;

	//Singleton
	private static Model singleModel;

	private Model(){
		//TODO initiate the model: load from memory?
	}

	/**
	 * Use this method to get the singleton instance of the model where necessary.
	 * @return the Model
	 */
	public static Model getModelInstance(){
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
			gameIdList.put(game.getGameId(), game);
		} else{
			gameList.put(game, new ArrayList<Turn>(7));
			gameIdList.put(game.getGameId(), game);
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
	 * Gets a game from its game id
	 * @param parseId
	 * @return a Game, or null it does not exist
	 */
	public Game getGame(String parseId){
		return gameIdList.get(parseId);
	}

	/**
	 * Removes a game form the model
	 * @param game - the game to be deleted
	 * @return - true if the game was in the list, false otherwise
	 */
	public boolean removeGame(Game game){
		gameIdList.remove(game.getGameId());
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

	/**
	 * Puts a player in stored players 
	 * @param player - the player to be stored
	 */
	public void putPlayer(Player player){
		storedPlayers.put(player.getParseId(),player);
		storedPlayerNames.put(player.getName(), player.getParseId());
	}

	/**
	 * Used to get a player representation from a username
	 * @param username - the player username
	 * @return a Player
	 */
	public Player getPlayer(String username){
		Player retPlayer = null;
		if(storedPlayerNames.containsKey(username)){
			retPlayer = storedPlayers.get(storedPlayerNames.get(username));
		}
		return retPlayer;
	}

	/**
	 * Used to get a player representation from a username
	 * @param parseId - the player id
	 * @return a Player or null if not found
	 */
	public Player getPlayerById(String parseId){
		return storedPlayers.get(parseId);
	}

	/**
	 * Designates a player as the current player. If the player does not exist,  
	 *  it gets added.
	 */
	public void setCurrentPlayer(){
		ParseUser parseUser = ParseUser.getCurrentUser();
		currentPlayer = new Player(parseUser.getObjectId(), 
				parseUser.getString(Database.PLAYER_USERNAME_NATURAL), 
				parseUser.getInt(Database.PLAYER_GLOBALSCORE));
		putPlayer(currentPlayer);
	}

	/**
	 * Returns the logged in player player (ParseUser)
	 * @return A Player representation of The current player, or null if this player does not exist.
	 */
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	/**
	 * Deletes the current player entirely from the model. Should be done when user logs out.
	 */
	public void logOutCurrentPlayer(){
		storedPlayers.remove(currentPlayer.getParseId());
		storedPlayerNames.remove(currentPlayer.getName());
		currentPlayer = null;
	}

}
