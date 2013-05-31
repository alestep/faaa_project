package com.example.wecharades.model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.wecharades.TestConstants;

/**
 * The class <code>DBMessageTest</code> contains tests for the class <code>{@link DBMessage}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class DBMessageTest {
	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_1()
		throws Exception {
		int message = 10;
		Object data = new Object();

		DBMessage result = new DBMessage(message, data);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
		assertEquals(data, result.getData());
	}

	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_2()
		throws Exception {
		int message = 10;
		String data = new String();

		DBMessage result = new DBMessage(message, data);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
		assertEquals(data, result.getData());
	}

	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_3()
		throws Exception {
		int message = 10;
		Object data = new HashMap();

		DBMessage result = new DBMessage(message, data);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}

	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_4()
		throws Exception {
		int message = 10;
		DatabaseException dbE = new DatabaseException(0, "error message");
		DBMessage result = new DBMessage(message, dbE);

		// add additional test code here
		assertNotNull(result);
		assertEquals(10, result.getMessage());
	}
	
	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_5()
		throws Exception {
		int message = 20;
		Object data = new Object();

		DBMessage result = new DBMessage(message, data);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
		assertEquals(data, result.getData());
	}

	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_6()
		throws Exception {
		int message = 20;
		String data = new String();

		DBMessage result = new DBMessage(message, data);

		assertNotNull(result);
		assertEquals(20, result.getMessage());
		assertEquals(data, result.getData());
	}

	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_7()
		throws Exception {
		int message = 20;
		Object data = new HashMap();

		DBMessage result = new DBMessage(message, data);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}

	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_8()
		throws Exception {
		int message = 20;
		DatabaseException dbE = new DatabaseException(0, "error message");
		DBMessage result = new DBMessage(message, dbE);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getMessage());
	}
	
	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_9()
		throws Exception {
		int message = 30;
		Object data = new Object();

		DBMessage result = new DBMessage(message, data);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
		assertEquals(data, result.getData());
	}
	
	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_10()
		throws Exception {
		int message = 30;
		String data = new String();

		DBMessage result = new DBMessage(message, data);

		assertNotNull(result);
		assertEquals(0, result.getMessage());
		assertEquals(data, result.getData());
	}


	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_11()
		throws Exception {
		int message = 30;
		Object data = new HashMap();

		DBMessage result = new DBMessage(message, data);

		assertNotNull(result);
		assertEquals(30, result.getMessage());
	}

	/**
	 * Run the DBMessage(int,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDBMessage_12()
		throws Exception {
		int message = 30;
		Map<Game, ArrayList<Turn>> data = new HashMap<Game, ArrayList<Turn>>();
		Game g = new Game(TestConstants.GAME_ID1,
				TestConstants.recPlayer,
				TestConstants.ansPlayer,
				TestConstants.recPlayer,
				TestConstants.TURN_NUMBER_1,
				TestConstants.NOT_FINISHED,
				new Date());
		ArrayList<Turn> turns = new ArrayList<Turn>();
		data.put(g, turns);
		DBMessage result = new DBMessage(message, data);

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
	public void testDCMessage_13()
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
	public void testDCMessage_14()
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
	public void testDCMessage_15()
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
	public void testDCMessage_16()
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
	public void testDCMessage_17()
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
		DBMessage fixture = new DBMessage(1, new Object());

		Object result = fixture.getData();

		// add additional test code here
		assertNotNull(result);
		assertTrue(result instanceof Object);
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
		DBMessage fixture = new DBMessage(1, new String());

		Object result = fixture.getData();

		// add additional test code here
		assertNotNull(result);
		assertTrue(result instanceof String);
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
		new org.junit.runner.JUnitCore().run(DBMessageTest.class);
	}
}