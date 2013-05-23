package com.example.wecharades.model;

import java.io.Serializable;

/**
 * This class represents a turn in a game.
 *
 */
public class Turn implements Serializable {
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
	
	public static final int INIT   = 0,	
							VIDEO  = 1,
							FINISH = 2;

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

	public void setState(int state) {
		this.state = state;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public void setRecPlayerScore(int recPlayerScore) {
		this.recPlayerScore = recPlayerScore;
	}

	public void setAnsPlayerScore(int ansPlayerScore) {
		this.ansPlayerScore = ansPlayerScore;
	}

	public String getGameId() {
		return gameId;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	public int getState() {
		return state;
	}

	public String getWord() {
		return word;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public Player getRecPlayer() {
		return recPlayer;
	}

	public int getRecPlayerScore() {
		return recPlayerScore;
	}

	public Player getAnsPlayer() {
		return ansPlayer;
	}

	public int getAnsPlayerScore() {
		return ansPlayerScore;
	}
	
	/**
	 * Returns this players score for this turn.
	 * @param player - The player whos score to fetch
	 * @return - an integer score value, or -1 if the player is not part of this turn.
	 */
	public int getPlayerScore(Player player){
		if(player.equals(getAnsPlayer()))
			return getAnsPlayerScore();
		else if(player.equals(getRecPlayer()))
			return getRecPlayerScore();
		else
			return -1;
	}
	
	public boolean equals(Turn anotherTurn){
		return anotherTurn != null
				&& anotherTurn.getGameId().equals(this.getGameId())
				&& anotherTurn.getTurnNumber() == (this.getTurnNumber());
		
	}
}
