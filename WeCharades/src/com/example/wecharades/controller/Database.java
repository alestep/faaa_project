package com.example.wecharades.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;

import com.example.wecharades.model.Game;
import com.example.wecharades.model.Player;
import com.example.wecharades.model.Turn;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

/**
 * This class is intended as the interface against the server and database of this game.
 *  
 * @author Anton Dahlström
 *
 */
@SuppressLint("DefaultLocale")
public class Database {
	
	//A private method to parse a ParseObject to a game
	private static Game parseGame(ParseObject game){
		if(game.getClassName().equals("Game")){
			return new Game(game.getString("player1"), 
					game.getString("player2"),
					game.getString("currentPlayer"), 
					game.getInt("turn"), 
					game.getBoolean("finished"), 
					game.getUpdatedAt());
		} else{
			return null;
		}
	}

	//A method to parse ParseObject turns into turns
	private static Turn parseTurn(ParseObject turn){
		if(turn.getClassName().equals("Turn")){
			return new Turn(turn.getString("game"), 
					turn.getInt("turn"), 
					turn.getInt("state"), 
					turn.getString("word"), 
					turn.getString("videoLink"), 
					turn.getString("recPlayer"), 
					turn.getInt("recPlayerScore"), 
					turn.getString("ansPlayer"), 
					turn.getInt("ansPlayerScore") 
					);
		} else{
			return null;
		}
	}
	
	/**
	 * Randomly get 6 unique word from the database 
	 * @return an ArrayList with 6 words 
	 * @throws ParseException 
	 */
	private static Stack<String> getWords() throws ParseException{
		Stack<String> list = new Stack<String>();
		ParseQuery query = new ParseQuery("WordList");
		ArrayList<String> w = new ArrayList<String>();
		w.add("word");
		query.selectKeys(w);
		List<ParseObject> dblist = query.find();
		for(ParseObject word : dblist){
			list.add(word.getString("word"));
		}
		Collections.shuffle(list);
		return list;
	}

	/**
	 * Creates a new game on the server
	 * 
	 * @param 	playerId1: The player who created the game
	 * 			playerId2: The player who received the game
	 * @throws ParseException 
	 */
	public static void createGame(String playerId1, String playerId2) throws ParseException {
		LinkedList<ParseObject> parseList = new LinkedList<ParseObject>();

		ParseObject newGame = new ParseObject("Game");
		newGame.put("player1", playerId1);
		newGame.put("player2", playerId2);
		newGame.put("currentPlayer", playerId1);
		newGame.put("turn", 1);
		newGame.put("finished", false);

		parseList.add(newGame);

		//Adds all the six turns
		Stack<String> wordList = getWords();
		String recP, ansP;
		for(int i=1; i <= 6 ; i++){
			if(i%2 == 0){
				recP = playerId2;
				ansP = playerId1;
			} else{
				recP = playerId1;
				ansP = playerId2;
			}
			createTurn(newGame, i, wordList.pop(), recP, ansP);
		}
		ParseObject.saveAllInBackground(parseList, new SaveCallback(){
			public void done(ParseException e){
				if(e == null){
					Log.d("Database", "Completed transaction");
				} else{
					Log.d("Database", "Transaction was catastrophic: " + e.getMessage());
				}
			}
		});
	}

	/**
	 * A method to get a single game
	 * @param gameId
	 * @return The game with gameId
	 * @throws ParseException 
	 */
	public static Game getGame(String gameId) throws ParseException{
		ParseQuery query = new ParseQuery("Game");
		return parseGame(query.get(gameId));
	}

