package com.example.wecharades.presenter;

import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.DataController;
import com.example.wecharades.views.AccountActivity;
import android.widget.EditText;
import com.example.wecharades.views.CaptureVideoActivity;
import com.example.wecharades.views.GenericActivity;
import com.example.wecharades.views.RegisterActivity;
import android.content.Context;

/**
 * The class <code>RegisterPresenterTest</code> contains tests for the class <code>{@link RegisterPresenter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:37
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class RegisterPresenterTest {
	/**
	 * Run the RegisterPresenter(RegisterActivity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testRegisterPresenter_1()
		throws Exception {
		RegisterActivity activity = new RegisterActivity();

		RegisterPresenter result = new RegisterPresenter(activity);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.RegisterActivity.<init>(RegisterActivity.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the void registerUser(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testRegisterUser_1()
		throws Exception {
		RegisterPresenter fixture = new RegisterPresenter(new RegisterActivity());
		fixture.registerUser("", "", "", "");
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		String inputNickname = "";
		String inputEmail = "";
		String inputPassword = "";
		String inputRepeatPassword = "";

		fixture.registerUser(inputNickname, inputEmail, inputPassword, inputRepeatPassword);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.RegisterActivity.<init>(RegisterActivity.java:16)
	}

	/**
	 * Run the void setListeners(EditText) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testSetListeners_1()
		throws Exception {
		RegisterPresenter fixture = new RegisterPresenter(new RegisterActivity());
		fixture.registerUser("", "", "", "");
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		EditText repeatPassword = new EditText(new CaptureVideoActivity());

		fixture.setListeners(repeatPassword);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.RegisterActivity.<init>(RegisterActivity.java:16)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
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
	 * @generatedBy CodePro at 2013-05-29 09:37
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
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RegisterPresenterTest.class);
	}
}