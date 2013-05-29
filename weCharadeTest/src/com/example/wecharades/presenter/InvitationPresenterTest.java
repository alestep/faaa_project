package com.example.wecharades.presenter;

import java.util.Observable;
import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.DCMessage;
import com.example.wecharades.model.DataController;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.AccountActivity;
import com.example.wecharades.views.CaptureVideoActivity;
import android.content.Context;
import com.example.wecharades.views.GenericActivity;
import com.example.wecharades.views.InvitationActivity;

/**
 * The class <code>InvitationPresenterTest</code> contains tests for the class <code>{@link InvitationPresenter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:36
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class InvitationPresenterTest {
	/**
	 * Run the InvitationPresenter(InvitationActivity) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testInvitationPresenter_1()
		throws Exception {
		InvitationActivity activity = new InvitationActivity();

		InvitationPresenter result = new InvitationPresenter(activity);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
		assertNotNull(result);
	}

	/**
	 * Run the void initialize() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testInitialize_1()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());

		fixture.initialize();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
	}

	/**
	 * Run the void setInvitation(Invitation,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testSetInvitation_1()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		Invitation invitation = new Invitation(new Player("", ""), new Player("", ""));
		boolean response = false;

		fixture.setInvitation(invitation, response);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
	}

	/**
	 * Run the void setInvitation(Invitation,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testSetInvitation_2()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		Invitation invitation = new Invitation(new Player("", ""), new Player("", ""));
		boolean response = true;

		fixture.setInvitation(invitation, response);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
	}

	/**
	 * Run the void setInvitation(Invitation,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testSetInvitation_3()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		Invitation invitation = new Invitation(new Player("", ""), new Player("", ""));
		boolean response = true;

		fixture.setInvitation(invitation, response);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
	}

	/**
	 * Run the void setInvitation(Invitation,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testSetInvitation_4()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		Invitation invitation = new Invitation(new Player("", ""), new Player("", ""));
		boolean response = false;

		fixture.setInvitation(invitation, response);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
	}

	/**
	 * Run the void update() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());

		fixture.update();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testUpdate_2()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
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
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testUpdate_3()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
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
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testUpdate_4()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		Observable obs = new Observable();
		Object obj = null;

		fixture.update(obs, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.GenericActivity.<init>(GenericActivity.java:24)
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:36
	 */
	@Test
	public void testUpdate_5()
		throws Exception {
		InvitationPresenter fixture = new InvitationPresenter(new InvitationActivity());
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
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
		//       at com.example.wecharades.views.InvitationActivity.<init>(InvitationActivity.java:14)
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
		new org.junit.runner.JUnitCore().run(InvitationPresenterTest.class);
	}
}