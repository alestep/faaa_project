package com.example.wecharades;

public class Turn {
	private String word;
	private Player rec, ans, activePlayer;
	private int recScore = 0, ansScore = 0;
	private Video video;
	//Variables to get the state of this turn
	private int state;
	public static final int INIT   = 0,	
							VIDEO  = 1,
							FINISH = 2;
	
	public Turn(Player rec, Player ans, String word){
		this.rec = rec;
		this.activePlayer = rec;
		this.ans = ans;
		this.word = word;
		this.state = INIT;
	}
	
	/**
	 * Play the next turn - this should probably delegate to some other classes later.
	 *
	 */
	public void playTurn(){
		//We could have a check for current player here.
		if(activePlayer.equals(rec)){
			video = new Video();
			activePlayer = ans;
			state = VIDEO;
		}
		else if (activePlayer.equals(ans)){
			//TODO Else, a "guessing session" should start
			activePlayer = null;
			state = FINISH;
		}
		else
			;//TODO Maybe should have some kind of error throwing here?
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
