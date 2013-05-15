package com.example.wecharades;


/**
 * This class represents a game.
 *  Each game has 6 turns that should be completed in order to finish a game.
 *  Each game has two players.
 * 
 * @author Anton Dahlström
 *
 */
public class Game {
	private static int gameId; //Should probably be a string of sorts later: uID1 + uID2 + linuxTime??
	private long timeSinceLastMove;
	private Player p1;
	private Player p2;
	private Player localPlayer;
	private Turn[] turns;
	private int turn = 0;
	
	/**Constructor for a Game, containing six turns.
	 * 
	 * @param p1 - Player 1
	 * @param p2 - Player 2
	 */
	public Game(Player p1, Player p2){
/*		this.p1 = p1;
		this.p2 = p2;
		turns = new Turn[6];
		
		//Creates the six rounds
		for(int i=0 ; i<turns.length ; i++){
			//Sets the players turn. Player 1 always starts a double-round
			if(i%2 == 0)
				turns[i] = new Turn(p1, p2, wordlist.getWord());
			else 
				turns[i] = new Turn(p2, p1, wordlist.getWord());
		}*/
	}
	
	/**
	 * Play the active turn. If it isn't the native player's turn, you should not be able to access this method. 
	 */
	public void play(){
		//if current turn is finished
		if(turns[turn].getState() == Turn.FINISH){
			nextTurn();
		} else{
			if(turns[turn].getActivePlayer().equals(localPlayer)){
				//TODO We need to generate a new view and stuff here.
				turns[turn].playTurn();
				try {
					//Database.pushTurn(this);
				} catch (Exception e) {
					// TODO Notify the user that something went wrong! We should also have a "try again"-button
					e.printStackTrace();
				}
			} else{
				//TODO if this player is not the active one, the button should be grayed out.
				//This should probably NOT be here. We do not want players to even have the
				//possibility to start a turn if it isn't their turn!
			}
		}
	}
	
	//Advances the game to next round, or finished it if no rounds left
	private void nextTurn(){
		if(turn < 5){
			try{
				//Database.pushTurn(this);
			} catch(Exception e){ //TODO correct exception later
				return; //if the transfer was incomplete
			}
			turn++;
			//TODO should probably redraw or something here
		} else{ //Else there are no more turns left in the game
			finish(); //finish the game!
		}
	}

	private void finish() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Returns the game's id number/string (not final version - do not implement anything based on this yet!)
	 * @return the Game ID
	 */
	public int getId(){
		return gameId;
	}
	
	/**
	 * Returns a representation of the current score. All non-played turns will have 0 score.
	 * @return
	 */
	public int[] getScore(){
		//TODO Implement score-system!
		int[] score = new int[6];
		return score;
	}
	
	/**
	 * The current turn number of this game
	 * @return an integer between 0 and 5
	 */
	public int getCurrentTurn(){
		return turn;
	}
	
	/**
	 * Returns a pointer to the current turn of the game
	 * @return a Turn
	 */
	public Turn getCurrentTurnInstance(){
		return turns[turn];
	}
	
	/**
	 * Whether it is the local player's turn
	 * @return true if local player's turn
	 */
	public boolean isLocalPlayersTurn(){
		return localPlayer.equals(turns[turn].getActivePlayer());
	}
}
