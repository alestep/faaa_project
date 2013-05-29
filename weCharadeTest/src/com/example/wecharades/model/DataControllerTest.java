package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.TreeMap;
import java.util.TreeSet;
import android.content.Context;
import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.views.CaptureVideoActivity;

/**
 * The class <code>DataControllerTest</code> contains tests for the class <code>{@link DataController}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class DataControllerTest {
	/**
	 * Run the void acceptInvitation(Invitation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testAcceptInvitation_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Invitation invitation = new Invitation(new Player("", ""), new Player("", ""));

		fixture.acceptInvitation(invitation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void createGame(Player,Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testCreateGame_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Player p1 = new Player("", "");
		Player p2 = new Player("", "");

		fixture.createGame(p1, p2);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the TreeSet<String> getAllOtherPlayerNames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAllOtherPlayerNames_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		TreeSet<String> result = fixture.getAllOtherPlayerNames();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the TreeSet<String> getAllOtherPlayerNames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAllOtherPlayerNames_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		TreeSet<String> result = fixture.getAllOtherPlayerNames();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the TreeSet<String> getAllPlayerNames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAllPlayerNames_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		TreeSet<String> result = fixture.getAllPlayerNames();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the TreeSet<String> getAllPlayerNames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAllPlayerNames_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		TreeSet<String> result = fixture.getAllPlayerNames();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the TreeSet<String> getAllPlayerNames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAllPlayerNames_3()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		TreeSet<String> result = fixture.getAllPlayerNames();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<Player> getAllPlayerObjects() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAllPlayerObjects_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		ArrayList<Player> result = fixture.getAllPlayerObjects();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<Player> getAllPlayerObjects() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetAllPlayerObjects_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		ArrayList<Player> result = fixture.getAllPlayerObjects();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Player getCurrentPlayer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetCurrentPlayer_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		Player result = fixture.getCurrentPlayer();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the DataController getDataController(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetDataController_1()
		throws Exception {
		Context context = new CaptureVideoActivity();

		DataController result = DataController.getDataController(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the DataController getDataController(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetDataController_2()
		throws Exception {
		Context context = new CaptureVideoActivity();

		DataController result = DataController.getDataController(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the DataController getDataController(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetDataController_3()
		throws Exception {
		Context context = new CaptureVideoActivity();

		DataController result = DataController.getDataController(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Game getGame(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetGame_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		String gameId = "";

		Game result = fixture.getGame(gameId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the TreeMap<Player, Integer> getGameScore(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetGameScore_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		TreeMap<Player, Integer> result = fixture.getGameScore(game);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the TreeMap<Player, Integer> getGameScore(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetGameScore_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		TreeMap<Player, Integer> result = fixture.getGameScore(game);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the TreeMap<Player, Integer> getGameScore(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetGameScore_3()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		TreeMap<Player, Integer> result = fixture.getGameScore(game);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<Game> getGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetGames_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		ArrayList<Game> result = fixture.getGames();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the void getInvitations() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetInvitations_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		fixture.getInvitations();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the Player getPlayer(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayer_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		String username = "";

		Player result = fixture.getPlayer(username);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Player getPlayer(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayer_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		String username = "";

		Player result = fixture.getPlayer(username);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Player getPlayerById(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayerById_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		String parseId = "";

		Player result = fixture.getPlayerById(parseId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Player getPlayerById(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetPlayerById_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		String parseId = "";

		Player result = fixture.getPlayerById(parseId);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the List<Invitation> getReceivedInvitations() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetReceivedInvitations_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		List<Invitation> result = fixture.getReceivedInvitations();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the List<Invitation> getSentInvitations() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetSentInvitations_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		List<Invitation> result = fixture.getSentInvitations();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the TreeSet<String> getSentInvitationsAsUsernames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetSentInvitationsAsUsernames_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		TreeSet<String> result = fixture.getSentInvitationsAsUsernames();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the TreeSet<String> getSentInvitationsAsUsernames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetSentInvitationsAsUsernames_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		TreeSet<String> result = fixture.getSentInvitationsAsUsernames();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<Player> getTopTenPlayers() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetTopTenPlayers_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		ArrayList<Player> result = fixture.getTopTenPlayers();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<Player> getTopTenPlayers() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetTopTenPlayers_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		ArrayList<Player> result = fixture.getTopTenPlayers();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the ArrayList<Turn> getTurns(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetTurns_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		ArrayList<Turn> result = fixture.getTurns(game);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the void logOutPlayer(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testLogOutPlayer_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Context context = new CaptureVideoActivity();

		fixture.logOutPlayer(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void loginPlayer(Context,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testLoginPlayer_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Context context = new CaptureVideoActivity();
		String username = "";
		String password = "";

		fixture.loginPlayer(context, username, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void loginPlayer(Context,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testLoginPlayer_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Context context = new CaptureVideoActivity();
		String username = "";
		String password = "";

		fixture.loginPlayer(context, username, password);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void putInRandomQueue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutInRandomQueue_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());

		fixture.putInRandomQueue();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void registerPlayer(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testRegisterPlayer_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		String inputNickname = "";
		String inputEmail = "";
		String inputPassword = "";
		String inputRepeatPassword = "";

		fixture.registerPlayer(inputNickname, inputEmail, inputPassword, inputRepeatPassword);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void registerPlayer(String,String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testRegisterPlayer_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		String inputNickname = "";
		String inputEmail = "";
		String inputPassword = "";
		String inputRepeatPassword = "";

		fixture.registerPlayer(inputNickname, inputEmail, inputPassword, inputRepeatPassword);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void rejectInvitation(Invitation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testRejectInvitation_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Invitation invitaiton = new Invitation(new Player("", ""), new Player("", ""));

		fixture.rejectInvitation(invitaiton);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void resetPassword(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testResetPassword_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		String email = "";

		fixture.resetPassword(email);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void resetPassword(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testResetPassword_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		String email = "";

		fixture.resetPassword(email);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void saveState(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSaveState_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Context context = new CaptureVideoActivity();

		fixture.saveState(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void saveState(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSaveState_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Context context = new CaptureVideoActivity();

		fixture.saveState(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void sendInvitation(Invitation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSendInvitation_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Invitation invitation = new Invitation(new Player("", ""), new Player("", ""));

		fixture.sendInvitation(invitation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void sendInvitation(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSendInvitation_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Player player = new Player("", "");

		fixture.sendInvitation(player);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, new ArrayList<Invitation>());
		obj.message = 40;

		fixture.update(db, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdate_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, new Object());
		obj.message = 1;

		fixture.update(db, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdate_3()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, new TreeMap());
		obj.message = 30;

		fixture.update(db, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdate_4()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, "");
		obj.message = 20;

		fixture.update(db, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdate_5()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, new DatabaseException(1, ""));
		obj.message = 10;

		fixture.update(db, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdate_6()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		Object obj = null;

		fixture.update(db, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdate_7()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		Object obj = new Object();

		fixture.update(db, obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 0, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_3()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 2, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_4()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 0, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_5()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_6()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 2, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_7()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 0, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_8()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_9()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 2, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_10()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 0, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_11()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Run the void updateTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testUpdateTurn_12()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 2, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateTurn(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
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
	 * @generatedBy CodePro at 2013-05-29 09:29
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
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DataControllerTest.class);
	}
}