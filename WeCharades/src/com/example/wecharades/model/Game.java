package com.example.wecharades.model;

import java.io.Serializable;
import java.util.Date;


/**
 * This class represents a game.
 * 
 * @author Anton Dahlström
 *
 */
public class Game implements Serializable, Comparable<Game> { //TODO make this class truly Serializable later
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

	public String getGameId() {
		return gameId;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
	
	public Player getOpponent(Player otherPlayer){
		if(otherPlayer.equals(player1) || otherPlayer.equals(player2)){
			return (otherPlayer.equals(getPlayer1())) ? getPlayer2() : getPlayer1();
		}
		else return null;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public Date getLastPlayed() {
		return (Date) lastPlayed.clone();
	}

	public void setCurrentPlayer(Player currentPlayer) {
		//Check if the player is part of this turn
		if(currentPlayer.equals(player1) || currentPlayer.equals(player2))
			this.currentPlayer = currentPlayer;
	}

	/**
	 * Increments the turn number. If it is the last turn, the value will be set to 0
	 */
	public void incrementTurn() {
		if(turnNumber == 6){
			isFinished = true;
		}
		else
			turnNumber ++;
	}
	
	public void setFinished(){
		isFinished = true;
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
	 * Two games are considered equal if they have the same id 
	 * 	
	 * @param otherGame - the game to compare
	 * @return if the games are equal
	 */
	public boolean equals(Game otherGame){
		return this.getGameId().equals(otherGame.getGameId());
	}
	
	/**
	 * A static method to check if a game has changed:
	 * 	will look on current player, turn and finished state.
	 * @return - if the game has changed
	 */
	public static boolean hasChanged(Game game1, Game game2){
		return game1 != null && game2 != null
				&& game1.equals(game2) 
				&& game1.getCurrentPlayer().equals(game2.getCurrentPlayer())
				&& game1.getTurnNumber() == game2.getTurnNumber()
				&& game1.isFinished() == game2.isFinished();
	}

	@Override
	public int compareTo(Game otherGame) {
		if(otherGame == null)
			throw new NullPointerException();
		return this.getGameId().compareTo(otherGame.getGameId());
	}
}
