package com.example.wecharades.model;

import java.text.DateFormat;
import java.util.Date;
import org.junit.*;

import com.example.wecharades.TestConstants;

import static org.junit.Assert.*;

/**
 * The class <code>InvitationTest</code> contains tests for the class <code>{@link Invitation}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class InvitationTest {
	/**
	 * Run the Invitation(Player,Player) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testInvitation_1()
		throws Exception {
		Player inviter = TestConstants.recPlayer;
		Player invitee = TestConstants.ansPlayer;
		
		Invitation result = new Invitation(inviter, invitee);

		assertNotNull(result.getTimeOfInvite());
	}

	/**
	 * Run the Invitation(Player,Player,Date) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testInvitation_2()
		throws Exception {
		Player inviter = TestConstants.recPlayer;
		Player invitee = TestConstants.ansPlayer;
		Date timeOfInvite = new Date(System.currentTimeMillis());

		Invitation result = new Invitation(inviter, invitee, timeOfInvite);

		assertNotNull(result);
		assertTrue(timeOfInvite.equals(result.getTimeOfInvite()));
		
	}

	/**
	 * Run the boolean equals(Invitation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Invitation fixture = new Invitation(TestConstants.ansPlayer, TestConstants.recPlayer, new Date());
		Invitation otherInv = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer);

		boolean result = fixture.equals(otherInv);

		assertFalse(result);
	}

	/**
	 * Run the boolean equals(Invitation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Invitation fixture = new Invitation(TestConstants.ansPlayer, TestConstants.recPlayer, new Date());
		Invitation otherInv = null;

		boolean result = fixture.equals(otherInv);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Invitation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		Invitation fixture = new Invitation(new Player("", "", 0, 0, 0, 0, 0), new Player("", "", 0, 0, 0, 0, 0), new Date());
		Invitation otherInv = new Invitation(TestConstants.ansPlayer, TestConstants.recPlayer);

		boolean result = fixture.equals(otherInv);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Invitation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		Invitation fixture = new Invitation(TestConstants.ansPlayer, TestConstants.recPlayer, new Date());
		Invitation otherInv = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer);

		boolean result = fixture.equals(otherInv);

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
		Invitation fixture = new Invitation(TestConstants.ansPlayer, TestConstants.recPlayer, new Date());
		Object obj = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer);

		boolean result = fixture.equals(obj);

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
	public void testEquals_6()
		throws Exception {
		Invitation fixture = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer, new Date());
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
	public void testEquals_7()
		throws Exception {
		Invitation fixture = new Invitation(TestConstants.ansPlayer, TestConstants.recPlayer, new Date());
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
	public void testEquals_8()
		throws Exception {
		Invitation fixture = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer, new Date());
		Object obj = new Invitation(TestConstants.ansPlayer, TestConstants.recPlayer);

		boolean result = fixture.equals(obj);

		assertFalse(result);
	}

	/**
	 * Run the Player getInvitee() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetInvitee_1()
		throws Exception {
		Invitation fixture = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer, new Date());

		Player result = fixture.getInvitee();

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
	 * Run the Player getInviter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetInviter_1()
		throws Exception {
		Invitation fixture = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer, new Date());

		Player result = fixture.getInviter();

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
	 * Run the Date getTimeOfInvite() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetTimeOfInvite_1()
		throws Exception {
		Invitation fixture = new Invitation(TestConstants.ansPlayer, TestConstants.recPlayer, new Date(1369812584219L));

		Date result = fixture.getTimeOfInvite();

		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1369812584219L)), DateFormat.getInstance().format(result));
		assertEquals(1369812584219L, result.getTime());
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
		Invitation i1 = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer, new Date());
		Invitation i2 = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer, new Date());

	    assertTrue(i1.equals(i2) && i2.equals(i1));
	    assertTrue(i1.hashCode() == i2.hashCode());
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
		new org.junit.runner.JUnitCore().run(InvitationTest.class);
	}
}