	/**
	 * Get a list of game-instances of the logged in player from the Parse server.
	 * @param The user Id
	 * @return an ArrayList with Game instances
	 * @throws ParseException 
	 */
	public static ArrayList<Game> getGames(String usrId) throws ParseException {
		ArrayList<Game> games = new ArrayList<Game>();
		ParseQuery query = new ParseQuery("Game");
		query.whereContains("player1", usrId);
		query.whereContains("player2", usrId);
		for(ParseObject game : query.find()){
			games.add(parseGame(game));
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
					object.put("playerTurn", game.getCurrentPlayer());
					object.put("turn", game.getTurn());
					object.saveEventually();
				} else{
					//TODO FIX toast or something here
					Log.d("Database",e.getMessage());
				}
			}
		});
	}
	
	/**
	 * A private method to create a new Turn. Should not be reachable outside this class!
	 * @param game - the Game ParseObject
	 * @param turnNumber - an integer representation of the turn number
	 * @param word - the word of the turn
	 * @param recPlayer - the player that should record
	 * @param ansPlayer - the player that should answer
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
	 * @throws ParseException 
	 */
	public static Turn getTurn(String gameId, int turnNumber) throws ParseException{
		ParseQuery query = new ParseQuery("Turn");
		query.whereEqualTo("game", gameId);
		query.whereEqualTo("turn", turnNumber);
		ParseObject turn = query.getFirst();
		return parseTurn(turn);
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
					//TODO exception
				}
			}
		});
	}

	/**
	 * Gets the player with player Id from the database
	 * @param playerId the Player's id
	 * @return a Player representation
	 */
	public static Player getPlayer(String playerId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Puts the playerId into the the random queue
	 */
	public static void putIntoPlayerQueue(String playerId) {
		ParseObject queue = new ParseObject("RandomQueue");
		queue.put("player", playerId);
		queue.saveInBackground();
	}

	/**
	 * Send an invite to another player
	 * 
	 * @param thisPlayerId the inviter
	 * @param otherPlayerId the invitee
	 */
	public static void invitePlayer(String thisPlayerId, String otherPlayerId) {
		ParseObject invite = new ParseObject("Invite");
		invite.put("inviter", thisPlayerId);
		invite.put("invitee", otherPlayerId);
		invite.saveInBackground();
	}

	/**
	 * Retrieves the invitations a player has received
	 * 
	 * @return an ArrayList with playerId:s
	 */
	public static ArrayList<String> getInvitations(String playerId) {
		ArrayList<String> returnList = new ArrayList<String>();

		ParseQuery query = new ParseQuery("Invite");
		query.whereContains("invitee", playerId);
		try {
			List<ParseObject> result = query.find();
			for(ParseObject object : result){
				returnList.add(object.getString("invitor"));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnList;
	}
	
	
	//TODO this should be one level above
	/*
	public static void acceptInvitation () {
		//TODO
	}

	public static void declineInvitation () {
		//TODO
	}
	*/

	/**
	 * A method to register a user
	 * @param view - the view of origin
	 * @param inputNickname - the nickname of choice
	 * @param inputEmail - Email address
	 * @param inputPassword - password
	 * @param inputRepeatPassword - controll password
	 * @throws ParseException - thrown if the database transferr fails
	 */
	public static void onClickRegister(View view, 
			String inputNickname, 
			String inputEmail, 
			String inputPassword, 
			String inputRepeatPassword) throws ParseException{
	
		if(inputNickname == null || inputNickname.length() == 0) {
			throw new ParseException(1,"Invalid nickname");
		} else if( inputPassword == null || inputPassword.length() <5 ){
			throw new ParseException(1,"Weak password");
		} else if(!inputPassword.equals(inputRepeatPassword)){
			throw new ParseException(1,"Unrepeated password");
		}
		
		ParseUser user = new ParseUser();
		user.setUsername(inputNickname.toLowerCase());
		user.put("naturalUsername", inputNickname);	//to keep the input username, e.g capital letter
		user.put("globalScore", 0); //globalScore is set to zero when register
		user.setPassword(inputPassword);
		user.setEmail(inputEmail);
		user.signUp();
	}
	
	/**
	 * Login activity
	 * @param view - the origin view //TODO Not needed?
	 * @param username - the user
	 * @param password - the password
	 * @throws ParseException - if something went wrong
	 */
	public static void onClickLogin(View view, String username, String password) throws ParseException{
		//login through parse.com's standard function
		//Using lowercase at login and registration to avoid case sensitivity problem
		ParseUser.logIn(username.toLowerCase(), password);
	}
}
