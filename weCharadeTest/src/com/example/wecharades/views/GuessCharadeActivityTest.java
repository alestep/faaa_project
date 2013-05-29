package com.example.wecharades.views;

import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.IProgress;
import com.example.wecharades.presenter.AccountPresenter;
import com.example.wecharades.presenter.Presenter;
import android.os.Bundle;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;

/**
 * The class <code>GuessCharadeActivityTest</code> contains tests for the class <code>{@link GuessCharadeActivity}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:38
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class GuessCharadeActivityTest {
	/**
	 * Run the GuessCharadeActivity() constructor test.
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testGuessCharadeActivity_1()
		throws Exception {
		GuessCharadeActivity result = new GuessCharadeActivity();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void finishDialog() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testFinishDialog_1()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());

		fixture.finishDialog();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
	}

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
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
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
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
		assertNotNull(result);
	}

	/**
	 * Run the void onClickGuess(View) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnClickGuess_1()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());
		View view = new View(new CaptureVideoActivity());

		fixture.onClickGuess(view);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
	}

	/**
	 * Run the void onClickGuess(View) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnClickGuess_2()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());
		View view = new View(new CaptureVideoActivity());

		fixture.onClickGuess(view);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
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
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
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
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
	}

	/**
	 * Run the boolean onKeyDown(int,KeyEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnKeyDown_1()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());
		int keyCode = 4;
		KeyEvent event = new KeyEvent(1, 1);

		boolean result = fixture.onKeyDown(keyCode, event);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
		assertTrue(result);
	}

	/**
	 * Run the boolean onKeyDown(int,KeyEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnKeyDown_2()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());
		int keyCode = 4;
		KeyEvent event = new KeyEvent(1, 1);

		boolean result = fixture.onKeyDown(keyCode, event);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
		assertTrue(result);
	}

	/**
	 * Run the boolean onKeyDown(int,KeyEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnKeyDown_3()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());
		int keyCode = 82;
		KeyEvent event = new KeyEvent(1, 1);

		boolean result = fixture.onKeyDown(keyCode, event);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
		assertTrue(result);
	}

	/**
	 * Run the boolean onKeyDown(int,KeyEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnKeyDown_4()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());
		int keyCode = 1;
		KeyEvent event = new KeyEvent(1, 1);

		boolean result = fixture.onKeyDown(keyCode, event);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
		assertTrue(result);
	}

	/**
	 * Run the void onResume() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnResume_1()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 0;
		fixture.presenter = new AccountPresenter(new AccountActivity());

		fixture.onResume();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
	}

	/**
	 * Run the void onResume() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnResume_2()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());

		fixture.onResume();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
	}

	/**
	 * Run the void onResume() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnResume_3()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());

		fixture.onResume();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
	}

	/**
	 * Run the void onStart() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnStart_1()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());

		fixture.onStart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
	}

	/**
	 * Run the void setPossibleLetters(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testSetPossibleLetters_1()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());
		String letters = "";

		fixture.setPossibleLetters(letters);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
	}

	/**
	 * Run the void setTime(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testSetTime_1()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());
		String time = "";

		fixture.setTime(time);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
	}

	/**
	 * Run the void showErrorDialog(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testShowErrorDialog_1()
		throws Exception {
		GuessCharadeActivity fixture = new GuessCharadeActivity();
		fixture.gameState = 1;
		fixture.presenter = new AccountPresenter(new AccountActivity());
		String str = "";

		fixture.showErrorDialog(str);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GuessCharadeActivity.<init>(GuessCharadeActivity.java:24)
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
		new org.junit.runner.JUnitCore().run(GuessCharadeActivityTest.class);
	}
}