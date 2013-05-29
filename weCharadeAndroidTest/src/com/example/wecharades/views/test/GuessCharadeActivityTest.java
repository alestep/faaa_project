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
 */

public class GuessCharadeActivityTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {
	
	private Solo solo;
	
	public GuessCharadeActivityTest() {
		super(LoginActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(),getActivity());
	}

	/**
	 * Test ID: T07. Variation One. Uses precondition 1
	 */
	public void testGuessCharadeVideoGuessWrong(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, "adam");
		solo.enterText(1, "adam92");
		solo.clickOnButton("Login");
		solo.waitForActivity(StartActivity.class);
		/*---------------------------------------*/
		solo.clickOnText("Antz");
		solo.waitForActivity(GameDashboardActivity.class);
		solo.clickOnButton("Guess charade");
		solo.waitForDialogToOpen(2000);
		solo.waitForDialogToClose(3000);
		solo.enterText(0, "LOL");
		
		solo.clickOnImageButton(0);
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("Retry");
		solo.waitForDialogToClose(5000);
	}
	/**
	 * Variation 2 - requires the right word. Precondition: Comment away row 99-102 which update the database.
	 */
	public void testGuessCharadeVideoGuessRight(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, "adam");
		solo.enterText(1, "adam92");
		solo.clickOnButton("Login");
		solo.waitForActivity(StartActivity.class);
		/*---------------------------------------*/
		solo.clickOnText("Antz");
		solo.waitForActivity(GameDashboardActivity.class);
		solo.clickOnButton("Guess charade");
		solo.waitForDialogToOpen(2000);
		solo.waitForDialogToClose(3000);
		solo.enterText(0, "skriva");
		solo.clickOnImageButton(0);
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("Continue");
		solo.waitForDialogToClose(5000);
		solo.waitForActivity(GameDashboardActivity.class);
		
	}
	
	@Override
	public void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}

}
