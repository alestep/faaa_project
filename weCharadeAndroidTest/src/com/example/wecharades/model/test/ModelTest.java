package com.example.wecharades.model.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import android.test.AndroidTestCase;

import com.example.wecharades.TestConstants;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Model;
import com.example.wecharades.model.Turn;
/**
 * Testing the Model class.
 * This class doesn't test getters and setters if they only return primitive data types or strings.
 * It doesn't test very simple methods since is doesn't enhances the quality of the testing.
 * It doesn't test methods which are directly or indirectly tested in other test classes.
 * @author felixkarlsson
 */
public class ModelTest extends AndroidTestCase {
	private Model m;
	protected void setUp() throws Exception {
		super.setUp();
		//Initiate the model
		m = Model.getModelInstance(getContext());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Run the void putGameList(ArrayList<Game>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testPutGameList_1()
			throws Exception {
		//update model
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(TestConstants.g1);
		games.add(TestConstants.g2);
		m.putGameList(games);

		assertTrue(m.getGames().contains(TestConstants.g1) && m.getGames().contains(TestConstants.g2));

		//remove from model
		m.removeGame(TestConstants.g1);
		m.removeGame(TestConstants.g2);
	}


	/**
	 * Run the void putGame(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testPutGame_1()
			throws Exception {
		m.putGame(TestConstants.g1);
		assertTrue(m.getGame(TestConstants.GAME_ID1).equals(TestConstants.g1));
		m.removeGame(TestConstants.g1);
	}

	/**
	 * Run the ArrayList<Game> getGames() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testGetGames_1()
			throws Exception {		//update model
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(TestConstants.g1);
		games.add(TestConstants.g2);
		m.putGameList(games);
		assertTrue(m.getGames().contains(TestConstants.g1) && m.getGames().contains(TestConstants.g2));

		//remove from model
		m.removeGame(TestConstants.g1);
		m.removeGame(TestConstants.g2);
	}

	/**
	 * Run the Game getGame(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testGetGame_1()
			throws Exception {
		m.putGame(TestConstants.g1);
		assertTrue(m.getGame(TestConstants.GAME_ID1).equals(TestConstants.g1));
		m.removeGame(TestConstants.g1);
	}

	/**
	 * Run the Game getGame(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testGetGame_2()
			throws Exception {
		assertNull(m.getGame("THIS_ID_DOESNT_EXIST"));
	}

	/**
	 * Run the void removeGame(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testRemoveGame_1()
			throws Exception {
		m.putGame(TestConstants.g1);
		assertNotNull(m.getGame(TestConstants.GAME_ID1));
		m.removeGame(TestConstants.g1);
		assertNull(m.getGame(TestConstants.GAME_ID1));
	}

	/**
	 * Run the void putTurns(ArrayList<Turn>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testPutTurns_1()
			throws Exception {

		assertNull(m.getTurns(TestConstants.g1));
		//Update
		ArrayList<Turn> turns = new ArrayList<Turn>();
		turns.add(TestConstants.t1);
		turns.add(TestConstants.t2);
		turns.add(TestConstants.t3);
		turns.add(TestConstants.t4);
		turns.add(TestConstants.t5);
		turns.add(TestConstants.t6);

		m.putGame(TestConstants.g1);
		m.putTurns(turns);
		for(int i = 0; i < turns.size(); i++) {
			assertTrue(turns.remove(0).equals(m.getTurns(TestConstants.g1).remove(0)));
		}
		m.removeGame(TestConstants.g1);
	}


	/**
	 * Run the void putTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testPutTurn_1()
			throws Exception {
		assertNull(m.getGame(TestConstants.GAME_ID1));			// Checking that game isn't in model
		m.putGame(TestConstants.g1);								// Adding to model
		m.putTurn(TestConstants.t1);								// Updating the turn to the corresponding game g1
		assertTrue(m.getTurns(TestConstants.g1).contains(TestConstants.t1));	// Check that it contains the recently put turn
		m.removeGame(TestConstants.g1);							// Remove from the model
	}


	/**
	 * Run the void putTurn(Turn) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testPutTurn_2()
			throws Exception {
		String invalidID = "not valid";
		Turn t = new Turn(invalidID ,1,1,"","",TestConstants.recPlayer,0, TestConstants.ansPlayer, 0);
		assertNull(m.getGame(invalidID));	// Checking that game isn't in model
		try {
			m.putTurn(TestConstants.t1);
			assertTrue(false); //should never run
		} catch (NoSuchElementException e) {
			assertTrue(true); //returns true
		}
	}

	/**
	 * Run the ArrayList<Turn> getTurns(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testGetTurns_1()
			throws Exception {
		assertNull(m.getTurns(TestConstants.g1));
		//Update
		ArrayList<Turn> turns = new ArrayList<Turn>();
		turns.add(TestConstants.t1);
		turns.add(TestConstants.t2);
		turns.add(TestConstants.t3);
		turns.add(TestConstants.t4);
		turns.add(TestConstants.t5);
		turns.add(TestConstants.t6);

		m.putGame(TestConstants.g1);
		m.putTurns(turns);
		for(int i = 0; i < turns.size(); i++) {
			assertTrue(turns.remove(0).equals(m.getTurns(TestConstants.g1).remove(0)));
		}
		m.removeGame(TestConstants.g1);
	}

	/**
	 * Run the Turn getCurrentTurn(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testGetCurrentTurn_1()
			throws Exception {
		assertNull(m.getTurns(TestConstants.g1));
		//Update
		ArrayList<Turn> turns = new ArrayList<Turn>();
		turns.add(TestConstants.t1);
		turns.add(TestConstants.t2);
		turns.add(TestConstants.t3);
		turns.add(TestConstants.t4);
		turns.add(TestConstants.t5);
		turns.add(TestConstants.t6);

		m.putGame(TestConstants.g1);
		m.putTurns(turns);
		//The current turn should be t1
		assertTrue(m.getCurrentTurn(TestConstants.g1).equals(TestConstants.t1) );
		m.removeGame(TestConstants.g1);
	}

	/**
	 * Run the Turn getCurrentTurn(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testGetCurrentTurn_2()
			throws Exception {
		//not added to the model
		assertNull(m.getCurrentTurn(TestConstants.g1));
	}

	/**
	 * Run the Turn getCurrentTurn(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testGetCurrentTurn_3()
			throws Exception {
		assertNull(m.getCurrentTurn(null));
	}

	/**
	 * Run the void putPlayer(Player) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testPutPlayer_1()
			throws Exception {
		//Cannot be tested since the model is built to never remove players...
	}

	/**
	 * Run the void putPlayers(Collection<Player>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testPutPlayers_1()
			throws Exception {
		//Cannot be tested since the model is built to never remove players...

	}


	/**
	 * Run the void setSentInvitations(LinkedList<Invitation>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2013-05-29 21:20
	 */
	public void testSetSentInvitations_1()
			throws Exception {
		LinkedList<Invitation> iList = new LinkedList<Invitation>();
		Invitation invitation = new Invitation(TestConstants.recPlayer, TestConstants.ansPlayer);
		iList.add(invitation);
		m.setSentInvitations(iList);
		assertTrue(m.getSentInvitations().equals(iList));
	}
}
