package com.example.wecharades.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TurnTest</code> contains tests for the class <code>{@link Turn}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class TurnTest {
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
		String gameId = "";
		int turnNumber = 1;
		int state = 1;
		String word = "";
		String videoLink = "";
		Player recPlayer = new Player("", "");
		int recPlayerScore = 1;
		Player ansPlayer = new Player("", "");
		int ansPlayerScore = 1;

		Turn result = new Turn(gameId, turnNumber, state, word, videoLink, recPlayer, recPlayerScore, ansPlayer, ansPlayerScore);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getState());
		assertEquals("", result.getWord());
		assertEquals("", result.getGameId());
		assertEquals(1, result.getTurnNumber());
		assertEquals("", result.getVideoLink());
		assertEquals(1, result.getRecPlayerScore());
		assertEquals(1, result.getAnsPlayerScore());
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		Turn anotherTurn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		int result = fixture.compareTo(anotherTurn);

		// add additional test code here
		assertEquals(0, result);
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		Turn anotherTurn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		boolean result = fixture.equals(anotherTurn);

		// add additional test code here
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
	public void testEquals_2()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		Turn anotherTurn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		boolean result = fixture.equals(anotherTurn);

		// add additional test code here
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		Turn anotherTurn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		boolean result = fixture.equals(anotherTurn);

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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		Object obj = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		Object obj = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		boolean result = fixture.equals(obj);

		// add additional test code here
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		Player result = fixture.getAnsPlayer();

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
	 * Run the int getAnsPlayerScore() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAnsPlayerScore_1()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		int result = fixture.getAnsPlayerScore();

		// add additional test code here
		assertEquals(1, result);
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		String result = fixture.getGameId();

		// add additional test code here
		assertEquals("", result);
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		Player player = new Player("", "");

		int result = fixture.getPlayerScore(player);

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getPlayerScore(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayerScore_2()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		Player player = new Player("", "");

		int result = fixture.getPlayerScore(player);

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getPlayerScore(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayerScore_3()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		Player player = new Player("", "");

		int result = fixture.getPlayerScore(player);

		// add additional test code here
		assertEquals(1, result);
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		Player result = fixture.getRecPlayer();

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
	 * Run the int getRecPlayerScore() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetRecPlayerScore_1()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		int result = fixture.getRecPlayerScore();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getState() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetState_1()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		int result = fixture.getState();

		// add additional test code here
		assertEquals(1, result);
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
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		int result = fixture.getTurnNumber();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the String getVideoLink() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetVideoLink_1()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		String result = fixture.getVideoLink();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getWord() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetWord_1()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		String result = fixture.getWord();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setAnsPlayerScore(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetAnsPlayerScore_1()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		int ansPlayerScore = 1;

		fixture.setAnsPlayerScore(ansPlayerScore);

		// add additional test code here
	}

	/**
	 * Run the void setRecPlayerScore(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetRecPlayerScore_1()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		int recPlayerScore = 1;

		fixture.setRecPlayerScore(recPlayerScore);

		// add additional test code here
	}

	/**
	 * Run the void setState(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetState_1()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		int state = 1;

		fixture.setState(state);

		// add additional test code here
	}

	/**
	 * Run the void setVideoLink(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetVideoLink_1()
		throws Exception {
		Turn fixture = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);
		String videoLink = "";

		fixture.setVideoLink(videoLink);

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
		new org.junit.runner.JUnitCore().run(TurnTest.class);
	}
}