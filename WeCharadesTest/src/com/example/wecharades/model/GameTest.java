package com.example.wecharades.model;

import java.text.DateFormat;
import java.util.Date;
import org.junit.*;

import com.example.wecharades.TestConstants;

import static org.junit.Assert.*;

/**
 * The class <code>GameTest</code> contains tests for the class <code>{@link Game}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class GameTest {
	/**
	 * Run the Game(String,Player,Player,Player,int,boolean,Date) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGame_1()
		throws Exception {
		Game result = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());

		assertNotNull(result);
		assertEquals(false, result.isFinished());
		assertEquals(TestConstants.GAME_ID1, result.getGameId());
		assertEquals(TestConstants.TURN_NUMBER_1, result.getTurnNumber());
	}

	/**
	 * Run the boolean aheadOf(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testAheadOf_1()
			throws Exception {
		
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());
		Game game = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_2,
				TestConstants.NOT_FINISHED,
				new Date());
		
		boolean result = game.aheadOf(fixture);
		assertTrue(result);
	}

	/**
	 * Run the boolean aheadOf(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testAheadOf_2()
		throws Exception {
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());

		
		boolean result = fixture.aheadOf(fixture);
		assertFalse(result);
	}

	/**
	 * Run the boolean aheadOf(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testAheadOf_3()
		throws Exception {
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());
		Game game = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_2,
				TestConstants.NOT_FINISHED,
				new Date());
		
		boolean result = fixture.aheadOf(game);
		assertFalse(result);
	}

	/**
	 * Run the boolean aheadOf(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testAheadOf_4()
		throws Exception {
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, false, new Date());
		Game game = null;
		boolean result = fixture.aheadOf(game);
		assertEquals(false, result);
	}

	/**
	 * Run the boolean aheadOf(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testAheadOf_5()
		throws Exception {
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());
		Game game = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.ansPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());
		boolean result = game.aheadOf(fixture);
		assertTrue(result);
	}

	/**
	 * Run the int compareTo(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testCompareTo_1()
		throws Exception {
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, false, new Date());
		Game otherGame = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());
		int result = fixture.compareTo(otherGame);
		assertEquals(0, result);
	}

	/**
	 * Run the boolean equals(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());
		Game otherGame = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());

		boolean result = fixture.equals(otherGame);
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Game fixture = new Game("game1", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());
		Game otherGame = new Game("gam2", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());

		boolean result = fixture.equals(otherGame);
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
	public void testEquals_3()
		throws Exception {
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());
		Object obj = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());

		boolean result = fixture.equals(obj);

		// add additional test code here
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
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
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
	public void testEquals_5()
		throws Exception {
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
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
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());
		Object obj = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the Player getCurrentPlayer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetCurrentPlayer_1()
		throws Exception {
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer, //<--currentPlayer
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());

		Player result = fixture.getCurrentPlayer();

		assertNotNull(result);
		assertEquals(TestConstants.REC_PLAYER_NAME, result.toString());
		assertEquals(TestConstants.REC_PLAYER_NAME, result.getName());
		assertEquals(TestConstants.REC_PLAYER_ID, result.getParseId());
		assertEquals(TestConstants.GLOBAL_SCORE_REC, result.getGlobalScore());
		assertEquals(TestConstants.PLAYED_GAMES, result.getPlayedGames());
		assertEquals(TestConstants.WON_GAMES, result.getWonGames());
		assertEquals(TestConstants.LOST_GAMES, result.getLostGames());
		assertEquals(TestConstants.DRAW_GAMES, result.getDrawGames());
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
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer, //<--currentPlayer
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());
		
		String result = fixture.getGameId();

		// add additional test code here
		assertEquals(TestConstants.GAME_ID1, result);
	}

	/**
	 * Run the Date getLastPlayed() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetLastPlayed_1()
		throws Exception {
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date(1369812576094L));
		Date result = fixture.getLastPlayed();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1369812576094L)), DateFormat.getInstance().format(result));
		assertEquals(1369812576094L, result.getTime());
	}

	/**
	 * Run the Player getOpponent(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetOpponent_1()
		throws Exception {
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());

		Player result = fixture.getOpponent(TestConstants.ansPlayer);

		//Should generate recPlayer
		assertNotNull(result);
		assertEquals(TestConstants.REC_PLAYER_NAME, result.toString());
		assertEquals(TestConstants.REC_PLAYER_NAME, result.getName());
		assertEquals(TestConstants.REC_PLAYER_ID, result.getParseId());
		assertEquals(TestConstants.GLOBAL_SCORE_REC, result.getGlobalScore());
		assertEquals(TestConstants.PLAYED_GAMES, result.getPlayedGames());
		assertEquals(TestConstants.WON_GAMES, result.getWonGames());
		assertEquals(TestConstants.LOST_GAMES, result.getLostGames());
		assertEquals(TestConstants.DRAW_GAMES, result.getDrawGames());
	}

	/**
	 * Run the Player getOpponent(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetOpponent_2()
		throws Exception {
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());

		Player result = fixture.getOpponent(TestConstants.recPlayer);

		//Should generate ansPlayer
		assertNotNull(result);
		assertEquals(TestConstants.ANS_PLAYER_NAME, result.toString());
		assertEquals(TestConstants.ANS_PLAYER_NAME, result.getName());
		assertEquals(TestConstants.ANS_PLAYER_ID, result.getParseId());
		assertEquals(TestConstants.GLOBAL_SCORE_ANS, result.getGlobalScore());
		assertEquals(TestConstants.PLAYED_GAMES, result.getPlayedGames());
		assertEquals(TestConstants.WON_GAMES, result.getWonGames());
		assertEquals(TestConstants.LOST_GAMES, result.getLostGames());
		assertEquals(TestConstants.DRAW_GAMES, result.getDrawGames());
	}

	/**
	 * Run the Player getPlayer1() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayer1_1()
		throws Exception {
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());

		Player result = fixture.getPlayer1();

		//Should generate recPlayer
		assertNotNull(result);
		assertEquals(TestConstants.REC_PLAYER_NAME, result.toString());
		assertEquals(TestConstants.REC_PLAYER_NAME, result.getName());
		assertEquals(TestConstants.REC_PLAYER_ID, result.getParseId());
		assertEquals(TestConstants.GLOBAL_SCORE_REC, result.getGlobalScore());
		assertEquals(TestConstants.PLAYED_GAMES, result.getPlayedGames());
		assertEquals(TestConstants.WON_GAMES, result.getWonGames());
		assertEquals(TestConstants.LOST_GAMES, result.getLostGames());
		assertEquals(TestConstants.DRAW_GAMES, result.getDrawGames());
	}

	/**
	 * Run the Player getPlayer2() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayer2_1()
		throws Exception {
		Game fixture = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());

		Player result = fixture.getPlayer2();

		//Should generate ansPlayer
		assertNotNull(result);
		assertEquals(TestConstants.ANS_PLAYER_NAME, result.toString());
		assertEquals(TestConstants.ANS_PLAYER_NAME, result.getName());
		assertEquals(TestConstants.ANS_PLAYER_ID, result.getParseId());
		assertEquals(TestConstants.GLOBAL_SCORE_ANS, result.getGlobalScore());
		assertEquals(TestConstants.PLAYED_GAMES, result.getPlayedGames());
		assertEquals(TestConstants.WON_GAMES, result.getWonGames());
		assertEquals(TestConstants.LOST_GAMES, result.getLostGames());
		assertEquals(TestConstants.DRAW_GAMES, result.getDrawGames());
	}


	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Game game1 = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());
		
		Game game2 = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());
	    assertTrue(game1.equals(game2) && game2.equals(game1));
	    assertTrue(game1.hashCode() == game2.hashCode());
	}



	/**
	 * Run the boolean isFinished() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testIsFinished_1()
		throws Exception {
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());

		boolean result = fixture.isFinished();

		assertTrue(result);
	}

	/**
	 * Run the boolean isFinished() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testIsFinished_2()
		throws Exception {
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, false, new Date());

		boolean result = fixture.isFinished();

		assertEquals(false, result);
	}

	/**
	 * Run the void setCurrentPlayer(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetCurrentPlayer_1()
		throws Exception {
		Game fixture = new Game("", TestConstants.recPlayer, TestConstants.recPlayer, TestConstants.recPlayer, 1, true, new Date());
		Player currentPlayer = TestConstants.recPlayer;

		fixture.setCurrentPlayer(currentPlayer);
		assertTrue(fixture.getCurrentPlayer().equals(currentPlayer));

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
		new org.junit.runner.JUnitCore().run(GameTest.class);
	}
}