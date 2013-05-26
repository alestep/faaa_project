package com.example.wecharades.model;

import java.io.Serializable;

/**
 * Information about players that is stored locally.
 * The session of the native player should also be stored in SharedPreferences
 *
 */
public class Player implements Serializable, Comparable<Player> {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 2165036941490853727L;
	private String parseId, username;
	private int globalScore, playedGames, wonGames, lostGames, drawGames;

	/**
	 * Creates a player with a parseId and a username
	 * @param parseId
	 * @param username
	 */
	public Player(String parseId, String username){
		this.parseId = parseId;
		this.username= username; 
	}

	/**
	 * Creates a player with a parseId, username and global score
	 * @param parseId
	 * @param username
	 * @param globalScore
	 */
	public Player(String parseId, String username, int globalScore){
		this.parseId = parseId;
		this.username = username;
		this.globalScore = globalScore;
	}


	/**
	 * Get the player id
	 * @return parseId
	 */
	public String getParseId() {
		return parseId;
	}

	/**
	 * Get username in the form which it was entered when registration
	 * @return username
	 */
	public String getName() {
		return username;
	}

	/**
	 * Get global score
	 * @return global score
	 */
	public int getGlobalScore() {
		return globalScore;
	}

	/**
	 * Get the number of finished games
	 * @return number of finished games
	 */
	public int getPlayedGames() {
		return playedGames;
	}

	/**
	 * Get the number of won games
	 * @return number of won games
	 */
	public int getWonGames() {
		return wonGames;
	}

	/**
	 * Get the number of lost games
	 * @return number of lost games
	 */
	public int getLostGames() {
		return lostGames;
	}

	/**
	 * Get the number of draw games
	 * @return number of draw games
	 */
	public int getDrawGames() {
		return drawGames;
	}

	/**
	 * Set the global score
	 * @param the integer which the current global score should be increased with
	 */
	public void setGlobalScore(int globalScore){
		this.globalScore += globalScore;  
	}

	/**
	 * Add one more finished game
	 */
	public void incrementFinishedGames() {
		this.playedGames++;
	}

	/**
	 * Add one more won game
	 */
	public void incrementWonGames() {
		this.wonGames++;
	}

	/**
	 * Add one more lost game
	 */
	public void  incrementLostGames() {
		this.lostGames++;
	}

	/**
	 * Add one more draw game
	 */
	public void incrementDrawGames() {
		this.drawGames++;
	}
	
	/**
	 * Check if to Player objects are the same
	 * @param otherPlayer
	 * @return
	 */
	public boolean equals(Player otherPlayer){
		return otherPlayer != null 
				&& this.getParseId().equals(otherPlayer.getParseId());
	}
	
	/**
	 * Get the hashcode
	 */
	@Override
	public int hashCode(){
		return getParseId().hashCode();	
	}
	
	/**
	 * Player object to string
	 */
	@Override
	public String toString(){
		return getName();
	}

	@Override
	public int compareTo(Player another) {
		if(another != null){
			return this.getParseId().compareTo(another.getParseId());
		} else return 0;
	}

}
