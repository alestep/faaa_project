package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.views.CaptureVideoActivity;
import android.content.Context;

/**
 * The class <code>DatabaseTest</code> contains tests for the class <code>{@link Database}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class DatabaseTest {
	/**
	 * Run the IDatabase getDatabaseInstance(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetDatabaseInstance_1()
		throws Exception {
		Context context = new CaptureVideoActivity();

		IDatabase result = Database.getDatabaseInstance(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the IDatabase getDatabaseInstance(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetDatabaseInstance_2()
		throws Exception {
		Context context = new CaptureVideoActivity();

		IDatabase result = Database.getDatabaseInstance(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
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
		new org.junit.runner.JUnitCore().run(DatabaseTest.class);
	}
}