package com.example.wecharades.model;

/**
 * Information about players that is stored locally.
 *  The session of the native player should also be stored in SharedPreferences
 *
 */
public class Player {
	private String parseId;
	private int globalScore;
	private String username;
	
	public Player(String parseId, String username, int globalScore){
		this.parseId = parseId;
		this.username = username;
		this.globalScore = globalScore;
	}
	
	public String getParseId() {
		return parseId;
	}
	public int getGlobalScore() {
		return globalScore;
	}
	public String getName() {
		return username;
	}
	public boolean equals(Player otherPlayer){
		return this.getParseId() == otherPlayer.getParseId();
	}
	
	public int hashCode(){
		return getParseId().hashCode();	
	}
}
