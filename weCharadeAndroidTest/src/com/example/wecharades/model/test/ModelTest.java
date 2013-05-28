package com.example.wecharades.model.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

import android.test.AndroidTestCase;
import android.util.Log;

import com.example.wecharades.model.Game;
import com.example.wecharades.model.Model;
import com.example.wecharades.model.Player;
import com.example.wecharades.model.Turn;
/**
 * Testing the Turn class.
 * This class doesn't test getters and setters if they only return primitive data types or strings.
 * It doesn't test very simple methods since is doesn't enhances the quality of the testing.
 * It doesn't test methods which are directly or indirectly tested in other test classes.
 * @author felixkarlsson
 */
public class ModelTest extends AndroidTestCase {
	private Model m;
	private TreeMap<Game, ArrayList<Turn>> gameList;
	private ArrayList<Turn> turns;
	private Game g1;
	private Player recPlayer, ansPlayer;
	private Turn t1,t2,t3,t4,t5,t6;
	private final int	GLOBAL_SCORE_REC= 5,
						GLOBAL_SCORE_ANS= 0,
						PLAYED_GAMES	= 0,
						WON_GAMES		= 0,
						LOST_GAMES		= 0,
						DRAW_GAMES		= 0,
						TURN_NUMBER_1	= 1,
						TURN_NUMBER_2	= 2,
						TURN_NUMBER_3	= 3,
						TURN_NUMBER_4	= 4,
						TURN_NUMBER_5	= 5,
						TURN_NUMBER_6	= 6,
						STATE			= 0;
	private final String	GAME_ID			= "gameID",
							CHARADEWORD_1	= "horse",
							CHARADEWORD_2	= "monkey",
							CHARADEWORD_3	= "pistol",
							CHARADEWORD_4	= "Coffee",
							CHARADEWORD_5	= "Phone",
							CHARADEWORD_6	= "Car",									
							VIDEOLINK		= "";
	private final boolean	FINISHED		= false;
	protected void setUp() throws Exception {
		super.setUp();
		Log.d("test", "test");

		//Initiate a bunch of stuff
		m			= Model.getModelInstance(getContext());
		gameList	= new TreeMap<Game, ArrayList<Turn>>();
		turns		= new ArrayList<Turn>();
		recPlayer	= new Player("id1", "username1", GLOBAL_SCORE_REC, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		ansPlayer	= new Player("id2", "username2", GLOBAL_SCORE_ANS, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		g1			= new Game(GAME_ID, recPlayer, ansPlayer, ansPlayer, TURN_NUMBER_1, FINISHED, new Date());
		t1			= new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		t2			= new Turn(GAME_ID, TURN_NUMBER_2, STATE, CHARADEWORD_2,VIDEOLINK,
				ansPlayer, GLOBAL_SCORE_ANS, recPlayer, GLOBAL_SCORE_REC);
		t3			= new Turn(GAME_ID, TURN_NUMBER_3, STATE, CHARADEWORD_3,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		t4			= new Turn(GAME_ID, TURN_NUMBER_4, STATE, CHARADEWORD_4,VIDEOLINK,
				ansPlayer, GLOBAL_SCORE_ANS, recPlayer, GLOBAL_SCORE_REC);
		t5			= new Turn(GAME_ID, TURN_NUMBER_5, STATE, CHARADEWORD_5,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		t6			= new Turn(GAME_ID, TURN_NUMBER_6, STATE, CHARADEWORD_6,VIDEOLINK,
				ansPlayer, GLOBAL_SCORE_ANS, recPlayer, GLOBAL_SCORE_REC);
		
		//Add to the arraylist of turns
		turns.add(t1);
		turns.add(t2);
		turns.add(t3);
		turns.add(t4);
		turns.add(t5);
		turns.add(t6);
		
		//Add to the model
		m.putGame(g1);
		m.putTurns(turns);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPutGameList() {
		fail("Not yet implemented");
	}

	public void testPutGame() {
		fail("Not yet implemented");
	}

	public void testGetGames() {
		fail("Not yet implemented");
	}

	public void testGetGame() {
		assertEquals(m.getGame(GAME_ID).equals(g1), true);
	}

	public void testRemoveGame() {
		fail("Not yet implemented");
	}

	public void testPutTurn() {
		fail("Not yet implemented");
	}

	public void testPutTurns() {
		fail("Not yet implemented");
	}

	public void testGetTurns() {
		fail("Not yet implemented");
	}

	public void testGetCurrentTurn() {
		fail("Not yet implemented");
	}

	public void testPlayerIsCached() {
		fail("Not yet implemented");
	}

	public void testPutPlayer() {
		fail("Not yet implemented");
	}

	public void testPutPlayers() {
		fail("Not yet implemented");
	}

	public void testSetSentInvitations() {
		fail("Not yet implemented");
	}

}
