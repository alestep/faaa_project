package com.example.wecharades.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PlayerTest</code> contains tests for the class <code>{@link Player}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class PlayerTest {
	/**
	 * Run the Player(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPlayer_1()
		throws Exception {
		String parseId = "";
		String username = "";

		Player result = new Player(parseId, username);

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
	 * Run the Player(String,String,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPlayer_2()
		throws Exception {
		String parseId = "";
		String username = "";
		int globalScore = 1;

		Player result = new Player(parseId, username, globalScore);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getParseId());
		assertEquals(1, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
	}

	/**
	 * Run the Player(String,String,int,int,int,int,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPlayer_3()
		throws Exception {
		String parseId = "";
		String username = "";
		int globalScore = 1;
		int playedGames = 1;
		int wonGames = 1;
		int lostGames = 1;
		int drawGames = 1;

		Player result = new Player(parseId, username, globalScore, playedGames, wonGames, lostGames, drawGames);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getParseId());
		assertEquals(1, result.getGlobalScore());
		assertEquals(0, result.getPlayedGames());
		assertEquals(0, result.getWonGames());
		assertEquals(0, result.getLostGames());
		assertEquals(0, result.getDrawGames());
	}

	/**
	 * Run the int compareTo(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testCompareTo_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
		Player another = new Player("", "");

		int result = fixture.compareTo(another);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int compareTo(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testCompareTo_2()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
		Player another = null;

		int result = fixture.compareTo(another);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the boolean equals(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
		Player otherPlayer = new Player("", "");

		boolean result = fixture.equals(otherPlayer);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
		Player otherPlayer = null;

		boolean result = fixture.equals(otherPlayer);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
		Player otherPlayer = new Player("", "");

		boolean result = fixture.equals(otherPlayer);

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
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
		Object obj = new Player("", "");

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
	public void testEquals_5()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
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
	public void testEquals_6()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
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
	public void testEquals_7()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
		Object obj = new Player("", "");

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the int getDrawGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetDrawGames_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		int result = fixture.getDrawGames();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getGlobalScore() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetGlobalScore_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		int result = fixture.getGlobalScore();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getLostGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetLostGames_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		int result = fixture.getLostGames();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getParseId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetParseId_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		String result = fixture.getParseId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int getPlayedGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayedGames_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		int result = fixture.getPlayedGames();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getWonGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetWonGames_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		int result = fixture.getWonGames();

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
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the void incrementDrawGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testIncrementDrawGames_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		fixture.incrementDrawGames();

		// add additional test code here
	}

	/**
	 * Run the void incrementFinishedGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testIncrementFinishedGames_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		fixture.incrementFinishedGames();

		// add additional test code here
	}

	/**
	 * Run the void incrementLostGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testIncrementLostGames_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		fixture.incrementLostGames();

		// add additional test code here
	}

	/**
	 * Run the void incrementWonGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testIncrementWonGames_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		fixture.incrementWonGames();

		// add additional test code here
	}

	/**
	 * Run the void setGlobalScore(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetGlobalScore_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();
		int globalScore = 1;

		fixture.setGlobalScore(globalScore);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Player fixture = new Player("", "", 1);
		fixture.incrementDrawGames();
		fixture.incrementLostGames();
		fixture.incrementFinishedGames();
		fixture.incrementWonGames();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("", result);
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
		new org.junit.runner.JUnitCore().run(PlayerTest.class);
	}
}