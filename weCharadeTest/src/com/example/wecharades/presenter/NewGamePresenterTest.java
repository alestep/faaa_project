package com.example.wecharades.presenter;

import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.DataController;
import com.example.wecharades.views.AccountActivity;
import com.example.wecharades.views.CaptureVideoActivity;
import com.example.wecharades.views.GenericActivity;
import com.example.wecharades.views.NewGameActivity;
import android.content.Context;

/**
 * The class <code>NewGamePresenterTest</code> contains tests for the class <code>{@link NewGamePresenter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:37
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class NewGamePresenterTest {
	/**
	 * Run the NewGamePresenter(NewGameActivity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testNewGamePresenter_1()
		throws Exception {
		NewGameActivity activity = new NewGameActivity();

		NewGamePresenter result = new NewGamePresenter(activity);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.NewGameActivity.<init>(NewGameActivity.java:12)
		assertNotNull(result);
	}

	/**
	 * Run the void randomInvitation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testRandomInvitation_1()
		throws Exception {
		NewGamePresenter fixture = new NewGamePresenter(new NewGameActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());

		fixture.randomInvitation();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.NewGameActivity.<init>(NewGameActivity.java:12)
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
		new org.junit.runner.JUnitCore().run(NewGamePresenterTest.class);
	}
}