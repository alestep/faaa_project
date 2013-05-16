package com.example.wecharades.model;

import java.util.Date;


/**
 * This class represents a game.
 *  Each game has 6 turns that should be completed in order to finish a game.
 *  Each game has two players.
 * 
 * @author Anton Dahlström
 *
 */
public class Game {
	private String gameId;
	private String playerId1;
	private String playerId2;
	private String currentPlayer;
	private int turn;
	private boolean isFinished;
	private Date lastPlayed;
	
	/**
	 * Constructor for a local representation of a game
	 * @param p1 - player 1
	 * @param p2 - player 2
	 * @param currentPlayer - the current player
	 * @param turn - which turn the game is on
	 * @param finished - whether the game is finished
	 * @param lastPlayed - the date of last play
	 */
	public Game(String p1, String p2, String currentPlayer, int turn, boolean finished, Date lastPlayed){
		this.playerId1 = p1;
		this.playerId2 = p2;
		this.currentPlayer = currentPlayer;
		this.turn = turn;
		this.isFinished = finished;
		this.lastPlayed = lastPlayed;
	}

	public String getGameId() {
		return gameId;
	}

	public String getPlayerId1() {
		return playerId1;
	}

	public String getPlayerId2() {
		return playerId2;
	}

	/**
	 * Returns the game's current player id
	 * @return
	 */
	public String getCurrentPlayer() {
		return currentPlayer;
	}

	public int getTurn() {
		return turn;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public Date getLastPlayed() {
		return (Date) lastPlayed.clone();
	}
	
}
