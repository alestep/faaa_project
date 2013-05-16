package com.example.wecharades;

/**
 * This class represents a turn in a game.
 *  Each turn has two players - one recording player and one answering player.
 *   There is also a pointer to the active player, although this might not be necessary.
 *  Each turn also has one of three states (stored in static variables)
 *  Each turn has a video instance
 *  
 *  It is the turns responsibility to do the game-related stuff, like record
 *   videos and possibility to guess. This can be implemented by delegation, although
 *   this is a later problem.
 *   
 *  The Turn data is stored in the online database:
 *   The turn state, score and video link  is stored here and synced in a later stage.
 * 
 * @author Anton Dahlström
 *
 */
public class Turn {
	private String gameId;
	private int turnNumber;
	private String word;
	private Player rec, ans, activePlayer;
	private int recScore = 0, ansScore = 0;
	//Variables to get the state of this turn
	private int state;
	public static final int INIT   = 0,	
							VIDEO  = 1,
							FINISH = 2;
	
	public Turn(String gameId, int turnNumber, Player rec, Player ans, String word){
		this.rec = rec;
		this.activePlayer = rec;
		this.ans = ans;
		this.word = word;
		this.state = INIT;
	}
	
	public String getGameId() {
		return gameId;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	/**
	 * Play the next turn - this should probably delegate to some other classes later.
	 *
	 */
	public void playTurn(){
		//We could have a check for current player here.
		if(activePlayer.equals(rec)){
			//video = new Video();
			activePlayer = ans;
			state = VIDEO;
		}
		else if (activePlayer.equals(ans)){
			//TODO Else, a "guessing session" should start
			activePlayer = null;
			state = FINISH;
		}
		else
			;//TODO Maybe should have some kind of error-throwing here?
	}
	
	/**
	 * Returns the active player and also determines if the round has finished
	 * @return - the active player, or null if the turn is finished
	 */
	public Player getActivePlayer(){
		return activePlayer;
	}
	
	/**
	 * Gets the current state of this turn
	 * @return 0 if initiated, 1 if video has been recorded, 2 if finished
	 */
	public int getState(){
		return state;
	}
	
	/**
	 * Returns the score for a player on this turn
	 * @param player - The player who's score is sought after
	 * @return the player's score
	 */
	public int getScore(Player player){
		if (player.equals(rec))
			return recScore;
		else if (player.equals(ans))
			return ansScore;
		else return 0; //TODO this should be an exception - or it maybe that we could exclude it.
	}
}
