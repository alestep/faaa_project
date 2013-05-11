package com.example.wecharades;

public class Turn {
	private Player player;
	private int score = 0;
	private String video;
	
	public Turn(Player player){
		this.player = player;
	}
	
	
	public void setVideo(String video){
		this.video = video;
	}
}
