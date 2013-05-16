package com.example.wecharades;

/**
 * This class represents a turn in a game.
 *  Each turn has two players - one recording player and one answering player.
 *   There is also a pointer to the active player, although this might not be necessary.
 *  Each turn also has one of three states (stored in static variables)
 *  Each turn has a video instance
 *  
 *  It is the turns responsibility to do the game-related stuff, like record
 *   videos and possibility to guess. This can be implemented by delegation, although
 *   this is a later problem.
 *   
 *  The Turn data is stored in the online database:
 *   The turn state, score and video link  is stored here and synced in a later stage.
 * 
 * @author Anton Dahlström
 *
 */
public class Turn {/*
	newTurn.put("game",newGame);
	newTurn.put("turn",i);
	newTurn.put("state","1");
	newTurn.put("word",getWord());
	newTurn.put("videoLink","N/A");
	newTurn.put("videoPlayer",playerId1);
	newTurn.put("videoPlayerScore",0);
	newTurn.put("answerPlayer",playerId2);
	newTurn.put("answerPlayerScore",0);
	*/
	private String gameId;
	private int turnNumber;
	private int state;
	private String word;
	private String videoLink;
	private String recPlayer;
	private int recPlayerScore;
	private String ansPlayer;
	private int ansPlayerScore;
	
	public static final int INIT   = 0,	
	VIDEO  = 1,
	FINISH = 2;

	public Turn(String gameId, int turnNumber, int state, String word,
			String videoLink, String recPlayer, int recPlayerScore,
			String ansPlayer, int ansPlayerScore) {
		this.gameId = gameId;
		this.turnNumber = turnNumber;
		this.state = state;
		this.word = word;
		this.videoLink = videoLink;
		this.recPlayer = recPlayer;
		this.recPlayerScore = recPlayerScore;
		this.ansPlayer = ansPlayer;
		this.ansPlayerScore = ansPlayerScore;
	}

	public String getGameId() {
		return gameId;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	public int getState() {
		return state;
	}

	public String getWord() {
		return word;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public String getRecPlayer() {
		return recPlayer;
	}

	public int getRecPlayerScore() {
		return recPlayerScore;
	}

	public String getAnsPlayer() {
		return ansPlayer;
	}

	public int getAnsPlayerScore() {
		return ansPlayerScore;
	}

}
