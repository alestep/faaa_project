package com.example.wecharades.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>DatabaseExceptionTest</code> contains tests for the class <code>{@link DatabaseException}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class DatabaseExceptionTest {
	/**
	 * Run the DatabaseException(int,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testDatabaseException_1()
		throws Exception {
		int code = 1;
		String message = "";

		DatabaseException result = new DatabaseException(code, message);

		assertNotNull(result);
		assertEquals(1, result.getCode());
		assertEquals("Internal server error", result.prettyPrint());
		assertEquals(null, result.getCause());
		assertEquals("com.example.wecharades.model.DatabaseException: ", result.toString());
		assertEquals("", result.getMessage());
		assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Run the int getCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetCode_1()
		throws Exception {
		DatabaseException fixture = new DatabaseException(1, "");

		int result = fixture.getCode();
		assertEquals(1, result);
	}

	/**
	 * Run the String prettyPrint() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPrettyPrint_1()
		throws Exception {
		DatabaseException fixture = new DatabaseException(1, "");

		String result = fixture.prettyPrint();

		assertEquals("Internal server error", result);
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
		new org.junit.runner.JUnitCore().run(DatabaseExceptionTest.class);
	}
}