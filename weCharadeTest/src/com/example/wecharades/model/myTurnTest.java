package com.example.wecharades.model;

import junit.framework.TestCase;

import com.example.wecharades.model.Player;
import com.example.wecharades.model.Turn;

/**
 * Testing the Turn class.
 * This class doesn't test getters and setters if they only return primitive data types or strings.
 * It doesn't test very simple methods since is doesn't enhances the quality of the testing.
 * It doesn't test methods which are directly or indirectly tested in other test classes.
 * @author felixkarlsson
 */
public class myTurnTest extends TestCase {

	private Player recPlayer, ansPlayer;
	private Turn t1,t2;
	private final int	GLOBAL_SCORE_REC= 5,
						GLOBAL_SCORE_ANS= 0,
						PLAYED_GAMES	= 0,
						WON_GAMES		= 0,
						LOST_GAMES		= 0,
						DRAW_GAMES		= 0,
						TURN_NUMBER_1	= 1,
						TURN_NUMBER_2	= 2,
						STATE			= 0;
	private final String	GAME_ID			= "gameID",
							CHARADEWORD_1	= "horse",
							CHARADEWORD_2	= "monkey",
							VIDEOLINK		= "";
						
						
	protected void setUp() throws Exception {
		super.setUp();
		recPlayer = new Player("id1", "username1", GLOBAL_SCORE_REC, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		ansPlayer = new Player("id2", "username2", GLOBAL_SCORE_ANS, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		
		t1 = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		t2 = new Turn(GAME_ID, TURN_NUMBER_2, STATE, CHARADEWORD_2,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetPlayerScore() {
		int score = t1.getPlayerScore(recPlayer);
		assertEquals(GLOBAL_SCORE_REC, score);
	}

	public void testEqualsObject() {
		assertFalse(t1.equals(t2));
		assertTrue(t1.equals(t1));
	}

	public void testEqualsTurn() {
		assertFalse(t1.equals(t2));
		assertTrue(t1.equals(t1));

	}

	public void testCompareTo() {
		assertTrue(t1.compareTo(t2) != 0);

	}

}
