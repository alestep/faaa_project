package com.example.wecharades;

public class Player {
	private int id;
	private long globalScore;
	private String name;
	
	public int getId() {
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
