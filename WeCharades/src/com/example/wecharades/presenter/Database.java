package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.model.Turn;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * This class is intended as the interface against the server and database of this game.
 *  
 * @author Anton Dahlstr�m
 *
 */
@SuppressLint("DefaultLocale")
public class Database {


	private static Database singleton;

	private Database(Context context){
		Parse.initialize(context, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
	}

	public static Database getDatabaseConnection(Context context){
		if(singleton == null)
			singleton = new Database(context);
		return singleton;
	}

	/**
	 * Randomly get 6 unique word from the database 
	 * @return an ArrayList with 6 words 
	 * @throws DatabaseException 
	 */
	private Stack<String> getWords() throws DatabaseException{
		Stack<String> list = new Stack<String>();
		ParseQuery query = new ParseQuery("WordList");
		ArrayList<String> w = new ArrayList<String>();
		w.add("word");
		query.selectKeys(w);
		List<ParseObject> dblist;
		try {
			dblist = query.find();
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1001,"Could not fetch word");
		}
		for(ParseObject word : dblist){
			list.add(word.getString("word"));
		}
		Collections.shuffle(list);
		return list;
	}

	//Games -----------------------------------------------------------------------------------------//	

	/**
	 * Creates a new game on the server
	 * 
	 * @param 	player1: The player who created the game
	 * 			player2: The player who received the game
	 * @throws DatabaseException 
	 */
	public void createGame(Player player1, Player player2) throws DatabaseException{

		LinkedList<ParseObject> parseList = new LinkedList<ParseObject>();

		ParseObject newGame = new ParseObject("Game");
		newGame.put("player1", player1.getParseId());
		newGame.put("player2", player2.getParseId());
		newGame.put("currentPlayer", player1.getParseId());
		newGame.put("turn", 1);
		newGame.put("finished", false);

		parseList.add(newGame);
		//Adds all the six turns
		Stack<String> wordList = getWords();
		String recP, ansP;
		for(int i=1; i <= 6 ; i++){
			if(i%2 == 0){
				recP = player2.getParseId();
				ansP = player1.getParseId();
			} else{
				recP = player1.getParseId();
				ansP = player2.getParseId();
			}
			createTurn(newGame, i, wordList.pop(), recP, ansP);
		}
		try {
			ParseObject.saveAll(parseList);
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1002,"Failed to create game");
		}
	}

	/**
	 * A method to get a single game
	 * @param gameId
	 * @return The game with gameId
	 * @throws DatabaseException 
	 */
	public Game getGame(String gameId) throws DatabaseException{
		Game game;
		try {
			ParseQuery query = new ParseQuery("Game");
			ParseObject dbGame = query.get(gameId);
			game = DatabaseConverter.parseGame(this, dbGame);
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1003,"Failed to fetch game data");
		}
		return game;
	}

	/**
	 * Get a list of game-instances of the logged in player from the Parse server.
	 * @param The user
	 * @return an ArrayList with Game instances
	 * @throws DatabaseException 
	 */
	public ArrayList<Game> getGames(Player player) throws DatabaseException {
		ArrayList<Game> games = new ArrayList<Game>();
		ArrayList<ParseQuery> queries = new ArrayList<ParseQuery>();
		ParseQuery query1 = new ParseQuery("Game");
		query1.whereContains("player1", player.getParseId());
		ParseQuery query2 = new ParseQuery("Game");
		query2.whereContains("player2", player.getParseId());

		queries.add(query1);
		queries.add(query2);

		ParseQuery mainQuery = ParseQuery.or(queries);

		try{
			List<ParseObject> dbResult = mainQuery.find();
			for(ParseObject game : dbResult){
				games.add(DatabaseConverter.parseGame(this, game));
			}
		} catch(ParseException e){
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1004,"Failed to fetch games");
		}
		return games;
	}

	/**
	 * Update a game on the Parse server.
	 * @param The game to be updated
	 */
	public void updateGame(Game theGame) {
		final Game game = theGame;
		ParseQuery query = new ParseQuery("Game");
		query.getInBackground(theGame.getGameId(), new GetCallback() {
			public void done(ParseObject object, ParseException e){
				if(e == null){
					//Updates the game on the server with the latest info
					object.put("playerTurn", game.getCurrentPlayer().getParseId());
					object.put("turn", game.getTurn());
					object.saveEventually();
				} else{
					Log.d("Database",e.getMessage());
				}
			}
		});
	}

	//Turn -----------------------------------------------------------------------------------------//	

	/**
	 * A PRIVATE method to create a new Turn. Should not be reachable outside this class!
	 * @param game - the Game ParseObject
	 * @param turnNumber - an integer representation of the turn number
	 * @param word - the word of the turn
	 * @param recPlayer - the parseId of the player that should record
	 * @param ansPlayer - the parseId of the player that should answer
	 */
	private void createTurn(ParseObject game, int turnNumber, String word, String recPlayer, String ansPlayer){
		ParseObject newTurn = new ParseObject("Turn");
		newTurn.put("game",game);
		newTurn.put("turn",turnNumber);
		newTurn.put("state",Turn.INIT);
		newTurn.put("word",word);
		newTurn.put("videoLink","");
		newTurn.put("recPlayer",recPlayer);
		newTurn.put("recPlayerScore",0);
		newTurn.put("ansPlayer",ansPlayer);
		newTurn.put("ansPlayerScore",0);
	}

	/**
	 * Retrieves a turn from the database
	 * @param gameId - the game to which this turn belongs
	 * @param turnNumber - the turn number
	 * @return A Turn class representation of the retrieved data
	 * @throws DatabaseException 
	 */
	public Turn getTurn(Game game, int turnNumber) throws DatabaseException{
		ParseQuery query = new ParseQuery("Turn");
		query.whereEqualTo("game", game.getGameId());
		query.whereEqualTo("turn", turnNumber);
		ParseObject turn = null;
		try {
			turn = query.getFirst();
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1005, "Failed to get turn");
		}
		return DatabaseConverter.parseTurn(this, turn);
	}

	/**
	 * Returns a list of all games associated with a game
	 * @param game - the game to fetch
	 * @return an ArrayList of turns
	 * @throws DatabaseException
	 */
	public ArrayList<Turn> getTurns(Game game) throws DatabaseException{
		ParseQuery query = new ParseQuery("Turn");
		query.whereEqualTo("game", game.getGameId());
		List<ParseObject> dbList = null;
		try{
			dbList = query.find();
		} catch(ParseException e){
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1009, "Failed to get turns");
		}
		ArrayList<Turn> turnList = new ArrayList<Turn>();
		for(ParseObject turn : dbList){
			turnList.add(DatabaseConverter.parseTurn(this, turn));
		}
		return turnList;
	}

	/**
	 * Updates a specific turn according to its local version
	 * @param theTurn - the Turn object that should be used as a reference
	 */
	public void updateTurn(Turn theTurn){
		final Turn turn = theTurn;
		ParseQuery query = new ParseQuery("Turn");
		query.whereEqualTo("game", turn.getGameId());
		query.whereEqualTo("turn", turn.getTurnNumber());
		query.getFirstInBackground(new GetCallback() {
			public void done(ParseObject dbTurn, ParseException e){
				if(e == null){
					dbTurn.put("state",turn.getState());
					dbTurn.put("videoLink", turn.getVideoLink());
					dbTurn.put("recPlayerScore", turn.getRecPlayerScore());
					dbTurn.put("ansPlayerScore", turn.getAnsPlayerScore());
				} else{
					Log.d("Database",e.getMessage());
				}
			}
		});
	}

	//Players-----------------------------------------------------------------------------------------//	

	/**
	 * Gets the player with player Id from the database
	 * @param playerId the Player's name
	 * @return a Player representation
	 * @throws DatabaseException 
	 */
	public Player getPlayer(String playerName) throws DatabaseException {
		ParseQuery query = ParseUser.getQuery();
		query.whereEqualTo("username", playerName.toLowerCase());
		ParseObject dbPlayer;
		try {
			dbPlayer = query.getFirst();
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1010,"Failed to fetch user");
		}
		return DatabaseConverter.parsePlayer(dbPlayer);
	}

	public Player getPlayerById(String parseId) throws DatabaseException {
		return DatabaseConverter.parsePlayer(getPlayerObject(parseId));
	}
	
	private ParseObject getPlayerObject(String parseId) throws DatabaseException{
		//TODO We should try and fetch this from the model first!
		try {
			return ParseUser.getQuery().get(parseId);
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1010,"Failed to fetch user");
		}
	}

	/**
	 * Puts the playerId into the the random queue
	 */
	public void putIntoPlayerQueue(Player player) {
		ParseObject queue = new ParseObject("RandomQueue");
		queue.put("player", player.getParseId());
		queue.saveInBackground();
	}

	/**
	 * Send an invite to another player
	 * 
	 * @param inviter - the inviter
	 * @param invitee - the player whe receives the invite
	 */
	public void invitePlayer(Player inviter, Player invitee) {
		ParseObject invite = new ParseObject("Invite");
		invite.put("inviter", inviter.getParseId());
		invite.put("invitee", invitee.getParseId());
		invite.saveInBackground();
	}

	/**
	 * Retrieves the invitations a player has received
	 * 
	 * @param player - the Player
	 * @return an ArrayList with playerId:s
	 * @throws DatabaseException 
	 */
	public ArrayList<Invitation> getInvitations(Player player) throws DatabaseException {
		ArrayList<Invitation> returnList = new ArrayList<Invitation>();

		ParseQuery query = new ParseQuery("Invite");
		query.whereContains("invitee", player.getParseId());
		try {
			List<ParseObject> result = query.find();
			for(ParseObject object : result){
				returnList.add(DatabaseConverter.parseInvitation(this, object));
			}
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1006, "Failed to get invitations");
		}
		return returnList;
	}

	/**
	 * Removes an invitation from the database - called when a user declines or accepts an invitation.
	 * 	This is a complete deletion - there is no need to call the method with different 
	 * 	combinations of the players, as this is done automatically.
	 * 
	 * @param player1 - one player
	 * @param player2 - another player
	 * @throws DatabaseException
	 */
	public void removeInvitation(Player player1, Player player2) throws DatabaseException{
		try{
			ParseQuery query = new ParseQuery("Invite");
			query.whereEqualTo("Invitor", player1.getParseId());
			query.whereEqualTo("Invitee", player2.getParseId());
			List<ParseObject> objectList = query.find();
			query = new ParseQuery("Invite");
			query.whereEqualTo("Invitor", player2.getParseId());
			query.whereEqualTo("Invitee", player1.getParseId());
			objectList.addAll(query.find());
			for(ParseObject object : objectList){
				object.delete();
			}
		} catch(ParseException e){
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1008,"Error removing player from queue");
		}
	}

	/**
	 * A method to register a user
	 * @param inputNickname - the nickname of choice
	 * @param inputEmail - Email address
	 * @param inputPassword - password
	 * @param inputRepeatPassword - control password
	 * @throws ParseException - thrown if the database transfer fails
	 */
	public void registerPlayer(
			String inputNickname, 
			String inputEmail, 
			String inputPassword, 
			String inputRepeatPassword
			) throws DatabaseException{

		//Some checks that are done locally
		if(inputNickname == null || inputNickname.length() == 0) {
			throw new DatabaseException(101,"Invalid nickname");
		} else if( inputPassword == null || inputPassword.length() <5 ){
			throw new DatabaseException(102,"Weak password");
		} else if(!inputPassword.equals(inputRepeatPassword)){
			throw new DatabaseException(103,"Unrepeated password");
		}

		ParseUser user = new ParseUser();
		user.setUsername(inputNickname.toLowerCase());
		user.put("naturalUsername", inputNickname);	//to keep the input username, e.g capital letter
		user.put("globalScore", 0); //globalScore is set to zero when register
		user.setPassword(inputPassword);
		user.setEmail(inputEmail);
		try {
			user.signUp();
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(e.getCode(), e.getMessage());
		}
	}

	/**
	 * Login activity
	 * @param username - the user
	 * @param password - the password
	 * @throws DatabaseException - if something went wrong
	 */
	public void loginPlayer(String username, String password) throws DatabaseException{
		//login through parse.com's standard function
		//Using lowercase at login and registration to avoid case sensitivity problem
		try {
			ParseUser.logIn(username.toLowerCase(), password);
		} catch (ParseException e) {
			Log.d("Database",e.getMessage() + ". Code: " + Integer.toString(e.getCode()));
			//TODO: it doesn't store e.getCode() properly - check DatabaseException ...
			throw new DatabaseException(e.getCode(), e.getMessage());
		}
	}

	public void resetPassword(String email) throws DatabaseException {
		try {
			ParseUser.requestPasswordReset(email);
		} catch (ParseException e) {
			throw new DatabaseException(e.getCode(), e.getMessage());
		}
	}
}
