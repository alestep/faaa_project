package com.example.wecharades.model.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.TreeMap;
import java.util.TreeSet;
import android.content.Context;
import android.test.AndroidTestCase;


import com.example.wecharades.TestConstants;
import com.example.wecharades.model.DBMessage;
import com.example.wecharades.model.DataController;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.CaptureVideoActivity;

/**
 * The class <code>DataControllerTest</code> contains tests for the class <code>{@link DataController}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 19:20
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class tempDataControllerTest extends AndroidTestCase {
	/**
	 * Run the void acceptInvitation(Invitation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	DataController dc;
	
	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void setUp()
		throws Exception {
		DataController dc = DataController.getDataController(getContext());
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}
	
	public void testAcceptInvitation_1()
		throws Exception {
		Invitation inv = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer);
		dc.acceptInvitation(inv);
		ArrayList<Game> gameList = dc.getGames();
//		//Check if a game is created between the two players.
//		boolean result = false;
//		for(Game g : dc.getGames()){ //Check if the invitation is in current (not finished) games
//			//If the game isn't finished AND that the combination of inviter/invitee doesn't exist in any games. 
//			if(		!g.isFinished() &&
//					(inv.getInviter().equals(g.getPlayer1()) 
//							&& inv.getInvitee().equals(g.getPlayer2()))
//							||
//							(inv.getInvitee().equals(g.getPlayer1())
//									&& inv.getInviter().equals(g.getPlayer2()))
//					){
//				result = true;
//			}
//		}
//		assertTrue(result);
	}

	/**
	 * Run the void createGame(Player,Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * Run the Player getCurrentPlayer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
	public void testGetCurrentPlayer_2()
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
	 * Run the Player getCurrentPlayer() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
	public void testGetCurrentPlayer_3()
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
	public void testGetGameScore_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Game game = null;

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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * Run the TreeMap<Player, Integer> getGameScore(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
	public void testGetGameScore_4()
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * Run the ArrayList<Turn> getTurns(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	 
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdate_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, new ArrayList<Invitation>());

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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdate_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, new Object());

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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdate_3()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, new TreeMap());

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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdate_4()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, "");

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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdate_5()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Observable db = new Observable();
		DBMessage obj = new DBMessage(1, new DatabaseException(1, ""));

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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
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
	 * Run the void updateGame(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdateGame_1()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 0, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateGame(turn);

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
	 * Run the void updateGame(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdateGame_2()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateGame(turn);

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
	 * Run the void updateGame(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdateGame_3()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 2, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateGame(turn);

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
	 * Run the void updateGame(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdateGame_4()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 0, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateGame(turn);

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
	 * Run the void updateGame(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdateGame_5()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateGame(turn);

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
	 * Run the void updateGame(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 19:20
	 */
	public void testUpdateGame_6()
		throws Exception {
		DataController fixture = DataController.getDataController(new CaptureVideoActivity());
		Turn turn = new Turn("", 1, 2, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.updateGame(turn);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: Stub!
		//       at android.content.Context.<init>(Context.java:4)
		//       at android.content.ContextWrapper.<init>(ContextWrapper.java:5)
		//       at android.view.ContextThemeWrapper.<init>(ContextThemeWrapper.java:5)
		//       at android.app.Activity.<init>(Activity.java:6)
		//       at com.example.wecharades.views.CaptureVideoActivity.<init>(CaptureVideoActivity.java:19)
	}
	
}