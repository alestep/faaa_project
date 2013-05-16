package com.example.wecharades.model;

/**
 * Information about players that is stored locally.
 *  The session of the native player should also be stored in SharedPreferences
 *  
 * @author Anton Dahlström
 *
 */
public class Player {
	private String id;
	private long globalScore;
	private String name;
	
	public String getId() {
		return id;
	}
	public long getGlobalScore() {
		return globalScore;
	}
	public String getName() {
		return name;
	}
	public boolean equals(Player otherPlayer){
		return this.getId() == otherPlayer.getId();
	}
}
