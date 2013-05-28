package com.example.wecharades.views.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;

import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;
/**
 * Test class for testing Test IDs: T08 and T09
 * @author Adam
 *
 */
public class GameOverviewTest extends ActivityInstrumentationTestCase2<StartActivity> {

	private Solo solo;
	
	public GameOverviewTest() {
		super(StartActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	/**
	 * Testing with three games: 1 your turn, 1 opponents turn, 1 finished.
	 */
	public void testYourTurn(){
		solo.assertCurrentActivity("initially startAcivity", StartActivity.class);
		login();
		solo.searchText("The score is");
		solo.clickOnText("Antz");
		solo.waitForActivity(GameDashboardActivity.class);
		boolean result = false;
		if(solo.searchText("Record Video") == true || solo.searchText("Guess charade") == true && !(solo.searchText("Record Video") == true && solo.searchText("Guess charade") == true)){
			result = true;
		}
		Assert.assertTrue(result);
		
	}
	public void testOpponentsTurn(){
		solo.assertCurrentActivity("initially startAcivity", StartActivity.class);
		login();
		solo.searchText("The score is");
		solo.clickOnText("Felix");
		solo.waitForActivity(GameDashboardActivity.class);
		boolean result = false;
		if(solo.searchText("Waiting...") == true && (solo.searchText("Record Video") == false && solo.searchText("Guess charade") == false)){
			result = true;
		}
		Assert.assertTrue(result);
	}
	public void testFinishedGame(){
		solo.assertCurrentActivity("initially startAcivity", StartActivity.class);
		login();
		solo.searchText("The score is");
		solo.clickOnText("Felix");
		solo.waitForActivity(GameDashboardActivity.class);
		boolean result = false;
		if(solo.searchText("points") == true && solo.searchText("Record Video") == false && solo.searchText("Guess charade") == false && solo.searchText("Waiting...") == false && solo.searchText("Locked") == false){
			result = true;
		}
		Assert.assertTrue(result);
	}
	
	private void login(){
		solo.waitForActivity(LoginActivity.class);
		solo.enterText(0, "adam");
		solo.enterText(1, "adam92");
		solo.clickOnButton("Login");
		solo.waitForActivity(StartActivity.class);
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}

}
