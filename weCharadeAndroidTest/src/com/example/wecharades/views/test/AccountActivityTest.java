package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.views.AccountActivity;

/**
 * This class tests relevant methods in the <code>AccountActivity</code> class.
 * It does not test methods related to the application's life cycle events,
 * such as onCreate(), onStart() and so on.
 * It does not test methods in the form of onClickX();
 * @author weCharade
 */
public class AccountActivityTest extends ActivityInstrumentationTestCase2<AccountActivity> {

	public AccountActivityTest() {
		super(AccountActivity.class);
	}

	private AccountActivity activity;

	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
	}
	
	/**
	 * Run the void updatePlayerInformation(String,int,int,int,int,int,int) method test.
	 * @throws Throwable
	 *
	 */
	public void testUpdatePlayerInformation_1()
		throws Throwable {
		final String newUsername = "test";
		final int globalRanking = 1;
		final int globalScore = 1;
		final int numberOfFinishedGames = 1;
		final int numberOfWonGames = 1;
		final int numberOfLostGames = 1;
		final int numberOfDrawGames = 1;
		final TextView ranking = (TextView) activity.findViewById(R.id.globalRanking);
		final TextView username = (TextView) activity.findViewById(R.id.username);
		final TextView playedGames = (TextView) activity.findViewById(R.id.playedGames);
		final TextView wonGames = (TextView) activity.findViewById(R.id.wonGames);
		final TextView lostGames = (TextView) activity.findViewById(R.id.lostGames);
		final TextView drawGames = (TextView) activity.findViewById(R.id.drawGames);
		
		runTestOnUiThread(new Runnable() {
			@Override
			public void run() {
				activity.updatePlayerInformation(newUsername, globalRanking, globalScore,
						numberOfFinishedGames, numberOfWonGames, numberOfLostGames, numberOfDrawGames);
				assertEquals(Integer.toString(globalRanking) + " (" + globalScore +" points)", ranking.getText().toString());
				assertEquals(newUsername,username.getText().toString());
				assertEquals(String.valueOf(numberOfFinishedGames), playedGames.getText().toString());
				assertEquals(String.valueOf(numberOfWonGames), wonGames.getText().toString());
				assertEquals(String.valueOf(numberOfLostGames), lostGames.getText().toString());
				assertEquals(String.valueOf(numberOfDrawGames), drawGames.getText().toString());
			}
		});	
	}
	

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
