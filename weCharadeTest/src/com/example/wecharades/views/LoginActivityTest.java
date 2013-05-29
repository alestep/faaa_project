package com.example.wecharades.views;

import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.LoadProgressBar;
import com.example.wecharades.presenter.AccountPresenter;
import com.example.wecharades.presenter.LoginPresenter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.content.Context;
import com.example.wecharades.presenter.Presenter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * The class <code>LoginActivityTest</code> contains tests for the class <code>{@link LoginActivity}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:38
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class LoginActivityTest {
	/**
	 * Run the LoadProgressBar getProgressBar() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testGetProgressBar_1()
		throws Exception {
		LoginActivity fixture = new LoginActivity();
		fixture.loginErrorMsg = new TextView(new CaptureVideoActivity());
		fixture.presenter = new LoginPresenter(new LoginActivity());
		fixture.inputUsername = new EditText(new CaptureVideoActivity());
		fixture.inputPassword = new EditText(new CaptureVideoActivity());
		fixture.myView = new View(new CaptureVideoActivity());
		fixture.presenter = new AccountPresenter(new AccountActivity());
		fixture.loginProgress = new LoadProgressBar(new CaptureVideoActivity(), new ProgressBar(new CaptureVideoActivity()));

		LoadProgressBar result = fixture.getProgressBar();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.LoginActivity.<init>(LoginActivity.java:15)
		assertNotNull(result);
	}

	/**
	 * Run the void onClickForgotPassword(View) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnClickForgotPassword_1()
		throws Exception {
		LoginActivity fixture = new LoginActivity();
		fixture.loginErrorMsg = new TextView(new CaptureVideoActivity());
		fixture.presenter = new LoginPresenter(new LoginActivity());
		fixture.inputUsername = new EditText(new CaptureVideoActivity());
		fixture.inputPassword = new EditText(new CaptureVideoActivity());
		fixture.myView = new View(new CaptureVideoActivity());
		fixture.presenter = new AccountPresenter(new AccountActivity());
		fixture.loginProgress = new LoadProgressBar(new CaptureVideoActivity(), new ProgressBar(new CaptureVideoActivity()));
		View view = new View(new CaptureVideoActivity());

		fixture.onClickForgotPassword(view);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.LoginActivity.<init>(LoginActivity.java:15)
	}

	/**
	 * Run the void onClickLogin(View) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnClickLogin_1()
		throws Exception {
		LoginActivity fixture = new LoginActivity();
		fixture.loginErrorMsg = new TextView(new CaptureVideoActivity());
		fixture.presenter = new LoginPresenter(new LoginActivity());
		fixture.inputUsername = new EditText(new CaptureVideoActivity());
		fixture.inputPassword = new EditText(new CaptureVideoActivity());
		fixture.myView = new View(new CaptureVideoActivity());
		fixture.presenter = new AccountPresenter(new AccountActivity());
		fixture.loginProgress = new LoadProgressBar(new CaptureVideoActivity(), new ProgressBar(new CaptureVideoActivity()));
		View view = new View(new CaptureVideoActivity());

		fixture.onClickLogin(view);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.LoginActivity.<init>(LoginActivity.java:15)
	}

	/**
	 * Run the void onClickRegister(View) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	@Test
	public void testOnClickRegister_1()
		throws Exception {
		LoginActivity fixture = new LoginActivity();
		fixture.loginErrorMsg = new TextView(new CaptureVideoActivity());
		fixture.presenter = new LoginPresenter(new LoginActivity());
		fixture.inputUsername = new EditText(new CaptureVideoActivity());
		fixture.inputPassword = new EditText(new CaptureVideoActivity());
		fixture.myView = new View(new CaptureVideoActivity());
		fixture.presenter = new AccountPresenter(new AccountActivity());
		fixture.loginProgress = new LoadProgressBar(new CaptureVideoActivity(), new ProgressBar(new CaptureVideoActivity()));
		View view = new View(new CaptureVideoActivity());

		fixture.onClickRegister(view);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.LoginActivity.<init>(LoginActivity.java:15)
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
		LoginActivity fixture = new LoginActivity();
		fixture.loginErrorMsg = new TextView(new CaptureVideoActivity());
		fixture.presenter = new LoginPresenter(new LoginActivity());
		fixture.inputUsername = new EditText(new CaptureVideoActivity());
		fixture.inputPassword = new EditText(new CaptureVideoActivity());
		fixture.myView = new View(new CaptureVideoActivity());
		fixture.presenter = new AccountPresenter(new AccountActivity());
		fixture.loginProgress = new LoadProgressBar(new CaptureVideoActivity(), new ProgressBar(new CaptureVideoActivity()));
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
		//       at com.example.wecharades.views.LoginActivity.<init>(LoginActivity.java:15)
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
		LoginActivity fixture = new LoginActivity();
		fixture.loginErrorMsg = new TextView(new CaptureVideoActivity());
		fixture.presenter = new LoginPresenter(new LoginActivity());
		fixture.inputUsername = new EditText(new CaptureVideoActivity());
		fixture.inputPassword = new EditText(new CaptureVideoActivity());
		fixture.myView = new View(new CaptureVideoActivity());
		fixture.presenter = new AccountPresenter(new AccountActivity());
		fixture.loginProgress = new LoadProgressBar(new CaptureVideoActivity(), new ProgressBar(new CaptureVideoActivity()));

		fixture.onStart();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.LoginActivity.<init>(LoginActivity.java:15)
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
		new org.junit.runner.JUnitCore().run(LoginActivityTest.class);
	}
}