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
	 * Creates a player with a parseId, username, global score, number of played games, number of won games,
	 * number of lost games and number of draw games
	 * @param parseId
	 * @param username
	 * @param globalScore
	 * @param playedGames
	 * @param wonGames
	 * @param lostGames
	 * @param drawGames
	 */
	public Player(String parseId, String username, int globalScore, int playedGames, int wonGames, int lostGames, int drawGames){
		this.parseId	= parseId;
		this.username	= username;
		this.globalScore= globalScore;
		this.playedGames= playedGames;
		this.wonGames	= wonGames;
		this.lostGames	= lostGames;
		this.drawGames	= drawGames;
	}

	/**
	 * Get this players ParseId
	 * @return parseId as a String
	 */
	public String getParseId() {
		return parseId;
	}

	/**
	 * Get username in the form which it was entered during registration
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
	 * Check if two objects are the same
	 * @param otherPlayer
	 * @return boolean value
	 */
	@Override
	public boolean equals(Object obj){
		return(obj != null 
				&& obj.getClass().equals(Player.class)
				&& this.getParseId().equals(((Player) obj).getParseId()));
	}
	
	/**
	 * Get the hashcode for this player
	 * @return the objects hashcode
	 */
	@Override
	public int hashCode(){
		return getParseId().hashCode();	
	}
	
	/**
	 * Get a string representation of this player
	 * @return the player username
	 */
	@Override
	public String toString(){
		return getName();
	}
	
	/**
	 * Compare a player to another
	 * @return boolean
	 */
	@Override
	public int compareTo(Player another) {
		if(another != null){
			return this.getParseId().compareTo(another.getParseId());
		} else return 0;
	}

}
