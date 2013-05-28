package com.example.wecharades.model.test;

import com.example.wecharades.model.Player;

import junit.framework.TestCase;

/**
 * Testing the Turn class.
 * This class doesn't test getters and setters if they only return primitive data types or strings.
 * It doesn't test very simple methods since is doesn't enhances the quality of the testing.
 * It doesn't test methods which are directly or indirectly tested in other test classes.
 * @author felixkarlsson
 */
public class PlayerTest extends TestCase {
	private Player p1, p2;
	private final int
			GLOBAL_SCORE	= 0,
			PLAYED_GAMES	= 0,
			WON_GAMES		= 0,
			LOST_GAMES		= 0,
			DRAW_GAMES		= 0;
	
	protected void setUp() throws Exception {
		super.setUp();
		p1 = new Player("id1", "username1", GLOBAL_SCORE, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
		p2 = new Player("id2", "username2", GLOBAL_SCORE, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEqualsPlayer() {
		assertEquals(p1.equals(p2), false);
		assertEquals(p1.equals(p1), true);

	}

	public void testEqualsObject() {
		assertEquals(p1.equals(p2), false);
		assertEquals(p1.equals(p1), true);
	}

	public void testCompareTo() {
		assertEquals(p1.compareTo(p2) == 0, false);
		assertEquals(p1.compareTo(p1) == 0, true);

	}

}
