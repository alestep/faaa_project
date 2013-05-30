package com.example.wecharades.model;

import java.io.Serializable;
import java.util.Date;


/**
 * This class represents a local version of a game.
 * 	The class contains standard getters and setters, 
 * 	and also some methods for comparing two games with eachother 
 *
 */
public class Game implements Serializable, Comparable<Game> {
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -3649758045030316767L;
	
	private String 	gameId;
	private Player 	player1;
	private Player 	player2;
	private Player 	currentPlayer;
	private int 	turnNumber;
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
		this.player1 = p1;
		this.player2 = p2;
		this.currentPlayer = currentPlayer;
		this.turnNumber = turn;
		this.isFinished = finished;
		this.lastPlayed = lastPlayed;
	}

	/**
	 * Get the games Id - same as its ParseId
	 * @return a String with this games id
	 */
	public String getGameId() {
		return gameId;
	}

	/**
	 * Get Player 1 of this game
	 * @return a Player representation
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * Get Player 2 of this game
	 * @return a Player representation
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * Get the opponent to a supplied player
	 * @param otherPlayer - The Player to find the opponent to
	 * @return A Player which is the opponent of the provided Player, or null if the provided player is not part of the game
	 */
	public Player getOpponent(Player otherPlayer){
		if(otherPlayer.equals(player1) || otherPlayer.equals(player2)){
			return (otherPlayer.equals(getPlayer1())) ? getPlayer2() : getPlayer1();
		}
		else return null;
	}

	/**
	 * Get the current player of this game
	 * @return the Player which is the current player of this game
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * Get the turn number of this game
	 * @return an Integer representation of the turn number 
	 */
	public int getTurnNumber() {
		return turnNumber;
	}

	/**
	 * Check if this game is finished or not
	 * @return if this game is finished 
	 */
	public boolean isFinished() {
		return isFinished;
	}

	/**
	 * Get the last time someone played this game.
	 * @return a Date representation of the time
	 */
	public Date getLastPlayed() {
		return (Date) lastPlayed.clone();
	}
	
	/**
	 * Set the current player of this game. The Player must take part in this game 
	 * @param currentPlayer - a Player in this game
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		//Check if the player is part of this turn
		if(currentPlayer.equals(player1) || currentPlayer.equals(player2))
			this.currentPlayer = currentPlayer;
	}

	/**
	 * Increments the turn number.
	 * 	Will also set the the game to finished when the last turn has been finished
	 */
	public void incrementTurn() {
		if(turnNumber == 6){ 
			isFinished = true;
		} else{
			turnNumber ++;
		}
	}

	public void setLastPlayed(Date lastPlayed) {
		this.lastPlayed = lastPlayed;
	}

	/**
	 * Returns the hashcode for this game
	 *  @return the hashcode
	 */
	@Override
	public int hashCode(){
		return getGameId().hashCode();
	}
	
	/**
	 * Check if a game and another object can be considered to be equal.
	 * 	This method checks the game id
	 * @param obj - an object to compare
	 * @return If the object and game is equal
	 */
	@Override
	public boolean equals(Object obj){
		return obj != null
				&& obj.getClass().equals(Game.class)
				&& this.getGameId().equals(((Game) obj).getGameId());
	}

	/**
	 * A method to check if a game can be considered to be ahead of another.
	 * 	will look on current player, turn and finished state.
	 * @return - if the game has changed - will return false on null input
	 */
	public boolean aheadOf(Game game){
		return this.equals(game) && //Check that its the same game
			(	this.isFinished
				|| (this.getTurnNumber() > game.getTurnNumber())
				|| (this.getTurnNumber() == game.getTurnNumber() && this.playerTurnValue() > game.playerTurnValue())
			);
	}
	
	/**
	 * This method will give a turn value for this player.
	 * 	There are two levels - ahead and behind. 
	 * 	This will be calculated from the current turn number and currentPlayer
	 * 	@return an integer representation of how far ahead a game is
	 */
	private int playerTurnValue(){
		int 	AHEAD = 1,
				BEHIND = 0;
		Player aheadPlayer = null;
		/*
		 * Because of the construction of the game, we can assert which turn state
		 * 	the game is in by comparing the current player and turn number.
		 */
		if(turnNumber == 1 || turnNumber == 4 || turnNumber == 5){
			aheadPlayer = player2;
		} else{
			aheadPlayer = player1;
		} 
		return (currentPlayer.equals(aheadPlayer) ? AHEAD : BEHIND);
	}

	/**
	 * Compares two games with each other
	 * 	Compares the gameId
	 */
	@Override
	public int compareTo(Game otherGame) {
		return this.getGameId().compareTo(otherGame.getGameId());
	}
}
