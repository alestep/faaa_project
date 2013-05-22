package com.example.wecharades.model;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import android.content.Context;
import android.util.Log;

/**
 * This class stores all the data available in the game.
 * @author Anton Dahlstr�m
 *
 */
public class Model implements Serializable {
	private static final String SAVE_FILE = "model.save";

	//Two maps for games for increased speed
	private TreeMap<Game, ArrayList<Turn>> gameList = new TreeMap<Game, ArrayList<Turn>>();
	private TreeMap<String, Game> gameIdList = new TreeMap<String, Game>();

	//Two maps for player names and id:s. The second one is used for increased speed
	private TreeMap<String, Player> storedPlayers = new TreeMap<String, Player>();
	private TreeMap<String, String> storedPlayerNames = new TreeMap<String, String>();
	private Player currentPlayer = null;

	/*
	 * Invitations are stored locally, in order to check that two invites aren't sent to one person (weak check).
	 */
	private ArrayList<Invitation> sentInvitations = new ArrayList<Invitation>(); 


	//Singleton
	private static Model singleModel;

	private Model(Context context){}

	/**
	 * Use this method to get the singleton instance of the model where necessary.
	 * @return the Model
	 */
	public static Model getModelInstance(Context context){
		if(singleModel == null){
			//Try to load from storage
			singleModel = loadModel(context);
			if(singleModel == null){
				//If there were no previous models present, create new
				singleModel = new Model(context);
			}
		}
		return singleModel;
	}

	/**
	 * A method to save the current model to memory.
	 * 	This should be done on every onDestroy
	 * @param context
	 */
	public void saveModel(Context context){
		try {
			ObjectOutputStream oOut = new ObjectOutputStream(
					context.openFileOutput(SAVE_FILE, Context.MODE_PRIVATE)
					);
			oOut.writeObject(singleModel);
			oOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Model loadModel(Context context){
		Model singleModel = null;
		try {
			ObjectInputStream oIn = new ObjectInputStream(context.openFileInput(SAVE_FILE));
			Object obj = oIn.readObject();
			if (obj.getClass().equals(Model.class)){
				singleModel = (Model) obj;
			}
		} catch (IOException e){
			//TODO �ndra h�r ocks�
		} catch (ClassNotFoundException e2){
			//TODO �ndra �ven h�r
		}
		return singleModel;
	}
	
	private static void eraseModel(Context context){
		File modelFile = new File(context.getFilesDir(), SAVE_FILE);
		if(modelFile.delete())
			Log.d("Model - File:","Removed file");
		singleModel = null;
	}

	//Games ---------------------------------------------------------------

	/**
	 * Updates a list of games. If a game is not existant, it will be added to the list. 
	 * @param games
	 */
	public void putGameList(ArrayList<Game> games){
		for(Game game : games){
			putGame(game);
		}
	}

	/**
	 * Updates a game in the internal list of games. Will also create new games that does not exist.
	 * @param game - the game to be updated
	 */
	public void putGame(Game game){
		//This is actually kind of fast, although it might look a bit weird.
		ArrayList<Turn> tempTurns;
		if(gameList.containsKey(game) && gameList.get(game) != null){
			tempTurns = gameList.get(game);
			gameList.remove(game);
			gameList.put(game,tempTurns);
			gameIdList.put(game.getGameId(), game);
		} else{
			gameList.put(game, null);
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
	public void removeGame(Game game){
		gameIdList.remove(game.getGameId());
		gameList.remove(game);
	}

	/**
	 * Use to update a single turn of a game. This will add a turn if it does not exist,
	 * 	as well as update its state if it is existant.
	 * @param game - the game in question
	 * @param turn - the turn of the game
	 * @throws NoSuchElementException if no game is found
	 */
	public void putTurn(Turn turn){
		if(turn != null){ //TODO vet inte om vi ska g�ra det h�r....
			Game game = getGame(turn.getGameId());
			if( !gameList.containsKey(game))
				throw new NoSuchElementException();
			ArrayList<Turn> listOfTurns = gameList.get(game);
			if(listOfTurns == null){
				listOfTurns = new ArrayList<Turn>();
				gameList.put(game, listOfTurns);
			}else if(listOfTurns.contains(turn)) //Removes the old copy of the turn
				listOfTurns.remove(turn.getTurnNumber()-1); 
			listOfTurns.add(turn.getTurnNumber()-1, turn); //Adds the new copy of the game
		}
	}

	/**
	 * Updates a list of turns at once - the existing list will be overwritten.
	 * @param game - 
	 * @param turnList
	 * @throws NoSuchElementException if no game is found
	 */
	public void putTurns(ArrayList<Turn> turnList) throws NoSuchElementException{
		for(Turn turn : turnList){
			putTurn(turn);
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

	/**
	 * Returns the current turn from the model
	 * @param game - the game to fetch from
	 * @return a Turn
	 */
	public Turn getCurrentTurn(Game game){
		return gameList.get(game).get(game.getTurn()-1);
	}

	//Players ---------------------------------------------------------------

	public boolean playerIsCached(Player player){
		return storedPlayers.containsKey(player.getParseId());
	}

	/**
	 * Puts a player in stored players 
	 * @param player - the player to be stored
	 * @return if the player was added or not
	 */
	public void putPlayer(Player player){
		if(playerIsCached(player))
			storedPlayerNames.put(player.getName(), player.getParseId());
		//The data for a player should always be updated
		storedPlayers.put(player.getParseId(),player);
	}

	/**
	 * Puts a collection of players into the model
	 * @param players - a collection of players
	 */
	public void putPlayers(Collection<Player> players){
		storedPlayers.clear();
		storedPlayerNames.clear();
		for(Player player : players){
			putPlayer(player);
		}
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
	public void setCurrentPlayer(Player player){
		currentPlayer = player;
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
	public void logOutCurrentPlayer(Context context){
		eraseModel(context);
	}

	//Invitations ---------------------------------------------------------------
	//Received invitations are not needed here, as they should allways be fetched from the database.

	/**
	 * 
	 * @param invitation
	 */
	public void setSentInvitation(Invitation invitation){
		sentInvitations.add(invitation);
	}

	/**
	 * Returns a set with all players the current player has sent invitations to. 
	 * @return
	 */
	public ArrayList<Invitation> getSentInvitations(){
		return sentInvitations;
	}
}
