package com.example.wecharades.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import android.content.Context;
import android.util.Log;

/**
 * This class stores all the data available in the game.
 * @author Anton Dahlström
 *
 */
public class Model implements Serializable{
	
	private static final long serialVersionUID = -8167671678222883965L;
	private static final String 	SAVE_FILE = "model.save";
	public static final int 		
	FINISHEDGAMES_SAVETIME 			= 168
	, FINISHEDGAMES_NUMBERSAVED 	= 10
	, INVITATIONS_SAVETIME 			= 72;

	//A variable to check if model is already saved.
	private boolean					SAVED = false;
	//A variable that can be changed in order to purge the model - this is done manually now!
	private static boolean			PURGE = false;
	//A variable which is called when a user logs out 
	// - the model exists a moment so we may finish any queries first
	private static boolean 			RECREATE = false;

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
	private LinkedList<Invitation> sentInvitations = new LinkedList<Invitation>();

	//Singleton
	private static Model singleModel;

	private Model(Context context){
		//Creating a file
		saveModel(context);
	}

	/**
	 * Use this method to get the singleton instance of the model where necessary.
	 * @return the Model
	 */
	public static Model getModelInstance(Context context){
		if(PURGE){
			eraseModel(context);
			singleModel = null;
			PURGE = false;
		}
		if(singleModel == null){
			//Try to load from storage
			singleModel = loadModel(context);
		}
		if(singleModel == null || RECREATE){
			//If there were no previous models present, create new
			singleModel = new Model(context);
			RECREATE = false;
		}
		return singleModel;
	}

	/**
	 * A method to save the current model to memory.
	 * 	This should be done on every onDestroy
	 * @param context
	 */
	public void saveModel(Context context){
		if(!SAVED){
			try {
				FileOutputStream ops = context.openFileOutput(SAVE_FILE, Context.MODE_PRIVATE);
				ObjectOutputStream oOut = new ObjectOutputStream(ops);
				oOut.writeObject(singleModel);
				oOut.close();
				SAVED = true;
			} catch (IOException e) {
				Log.d("IO - Model save", e.getMessage());
			}
		}
	}

	private static Model loadModel(Context context){
		Model singleModel = null;
		try {
			ObjectInputStream oIn = new ObjectInputStream(context.openFileInput(SAVE_FILE));
			Object obj = oIn.readObject();
			if (obj != null && obj.getClass().equals(Model.class)){
				singleModel = (Model) obj;
			}
		} catch (IOException e){
			Log.d("IO - Model load", "IOException");
		} catch (ClassNotFoundException e2){
			Log.d("IO - Model load", "ClassNotFound");
		}
		return singleModel;
	}

	private static void eraseModel(Context context){
		File modelFile = new File(context.getFilesDir(), SAVE_FILE);
		if(modelFile.delete()){
			Log.d("Model - File:","Removed file");
		}
		RECREATE = true;
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
		SAVED = false;
	}

	/**
	 * Updates a game in the internal list of games. Will also create new games that does not exist.
	 * @param game - the game to be updated
	 */
	public void putGame(Game game){
		//This is actually kind of fast, although it might look a bit weird.
		ArrayList<Turn> tempTurns;
		if(gameList.containsKey(game) && gameList.get(game) != null){
			Log.d("Model: putGame()", "Game in List");
			tempTurns = gameList.get(game);
			gameList.remove(game);
			gameList.put(game,tempTurns);
			gameIdList.put(game.getGameId(), game);
		} else{
			Log.d("Model: putGame()", "game not in list, add game");
			gameList.put(game, null);
			gameIdList.put(game.getGameId(), game);
		}
		SAVED = false;
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
		SAVED = false;
	}

	/**
	 * Use to update a single turn of a game. This will add a turn if it does not exist,
	 * 	as well as update its state if it is existant.
	 * @param game - the game in question
	 * @param turn - the turn of the game
	 * @throws NoSuchElementException if no game is found
	 */
	public void putTurn(Turn turn){
		if(turn != null){
			if(!gameIdList.containsKey(turn.getGameId()))
				throw new NoSuchElementException();
			Game game = getGame(turn.getGameId());
			ArrayList<Turn> listOfTurns = gameList.get(game);
			if(listOfTurns == null){
				listOfTurns = new ArrayList<Turn>();
				gameList.put(game, listOfTurns);
			} else if(listOfTurns.contains(turn)){
				listOfTurns.remove(turn);
			}
			listOfTurns.add(turn);
		}
		SAVED = false;
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
	public Turn getCurrentTurn(Game game) {
		for(Turn t : getTurns(game)){
			if(t.getTurnNumber() == game.getTurnNumber()){
				return t;
			}
		}
		return null;
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
		SAVED = false;
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
		SAVED = false;
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
	 * Set all sent invitations from this player
	 * @param invitation - The invitation to add
	 */
	public void setSentInvitations(LinkedList<Invitation> invitations){
		sentInvitations = invitations;
		SAVED = false;
	}
	
	/**
	 * Retrieve a list of Invitations sent from this device.
	 */
	public List<Invitation> getSentInvitations(){
		return sentInvitations;
	}
	
/* 	//TODO Delete these later.
	 * *//**
	 * Removes a sent invitation from the list of sent invitation
	 * @param invitation - the Invitation to delete
	 *//*
	public void removeSentInvitation(Invitation invitation){
		sentInvitations.remove(invitation);
		SAVED = false;
	}
	
	*//**
	 * Method to replace stored sent invitations from the list.
	 * @param newInv
	 *//*
	public void updateSentInvitations(List<Invitation> newInv){
		sentInvitations = new LinkedList<Invitation>(newInv);
		SAVED = false;
	}

	*//**
	 * Returns a set with all players the current player has sent invitations to. 
	 * @return
	 *//*
	public LinkedList<Invitation> getSentInvitations(){
		return sentInvitations;
	}
	
*/	
}
