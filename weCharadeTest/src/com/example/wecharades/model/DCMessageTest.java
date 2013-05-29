package com.example.wecharades.model;

import java.util.ArrayList;
import org.junit.*;
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

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassCastException: java.lang.Object cannot be cast to java.util.List
		//       at com.example.wecharades.model.DCMessage.<init>(DCMessage.java:31)
		assertNotNull(result);
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
		Object data = new Object();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ClassCastException: java.lang.Object cannot be cast to java.util.List
		//       at com.example.wecharades.model.DCMessage.<init>(DCMessage.java:31)
		assertNotNull(result);
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

		// add additional test code here
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
	public void testDCMessage_4()
		throws Exception {
		int message = 10;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_5()
		throws Exception {
		int message = 40;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_6()
		throws Exception {
		int message = 10;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_7()
		throws Exception {
		int message = 1;
		Object data = new Object();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getMessage());
		assertEquals(new Object(), result.getData());
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
		int message = 30;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_9()
		throws Exception {
		int message = 20;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_10()
		throws Exception {
		int message = 10;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_11()
		throws Exception {
		int message = 30;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
		int message = 20;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_13()
		throws Exception {
		int message = 10;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_14()
		throws Exception {
		int message = 30;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_15()
		throws Exception {
		int message = 20;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
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
	public void testDCMessage_16()
		throws Exception {
		int message = 10;
		Object data = new ArrayList();

		DCMessage result = new DCMessage(message, data);

		// add additional test code here
		assertNotNull(result);
		assertEquals(10, result.getMessage());
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
		DCMessage fixture = new DCMessage(1, new Object());
		fixture.message = 1;

		Object result = fixture.getData();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the int getMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetMessage_1()
		throws Exception {
		DCMessage fixture = new DCMessage(1, new Object());
		fixture.message = 1;

		int result = fixture.getMessage();

		// add additional test code here
		assertEquals(1, result);
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
		new org.junit.runner.JUnitCore().run(DCMessageTest.class);
	}
}