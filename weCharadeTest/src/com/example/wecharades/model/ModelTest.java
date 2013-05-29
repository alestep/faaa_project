package com.example.wecharades.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.example.wecharades.views.CaptureVideoActivity;
import android.content.Context;

/**
 * The class <code>ModelTest</code> contains tests for the class <code>{@link Model}</code>.
 *
 * @generatedBy CodePro at 2013-05-29 09:29
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
public class ModelTest {
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
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());

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
	 * Run the Turn getCurrentTurn(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetCurrentTurn_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		Turn result = fixture.getCurrentTurn(game);

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
	 * Run the Turn getCurrentTurn(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetCurrentTurn_2()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		Turn result = fixture.getCurrentTurn(game);

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
	 * Run the Turn getCurrentTurn(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetCurrentTurn_3()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		Turn result = fixture.getCurrentTurn(game);

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
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		String parseId = "";

		Game result = fixture.getGame(parseId);

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
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());

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
	 * Run the Model getModelInstance(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetModelInstance_1()
		throws Exception {
		Context context = new CaptureVideoActivity();

		Model result = Model.getModelInstance(context);

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
	 * Run the Model getModelInstance(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetModelInstance_2()
		throws Exception {
		Context context = new CaptureVideoActivity();

		Model result = Model.getModelInstance(context);

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
	 * Run the Model getModelInstance(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetModelInstance_3()
		throws Exception {
		Context context = new CaptureVideoActivity();

		Model result = Model.getModelInstance(context);

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
	public void testGetPlayer_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
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
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
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
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
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
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());

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
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());

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
	 * Run the ArrayList<Turn> getTurns(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testGetTurns_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
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
	 * Run the void logOutCurrentPlayer(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testLogOutCurrentPlayer_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Context context = new CaptureVideoActivity();

		fixture.logOutCurrentPlayer(context);

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
	 * Run the void putGame(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutGame_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		fixture.putGame(game);

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
	 * Run the void putGame(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutGame_2()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		fixture.putGame(game);

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
	 * Run the void putGame(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutGame_3()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		fixture.putGame(game);

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
	 * Run the void putGameList(ArrayList<Game>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutGameList_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		ArrayList<Game> games = new ArrayList();

		fixture.putGameList(games);

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
	 * Run the void putGameList(ArrayList<Game>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutGameList_2()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		ArrayList<Game> games = new ArrayList();

		fixture.putGameList(games);

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
	 * Run the void putPlayer(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutPlayer_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Player player = new Player("", "", 1);

		fixture.putPlayer(player);

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
	 * Run the void putPlayer(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutPlayer_2()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Player player = new Player("", "", 1);

		fixture.putPlayer(player);

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
	 * Run the void putPlayers(Collection<Player>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutPlayers_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Collection<Player> players = new ArrayList<Player>();

		fixture.putPlayers(players);

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
	 * Run the void putPlayers(Collection<Player>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutPlayers_2()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Collection<Player> players = new ArrayList<Player>();

		fixture.putPlayers(players);

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
	 * Run the void putTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutTurn_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.putTurn(turn);

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
	 * Run the void putTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutTurn_2()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.putTurn(turn);

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
	 * Run the void putTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutTurn_3()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.putTurn(turn);

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
	 * Run the void putTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutTurn_4()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Turn turn = new Turn("", 1, 1, "", "", new Player("", ""), 1, new Player("", ""), 1);

		fixture.putTurn(turn);

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
	 * Run the void putTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutTurn_5()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Turn turn = null;

		fixture.putTurn(turn);

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
	 * Run the void putTurns(ArrayList<Turn>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutTurns_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		ArrayList<Turn> turnList = new ArrayList();

		fixture.putTurns(turnList);

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
	 * Run the void putTurns(ArrayList<Turn>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testPutTurns_2()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		ArrayList<Turn> turnList = new ArrayList();

		fixture.putTurns(turnList);

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
	 * Run the void removeGame(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testRemoveGame_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Game game = new Game("", new Player("", ""), new Player("", ""), new Player("", ""), 1, true, new Date());

		fixture.removeGame(game);

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
	 * Run the void saveModel(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSaveModel_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Context context = new CaptureVideoActivity();

		fixture.saveModel(context);

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
	 * Run the void saveModel(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSaveModel_2()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Context context = new CaptureVideoActivity();

		fixture.saveModel(context);

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
	 * Run the void saveModel(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSaveModel_3()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Context context = new CaptureVideoActivity();

		fixture.saveModel(context);

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
	 * Run the void saveModel(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSaveModel_4()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Context context = new CaptureVideoActivity();

		fixture.saveModel(context);

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
	 * Run the void saveModel(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSaveModel_5()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Context context = new CaptureVideoActivity();

		fixture.saveModel(context);

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
	 * Run the void saveModel(Context) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSaveModel_6()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Context context = new CaptureVideoActivity();

		fixture.saveModel(context);

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
	 * Run the void setCurrentPlayer(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetCurrentPlayer_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		Player player = new Player("", "");

		fixture.setCurrentPlayer(player);

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
	 * Run the void setReceivedInvitations(LinkedList<Invitation>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetReceivedInvitations_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		LinkedList<Invitation> invitations = new LinkedList();

		fixture.setReceivedInvitations(invitations);

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
	 * Run the void setSentInvitations(LinkedList<Invitation>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 09:29
	 */
	@Test
	public void testSetSentInvitations_1()
		throws Exception {
		Model fixture = Model.getModelInstance(new CaptureVideoActivity());
		fixture.setSentInvitations(new LinkedList());
		fixture.setCurrentPlayer(new Player("", ""));
		fixture.setReceivedInvitations(new LinkedList());
		LinkedList<Invitation> invitations = new LinkedList();

		fixture.setSentInvitations(invitations);

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
		new org.junit.runner.JUnitCore().run(ModelTest.class);
	}
}