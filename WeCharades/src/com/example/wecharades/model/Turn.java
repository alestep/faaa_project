package com.example.wecharades.model;

import java.io.Serializable;

/**
 * This class represents a turn in a game.
 *
 */
public class Turn implements Serializable, Comparable<Turn> {
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 6616811397934106505L;
	private String gameId;
	private int turnNumber;
	private int state;
	private String word;
	private String videoLink;
	private Player recPlayer;
	private int recPlayerScore;
	private Player ansPlayer;
	private int ansPlayerScore;
	
	/*
	 * Turn states, used for comparison
	 */
	public static final int INIT   = 0,	
							VIDEO  = 1,
							FINISH = 2;

	/**
	 * Create a turn
	 * @param gameId
	 * @param turnNumber
	 * @param state
	 * @param word
	 * @param videoLink
	 * @param recPlayer
	 * @param recPlayerScore
	 * @param ansPlayer
	 * @param ansPlayerScore
	 */
	public Turn(String gameId, int turnNumber, int state, String word,
			String videoLink, Player recPlayer, int recPlayerScore,
			Player ansPlayer, int ansPlayerScore) {
		this.gameId = gameId;
		this.turnNumber = turnNumber;
		this.state = state;
		this.word = word;
		this.videoLink = videoLink;
		this.recPlayer = recPlayer;
		this.recPlayerScore = recPlayerScore;
		this.ansPlayer = ansPlayer;
		this.ansPlayerScore = ansPlayerScore;
	}

	/**
	 * Sets the state of this turn
	 * @param state
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * Set the direct-download-link to the video
	 * @param videoLink
	 */
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	/**
	 * Set the recording players score
	 * @param recPlayerScore
	 */
	public void setRecPlayerScore(int recPlayerScore) {
		this.recPlayerScore = recPlayerScore;
	}

	/**
	 * Set the answering players score
	 * @param recPlayerScore
	 */
	public void setAnsPlayerScore(int ansPlayerScore) {
		this.ansPlayerScore = ansPlayerScore;
	}

	/**
	 * Get the GameId this turn is connected to
	 * @return
	 */
	public String getGameId() {
		return gameId;
	}

	/**
	 * Get the turn number of this turn
	 * @return The turn number (1-6)
	 */
	public int getTurnNumber() {
		return turnNumber;
	}

	/**
	 * Get the state of this turn
	 * @return Get the state of this turn
	 */
	public int getState() {
		return state;
	}

	/**
	 * Get the word associated with this turn
	 * @return A String
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Get the video link of this turn, if it exist
	 * @return a direct link to the video
	 */
	public String getVideoLink() {
		return videoLink;
	}

	/**
	 * Get the recording player
	 * @return A Player
	 */
	public Player getRecPlayer() {
		return recPlayer;
	}

	/**
	 * Get the Recording player's score
	 * @return an Integer
	 */
	public int getRecPlayerScore() {
		return recPlayerScore;
	}

	/**
	 * Get the answering player
	 * @return A Player
	 */
	public Player getAnsPlayer() {
		return ansPlayer;
	}

	/**
	 * Get the Answer player's score
	 * @return an Integer
	 */
	public int getAnsPlayerScore() {
		return ansPlayerScore;
	}
	
	/**
	 * Returns this players score for this turn.
	 * @param player - The player who's score to fetch
	 * @return - an integer score value, or 0 if the player is not part of this turn.
	 */
	public int getPlayerScore(Player player){
		if(player.equals(getAnsPlayer()))
			return getAnsPlayerScore();
		else if(player.equals(getRecPlayer()))
			return getRecPlayerScore();
		else
			return 0;
	}
	
	/**
	 * Check if equals
	 * @param obj - an object to check
	 * @return - if the object equals the turn
	 */
	@Override
	public boolean equals(Object obj){
		return  obj != null
				&& obj.getClass().equals(Turn.class)
				&& ((Turn) obj).getGameId().equals(this.getGameId())
				&& ((Turn) obj).getTurnNumber() == (this.getTurnNumber());
	}

	/**
	 * Compares two turn with each other. Comparison is done on gameId and turn Number
	 */
	@Override
	public int compareTo(Turn anotherTurn) {
		int compareGame = this.getGameId().compareTo(anotherTurn.getGameId());
		return (compareGame == 0) ? this.getTurnNumber() - anotherTurn.getTurnNumber() : compareGame;
	}
}
