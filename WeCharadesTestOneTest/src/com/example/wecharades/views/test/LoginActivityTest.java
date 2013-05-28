package com.example.wecharades.views.test;

import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;

import android.net.wifi.WifiManager;
import android.test.ActivityInstrumentationTestCase2;

/**
 * @author Adam
 * Test class to test the LoginActivity Test ID: T02
 */

public class LoginActivityTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {
	
	private Solo solo;
	
	public LoginActivityTest() {
		super(LoginActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(),getActivity());
	}
	/**
	 * Variation 1 - Invalid login credentials - no username or password entered
	 */
	public void testEmptyFieldsLogin(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, "");
		solo.enterText(1, "");
		solo.clickOnButton("Login");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
	}
	/**
	 * Variation 2 - incorrect login credentials: no password
	 */
	public void testPasswordEmptyFieldLogin(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0,"adam");
		solo.clickOnButton("Login");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
	}
	/**
	 * Variation 3 - Case 1: Correct login credentials
	 */
	public void testValidUsernameAndPasswordCaseOne(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, "adam"); //Correct username
		solo.enterText(1, "adam92"); //Correct password
		solo.clickOnButton("Login");
		solo.assertCurrentActivity("Assertion of StartScreen", StartActivity.class);
	}
	/**
	 * Variation 3 - Case 2
	 */
	public void testValidUsernameAndPasswordCaseTwo(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, "adam");
		solo.enterText(1, "WRONG_PASSWORD");
		solo.clickOnButton("Login");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
		
	}
	/**
	 * Variation 3 - Case 3 Requires no internet connection. TODO: turn internet autmatically off.
	 */
	public void testValidUsernameAndPasswordCaseThree(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, "adam"); //Correct username
		solo.enterText(1, "adam92"); //Correct password
		solo.clickOnButton("Login");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
		
	}
	@Override
	public void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}

}
