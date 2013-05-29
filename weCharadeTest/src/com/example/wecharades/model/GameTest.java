package com.example.wecharades.model;

import java.text.DateFormat;
import java.util.Date;
import org.junit.*;
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
		String gameId = "";
		Player p1 = new Player("", "");
		Player p2 = new Player("", "");
		Player currentPlayer = new Player("", "");
		int turn = 1;
		boolean finished = true;
		Date lastPlayed = new Date();

		Game result = new Game(gameId, p1, p2, currentPlayer, turn, finished, lastPlayed);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.isFinished());
		assertEquals("", result.getGameId());
		assertEquals(1, result.getTurnNumber());
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		boolean result = fixture.aheadOf(game);

		// add additional test code here
		assertEquals(true, result);
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, false, new Date());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		boolean result = fixture.aheadOf(game);

		// add additional test code here
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
	public void testAheadOf_3()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, false, new Date());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		boolean result = fixture.aheadOf(game);

		// add additional test code here
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
	public void testAheadOf_4()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Game game = null;

		boolean result = fixture.aheadOf(game);

		// add additional test code here
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, false, new Date());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		boolean result = fixture.aheadOf(game);

		// add additional test code here
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
	public void testAheadOf_6()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, false, new Date());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		boolean result = fixture.aheadOf(game);

		// add additional test code here
		assertEquals(false, result);
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Game otherGame = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		int result = fixture.compareTo(otherGame);

		// add additional test code here
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Game otherGame = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		boolean result = fixture.equals(otherGame);

		// add additional test code here
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Game otherGame = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		boolean result = fixture.equals(otherGame);

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
	public void testEquals_3()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Object obj = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Object obj = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		Player result = fixture.getCurrentPlayer();

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getParseId());
		assertEquals(0, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		String result = fixture.getGameId();

		// add additional test code here
		assertEquals("", result);
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Player otherPlayer = new Player("", "");

		Player result = fixture.getOpponent(otherPlayer);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getParseId());
		assertEquals(0, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Player otherPlayer = new Player("", "");

		Player result = fixture.getOpponent(otherPlayer);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getParseId());
		assertEquals(0, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
	}

	/**
	 * Run the Player getOpponent(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetOpponent_3()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Player otherPlayer = new Player("", "");

		Player result = fixture.getOpponent(otherPlayer);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getParseId());
		assertEquals(0, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		Player result = fixture.getPlayer1();

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getParseId());
		assertEquals(0, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		Player result = fixture.getPlayer2();

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getParseId());
		assertEquals(0, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
	}

	/**
	 * Run the int getTurnNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetTurnNumber_1()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		int result = fixture.getTurnNumber();

		// add additional test code here
		assertEquals(1, result);
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the void incrementTurn() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testIncrementTurn_1()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		fixture.incrementTurn();

		// add additional test code here
	}

	/**
	 * Run the void incrementTurn() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testIncrementTurn_2()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 6, true, new Date());

		fixture.incrementTurn();

		// add additional test code here
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		boolean result = fixture.isFinished();

		// add additional test code here
		assertEquals(true, result);
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, false, new Date());

		boolean result = fixture.isFinished();

		// add additional test code here
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
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Player currentPlayer = new Player("", "");

		fixture.setCurrentPlayer(currentPlayer);

		// add additional test code here
	}

	/**
	 * Run the void setCurrentPlayer(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetCurrentPlayer_2()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Player currentPlayer = new Player("", "");

		fixture.setCurrentPlayer(currentPlayer);

		// add additional test code here
	}

	/**
	 * Run the void setCurrentPlayer(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetCurrentPlayer_3()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Player currentPlayer = new Player("", "");

		fixture.setCurrentPlayer(currentPlayer);

		// add additional test code here
	}

	/**
	 * Run the void setFinished() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetFinished_1()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		fixture.setFinished();

		// add additional test code here
	}

	/**
	 * Run the void setLastPlayed(Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetLastPlayed_1()
		throws Exception {
		Game fixture = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());
		Date lastPlayed = new Date();

		fixture.setLastPlayed(lastPlayed);

		// add additional test code here
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
		// add additional set up code here
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
		// Add additional tear down code here
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