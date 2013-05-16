kpackage com.example.wecharades;

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
	//Fix for strange query behavious
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
			newTurn.add("game",newGame);
			newTurn.add("turn",i);
			newTurn.add("state","1");
			newTurn.add("word",getWord());
			newTurn.add("videoLink","N/A");
			newTurn.add("videoPlayer",playerId1);
			newTurn.add("videoPlayerScore",0);
			newTurn.add("answerPlayer",playerId2);
			newTurn.add("answerPlayerScore",0);
		}
		ParseObject.saveAllInBackground(parseList);
	}

	//A private method to parse a ParseObject to a game
	private static Game parseGame(ParseObject game){
		if(game.getClassName().equals("Game")){
			return new Game(game.getString("player1"), game.getString("player2"),game.getString("currentPlayer"), game.getInt("turn"), game.getBoolean("finished"), game.getUpdatedAt());
		} else{
			return null;
		}
	}

	/**
	 * A method to get a single game
	 * @param gameId
	 * @return
	 */
	public static Game getGame(String gameId){
		Game game;
		ParseQuery query = new ParseQuery("Game");
		query.getInBackground(gameId, new GetCallback() {
			public void done(ParseObject object, ParseException e){
				if(e == null){
					queryReturn = parseGame(object);
				} else{
					//TODO Generate error code
				}
			}
		});
		return (Game) queryReturn;
		return null;
	}

	/**
	 * Get a list of game-instances of the logged in player from the Parse server.
	 * 
	 * @return an ArrayList with Game instances
	 */
	public static ArrayList<Game> getGames() {
		String sharedPreferences = null; //TODO Add the sharedpreferences stored ID here
		ParseQuery query = new ParseQuery("Game");
		query.whereContains("player1", sharedPreferences);
		query.whereContains("player2", sharedPreferences);//TODO
		return null;
	}

	/**
	 * Updates a game to the Parse server.
	 * 
	 */
	public static void updateGame(Game theGame) {

	}

	public static Player getPlayer(String playerId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Puts the playerId into the the random queue
	 */
	public static void putIntoPlayerQueue(String playerId) {
		//We should maybe check if the player is already in queue

		ParseObject queue = new ParseObject("RandomQueue");
		queue.put("player", playerId);
		queue.saveInBackground();
	}

	/**
	 * Registers invitation
	 */
	public static void invitePlayer(String thisPlayerId, String otherPlayerId) {
		ParseObject invite = new ParseObject("Invite");
		invite.put("invitor", thisPlayerId);
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