package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.views.HighScoreActivity;

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
	 * @throws Exception
	 *
	 */
	public void testUpdateGlobalRanking_1()
		throws Exception {
		int globalRanking = 1;
		int numberOfPlayers = 999;		
		
		//initialize
		activity.updateGlobalRanking(0,0);		
		TextView theView = (TextView) activity.findViewById(R.id.globalRanking);
		//first check
		assertEquals(String.valueOf(0), theView.getText().toString());
		
		activity.updateGlobalRanking(globalRanking, numberOfPlayers);
		assertEquals(String.valueOf(globalRanking), theView.toString());
		
	}
	

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
