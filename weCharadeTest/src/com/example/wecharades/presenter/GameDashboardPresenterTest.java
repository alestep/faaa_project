package com.example.wecharades.presenter;

import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.DataController;
import com.example.wecharades.views.AccountActivity;
import android.content.Context;
import android.widget.TableLayout;
import com.example.wecharades.views.CaptureVideoActivity;
import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.GenericActivity;

/**
 * The class <code>GameDashboardPresenterTest</code> contains tests for the class <code>{@link GameDashboardPresenter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:36
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class GameDashboardPresenterTest {
	/**
	 * Run the GameDashboardPresenter(GameDashboardActivity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testGameDashboardPresenter_1()
		throws Exception {
		GameDashboardActivity activity = new GameDashboardActivity();

		GameDashboardPresenter result = new GameDashboardPresenter(activity);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GameDashboardActivity.<init>(GameDashboardActivity.java:15)
		assertNotNull(result);
	}

	/**
	 * Run the void createDashboard(TableLayout) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testCreateDashboard_1()
		throws Exception {
		GameDashboardPresenter fixture = new GameDashboardPresenter(new GameDashboardActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		TableLayout table = new TableLayout(new CaptureVideoActivity());

		fixture.createDashboard(table);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.GameDashboardActivity.<init>(GameDashboardActivity.java:15)
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
		new org.junit.runner.JUnitCore().run(GameDashboardPresenterTest.class);
	}
}