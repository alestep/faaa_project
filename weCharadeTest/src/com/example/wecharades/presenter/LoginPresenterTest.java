package com.example.wecharades.presenter;

import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.DataController;
import com.example.wecharades.views.AccountActivity;
import android.widget.EditText;
import com.example.wecharades.views.CaptureVideoActivity;
import com.example.wecharades.views.GenericActivity;
import com.example.wecharades.views.LoginActivity;
import android.content.Context;

/**
 * The class <code>LoginPresenterTest</code> contains tests for the class <code>{@link LoginPresenter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:36
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class LoginPresenterTest {
	/**
	 * Run the LoginPresenter(LoginActivity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testLoginPresenter_1()
		throws Exception {
		LoginActivity activity = new LoginActivity();

		LoginPresenter result = new LoginPresenter(activity);

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
	 * Run the void login(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testLogin_1()
		throws Exception {
		LoginPresenter fixture = new LoginPresenter(new LoginActivity());
		fixture.login("", "");
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		String username = "";
		String password = "";

		fixture.login(username, password);

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
	 * Run the void setListeners(EditText) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testSetListeners_1()
		throws Exception {
		LoginPresenter fixture = new LoginPresenter(new LoginActivity());
		fixture.login("", "");
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		EditText password = new EditText(new CaptureVideoActivity());

		fixture.setListeners(password);

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
	 * @generatedBy CodePro at 2013-05-29 09:36
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
	 * @generatedBy CodePro at 2013-05-29 09:36
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
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(LoginPresenterTest.class);
	}
}