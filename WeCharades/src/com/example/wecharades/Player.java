package com.example.wecharades;

public class Player {
	private int id;
	private int score;
	private long globalScore;
	private String name;
	
	public int getId() {
		return id;
	}
	public int getScore() {
		return score;
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
