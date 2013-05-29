package com.example.wecharades.model;

import java.text.DateFormat;
import java.util.Date;
import org.junit.*;
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
		Player inviter = new Player("", "");
		Player invitee = new Player("", "");

		Invitation result = new Invitation(inviter, invitee);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getTimeOfInvite());
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
		Player inviter = new Player("", "");
		Player invitee = new Player("", "");
		Date timeOfInvite = new Date();

		Invitation result = new Invitation(inviter, invitee, timeOfInvite);

		// add additional test code here
		assertNotNull(result);
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
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());
		Invitation otherInv = new Invitation(new Player("", ""), new Player("", ""));

		boolean result = fixture.equals(otherInv);

		// add additional test code here
		assertEquals(true, result);
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
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());
		Invitation otherInv = null;

		boolean result = fixture.equals(otherInv);

		// add additional test code here
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
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());
		Invitation otherInv = new Invitation(new Player("", ""), new Player("", ""));

		boolean result = fixture.equals(otherInv);

		// add additional test code here
		assertEquals(true, result);
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
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());
		Invitation otherInv = new Invitation(new Player("", ""), new Player("", ""));

		boolean result = fixture.equals(otherInv);

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
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());
		Object obj = new Invitation(new Player("", ""), new Player("", ""));

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
	public void testEquals_6()
		throws Exception {
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());
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
	public void testEquals_7()
		throws Exception {
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());
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
	public void testEquals_8()
		throws Exception {
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());
		Object obj = new Invitation(new Player("", ""), new Player("", ""));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
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
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());

		Player result = fixture.getInvitee();

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
	 * Run the Player getInviter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetInviter_1()
		throws Exception {
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());

		Player result = fixture.getInviter();

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
	 * Run the Date getTimeOfInvite() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetTimeOfInvite_1()
		throws Exception {
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());

		Date result = fixture.getTimeOfInvite();

		// add additional test code here
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
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1504, result);
	}

	/**
	 * Run the void setTime(Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetTime_1()
		throws Exception {
		Invitation fixture = new Invitation(new Player("", ""), new Player("", ""), new Date());
		Date date = new Date();

		fixture.setTime(date);

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
		new org.junit.runner.JUnitCore().run(InvitationTest.class);
	}
}