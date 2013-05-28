package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.PushService;

/**
 * This class is intended as the interface against the server and database of this game.
 *  
 * @author Anton Dahlström
 *
 */
@SuppressLint("DefaultLocale")
public class Database extends Observable implements IDatabase {

	//TODO change how dbexceptions are sent

	//This is used to avoid problems with using plain strings when calling the database.
	public static final String
	WORDLIST				= "WordList",
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
	PLAYER_GAMES_PLAYED		= "gamesPlayed",
	PLAYER_GAMES_LOST		= "gamesLost",
	PLAYER_GAMES_DRAW		= "gamesDraw",
	PLAYER_GAMES_WON 		= "gamesWon",
	RANDOMQUEUE				= "RandomQueue",
	RANDOMQUEUE_PLAYER		= "player",
	INVITE 					= "invite",
	INVITE_INVITER 			= "inviter",
	INVITE_INVITEE 			= "invitee";

	private static IDatabase singleton;
	private DatabaseConverter dbc;

	private Database(Context context){
		Parse.initialize(context.getApplicationContext(), "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
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

	private void sendError(DatabaseException e){
		setChanged();
		notifyObservers(new DBMessage(DBMessage.ERROR, e));
	}

	//Games -----------------------------------------------------------------------------------------//	

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#createGame(com.example.wecharades.model.Player, com.example.wecharades.model.Player)
	 */
	@Override
	public void createGame(Player player1, Player player2){
		//Begin the chain of methods in order to create a game.
		checkExistingGame(player1, player2);
	}
	/**
	 * A query to check if a game between two players already exist
	 */
	private void checkExistingGame(final Player player1, final Player player2){
		ArrayList<String> idList = new ArrayList<String>();
		idList.add(player1.getParseId()); idList.add(player2.getParseId());
		ParseQuery mainQuery = new ParseQuery(GAME);
		mainQuery.whereContainedIn(GAME_PLAYER_1, idList);
		mainQuery.findInBackground(new FindCallback(){
			public void done(List<ParseObject> obj, ParseException e){
				if(e == null){
					//If a game doesn't exist, we can continue
					List<ParseObject> actualList = new LinkedList<ParseObject>();
					for(ParseObject o : obj){
						if( (o.getString(GAME_PLAYER_1).equals(player1.getParseId())
								&& o.getString(GAME_PLAYER_2).equals(player2.getParseId()))
								||
								(o.getString(GAME_PLAYER_1).equals(player2.getParseId())
										&& o.getString(GAME_PLAYER_2).equals(player1.getParseId()))
								){
							actualList.add(o);
						}
					}
					if(actualList.isEmpty()){
						createGameInBackground(player1, player2);
					} else{
						sendError(new DatabaseException(1000,""));
					}
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
				}
			}
		});
	}
	/**
	 * Helper method for createGame. The thread calling this method should already be running in the background!
	 */
	private void createGameInBackground(Player player1, Player player2){
		try{
			Stack<String> wordList = getWords();
			LinkedList<ParseObject> parseList = new LinkedList<ParseObject>();

			ParseObject newGame = new ParseObject(GAME);
			newGame.put(GAME_PLAYER_1, player1.getParseId());
			newGame.put(GAME_PLAYER_2, player2.getParseId());
			newGame.put(GAME_PLAYER_CURRENT, player1.getParseId());
			newGame.put(GAME_TURN, 1);
			newGame.put(GAME_FINISH, false);
			parseList.add(newGame);
			//Adds all the six turns
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
			ParseObject.saveAll(parseList);
		} catch(ParseException e){
			sendError(new DatabaseException(e.getCode(), e.getMessage()));
		}
	}
	/**
	 * Randomly get 6 unique word from the database 
	 * @return an ArrayList with 6 words 
	 * @throws ParseException
	 */
	private Stack<String> getWords() throws ParseException{
		ParseQuery query = new ParseQuery(WORDLIST);
		List<ParseObject> dblist = query.find();
		Stack<String> wordList = new Stack<String>();
		for(ParseObject word : dblist){
			wordList.add(word.getString(WORDLIST_WORD));
		}
		Collections.shuffle(wordList);
		return wordList;
	}

	/**
	 * Method to delete a game in background
	 */
	public void removeGame(Game game){
		ParseQuery query = new ParseQuery(GAME);
		query.getInBackground(game.getGameId(), new GetCallback(){
			public void done(ParseObject game, ParseException e){
				if(e == null){
					try{
						removeTurns(game);
						game.delete();
					} catch(ParseException e2){
						sendError(new DatabaseException(e2.getCode(), e2.getMessage()));
					}
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
				}
			}
		});
	}
	/*
	 * Helper method to removeTurns - called when the game has been fetched from the db.
	 */
	private void removeTurns(ParseObject game) throws ParseException{
		ParseQuery turnQuery = new ParseQuery(TURN);
		turnQuery.whereEqualTo(TURN_GAME, game);
		List<ParseObject> list = turnQuery.find();
		for(ParseObject turn : list){
			turn.delete();
		}
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
			throw new DatabaseException(e.getCode(), e.getMessage());
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
			throw new DatabaseException(e.getCode(), e.getMessage());
		}

		return object;
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#getGames(com.example.wecharades.model.Player)
	 */
	@Override
	public void fetchGames(Player player){
		final Database db = this;
		ArrayList<ParseQuery> queries = new ArrayList<ParseQuery>();
		ParseQuery query1 = new ParseQuery(GAME);
		query1.whereContains(GAME_PLAYER_1, player.getParseId());
		ParseQuery query2 = new ParseQuery(GAME);
		query2.whereContains(GAME_PLAYER_2, player.getParseId());

		queries.add(query1);
		queries.add(query2); 

		ParseQuery mainQuery = ParseQuery.or(queries);

		mainQuery.findInBackground(new FindCallback(){
			public void done(List<ParseObject> dbResult, ParseException e){
				if(e == null){
					if (db != null){
						db.getTurnsInBackgrund(dbResult);
					}
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
				}
			}
		});
	}
	/*
	 * Helper method to fetch games. Games and turns are fetched in background.
	 */
	private void getTurnsInBackgrund(final List<ParseObject> gameList){
		if(gameList.isEmpty()){
			//If there are no games, we should still update screen to remove old games!
			setChanged();
			notifyObservers(new DBMessage(DBMessage.GAMELIST, new TreeMap<Game, ArrayList<Turn>>()));
		} else{
			LinkedList<ParseQuery> gameQueries = new LinkedList<ParseQuery>();
			for(ParseObject game : gameList){
				gameQueries.add((new ParseQuery(TURN)).whereEqualTo(TURN_GAME, game));
			}
			ParseQuery masterQuery = ParseQuery.or(gameQueries);
			masterQuery.findInBackground(new FindCallback(){
				public void done(List<ParseObject> resultList, ParseException e){
					if(e == null){
						if(!resultList.isEmpty()){
							try{
								TreeMap<Game, ArrayList<Turn>> map = new TreeMap<Game, ArrayList<Turn>>();
								TreeMap<String, Game> idList = new TreeMap<String, Game>();
								Game game;
								for(ParseObject obj : gameList){
									game = dbc.parseGame(obj);
									map.put(game, new ArrayList<Turn>());
									idList.put(game.getGameId(), game);
								}
								//Then, we must parse the ParseObjects to turns and add them to the correct list
								for(ParseObject obj : resultList){
									Turn turn = dbc.parseTurn(obj); //TODO This should also be fixed.
									Game g = idList.get(turn.getGameId());
									ArrayList<Turn> tl = map.get(g);
									tl.add(turn);
								}
								setChanged();
								notifyObservers(new DBMessage(DBMessage.GAMELIST, map));
							} catch(DatabaseException e2){
								sendError(new DatabaseException(e2.getCode(), e2.getMessage()));
							}
						} else{
							setChanged();
							notifyObservers(new DBMessage(DBMessage.GAMELIST, new TreeMap<Game, ArrayList<Turn>>()));
						}
					} else{
						sendError(new DatabaseException(e.getCode(), e.getMessage()));
					}
				}
			});
		}
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
					object.put(GAME_TURN, game.getTurnNumber());
					object.put(GAME_FINISH, game.isFinished());
					object.saveInBackground();
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
				}
			}
		});
	}

	//Turn -----------------------------------------------------------------------------------------//	

	/**
	 * A PRIVATE method to create a new ParseObject-Turn. Not pushed to db.
	 * 	This is a helper class for create game.
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
		query.whereEqualTo(TURN_GAME, getGameParseObject(game.getGameId()));
		query.whereEqualTo(TURN_TURN, turnNumber);
		ParseObject turn = null;
		try {
			turn = query.getFirst();
		} catch (ParseException e) {
			Log.d("Database",e.getMessage());
			throw new DatabaseException(1004, "Failed to get turn");
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
			throw new DatabaseException(1005, "Failed to get turns");
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
		query.whereEqualTo(TURN_GAME, ParseObject.createWithoutData(GAME, turn.getGameId()));
		/*try { //TODO background activity
			query.whereEqualTo(TURN_GAME, getGameParseObject(turn.getGameId()));
		} catch (DatabaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		query.whereEqualTo(TURN_TURN, turn.getTurnNumber());
		query.getFirstInBackground(new GetCallback() {
			public void done(ParseObject dbTurn, ParseException e){
				if(e == null){
					dbTurn.put(TURN_STATE,turn.getState());
					dbTurn.put(TURN_VIDEOLINK, turn.getVideoLink());
					dbTurn.put(TURN_PLAYER_REC_SCORE, turn.getRecPlayerScore());
					dbTurn.put(TURN_PLAYER_ANS_SCORE, turn.getAnsPlayerScore());
					dbTurn.saveInBackground();
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
				}
			}
		});
	}
	@Override
	public void updateTurns(final List<Turn> turnList) {
		LinkedList<ParseQuery> ql = new LinkedList<ParseQuery>(); 
		for(Turn turn : turnList){
			ParseQuery q = new ParseQuery(TURN);
			q.whereEqualTo(TURN_GAME, ParseObject.createWithoutData(GAME, turn.getGameId()));
			q.whereEqualTo(TURN_TURN, turn.getTurnNumber());
			ql.add(q);
		}
		ParseQuery main = ParseQuery.or(ql);
		main.findInBackground(new FindCallback(){
			public void done(List<ParseObject> result, ParseException e){
				if(e == null){
					for(ParseObject dbTurn : result){
						for(Turn turn : turnList){
							if(turn.getGameId().equals(dbTurn.getString(TURN_GAME)) 
									&& turn.getTurnNumber() == dbTurn.getInt(TURN_TURN)){
								dbTurn.put(TURN_STATE, turn.getState());
								dbTurn.put(TURN_VIDEOLINK, turn.getVideoLink());
								dbTurn.put(TURN_PLAYER_REC_SCORE, turn.getRecPlayerScore());
								dbTurn.put(TURN_PLAYER_ANS_SCORE, turn.getAnsPlayerScore());
							}
							if(!result.isEmpty()){
								try{
									ParseObject.saveAll(result);
								} catch(ParseException e2){
									sendError(new DatabaseException(e.getCode(), e.getMessage()));
								}
							}
						}
					}
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
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
			throw new DatabaseException(1006,"Failed to fetch user");
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
	private ParseObject getPlayerObject(String parseId) throws DatabaseException {
		try {
			return ParseUser.getQuery().get(parseId);
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1007,"Failed to fetch user");
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
			throw new DatabaseException(1008,"Failed to fetch players");
		}
		return players;
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#incrementPlayerStats(Player player)
	 */
	public void incrementPlayerStats(final Player player, final int scoreInc, final int won, final int draw, final int lost){
		ParseQuery query = ParseUser.getQuery();
		query.getInBackground(player.getParseId(), new GetCallback(){
			public void done(ParseObject obj, ParseException e){
				if(e == null){
					obj.increment(PLAYER_GAMES_DRAW, draw);
					obj.increment(PLAYER_GAMES_LOST, lost);
					obj.increment(PLAYER_GAMES_WON, won);
					obj.increment(PLAYER_GAMES_PLAYED);
					obj.increment(PLAYER_GLOBALSCORE, scoreInc);
					obj.saveInBackground();
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
				}
			}
		});
	}

	/**
	 * Generates a list with the 10 players with best global score
	 * @return a list with top 10 players based on their global score
	 * @throws DatabaseException
	 */
	public ArrayList<Player> getTopTenPlayers() throws DatabaseException {
		ArrayList<Player> players = new ArrayList<Player>();
		ParseQuery query = ParseUser.getQuery();
		query.addDescendingOrder("globalScore");
		query.setLimit(10);

		try {
			List<ParseObject> dbResult = query.find();
			for(ParseObject player : dbResult) {
				players.add(dbc.parsePlayer(player));
			}
		} catch (ParseException e) {
			Log.d("Database", e.getMessage());
			throw new DatabaseException(1008,"Failed to fetch players");
		}
		return players;

	}

	//Invitations -----------------------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#putIntoPlayerQueue(com.example.wecharades.model.Player)
	 */
	@Override
	public void putIntoRandomQueue(final Player player){
		final Database db = this;

		ParseQuery query = new ParseQuery(RANDOMQUEUE);
		query.findInBackground(new FindCallback(){
			public void done(List<ParseObject> queryList, ParseException e){
				if(e == null){
					try{
						if(queryList.isEmpty()){
							db.putRandom(player);
						} else if(queryList.contains(ParseObject.createWithoutData(PLAYER, player.getParseId()))){
							setChanged();
							notifyObservers(new DBMessage(DBMessage.MESSAGE, "Already in queue"));
						} else{
							Collections.shuffle(queryList);
							try {
								Player p2 = getPlayerById(queryList.get(0).getString(RANDOMQUEUE_PLAYER));
								db.createGame(player, p2);
								db.removeRandom(p2);
							} catch (DatabaseException e1) {
								sendError(new DatabaseException(e1.getCode(), e1.getMessage()));
							}
						}
					} catch(ParseException e2){
						sendError(new DatabaseException(e2.getCode(), e2.getMessage()));
					}
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
				}
			}
		});
	}
	/*
	 * Helper methods for putInRandomQueue
	 */
	private void putRandom(Player player) throws ParseException{
		ParseObject queue = new ParseObject(RANDOMQUEUE);
		queue.put(RANDOMQUEUE_PLAYER, player.getParseId());
		queue.save();
	}
	private void removeRandom(Player player) throws ParseException{
		ParseQuery query = new ParseQuery(RANDOMQUEUE);
		query.whereEqualTo(RANDOMQUEUE_PLAYER, player.getParseId());
		//First fetches the player from the randomqueue, then deletes the player. All on speparate thread.
		List<ParseObject> thePlayer = query.find();
		for(ParseObject p : thePlayer){
			p.delete();
		}
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
	public void getInvitations(Player player) {
		//Invitations
		ParseQuery others = new ParseQuery(INVITE);
		others.whereContains(INVITE_INVITEE, player.getParseId());
		ParseQuery mine = new ParseQuery(INVITE);
		mine.whereContains(INVITE_INVITER, player.getParseId());
		LinkedList<ParseQuery> ql = new LinkedList<ParseQuery>();
		ql.add(mine); ql.add(others);
		ParseQuery query = ParseQuery.or(ql);

		query.findInBackground(new FindCallback(){
			public void done(List<ParseObject> result, ParseException e){
				if(e == null){
					ArrayList<Invitation> invList = new ArrayList<Invitation>();
					try{
						if(!result.isEmpty()){
							for(ParseObject obj : result){
								invList.add(dbc.parseInvitation(obj));
							}
						}
						setChanged();
						notifyObservers(new DBMessage(DBMessage.INVITATIONS, invList));
					} catch(DatabaseException e2){
						sendError(e2);
					}
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#removeInvitation(com.example.wecharades.model.Invitation)
	 */
	@Override
	public void removeInvitation(Invitation inv) {
		ParseQuery query = new ParseQuery(INVITE);
		query.whereEqualTo(INVITE_INVITER, inv.getInviter().getParseId());
		query.whereEqualTo(INVITE_INVITEE, inv.getInvitee().getParseId());
		query.findInBackground(new FindCallback(){
			public void done(List<ParseObject> result, ParseException e){
				if(e == null){
					for(ParseObject object : result){
						object.deleteInBackground();
					}
				} else{
					sendError(new DatabaseException(e.getCode(), e.getMessage()));
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.example.wecharades.model.IDatabase#removeInvitations(java.util.Collection)
	 */
	@Override
	public void removeInvitations(Collection<Invitation> inv){
		if(!inv.isEmpty()){
			LinkedList<ParseQuery> queries = new LinkedList<ParseQuery>();
			ParseQuery q;
			for(Invitation invite : inv){
				q = new ParseQuery(INVITE);
				q.whereEqualTo(INVITE_INVITER, invite.getInviter().getParseId());
				q.whereEqualTo(INVITE_INVITEE, invite.getInvitee().getParseId());
				queries.add(q);
			}
			ParseQuery main = ParseQuery.or(queries);
			main.findInBackground(new FindCallback(){
				public void done(List<ParseObject> result, ParseException e){
					if(e == null){
						try{
							for(ParseObject obj : result){
								obj.delete();
							}
						} catch(ParseException e2){
							sendError(new DatabaseException(e2.getCode(), e2.getMessage()));
						}
					} else{
						sendError(new DatabaseException(e.getCode(), e.getMessage()));
					}
				}
			});
		}
	}

	//User login, registration and logout -----------------------------------------------------------------------------


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
		if(inputNickname == null || !Pattern.compile("^[A-Za-z0-9_]{2,16}$").matcher(inputNickname).matches()) {
			throw new DatabaseException(2001,"Invalid nickname. \n - It should be between 2 and 16 characters.\n - It should only contain A-Z, a-z, 0-9 and underline");
		} else if (inputEmail == null || inputEmail.length() == 0) {
			throw new DatabaseException(125, "Invalid e-mail address.");
		} else if( inputPassword == null || inputPassword.length() <5 ){
			throw new DatabaseException(2003,"Weak password");
		} else if(!inputPassword.equals(inputRepeatPassword)){
			throw new DatabaseException(2004,"Unrepeated password");
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
	@Override
	public void removePushNotification(Context context){
		Player p = getCurrentPlayer();
		Set<String> setOfAllSubscriptions = PushService.getSubscriptions(context);
		for(String s: setOfAllSubscriptions){
			if(s.equals(p.getName())){
				PushService.unsubscribe(context, p.getName());
				System.out.println("Unsubcribed from push notifications");
			}
		}		
	}

	@Override
	public void subscribetoNotification(Context context) {
		//PushService.subscribe(context, getCurrentPlayer().getName(), StartActivity.class);

	}
}
