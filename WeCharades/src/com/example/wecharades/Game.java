package com.example.wecharades;

public class Game {
	private Turn[] turns;
	private Player p1;
	private Player p2;
	private int turn = 0;
	private Wordlist wordlist;
	
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
}
