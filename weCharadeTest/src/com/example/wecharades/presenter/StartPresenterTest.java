package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Observable;
import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.DCMessage;
import com.example.wecharades.model.DataController;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.views.AccountActivity;
import com.example.wecharades.views.CaptureVideoActivity;
import android.content.Context;
import com.example.wecharades.views.GenericActivity;
import com.example.wecharades.views.StartActivity;

/**
 * The class <code>StartPresenterTest</code> contains tests for the class <code>{@link StartPresenter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:37
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class StartPresenterTest {
	/**
	 * Run the StartPresenter(StartActivity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testStartPresenter_1()
		throws Exception {
		StartActivity activity = new StartActivity();

		StartPresenter result = new StartPresenter(activity);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
		assertNotNull(result);
	}

	/**
	 * Run the boolean checkLogin() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testCheckLogin_1()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		boolean result = fixture.checkLogin();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
		assertTrue(result);
	}

	/**
	 * Run the boolean checkLogin() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testCheckLogin_2()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		boolean result = fixture.checkLogin();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
		assertTrue(result);
	}

	/**
	 * Run the void createListView(LinkedHashMap<String,ArrayList<Game>>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testCreateListView_1()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		LinkedHashMap<String, ArrayList<Game>> listMap = new LinkedHashMap();

		fixture.createListView(listMap);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void createListView(LinkedHashMap<String,ArrayList<Game>>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testCreateListView_2()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		LinkedHashMap<String, ArrayList<Game>> listMap = new LinkedHashMap();

		fixture.createListView(listMap);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void createListView(LinkedHashMap<String,ArrayList<Game>>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testCreateListView_3()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		LinkedHashMap<String, ArrayList<Game>> listMap = new LinkedHashMap();

		fixture.createListView(listMap);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void createNotificationInstallation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testCreateNotificationInstallation_1()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		fixture.createNotificationInstallation();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void createNotificationInstallation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testCreateNotificationInstallation_2()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		fixture.createNotificationInstallation();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void initiate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testInitiate_1()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		fixture.initiate();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void initiate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testInitiate_2()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		fixture.initiate();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void logOut() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testLogOut_1()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		fixture.logOut();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void setNotUpdating() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testSetNotUpdating_1()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		fixture.setNotUpdating();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void update() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		fixture.update();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void update() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_2()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();

		fixture.update();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_3()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		Observable obs = new Observable();
		Object obj = new DCMessage(1, new Object());

		fixture.update(obs, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_4()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		Observable obs = new Observable();
		Object obj = new DCMessage(1, new ArrayList<Invitation>());

		fixture.update(obs, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_5()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		Observable obs = new Observable();
		Object obj = new DCMessage(1, new ArrayList());

		fixture.update(obs, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_6()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		Observable obs = new Observable();
		Object obj = new DCMessage(1, new Object());

		fixture.update(obs, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_7()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		Observable obs = new Observable();
		Object obj = new DCMessage(1, new ArrayList<Invitation>());

		fixture.update(obs, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_8()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		Observable obs = new Observable();
		Object obj = new DCMessage(1, new ArrayList());

		fixture.update(obs, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdate_9()
		throws Exception {
		StartPresenter fixture = new StartPresenter(new StartActivity());
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.activity = new AccountActivity();
		Observable obs = new Observable();
		Object obj = new Object();

		fixture.update(obs, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.StartActivity.<init>(StartActivity.java:31)
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
		new org.junit.runner.JUnitCore().run(StartPresenterTest.class);
	}
}