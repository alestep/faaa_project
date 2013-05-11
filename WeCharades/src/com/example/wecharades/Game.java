package com.example.wecharades;

public class Game {
	private Turn[] turns;
	private Player p1;
	private Player p2;
	private int turn = 0;
	private Wordlist wordlist;
	
	/**Constructor for a Game, containing six turns.
	 * 
	 * @param p1 - Player 1
	 * @param p2 - Player 2
	 */
	public Game(Player p1, Player p2){
		this.p1 = p1;
		this.p2 = p2;
		
		wordlist = new Wordlist();
		turns = new Turn[6];
		
		//Creates the six rounds
		Player playerTurn;
		for(int i=0 ; i<turns.length ; i++){
			
			//Sets the players turn. Player 1 always starts a double-round
			playerTurn = (i%2 == 0) ? p1 : p2; 
			
			turns[i] = new Turn(playerTurn);
		}
	}
	
	/**
	 * Method to set the video link (or other representation) for the turn
	 * @param video - the link to the video
	 */
	public void setVideo(String video){
		turns[turn].setVideo(video);
	}
	
	/**
	 * Advance one turn
	 */
	public void nextTurn(){
		turn++;
	}
}
