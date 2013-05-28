package com.example.wecharades.model.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.TreeMap;

import android.test.AndroidTestCase;

import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
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
	private Game g1,g2;
	private Player recPlayer, ansPlayer;
	private Turn t1,t2,t3,t4,t5,t6;
	private Invitation invitation;
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
	private final String
			GAME_ID1		= "gameID1",
			GAME_ID2		= "gameID2",
			CHARADEWORD_1	= "horse",
			CHARADEWORD_2	= "monkey",
			CHARADEWORD_3	= "pistol",
			CHARADEWORD_4	= "Coffee",
			CHARADEWORD_5	= "Phone",
			CHARADEWORD_6	= "Car",									
			VIDEOLINK		= "";
	private final boolean	NOT_FINISHED		= false;
	protected void setUp() throws Exception {
		super.setUp();

		//Initiate some useful stuff
		m			= Model.getModelInstance(getContext());
		gameList	= new TreeMap<Game, ArrayList<Turn>>();
		turns		= new ArrayList<Turn>();
		recPlayer	= new Player("id1", "username1", GLOBAL_SCORE_REC, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		ansPlayer	= new Player("id2", "username2", GLOBAL_SCORE_ANS, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		invitation	= new Invitation(recPlayer, ansPlayer);
		g1			= new Game(GAME_ID1, recPlayer, ansPlayer, ansPlayer, TURN_NUMBER_1, NOT_FINISHED, new Date());
		g2			= new Game(GAME_ID2, recPlayer, ansPlayer, ansPlayer, TURN_NUMBER_1, NOT_FINISHED, new Date());
		t1			= new Turn(GAME_ID1, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK, recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		t2			= new Turn(GAME_ID1, TURN_NUMBER_2, STATE, CHARADEWORD_2,VIDEOLINK, ansPlayer, GLOBAL_SCORE_ANS, recPlayer, GLOBAL_SCORE_REC);
		t3			= new Turn(GAME_ID1, TURN_NUMBER_3, STATE, CHARADEWORD_3,VIDEOLINK, recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		t4			= new Turn(GAME_ID1, TURN_NUMBER_4, STATE, CHARADEWORD_4,VIDEOLINK, ansPlayer, GLOBAL_SCORE_ANS, recPlayer, GLOBAL_SCORE_REC);
		t5			= new Turn(GAME_ID1, TURN_NUMBER_5, STATE, CHARADEWORD_5,VIDEOLINK, recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		t6			= new Turn(GAME_ID1, TURN_NUMBER_6, STATE, CHARADEWORD_6,VIDEOLINK, ansPlayer, GLOBAL_SCORE_ANS, recPlayer, GLOBAL_SCORE_REC);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPutGameList() {
		//update model
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(g1);
		games.add(g2);
		m.putGameList(games);

		assertTrue(m.getGames().contains(g1) && m.getGames().contains(g2));

		//remove from model
		m.removeGame(g1);
		m.removeGame(g2);
	}

	public void testPutGame() {
		m.putGame(g1);
		assertTrue(m.getGame(GAME_ID1).equals(g1));
		m.removeGame(g1);
	}

	public void testGetGames() {
		//update model
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(g1);
		games.add(g2);
		m.putGameList(games);
		assertTrue(m.getGames().contains(g1) && m.getGames().contains(g2));

		//remove from model
		m.removeGame(g1);
		m.removeGame(g2);
	}

	public void testGetGame() {
		m.putGame(g1);
		assertTrue(m.getGame(GAME_ID1).equals(g1));
		m.removeGame(g1);
	}

	public void testRemoveGame() {
		m.putGame(g1);
		m.removeGame(g1);
		assertNull(m.getGame(GAME_ID1));
	}

	public void testPutTurns() {
		
		assertNull(m.getTurns(g1));
		//Update
		turns.add(t1);
		turns.add(t2);
		turns.add(t3);
		turns.add(t4);
		turns.add(t5);
		turns.add(t6);
		
		m.putGame(g1);
		m.putTurns(turns);
		for(int i = 0; i < turns.size(); i++) {
			assertTrue(turns.remove(0).equals(m.getTurns(g1).remove(0)));
		}
		m.removeGame(g1);
	}

	public void testGetTurns() {
		assertNull(m.getTurns(g1));
		//Update
		turns.add(t1);
		turns.add(t2);
		turns.add(t3);
		turns.add(t4);
		turns.add(t5);
		turns.add(t6);
		
		m.putGame(g1);
		m.putTurns(turns);
		for(int i = 0; i < turns.size(); i++) {
			assertTrue(turns.remove(0).equals(m.getTurns(g1).remove(0)));
		}
		m.removeGame(g1);
	}

	public void testGetCurrentTurn() {
		assertNull(m.getTurns(g1));
		//Update
		turns.add(t1);
		turns.add(t2);
		turns.add(t3);
		turns.add(t4);
		turns.add(t5);
		turns.add(t6);
		
		m.putGame(g1);
		m.putTurns(turns);
		//The current turn should be t1
		assertTrue(m.getCurrentTurn(g1).equals(t1) );
		
	}

	public void testSetSentInvitations() {
		
		LinkedList<Invitation> iList = new LinkedList<Invitation>();
		iList.add(invitation);
		m.setSentInvitations(iList);
		//TODO: FIX THIS SHIT.
	}
	
	public void testSetReceivedInvitations() {
	}


}
