package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.Parse;
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
public class Database implements IDatabase {

	//This is used to avoid problems with using plain strings when calling the database.
	public static final String 	WORDLIST				= "WordList",
			WORDLIST_WORD			= "word",
			GAME 					= "Game",
			GAME_PLAYER_1 			= "player1",
			GAME_PLAYER_2 			= "player2",
			GAME_PLAYER_CURRENT 	= "currentPlayer",
			GAME_TURN 				= "turn",
			GAME_FINISH 			= "finished",
			TURN					= "Turn",
			TURN_GAME				= "game",
			TURN_TURN				= "turn",
			TURN_STATE				= "state",
			TURN_WORD				= "word",
			TURN_VIDEOLINK			= "videoLink",
			TURN_PLAYER_REC			= "recPlayer",
			TURN_PLAYER_REC_SCORE	= "recPlayerScore",
			TURN_PLAYER_ANS			= "ansPlayer",
			TURN_PLAYER_ANS_SCORE	= "ansPlayerScore",
			PLAYER					= "_User",
			PLAYER_USERNAME			= "username",
			PLAYER_USERNAME_NATURAL	= "naturalUsername",
			PLAYER_GLOBALSCORE		= "globalScore",
			RANDOMQUEUE				= "RandomQueue",
			RANDOMQUEUE_PLAYER		= "player",
			INVITE 					= "invite",
			INVITE_INVITER 			= "inviter",
			INVITE_INVITEE 			= "invitee";

	private static IDatabase singleton;
	private DatabaseConverter dbc;

