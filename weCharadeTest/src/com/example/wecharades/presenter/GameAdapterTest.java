package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.accounts.AccountAuthenticatorActivity;
import android.view.View;
import android.widget.AbsoluteLayout;
import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.CaptureVideoActivity;
import com.example.wecharades.views.StartActivity;
import android.view.ViewGroup;
import android.content.Context;

/**
 * The class <code>GameAdapterTest</code> contains tests for the class <code>{@link GameAdapter}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:37
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class GameAdapterTest {
	/**
	 * Run the GameAdapter(StartActivity,ArrayList<Game>,Player,Map<Game,Map<Player,Integer>>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGameAdapter_1()
		throws Exception {
		StartActivity activity = new StartActivity();
		ArrayList<Game> games = new ArrayList();
		Player currentPlayer = new Player("", "");
		Map<Game, Map<Player, Integer>> score = new HashMap<Game, Map<Player, Integer>>();

		GameAdapter result = new GameAdapter(activity, games, currentPlayer, score);

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
	 * Run the View getView(int,View,ViewGroup) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetView_1()
		throws Exception {
		GameAdapter fixture = new GameAdapter(new StartActivity(), new ArrayList(), new Player("", ""), new HashMap<Game, Map<Player, Integer>>());
		int position = 1;
		View convertView = new View(new CaptureVideoActivity());
		ViewGroup parent = new AbsoluteLayout(new AccountAuthenticatorActivity());

		View result = fixture.getView(position, convertView, parent);

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
	 * Run the View getView(int,View,ViewGroup) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetView_2()
		throws Exception {
		GameAdapter fixture = new GameAdapter(new StartActivity(), new ArrayList(), new Player("", ""), new HashMap<Game, Map<Player, Integer>>());
		int position = 1;
		View convertView = new View(new CaptureVideoActivity());
		ViewGroup parent = new AbsoluteLayout(new AccountAuthenticatorActivity());

		View result = fixture.getView(position, convertView, parent);

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
	 * Run the View getView(int,View,ViewGroup) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:37
	 */
	@Test
	public void testGetView_3()
		throws Exception {
		GameAdapter fixture = new GameAdapter(new StartActivity(), new ArrayList(), new Player("", ""), new HashMap<Game, Map<Player, Integer>>());
		int position = 1;
		View convertView = new View(new CaptureVideoActivity());
		ViewGroup parent = new AbsoluteLayout(new AccountAuthenticatorActivity());

		View result = fixture.getView(position, convertView, parent);

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
		new org.junit.runner.JUnitCore().run(GameAdapterTest.class);
	}
}