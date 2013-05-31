package com.example.wecharades.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.wecharades.TestConstants;

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

		Player result = TestConstants.recPlayer;

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
	 * Run the int compareTo(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testCompareTo_1()
		throws Exception {
		Player p1 = TestConstants.recPlayer;
		Player p2 = TestConstants.ansPlayer;
		int result  = p1.compareTo(p2);
		int result2 = p1.compareTo(p1);
		assertTrue(result > 0);
		assertEquals(0, result2);
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
		Player fixture = TestConstants.recPlayer;
		Player otherPlayer = TestConstants.ansPlayer;
		boolean result = fixture.equals(otherPlayer);
		assertFalse(result);
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
		Player fixture = TestConstants.recPlayer;
		Player otherPlayer = null;

		boolean result = fixture.equals(otherPlayer);

		assertFalse(result);
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
		Player fixture = new Player("parseId", "username", 1, 0, 0, 0, 0);
		Object obj = new Player("parseId", "username", 0, 0, 0, 0, 0);
		boolean result = fixture.equals(obj);
		assertTrue(result);
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
		Player fixture = new Player("parseId", "username", 1, 0, 0, 0, 0);
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertFalse(result);
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
		Player p1 = TestConstants.ansPlayer;
		Player p2 = TestConstants.ansPlayer;
		
		assertTrue(p1.equals(p2) && p2.equals(p1));
	    assertTrue(p1.hashCode() == p2.hashCode());
	}
	
	
	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		Player p1 = TestConstants.ansPlayer;
		Player p2 = TestConstants.recPlayer;
		
		assertFalse(p1.equals(p2) && p2.equals(p1));
	    assertFalse(p1.hashCode() == p2.hashCode());
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
		Player fixture = new Player("parseId", "username", 1, 0, 0, 0, 0);

		String result = fixture.toString();

		assertEquals("username", result);
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
		new org.junit.runner.JUnitCore().run(PlayerTest.class);
	}
	
}