package com.example.wecharades.views.test;
 
import android.test.ActivityInstrumentationTestCase2;

import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;


/**
 * 
 * @author Adam
 *Test class to test the GuessCharadeActivity Test ID: T07.
 *Precondition: The user must be logged out and have a game where it is the users turn to guess a charade.
 */

public class GuessCharadeActivityTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {
	/*
	 * THESE VARIABLES MUST BE SET CORRESPONDING TO THE PRECONDTIONS TO GET THE TEST TO WORK!
	 */
	private Solo solo;
	private String USERNAME = "adam";
	private String USER_PASSWORD="adam92";
	private String OPPONENT_YOUR_TURN ="Felix";
	private String WRONG_WORD ="ALKSsadA"; //random wrong letter combination
	private String RIGHT_WORD = "horse";
	
	public GuessCharadeActivityTest() {
		super(LoginActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(),getActivity());
	}

	/**
	 * Test ID: T07. Variation 1. Uses precondition.
	 */
	public void testGuessCharadeVideoGuessNotRight(){
		solo.enterText(0, USERNAME);
		solo.enterText(1, USER_PASSWORD);
		solo.clickOnButton("Login");
		solo.waitForActivity(StartActivity.class);
		/*---------------------------------------*/
		solo.clickOnText(OPPONENT_YOUR_TURN);
		solo.waitForActivity(GameDashboardActivity.class);
		solo.clickOnButton("Guess charade");
		solo.waitForDialogToOpen(2000);
		solo.waitForDialogToClose(3000);
		solo.enterText(0, WRONG_WORD);
		
		solo.clickOnImageButton(0);
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("Retry");
		solo.waitForDialogToClose(5000);
	}
	/**
	 * Variation 2 - requires the right word. Precondition: Comment away row 98-101 in GuessCharadePresenter.java which updates the database.
	 */
	public void testGuessCharadeVideoGuessRight(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, USERNAME);
		solo.enterText(1, USER_PASSWORD);
		solo.clickOnButton("Login");
		solo.waitForActivity(StartActivity.class);
//		/*---------------------------------------*/
		solo.clickOnText(OPPONENT_YOUR_TURN);
		solo.waitForActivity(GameDashboardActivity.class);
		solo.clickOnButton("Guess charade");
		solo.waitForDialogToOpen(2000);
		solo.waitForDialogToClose(3000);
		solo.enterText(0, RIGHT_WORD);
		solo.clickOnImageButton(0);
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("Continue");
		solo.waitForDialogToClose(5000);
		
	}
	
	@Override
	public void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}

}
