package com.example.wecharades.presenter;

import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.DataController;
import com.example.wecharades.views.AccountActivity;
import android.content.Context;
import android.widget.EditText;
import com.example.wecharades.views.CaptureVideoActivity;
import com.example.wecharades.views.GenericActivity;
import com.example.wecharades.views.SearchPlayerActivity;

/**
 * The class <code>SearchPlayerPresenterTest</code> contains tests for the class <code>{@link SearchPlayerPresenter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:37
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class SearchPlayerPresenterTest {
	/**
	 * Run the SearchPlayerPresenter(SearchPlayerActivity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testSearchPlayerPresenter_1()
		throws Exception {
		SearchPlayerActivity activity = new SearchPlayerActivity();

		SearchPlayerPresenter result = new SearchPlayerPresenter(activity);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.SearchPlayerActivity.<init>(SearchPlayerActivity.java:18)
		assertNotNull(result);
	}

	/**
	 * Run the void invite(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testInvite_1()
		throws Exception {
		SearchPlayerPresenter fixture = new SearchPlayerPresenter(new SearchPlayerActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		String invitee = "";

		fixture.invite(invitee);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.SearchPlayerActivity.<init>(SearchPlayerActivity.java:18)
	}

	/**
	 * Run the void invite(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testInvite_2()
		throws Exception {
		SearchPlayerPresenter fixture = new SearchPlayerPresenter(new SearchPlayerActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		String invitee = "";

		fixture.invite(invitee);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.SearchPlayerActivity.<init>(SearchPlayerActivity.java:18)
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
		SearchPlayerPresenter fixture = new SearchPlayerPresenter(new SearchPlayerActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		EditText searchBox = new EditText(new CaptureVideoActivity());

		fixture.setListeners(searchBox);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.SearchPlayerActivity.<init>(SearchPlayerActivity.java:18)
	}

	/**
	 * Run the void update(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		SearchPlayerPresenter fixture = new SearchPlayerPresenter(new SearchPlayerActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		String s = "";

		fixture.update(s);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.SearchPlayerActivity.<init>(SearchPlayerActivity.java:18)
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
		new org.junit.runner.JUnitCore().run(SearchPlayerPresenterTest.class);
	}
}