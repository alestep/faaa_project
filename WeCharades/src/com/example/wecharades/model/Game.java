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
	private Player playerId1;
	private Player playerId2;
	private Player currentPlayer;
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
	public Game(Player p1, Player p2, Player currentPlayer, int turn, boolean finished, Date lastPlayed){
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

	public Player getPlayerId1() {
		return playerId1;
	}

	public Player getPlayerId2() {
		return playerId2;
	}

	/**
	 * Returns the game's current player id
	 * @return the player
	 */
	public Player getCurrentPlayer() {
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
