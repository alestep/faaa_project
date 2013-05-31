package com.example.wecharades.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.wecharades.TestConstants;

import android.util.Log;

/**
 * The class <code>TurnTest</code> contains tests for the class <code>{@link Turn}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class TurnTest {
	
	
	private Player recPlayer, ansPlayer;
	private final int	GLOBAL_SCORE_REC= 5,
						GLOBAL_SCORE_ANS= 3,
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
							VIDEOLINK		= "theLink";
	
	/**
	 * Run the Turn(String,int,int,String,String,Player,int,Player,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testTurn_1()
		throws Exception {
		Turn result = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);

		assertNotNull(result);
		assertEquals(STATE, result.getState());
		assertEquals(CHARADEWORD_1, result.getWord());
		assertEquals(GAME_ID, result.getGameId());
		assertEquals(TURN_NUMBER_1, result.getTurnNumber());
		assertEquals(VIDEOLINK, result.getVideoLink());
		assertEquals(GLOBAL_SCORE_REC, result.getRecPlayerScore());
		assertEquals(GLOBAL_SCORE_ANS, result.getAnsPlayerScore());
	}

	/**
	 * Run the int compareTo(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testCompareTo_1()
		throws Exception {
		Turn fixture = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		Turn anotherTurn = new Turn(GAME_ID, TURN_NUMBER_2, STATE, CHARADEWORD_2,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		int result = fixture.compareTo(anotherTurn);
		
		assertEquals(-1, result);
	}

	/**
	 * Run the boolean equals(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Turn fixture = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		Turn anotherTurn = new Turn(GAME_ID, TURN_NUMBER_2, STATE, CHARADEWORD_2,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);

		boolean result = fixture.equals(anotherTurn);

		assertFalse(result);
	}

	/**
	 * Run the boolean equals(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);
		Turn anotherTurn = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);

		boolean result = fixture.equals(anotherTurn);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);
		Turn anotherTurn = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);

		boolean result = fixture.equals(anotherTurn);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);
		Object obj = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);

		boolean result = fixture.equals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);
		Object obj = null;

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);
		Object obj = new Turn("", 1, 1, "", "", TestConstants.recPlayer, 1, TestConstants.recPlayer, 1);

		boolean result = fixture.equals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the Player getAnsPlayer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAnsPlayer_1()
		throws Exception {
		Player recPlayer2 = new Player("id1", "username1", GLOBAL_SCORE_REC, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		Player ansPlayer2 = new Player("id2", "username2", GLOBAL_SCORE_ANS, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		Turn fixture = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer2, GLOBAL_SCORE_REC, ansPlayer2, GLOBAL_SCORE_ANS);
		Player result = fixture.getAnsPlayer();
		
		assertNotNull(result);
		assertTrue(result.equals(ansPlayer2));
		assertEquals("username2", result.toString());
		assertEquals("username2", result.getName());
		assertEquals("id2", result.getParseId());
		assertEquals(GLOBAL_SCORE_ANS, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
	}

	/**
	 * Run the int getAnsPlayerScore() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAnsPlayerScore_1()
		throws Exception {
		Turn fixture = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		int result = fixture.getAnsPlayerScore();

		assertEquals(GLOBAL_SCORE_ANS, result);
	}

	/**
	 * Run the String getGameId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetGameId_1()
		throws Exception {
		
		Turn fixture = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);

		String result = fixture.getGameId();

		assertEquals(GAME_ID, result);
	}

	/**
	 * Run the int getPlayerScore(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayerScore_1()
		throws Exception {
		Turn fixture = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);

		int result = fixture.getPlayerScore(ansPlayer);

		assertEquals(GLOBAL_SCORE_ANS, result);
	}

	/**
	 * Run the Player getRecPlayer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetRecPlayer_1()
		throws Exception {
		Player recPlayer2 = new Player("id1", "username1", GLOBAL_SCORE_REC, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		Player ansPlayer2 = new Player("id2", "username2", GLOBAL_SCORE_ANS, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		Turn fixture = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer2, GLOBAL_SCORE_REC, ansPlayer2, GLOBAL_SCORE_ANS);
		Player result = fixture.getRecPlayer();
		
		assertNotNull(result);
		assertTrue(result.equals(recPlayer2));
		assertEquals("username1", result.toString());
		assertEquals("username1", result.getName());
		assertEquals("id1", result.getParseId());
		assertEquals(GLOBAL_SCORE_REC, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
	}

	/**
	 * Run the int getRecPlayerScore() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetRecPlayerScore_1()
		throws Exception {
		Turn fixture = new Turn(GAME_ID, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK,
				recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
		int result = fixture.getRecPlayerScore();

		assertEquals(GLOBAL_SCORE_REC, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Before
	public void setUp()
		throws Exception {
		recPlayer = new Player("id1", "username1", GLOBAL_SCORE_REC, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		ansPlayer = new Player("id2", "username2", GLOBAL_SCORE_ANS, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@After
	public void tearDown()
		throws Exception {
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TurnTest.class);
	}
}