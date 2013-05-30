package com.example.wecharades.views.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;

import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;
/**
 * Test class for testing Test IDs: T08 and T09.
 * Precondition: User must be logged out and have three games: 1 your turn, 1 opponents turn, 1 finished.
 * @author Adam
 *
 */
public class GameOverviewTest extends ActivityInstrumentationTestCase2<StartActivity> {
	/*
	 * THESE VARIABLES MUST BE SET CORRESPONDING TO THE PRECONDTIONS TO GET THE TEST TO WORK!
	 */
	private Solo solo;
	private String USERNAME = "";
	private String USER_PASSWORD="";
	private String OPPONENT_YOUR_TURN ="";
	private String OPPONENT_OPPONENTS_TURN="";
	private String OPPONENT_FINISHED_GAME="";
	
	public GameOverviewTest() {
		super(StartActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	/**
	 * Checks 
	 */
	public void testYourTurnOpponentsTurnAndFinishedGame(){
		solo.assertCurrentActivity("initially startAcivity", StartActivity.class);
		login();
		solo.searchText("The score is");
		solo.clickOnText(OPPONENT_YOUR_TURN);
		solo.waitForActivity(GameDashboardActivity.class);
		boolean result = false;
		if(solo.searchText("Record Video") == true || solo.searchText("Guess charade") == true && !(solo.searchText("Record Video") == true && solo.searchText("Guess charade") == true)){
			result = true;
		}
		Assert.assertTrue(result);
		solo.clickOnText(OPPONENT_OPPONENTS_TURN);
		solo.waitForActivity(GameDashboardActivity.class);
		result = false;
		if(solo.searchText("Waiting...") == true && (solo.searchText("Record Video") == false && solo.searchText("Guess charade") == false)){
			result = true;
		}
		Assert.assertTrue(result);
		
		solo.clickOnText(OPPONENT_FINISHED_GAME);
		solo.waitForActivity(GameDashboardActivity.class);
		result = false;
		if(solo.searchText("points") == true && solo.searchText("Record Video") == false && solo.searchText("Guess charade") == false && solo.searchText("Waiting...") == false && solo.searchText("Locked") == false){
			result = true;
		}
		Assert.assertTrue(result);
	}
	
	private void login(){
		solo.waitForActivity(LoginActivity.class);
		solo.enterText(0, USERNAME);
		solo.enterText(1, USER_PASSWORD);
		solo.clickOnButton("Login");
		solo.waitForActivity(StartActivity.class);
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

}
