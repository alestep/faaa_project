package com.example.wecharades.model;

/**
 * This class represents a turn in a game.
 *
 */
public class Turn {
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

}
