package com.example.wecharades;

public class Turn {
	private String word;
	private Player rec, ans, activePlayer;
	private int recScore = 0, ansScore = 0;
	private Video video;
	
	public Turn(Player rec, Player ans, String word){
		this.rec = rec;
		this.activePlayer = rec;
		this.ans = ans;
		this.word = word;
	}
	
	/** //TODO implement this
	 * 
	 * @param p - the actual players turn
	 */
	public void playTurn(){
		//We could have a check for current player here.
		if(activePlayer.equals(rec)){
			video = new Video();
			activePlayer = ans;
		}
		else if (activePlayer.equals(ans)){
			//TODO Else, a "guessing session" should start
			activePlayer = null;
		}
		else
			;
	}
	
	/**
	 * Returns the active player and also determines if the round has finished
	 * @return - the active player, or null if the turn is finished
	 */
	public Player getActivePlayer(){
		return activePlayer;
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
