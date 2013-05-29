package com.example.wecharades.presenter;

import org.junit.*;
import android.widget.VideoView;
import static org.junit.Assert.*;
import com.example.wecharades.model.DataController;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Player;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.AccountActivity;
import com.example.wecharades.views.CaptureVideoActivity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.EditText;
import com.example.wecharades.views.GenericActivity;
import com.example.wecharades.views.GuessCharadeActivity;

/**
 * The class <code>GuessCharadePresenterTest</code> contains tests for the class <code>{@link GuessCharadePresenter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:37
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class GuessCharadePresenterTest {
	/**
	 * Run the GuessCharadePresenter(GuessCharadeActivity,Turn) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGuessCharadePresenter_1()
		throws Exception {
		GuessCharadeActivity activity = new GuessCharadeActivity();
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		GuessCharadePresenter result = new GuessCharadePresenter(activity, turn);

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
	 * Run the boolean checkRightWord(EditText) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testCheckRightWord_1()
		throws Exception {
		GuessCharadePresenter fixture = new GuessCharadePresenter(new GuessCharadeActivity(), new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1));
		fixture.downloadVideo(new CaptureVideoActivity(), new VideoView(new CaptureVideoActivity()));
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.downloadState = 1;
		fixture.currentWord = "";
		fixture.timer = null;
		EditText answerWord = new EditText(new CaptureVideoActivity());

		boolean result = fixture.checkRightWord(answerWord);

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
	 * Run the boolean checkRightWord(EditText) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testCheckRightWord_2()
		throws Exception {
		GuessCharadePresenter fixture = new GuessCharadePresenter(new GuessCharadeActivity(), new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1));
		fixture.downloadVideo(new CaptureVideoActivity(), new VideoView(new CaptureVideoActivity()));
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.downloadState = 1;
		fixture.currentWord = "";
		fixture.timer = null;
		EditText answerWord = new EditText(new CaptureVideoActivity());

		boolean result = fixture.checkRightWord(answerWord);

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
	 * Run the void downloadVideo(Context,VideoView) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testDownloadVideo_1()
		throws Exception {
		GuessCharadePresenter fixture = new GuessCharadePresenter(new GuessCharadeActivity(), new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1));
		fixture.downloadVideo(new CaptureVideoActivity(), new VideoView(new CaptureVideoActivity()));
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.downloadState = 1;
		fixture.currentWord = "";
		fixture.timer = null;
		Context context = new CaptureVideoActivity();
		VideoView videoView = new VideoView(new CaptureVideoActivity());

		fixture.downloadVideo(context, videoView);

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
	 * Run the Game getGame() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetGame_1()
		throws Exception {
		GuessCharadePresenter fixture = new GuessCharadePresenter(new GuessCharadeActivity(), new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1));
		fixture.downloadVideo(new CaptureVideoActivity(), new VideoView(new CaptureVideoActivity()));
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.downloadState = 1;
		fixture.currentWord = "";
		fixture.timer = null;

		Game result = fixture.getGame();

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
	 * Run the void initialize() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testInitialize_1()
		throws Exception {
		GuessCharadePresenter fixture = new GuessCharadePresenter(new GuessCharadeActivity(), new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1));
		fixture.downloadVideo(new CaptureVideoActivity(), new VideoView(new CaptureVideoActivity()));
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.downloadState = 1;
		fixture.currentWord = "";
		fixture.timer = null;

		fixture.initialize();

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
	 * Run the void initializeTimer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testInitializeTimer_1()
		throws Exception {
		GuessCharadePresenter fixture = new GuessCharadePresenter(new GuessCharadeActivity(), new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1));
		fixture.downloadVideo(new CaptureVideoActivity(), new VideoView(new CaptureVideoActivity()));
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.downloadState = 1;
		fixture.currentWord = "";
		fixture.timer = null;

		fixture.initializeTimer();

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
	 * Run the void playVideo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testPlayVideo_1()
		throws Exception {
		GuessCharadePresenter fixture = new GuessCharadePresenter(new GuessCharadeActivity(), new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1));
		fixture.downloadVideo(new CaptureVideoActivity(), new VideoView(new CaptureVideoActivity()));
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.downloadState = 1;
		fixture.currentWord = "";
		fixture.timer = null;

		fixture.playVideo();

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
	 * Run the void updateModel() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testUpdateModel_1()
		throws Exception {
		GuessCharadePresenter fixture = new GuessCharadePresenter(new GuessCharadeActivity(), new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1));
		fixture.downloadVideo(new CaptureVideoActivity(), new VideoView(new CaptureVideoActivity()));
		fixture.activity = new AccountActivity();
		fixture.dc = DataController.getDataController(new CaptureVideoActivity());
		fixture.downloadState = 1;
		fixture.currentWord = "";
		fixture.timer = null;

		fixture.updateModel();

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
		new org.junit.runner.JUnitCore().run(GuessCharadePresenterTest.class);
	}
}