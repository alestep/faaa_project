package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.Date;

import org.junit.*;

import com.example.wecharades.TestConstants;

import static org.junit.Assert.*;

/**
 * The class <code>DCMessageTest</code> contains tests for the class <code>{@link DCMessage}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class DCMessageTest {
	
	
	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_1()
		throws Exception {
		int message = 10;
		Object data = new Object();

		DCMessage result = new DCMessage(message, data);
		assertNotNull(result);
		assertEquals(0, result.getMessage());

	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_2()
		throws Exception {
		int message = 10;
		String data = new String();

		DCMessage result = new DCMessage(message, data);
		assertNotNull(result);
		assertEquals(10, result.getMessage());

		
	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_3()
		throws Exception {
		int message = 10;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_4()
		throws Exception {
		int message = 10;

		DCMessage result = new DCMessage(message, null);
		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}

	
	
	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_5()
		throws Exception {
		int message = 20;
		Object data = new Object();

		DCMessage result = new DCMessage(message, data);
		assertNotNull(result);
		assertEquals(0, result.getMessage());

	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_6()
		throws Exception {
		int message = 20;
		String data = new String();

		DCMessage result = new DCMessage(message, data);
		assertNotNull(result);
		assertEquals(20, result.getMessage());
	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_7()
		throws Exception {
		int message = 20;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_8()
		throws Exception {
		int message = 20;

		DCMessage result = new DCMessage(message, null);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}
	
	
	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_9()
		throws Exception {
		int message = 30;
		Object data = new Object();

		DCMessage result = new DCMessage(message, data);
		assertNotNull(result);
		assertEquals(0, result.getMessage());

	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_10()
		throws Exception {
		int message = 30;
		String data = new String();

		DCMessage result = new DCMessage(message, data);
		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_11()
		throws Exception {
		int message = 30;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		assertNotNull(result);
		assertEquals(30, result.getMessage());
	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_12()
		throws Exception {
		int message = 30;

		DCMessage result = new DCMessage(message, null);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}
	
	
	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_13()
		throws Exception {
		int message = 30;
		ArrayList<Game> data = new ArrayList<Game>();
		Game g = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());
		data.add(g);
		DCMessage result = new DCMessage(message, data);

		assertNotNull(result);
		assertEquals(30, result.getMessage());
	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_14()
		throws Exception {
		int message = 40;
		Object data = new Object();

		DCMessage result = new DCMessage(message, data);
		assertNotNull(result);
		assertEquals(0, result.getMessage());

	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_15()
		throws Exception {
		int message = 40;
		String data = new String();

		DCMessage result = new DCMessage(message, data);
		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_16()
		throws Exception {
		int message = 40;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		assertNotNull(result);
		assertEquals(40, result.getMessage());
	}

	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_17()
		throws Exception {
		int message = 40;

		DCMessage result = new DCMessage(message, null);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}
	
	
	/**
	 * Run the DCMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDCMessage_18()
		throws Exception {
		int message = 40;
		ArrayList<Invitation> data = new ArrayList<Invitation>();
		Invitation i = new Invitation(TestConstants.ansPlayer, TestConstants.recPlayer);
		data.add(i);
		DCMessage result = new DCMessage(message, data);

		assertNotNull(result);
		assertEquals(40, result.getMessage());
	}

	/**
	 * Run the Object getData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetData_1()
		throws Exception {
		DCMessage fixture = new DCMessage(10, new String());

		Object result = fixture.getData();

		assertNotNull(result);
		assertTrue(result instanceof String);
	}
	
	/**
	 * Run the Object getData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetData_2()
		throws Exception {
		DCMessage fixture = new DCMessage(10, new Object());

		Object result = fixture.getData();

		assertNotNull(result);
		assertTrue(result instanceof Object);
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
		new org.junit.runner.JUnitCore().run(DCMessageTest.class);
	}
}