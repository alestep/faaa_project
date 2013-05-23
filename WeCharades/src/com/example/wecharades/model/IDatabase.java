package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observer;

import com.parse.ParseException;

public interface IDatabase{
	
	public void addObserver(Observer observer);
	
	public void deleteObserver(Observer observer);

	/**
	 * Sets the converter for this database.
	 * @param dc - the Datacontroller
	 */
	public abstract void setConverter(DataController dc);

	/**
	 * Creates a new game on the server
	 * 
	 * @param 	player1: The player who created the game
	 * 			player2: The player who received the game
	 * @return - The newly created game
	 * @throws DatabaseException 
	 */
	public abstract void createGame(Player player1, Player player2)
			throws DatabaseException;

	/**
	 * A method to get a single game
	 * @param gameId
	 * @return The game with gameId
	 * @throws DatabaseException 
	 */
	public abstract Game getGame(String gameId) throws DatabaseException;

	/**
	 * Get a list of game-instances of the logged in player from the Parse server.
	 * @param The user
	 * @return an ArrayList with Game instances
	 * @throws DatabaseException 
	 */
	public abstract void fetchGames(Player player)
			throws DatabaseException;

	/**
	 * Update a game on the Parse server.
	 * @param The game to be updated
	 */
	public abstract void updateGame(Game theGame);

	/**
	 * Retrieves a turn from the database
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
	 * Gets the player with player Id from the database
	 * @param playerId the Player's name
	 * @return a Player representation
	 * @throws DatabaseException 
	 */
	public abstract Player getPlayer(String playerName)
			throws DatabaseException;

	/**
	 * 
	 * @param parseId
	 * @return
	 * @throws DatabaseException
	 */
	public abstract Player getPlayerById(String parseId)
			throws DatabaseException;

	/**
	 * Get a list of player-instances containing all players 
	 * @param searchString 
	 * @return List containing all players
	 * @throws DatabaseException
	 */
	public abstract ArrayList<Player> getPlayers() throws DatabaseException;

	/**
	 * Puts the playerId into the the random queue
	 */
	public abstract void putIntoRandomQueue(Player player);

	/**
	 * Send an invitation to another player
	 * @param inv
	 */
	public abstract void sendInvitation(Invitation inv);

	/**
	 * Retrieves the invitations a player has received
	 * 
	 * @param player - the Player
	 * @return an ArrayList with playerId:s
	 * @throws DatabaseException 
	 */
	public abstract ArrayList<Invitation> getInvitations(Player player)
			throws DatabaseException;

	/**
	 * Removes an invitation from the database
	 * 
	 * @param inv - an invitation to delete
	 * @throws DatabaseException
	 */
	public abstract void removeInvitation(Invitation inv)
			throws DatabaseException;

	/**
	 * Removes the entire collection of Invites from the database
	 * @param inv - a collection of invitations
	 * @throws DatabaseException
	 */
	public abstract void removeInvitations(Collection<Invitation> inv)
			throws DatabaseException;

	/**
	 * A method to register a user
	 * @param inputNickname - the nickname of choice
	 * @param inputEmail - Email address
	 * @param inputPassword - password
	 * @param inputRepeatPassword - control password
	 * @throws ParseException - thrown if the database transfer fails
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
	 * @return A Player
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
	 * Generates a list with the 10 players with best global score
	 * @return a list with top 10 players based on their global score
	 * @throws DatabaseException
	 */
	public ArrayList<Player> getTopTenPlayers() throws DatabaseException;

}