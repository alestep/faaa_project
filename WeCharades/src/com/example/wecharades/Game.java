package com.example.wecharades;

import android.database.SQLException;

public class Game {
	private Turn[] turns;
	private Player p1;
	private Player p2;
	private Player thisPlayer;
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
		for(int i=0 ; i<turns.length ; i++){
			//Sets the players turn. Player 1 always starts a double-round
			if(i%2 == 0)
				turns[i] = new Turn(p1, p2, wordlist.getWord());
			else 
				turns[i] = new Turn(p2, p1, wordlist.getWord());
		}
	}
	
	/**
	 * Play the active turn. If it isn't the native player's turn, nothing will happen. 
	 */
	public void play(){
		//if current turn is finished
		if(turns[turn].getState() == Turn.FINISH){
			nextTurn();
		} else{
			if(turns[turn].getActivePlayer().equals(thisPlayer)){
				//TODO We need to generate a new view and stuff here.
				turns[turn].playTurn();
			} else{
				//TODO if this player is not the active one, the button should be grayed out.
				//This should probably NOT be here. We do not want players to even have the
				//possibility to start a turn if it isn't their turn!
			}
		}
	}
	
	/**
	 * Returns a representation of the current score. All non-played turns will have 0 score.
	 * @return
	 */
	public int[] getScore(){
		int[] score = new int[6];
		return score;
	}
	
	//Advances the game to next round, or finished it if no rounds left
	private void nextTurn(){
		if(turn < 6){
			turn++;
			//If database connection failed
			if(!Database.pushTurn(this)){
				turn--; //rollback turn
				throw new SQLException();
			}
			//TODO should probably redraw or something here
		} else{
			finish();
		}
	}

	private void finish() {
		// TODO Auto-generated method stub
		
	}
}
