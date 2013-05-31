package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.views.HighScoreActivity;

/**
 * This class tests relevant methods in the <code>StartActivity</code> class.
 * It does not test methods related to the application's life cycle events,
 * such as onCreate(), onStart() and so on.
 * It does not test methods in the form of onClickX();
 * @author weCharade
 */
public class HighScoreActivityTest extends ActivityInstrumentationTestCase2<HighScoreActivity> {

	public HighScoreActivityTest() {
		super(HighScoreActivity.class);
	}

	private HighScoreActivity activity;

	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
	}

	/**
	 * Run the void updatePlayerInformation(String,int,int,int,int,int,int) method test.
	 * @throws Throwable
	 *
	 */
	public void testUpdateGlobalRanking_1() throws Throwable {
		final int globalRanking		= 1;
		final int numberOfPlayers	= 999;		

		final TextView theView = (TextView) activity.findViewById(R.id.globalRanking);
		runTestOnUiThread(new Runnable() {
			@Override
			public void run() {
				//initialize				
				activity.updateGlobalRanking(0,0);		
				//first check
				assertEquals("Your global ranking position is " + 0 + " out of " + 0,
						theView.getText().toString());
				activity.updateGlobalRanking(globalRanking, numberOfPlayers);
				assertEquals("Your global ranking position is " + globalRanking + " out of " + numberOfPlayers,
						theView.getText().toString());
			}
		});
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
