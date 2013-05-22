package com.example.wecharades.model;

import java.io.Serializable;

/**
 * Information about players that is stored locally.
 *  The session of the native player should also be stored in SharedPreferences
 *
 */
public class Player implements Serializable {
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 2165036941490853727L;
	private String parseId;
	private int globalScore;
	private String username;
	
	public Player(String parseId, String username){
		this.parseId = parseId;
		this.username= username; 
	}
	
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
	
	public void setGlobalScore(int globalScore){
		this.globalScore =globalScore;  
	}
	
	public boolean equals(Player otherPlayer){
		return otherPlayer != null 
				&& this.getParseId().equals(otherPlayer.getParseId());
	}
	
	@Override
	public int hashCode(){
		return getParseId().hashCode();	
	}
	
	@Override
	public String toString(){
		return getName();
	}
}
