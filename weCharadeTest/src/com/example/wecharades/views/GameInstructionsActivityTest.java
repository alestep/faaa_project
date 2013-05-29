package com.example.wecharades.views;

import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.IProgress;
import com.example.wecharades.presenter.AccountPresenter;
import com.example.wecharades.presenter.Presenter;
import android.os.Bundle;
import android.content.Context;
import android.view.View;

/**
 * The class <code>GameInstructionsActivityTest</code> contains tests for the class <code>{@link GameInstructionsActivity}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:38
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class GameInstructionsActivityTest {
	/**
	 * Run the IProgress getProgressBar() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testGetProgressBar_1()
		throws Exception {
		GameInstructionsActivity fixture = new GameInstructionsActivity();
		fixture.presenter = new AccountPresenter(new AccountActivity());

		IProgress result = fixture.getProgressBar();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GameInstructionsActivity.<init>(GameInstructionsActivity.java:12)
		assertNotNull(result);
	}

	/**
	 * Run the void onClickHome(View) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnClickHome_1()
		throws Exception {
		GameInstructionsActivity fixture = new GameInstructionsActivity();
		fixture.presenter = new AccountPresenter(new AccountActivity());
		View v = new View(new CaptureVideoActivity());

		fixture.onClickHome(v);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GameInstructionsActivity.<init>(GameInstructionsActivity.java:12)
	}

	/**
	 * Run the void onCreate(Bundle) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnCreate_1()
		throws Exception {
		GameInstructionsActivity fixture = new GameInstructionsActivity();
		fixture.presenter = new AccountPresenter(new AccountActivity());
		Bundle savedInstanceState = new Bundle();

		fixture.onCreate(savedInstanceState);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GameInstructionsActivity.<init>(GameInstructionsActivity.java:12)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
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
	 * @generatedBy CodePro at 2013-05-29 09:38
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
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GameInstructionsActivityTest.class);
	}
}