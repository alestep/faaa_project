package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.model.Turn;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * This class is intended as the interface against the server and database of this game.
 *  
 * @author Anton Dahlström
 *
 */
@SuppressLint("DefaultLocale")
public class Database {
	//TODO Make Database an instance-class!
	
	//Helper methods -----------------------------------------------------------------------------------------//
	//TODO These should be moved to a separate class!
	
	//A private method to parse a ParseObject to a game
	private static Game parseGame(ParseObject game) throws DatabaseException{
		if(game.getClassName().equals("Game")){
			//Save player locally to avoid multiple fetches. //TODO have a local list of players??
			Player p1 = getPlayer(game.getString("player1")); 
			Player p2 = getPlayer(game.getString("player2"));
			Player current = (game.getString("currentPlayer").equals(p1.getParseId())) ? p1 : p2 ;
			return new Game(
					p1,
					p2,
					current,
					game.getInt("turn"), 
					game.getBoolean("finished"), 
					game.getUpdatedAt());
		} else{
			return null;
		}
	}

	//A method to parse ParseObject turns into turns
	private static Turn parseTurn(ParseObject turn) throws DatabaseException{
		if(turn.getClassName().equals("Turn")){
			return new Turn(
					turn.getString("game"), 
					turn.getInt("turn"), 
					turn.getInt("state"), 
					turn.getString("word"), 
					turn.getString("videoLink"), 
					getPlayer(turn.getString("recPlayer")), 
					turn.getInt("recPlayerScore"), 
					getPlayer(turn.getString("ansPlayer")), 
					turn.getInt("ansPlayerScore") 
					);
		} else{
			return null;
		}
	}

	//A method to parse ParseObject players to players
	private static Player parsePlayer(ParseObject player){
		if(player.getClassName().equals("User")){
			return new Player(
					player.getObjectId(), 
					player.getString("naturalUsername"), 
					player.getInt("globalScore"));
		} else{
			return null;
		}
	}

	private static Invitation parseInvitation(ParseObject invitation) throws DatabaseException{
		if(invitation.getClassName().equals("Invite")){
			return new Invitation(getPlayer(invitation.getString("inviter")), getPlayer(invitation.getString("invitee")), invitation.getCreatedAt());
		} else{
			return null;
		}
	}

	/**
	 * Randomly get 6 unique word from the database 
	 * @return an ArrayList with 6 words 
	 * @throws DatabaseException 
	 */
	private static Stack<String> getWords() throws DatabaseException{
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
	public static void createGame(Player player1, Player player2) throws DatabaseException{

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
	public static Game getGame(String gameId) throws DatabaseException{
		ParseQuery query = new ParseQuery("Game");
		Game game;
		try {
			game = parseGame(query.get(gameId));
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
	public static ArrayList<Game> getGames(Player player) throws DatabaseException {
		ArrayList<Game> games = new ArrayList<Game>();
		ParseQuery query = new ParseQuery("Game");
		query.whereContains("player1", player.getParseId());
		query.whereContains("player2", player.getParseId());
		try{
			for(ParseObject game : query.find()){
				games.add(parseGame(game));
			}
		} catch(ParseException e){
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1004,"Failed to fetch games");
		}
		return games;
	}

	/**
	 * Update a game on the Parse server.
	 * @param The game to be updated
	 */
	public static void updateGame(Game theGame) {
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

	/*
	 * A PRIVATE method to create a new Turn. Should not be reachable outside this class!
	 * @param game - the Game ParseObject
	 * @param turnNumber - an integer representation of the turn number
	 * @param word - the word of the turn
	 * @param recPlayer - the parseId of the player that should record
	 * @param ansPlayer - the parseId of the player that should answer
	 */
	private static void createTurn(ParseObject game, int turnNumber, String word, String recPlayer, String ansPlayer){
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
	public static Turn getTurn(Game game, int turnNumber) throws DatabaseException{
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
		return parseTurn(turn);
	}
	
	/**
	 * Returns a list of all games associated with a game
	 * @param game - the game to fetch
	 * @return an ArrayList of turns
	 * @throws DatabaseException
	 */
	public static ArrayList<Turn> getTurns(Game game) throws DatabaseException{
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
			turnList.add(parseTurn(turn));
		}
		return turnList;
	}

	/**
	 * Updates a specific turn according to its local version
	 * @param theTurn - the Turn object that should be used as a reference
	 */
	public static void updateTurn(Turn theTurn){
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
	public static Player getPlayer(String playerName) throws DatabaseException {
		ParseQuery query = ParseUser.getQuery();
		query.whereEqualTo("username", playerName.toLowerCase());
		ParseObject dbPlayer;
		try {
			dbPlayer = query.getFirst();
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1010,"Failed to fetch user");
		}
		return parsePlayer(dbPlayer);
	}

	/**
	 * Puts the playerId into the the random queue
	 */
	public static void putIntoPlayerQueue(Player player) {
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
	public static void invitePlayer(Player inviter, Player invitee) {
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
	public static ArrayList<Invitation> getInvitations(Player player) throws DatabaseException {
		ArrayList<Invitation> returnList = new ArrayList<Invitation>();

		ParseQuery query = new ParseQuery("Invite");
		query.whereContains("invitee", player.getParseId());
		try {
			List<ParseObject> result = query.find();
			for(ParseObject object : result){
				returnList.add(parseInvitation(object));
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
	public static void removeInvitation(Player player1, Player player2) throws DatabaseException{
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
	public static void registerPlayer(
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
			throw new DatabaseException(104, e.getMessage());
		}
	}

	/**
	 * Login activity
	 * @param username - the user
	 * @param password - the password
	 * @throws DatabaseException - if something went wrong
	 */
	public static void loginPlayer(String username, String password) throws DatabaseException{
		//login through parse.com's standard function
		//Using lowercase at login and registration to avoid case sensitivity problem
		try {
			ParseUser.logIn(username.toLowerCase(), password);
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1007, "Login failed");
		}
	}
}