	private Database(Context context){
		Parse.initialize(context, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
	}

	public static IDatabase getDatabaseInstance(Context context){
		if(singleton == null)
			singleton = new Database(context);
		return singleton;
	}

	/**
	 * Sets the converter for this database.
	 * @param dc - the Datacontroller
	 */
	@Override
	public void setConverter(DataController dc){
		dbc = new DatabaseConverter(dc);
	}

	/**
	 * Randomly get 6 unique word from the database 
	 * @return an ArrayList with 6 words 
	 * @throws DatabaseException 
	 */
	private Stack<String> getWords() throws DatabaseException{
		Stack<String> list = new Stack<String>();
		ParseQuery query = new ParseQuery(WORDLIST);
		ArrayList<String> w = new ArrayList<String>();
		w.add(WORDLIST_WORD);
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

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#createGame(com.example.wecharades.model.Player, com.example.wecharades.model.Player)
	 */
	@Override
	public void createGame(Player player1, Player player2) throws DatabaseException{

		LinkedList<ParseObject> parseList = new LinkedList<ParseObject>();

		ParseObject newGame = new ParseObject(GAME);
		newGame.put(GAME_PLAYER_1, player1.getParseId());
		newGame.put(GAME_PLAYER_2, player2.getParseId());
		newGame.put(GAME_PLAYER_CURRENT, player1.getParseId());
		newGame.put(GAME_TURN, 1);
		newGame.put(GAME_FINISH, false);

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
			parseList.add(createTurn(newGame, i, wordList.pop(), recP, ansP));
		}
		ParseObject.saveAllInBackground(parseList);
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getGame(java.lang.String)
	 */
	@Override
	public Game getGame(String gameId) throws DatabaseException{
		Game game;
		try {
			ParseQuery query = new ParseQuery(GAME);
			ParseObject dbGame = query.get(gameId);
			game = dbc.parseGame(dbGame);
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1003,"Failed to fetch game data");
		}
		return game;
	}

	private ParseObject getGameParseObject(String gameId) throws DatabaseException {
		ParseObject object = null;
		ParseQuery query = new ParseQuery("Game");
		try {
			object = query.get(gameId);
		} catch(ParseException e){
			Log.d("Database", e.getMessage());
			//TODO: fix error message
			throw new DatabaseException(1112, "Failed to get ParseObject");
		}

		return object;
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getGames(com.example.wecharades.model.Player)
	 */
	@Override
	public ArrayList<Game> getGames(Player player) throws DatabaseException {
		ArrayList<Game> games = new ArrayList<Game>();
		ArrayList<ParseQuery> queries = new ArrayList<ParseQuery>();
		ParseQuery query1 = new ParseQuery(GAME);
		query1.whereContains(GAME_PLAYER_1, player.getParseId());
		ParseQuery query2 = new ParseQuery(GAME);
		query2.whereContains(GAME_PLAYER_2, player.getParseId());

		queries.add(query1);
		queries.add(query2);

		ParseQuery mainQuery = ParseQuery.or(queries);

		try{
			List<ParseObject> dbResult = mainQuery.find();
			for(ParseObject game : dbResult){
				games.add(dbc.parseGame(game));//TODO The DB-helper should not connect to db.
			}
		} catch(ParseException e){
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1004,"Failed to fetch games");
		}
		return games;
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#updateGame(com.example.wecharades.model.Game)
	 */
	@Override
	public void updateGame(Game theGame) {
		final Game game = theGame;
		ParseQuery query = new ParseQuery(GAME);
		query.getInBackground(theGame.getGameId(), new GetCallback() {
			public void done(ParseObject object, ParseException e){
				if(e == null){
					//Updates the game on the server with the latest info
					object.put(GAME_PLAYER_CURRENT, game.getCurrentPlayer().getParseId());
					object.put(GAME_TURN, game.getTurn());
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
	private ParseObject createTurn(ParseObject game, int turnNumber, String word, String recPlayer, String ansPlayer) {
		ParseObject newTurn = new ParseObject(TURN);
		newTurn.put(TURN_GAME,game);
		newTurn.put(TURN_TURN,turnNumber);
		newTurn.put(TURN_STATE,Turn.INIT);
		newTurn.put(TURN_WORD,word);
		newTurn.put(TURN_VIDEOLINK,"");
		newTurn.put(TURN_PLAYER_REC,recPlayer);
		newTurn.put(TURN_PLAYER_REC_SCORE,0);
		newTurn.put(TURN_PLAYER_ANS,ansPlayer);
		newTurn.put(TURN_PLAYER_ANS_SCORE,0);
		return newTurn;
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getTurn(com.example.wecharades.model.Game, int)
	 */
	@Override
	public Turn getTurn(Game game, int turnNumber) throws DatabaseException{
		ParseQuery query = new ParseQuery(TURN);
		query.whereEqualTo(TURN_GAME, game.getGameId());
		query.whereEqualTo(TURN_TURN, turnNumber);
		ParseObject turn = null;
		try {
			turn = query.getFirst();
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1005, "Failed to get turn");
		}
		return dbc.parseTurn(turn);
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getTurns(com.example.wecharades.model.Game)
	 */
	@Override
	public ArrayList<Turn> getTurns(Game game) throws DatabaseException{
		ParseQuery query = new ParseQuery(TURN);
		//We have to do this, as the turn is linked to a parse object
		query.whereEqualTo(TURN_GAME, getGameParseObject(game.getGameId()));
		query.addAscendingOrder(TURN_TURN);

		List<ParseObject> dbList = null;
		try{
			dbList = query.find();
		} catch(ParseException e){
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1009, "Failed to get turns");
		}
		ArrayList<Turn> turnList = new ArrayList<Turn>();
		for(ParseObject turn : dbList){
			turnList.add(dbc.parseTurn(turn));
		}
		return turnList;
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#updateTurn(com.example.wecharades.model.Turn)
	 */
	@Override
	public void updateTurn(Turn theTurn){
		final Turn turn = theTurn;
		ParseQuery query = new ParseQuery(TURN);
		query.whereEqualTo(TURN_GAME, turn.getGameId());
		query.whereEqualTo(TURN_TURN, turn.getTurnNumber());
		query.getFirstInBackground(new GetCallback() {
			public void done(ParseObject dbTurn, ParseException e){
				if(e == null){
					dbTurn.put(TURN_STATE,turn.getState());
					dbTurn.put(TURN_VIDEOLINK, turn.getVideoLink());
					dbTurn.put(TURN_PLAYER_REC_SCORE, turn.getRecPlayerScore());
					dbTurn.put(TURN_PLAYER_ANS_SCORE, turn.getAnsPlayerScore());
				} else{
					Log.d("Database",e.getMessage());
				}
			}
		});
	}

	//Players -----------------------------------------------------------------------------------------//	

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getPlayer(java.lang.String)
	 */
	@Override
	public Player getPlayer(String playerName) throws DatabaseException {
		ParseQuery query = ParseUser.getQuery();
		query.whereEqualTo(PLAYER_USERNAME, playerName.toLowerCase());
		ParseObject dbPlayer;
		try {
			dbPlayer = query.getFirst();
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1010,"Failed to fetch user");
		}
		return dbc.parsePlayer(dbPlayer);
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getPlayerById(java.lang.String)
	 */
	@Override
	public Player getPlayerById(String parseId) throws DatabaseException {
		return dbc.parsePlayer(getPlayerObject(parseId));
	}

	/**
	 * 
	 * @param parseId
	 * @return
	 * @throws DatabaseException
	 */
	private ParseObject getPlayerObject(String parseId) throws DatabaseException{
		try {
			return ParseUser.getQuery().get(parseId);
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1010,"Failed to fetch user");
		}
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getPlayers()
	 */
	@Override
	public ArrayList<Player> getPlayers() throws DatabaseException {
		ArrayList<Player> players = new ArrayList<Player>();
		ParseQuery query = ParseUser.getQuery();

		try {
			List<ParseObject> dbResult = query.find();
			for(ParseObject player : dbResult) {
				players.add(dbc.parsePlayer(player));
			}
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1010,"Failed to fetch players");
		}
		return players;
	}

	//Invitations -----------------------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#putIntoPlayerQueue(com.example.wecharades.model.Player)
	 */
	@Override
	public void putIntoRandomQueue(Player player) {
		
		
		ParseObject queue = new ParseObject(RANDOMQUEUE);
		queue.put(RANDOMQUEUE_PLAYER, player.getParseId());
		queue.saveInBackground();
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#sendInvitation(com.example.wecharades.model.Invitation)
	 */
	@Override
	public void sendInvitation(Invitation inv){
		ParseObject invite = new ParseObject(INVITE);
		invite.put(INVITE_INVITER, inv.getInviter().getParseId());
		invite.put(INVITE_INVITEE, inv.getInvitee().getParseId());
		invite.saveInBackground();
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getInvitations(com.example.wecharades.model.Player)
	 */
	@Override
	public ArrayList<Invitation> getInvitations(Player player) throws DatabaseException {
		ArrayList<Invitation> returnList = new ArrayList<Invitation>();

		ParseQuery query = new ParseQuery(INVITE);
		query.whereContains(INVITE_INVITEE, player.getParseId());
		try {
			List<ParseObject> result = query.find();
			for(ParseObject object : result){
				returnList.add(dbc.parseInvitation(object));
			}
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1006, "Failed to get invitations");
		}
		return returnList;
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#removeInvitation(com.example.wecharades.model.Invitation)
	 */
	@Override
	public void removeInvitation(Invitation inv) throws DatabaseException{
		try{
			ParseQuery query = new ParseQuery(INVITE);
			query.whereEqualTo(INVITE_INVITER, inv.getInviter().getParseId());
			query.whereEqualTo(INVITE_INVITEE, inv.getInvitee().getParseId());
			List<ParseObject> objectList = query.find();
			for(ParseObject object : objectList){
				object.delete();
			}
		} catch(ParseException e){
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1008,"Error removing player from queue");
		}
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#removeInvitations(java.util.Collection)
	 */
	@Override
	public void removeInvitations(Collection<Invitation> inv) throws DatabaseException{
		for(Invitation invite : inv){
			removeInvitation(invite);
		}
	}

	//User registration -----------------------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#registerPlayer(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
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
		user.put(PLAYER_USERNAME_NATURAL, inputNickname);	//to keep the input username, e.g capital letter
		user.put(PLAYER_GLOBALSCORE, 0); //globalScore is set to zero when register
		user.setPassword(inputPassword);
		user.setEmail(inputEmail);
		try {
			user.signUp();
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(e.getCode(), e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#loginPlayer(java.lang.String, java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getCurrentPlayer()
	 */
	@Override
	public Player getCurrentPlayer(){
		return dbc.parsePlayer(ParseUser.getCurrentUser());
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#resetPassword(java.lang.String)
	 */
	@Override
	public void resetPassword(String email) throws DatabaseException {
		try {
			ParseUser.requestPasswordReset(email);
		} catch (ParseException e) {
			throw new DatabaseException(e.getCode(), e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#logOut()
	 */
	@Override
	public void logOut(){
		ParseUser.logOut();
	}

}
