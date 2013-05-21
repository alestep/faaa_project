package com.example.wecharades.model;

import java.io.Serializable;
import java.util.Date;


/**
 * This class represents a game.
 * 
 * @author Anton Dahlström
 *
 */
public class Game implements Serializable { //TODO make this class truly Serializable later
	private String 	gameId;
	private Player 	playerId1;
	private Player 	playerId2;
	private Player 	currentPlayer;
	private int 	turn;
	private boolean isFinished;
	private Date 	lastPlayed;

	/**
	 * Constructor for a local representation of a game
	 * @param p1 - player 1
	 * @param p2 - player 2
	 * @param currentPlayer - the current player
	 * @param turn - which turn the game is on
	 * @param finished - whether the game is finished
	 * @param lastPlayed - the date of last play
	 */
	public Game(String gameId, Player p1, Player p2, Player currentPlayer, int turn, boolean finished, Date lastPlayed){
		this.gameId = gameId;
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

	public void setCurrentPlayer(Player currentPlayer) {
		//Check if the player is part of this turn
		if(currentPlayer.equals(playerId1) || currentPlayer.equals(playerId2))
			this.currentPlayer = currentPlayer;
	}

	/**
	 * Increments the turn number. If it is the last turn, the value will be set to 0
	 */
	public void inclementTurn() {
		if(turn == 6){
			isFinished = true;
			turn = 0;
		}
		else
			turn ++;
	}

	public void setLastPlayed(Date lastPlayed) {
		this.lastPlayed = lastPlayed;
	}
	
	public int hashCode(){
		return getGameId().hashCode();
	}

	/**
	 * Two games are considered equal if they have the same 
	 * 	id, current player, turn number, date-stamp and finished state
	 * @param otherGame - the game to compare
	 * @return if the games are equal
	 */
	public boolean equals(Game otherGame){
		return this.getGameId() == otherGame.getGameId() &&
				this.getCurrentPlayer().equals(otherGame.getCurrentPlayer()) &&
				this.getTurn() == otherGame.getTurn() &&
				this.getLastPlayed().equals(otherGame.getLastPlayed()) &&
				this.isFinished()== otherGame.isFinished();
	}
}
