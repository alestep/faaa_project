package com.example.wecharades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * This class is intended as the interface against the server and database of this game.
 *  
 * @author Anton Dahlström
 *
 */
public class Database {

	//A variable to temporarily save a query result. Should be deleted after use (set to null)
	private static Object queryReturn;

	private static String getWord(){
		return "Testord"; //TODO This should be implemented later.
	}

	/**
	 * Creates a new game on the server
	 * 
	 * @param 	playerId1: The player who created the game
	 * 			playerId2: The player who received the game
	 */
	public static void createGame(String playerId1, String playerId2) {
		LinkedList<ParseObject> parseList = new LinkedList<ParseObject>();

		ParseObject newGame = new ParseObject("Game");
		newGame.put("player1", playerId1);
		newGame.put("player2", playerId2);
		newGame.put("currentPlayer", playerId1);
		newGame.put("turn", 1);
		newGame.put("finished", false);

		parseList.add(newGame);

		//Adds all the six turns
		ParseObject newTurn;
		for(int i=1; i <= 6 ; i++){
			newTurn = new ParseObject("Turn");
			newTurn.put("game",newGame);
			newTurn.put("turn",i);
			newTurn.put("state","1");
			newTurn.put("word",getWord());
			newTurn.put("videoLink","N/A");
			newTurn.put("videoPlayer",playerId1);
			newTurn.put("videoPlayerScore",0);
			newTurn.put("answerPlayer",playerId2);
			newTurn.put("answerPlayerScore",0);
		}
		ParseObject.saveAllInBackground(parseList);
	}

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

	/**
	 * A method to get a single game
	 * @param gameId
	 * @return The game with gameId
	 */
	public static Game getGame(String gameId){
		ParseQuery query = new ParseQuery("Game");
		query.getInBackground(gameId, new GetCallback() {
			public void done(ParseObject object, ParseException e){
				if(e == null){
					queryReturn = object;
				} else{
					//TODO Fix exceptions
				}
			}
		});
		Game game = parseGame((ParseObject) queryReturn);
		queryReturn = null;
		return game;
	}

	/**
	 * Get a list of game-instances of the logged in player from the Parse server.
	 * @param The user Id
	 * @return an ArrayList with Game instances
	 */
	public static ArrayList<Game> getGames(String usrId) {
		ParseQuery query = new ParseQuery("Game");
		query.whereContains("player1", usrId);
		query.whereContains("player2", usrId);
		query.findInBackground(new FindCallback(){
			public void done(List<ParseObject> parseObjects, ParseException e){
				if(e == null){
					queryReturn = parseObjects;
				} else{
					//TODO Exceptions again!
				}
			}
		});
		ArrayList<Game> games = new ArrayList<Game>();
		if (queryReturn != null && queryReturn instanceof List){ //check if we have stuff from the query
			for(ParseObject dbGame : (List<ParseObject>) queryReturn){
				games.add(parseGame(dbGame));
			}
		}
		queryReturn = null;
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
					object.saveInBackground();
				} else{
					//TODO Fix exceptions
				}
			}
		});
	}
	
	/**
	 * Retrieves a turn from the database
	 * @param gameId - the game to which this turn belongs
	 * @param turnNumber - the turn number
	 * @return A Turn class representation of the retrieved data
	 */
	public static Turn getTurn(String gameId, int turnNumber){
		ParseQuery query = new ParseQuery("Turn");
		query.whereEqualTo("game", gameId);
		query.whereEqualTo("turn", turnNumber);
		query.getInBackground(gameId, new GetCallback(){
			public void done(ParseObject object, ParseException e){
				if(e == null){
					queryReturn = object;
				} else{
					//TODO fix exception
				}
			}
		});
		return null;
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
		//TODO We should maybe check if the player is already in queue

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

}