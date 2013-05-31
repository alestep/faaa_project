package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.views.AccountActivity;

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
	 * @throws Exception
	 *
	 */
	public void testUpdatePlayerInformation_1()
		throws Exception {
		String newUsername = "test";
		int globalRanking = 1;
		int globalScore = 1;
		int numberOfFinishedGames = 1;
		int numberOfWonGames = 1;
		int numberOfLostGames = 1;
		int numberOfDrawGames = 1;
		TextView ranking = (TextView) activity.findViewById(R.id.globalRanking);
		activity.updatePlayerInformation(newUsername, globalRanking, globalScore,
				numberOfFinishedGames, numberOfWonGames, numberOfLostGames, numberOfDrawGames);
		assertEquals(String.valueOf(globalRanking), ranking.toString());
		
	}
	

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
