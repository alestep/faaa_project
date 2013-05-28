package com.example.wecharades.views.test;

import junit.framework.Assert;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;

/**
 * 
 * @author Adam
 *Test class to test the LoginActivity Test ID: T02
 */

public class LoginActivityTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {
	
	private Solo solo;
	
	public LoginActivityTest() {
		super(LoginActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(),getActivity());
	}
//	/**
//	 * Variation 1
//	 */
//	public void testEmptyFieldsLogin(){
//		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//		solo.enterText(0, "");
//		solo.enterText(1, "");
//		solo.clickOnButton("Login");
//		solo.waitForDialogToOpen(5000);
//		solo.clickOnButton("OK");
//	}
//	/**
//	 * Variation 2
//	 */
//	public void testPasswordEmptyFieldLogin(){
//		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//		solo.enterText(0,"adam");
//		solo.clickOnButton("Login");
//		solo.waitForDialogToOpen(5000);
//		solo.clickOnButton("OK");
//	}
//	/**
//	 * Variation 3 - Case 1
//	 */
//	public void testValidUsernameAndPasswordCaseOne(){
//		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//		solo.enterText(0, "adam");
//		solo.enterText(1, "adam92");
//		solo.clickOnButton("Login");
//		solo.waitForActivity(StartActivity.class);
//		solo.assertCurrentActivity("Assertion of StartScreen", StartActivity.class);
//	}
//	/**
//	 * Variation 3 - Case 2
//	 */
//	public void testValidUsernameAndPasswordCaseTwo(){
//		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//		solo.enterText(0, "adam");
//		solo.enterText(1, "WRONG_PASSWORD");
//		solo.clickOnButton("Login");
//		solo.waitForDialogToOpen(5000);
//		solo.clickOnButton("OK");
//		
//	}
//	/**
//	 * Variation 3 - Case 3 Requires no internet connection. TODO: turn internet autmatically off.
//	 */
//	public void testValidUsernameAndPasswordCaseThree(){
//		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//		solo.enterText(0, "adam");
//		solo.enterText(1, "WRONG_PASSWORD");
//		solo.clickOnButton("Login");
//		solo.waitForDialogToOpen(5000);
//		solo.clickOnButton("OK");
//		
//	}
	/**
	 * Test ID
	 */
	public void testGuessCharadeVideo(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, "adam");
		solo.enterText(1, "adam92");
		solo.clickOnButton("Login");
		solo.waitForActivity(StartActivity.class);
		solo.clickOnText("Antz");
		solo.waitForActivity(GameDashboardActivity.class);
		solo.clickOnButton("Guess charade");
		solo.waitForDialogToOpen(3000);
		solo.waitForDialogToClose(15000);
		solo.enterText(0, "LOL");
//		solo.clickOnButton(0);
//		solo.waitForDialogToOpen(5000);
//		solo.clickOnButton("Retry");
//		solo.waitForDialogToClose(5000);
		
		
	}
	
	@Override
	public void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}

}
