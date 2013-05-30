package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observer;

import android.content.Context;

/**
 * An interface for any database connected to this application.
 * 	A database-class should AT LEAST implement these methods.
 *
 */
public interface IDatabase{
	
	/*
	 * We use an observer pattern
	 */
	
	/**
	 * Add observer of this database
	 * @param observer
	 */
	public void addObserver(Observer observer);
	
	/**
	 * Remove an observer of this database
	 * @param observer
	 */
	public void deleteObserver(Observer observer);

	/**
	 * Sets the converter for this database.
	 * @param dc - the Datacontroller
	 */
	public abstract void setConverter(DataController dc);
	//TODO This may me moved at a later stage
	
	/**
	 * Creates a new game on the server. The game will not be added if a game between two players already exist.
	 * 
	 * @param 	player1: The player who created the game
	 * 			player2: The player who received the game
	 * @return - The newly created game
	 */
	public abstract void createGame(Player player1, Player player2);
	
	/**
	 * Removed a game from the database
	 * @param game - the game to delete
	 */
	public abstract void removeGame(Game game);
	
	/**
	 * Removes all turns associated with a local version of the game from the database.
	 * @param game - the game who's turns to delete
	 */
	public abstract void removeTurnsOfGame(Game game);
	
	/**
	 * A method to get a single game - this is not done in background
	 * @param gameId
	 * @return The game with gameId
	 * @throws DatabaseException 
	 */
	public abstract Game getGame(String gameId) throws DatabaseException;

	/**
	 * Get a list of game-instances of the logged in player from the Parse server.
	 * @param The user
	 * @return an ArrayList with Game instances
	 */
	public abstract void fetchGames(Player player);

	/**
	 * Update a game on the Parse server.
	 * @param The game to be updated
	 */
	public abstract void updateGame(Game theGame);
	
	/**
	 * Retrieves a turn from the database - this is not done in background
	 * @param gameId - the game to which this turn belongs
	 * @param turnNumber - the turn number
	 * @return A Turn class representation of the retrieved data
	 * @throws DatabaseException 
	 */
	public abstract Turn getTurn(Game game, int turnNumber)
			throws DatabaseException;

	/**
	 * Returns a list of all games associated with a game
	 * @param game - the game to fetch
	 * @return an ArrayList of turns
	 * @throws DatabaseException
	 */
	public abstract ArrayList<Turn> getTurns(Game game)
			throws DatabaseException;

	/**
	 * Updates a specific turn according to its local version
	 * @param theTurn - the Turn object that should be used as a reference
	 */
	public abstract void updateTurn(Turn theTurn);

	/**
	 * Updated a list of turns at once
	 * @param turnList
	 */
	public abstract void updateTurns(List<Turn> turnList);
	
	/**
	 * Gets the player with player Id from the database
	 * @param playerId the Player's name
	 * @return a Player representation
	 * @throws DatabaseException 
	 */
	public abstract Player getPlayer(String playerName)
			throws DatabaseException;

	/**
	 * Get a player by its parseId
	 * @param parseId - the ID of the player
	 * @return A Player representation of the player
	 * @throws DatabaseException
	 */
	public abstract Player getPlayerById(String parseId)
			throws DatabaseException;

	/**
	 * Get a list of player-instances containing all players 
	 * @return List containing all players in DB.
	 * @throws DatabaseException
	 */
	public abstract ArrayList<Player> getPlayers() throws DatabaseException;
	
	/**
	 * A method to increment the global statistics of players.
	 * @param player - the player
	 * @param scoreInc - the amount the score should be incremented
	 * @param won - the amount of won turns to increment
	 * @param draw - the amount of turns draw to increment
	 * @param lost - - the amount of lost turns to increment
	 */
	public abstract void incrementPlayerStats(Player player, int scoreInc, int won, int draw, int lost);

	/**
	 * Puts the playerId into the the random queue
	 * @param player - The player
	 */
	public abstract void putIntoRandomQueue(Player player);

	/**
	 * Send an invitation to another player
	 * @param inv - the invitation to send
	 */
	public abstract void sendInvitation(Invitation inv);

	/**
	 * Retrieves the invitations a player has received
	 * 
	 * @param player - the Player
	 * @return an ArrayList with playerId:s
	 */
	public abstract void getInvitations(Player player);

	/**
	 * Removes an invitation from the database
	 * 
	 * @param inv - an invitation to delete
	 */
	public abstract void removeInvitation(Invitation inv);

	/**
	 * Removes the entire collection of Invites from the database
	 * @param inv - a collection of invitations
	 */
	public abstract void removeInvitations(Collection<Invitation> inv);

	/**
	 * A method to register a user
	 * @param inputNickname - the nickname of choice
	 * @param inputEmail - Email address
	 * @param inputPassword - password
	 * @param inputRepeatPassword - control password
	 * @throws DatabaseException - thrown if the database transfer fails
	 */
	public abstract void registerPlayer(String inputNickname,
			String inputEmail, String inputPassword, String inputRepeatPassword)
			throws DatabaseException;

	/**
	 * Login activity
	 * @param username - the user
	 * @param password - the password
	 * @throws DatabaseException - if something went wrong
	 */
	public abstract void loginPlayer(String username, String password)
			throws DatabaseException;

	/**
	 * Returns the current player
	 * @return A Player representation of the current player
	 */
	public abstract Player getCurrentPlayer();

	/**
	 * A method to restore the user password
	 * @param email - the user email
	 * @throws DatabaseException - If the connection fails
	 */
	public abstract void resetPassword(String email) throws DatabaseException;

	/**
	 * A method that will log out the current user
	 */
	public abstract void logOut();

	/**
	 * Remove push notifications form the 
	 * @param context
	 */
	void removePushNotification(Context context);

	/**
	 * Subscribe to notifications from this device - uses the current player username as key.
	 * @param context - The application context
	 */
	public void subscribeToNotification(Context context);


}