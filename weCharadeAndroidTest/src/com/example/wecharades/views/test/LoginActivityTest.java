package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.AutoCompleteTextView.Validator;

import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;

/**
 * @author weCharade
 * Test class to test the LoginActivity Test ID: T02
 * @pre valid user account
 */

public class LoginActivityTest extends
		ActivityInstrumentationTestCase2<LoginActivity> {
	
	private String userName = "adam";
	private String password = "adam92";
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
		solo.enterText(0,userName);
		solo.clickOnButton("Login");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
	}
	/**
	 * Variation 3 - Case 1: Correct login credentials
	 */
	public void testValidUsernameAndPasswordCaseOne(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, userName); //Correct username
		solo.enterText(1, password); //Correct password
		solo.clickOnButton("Login");
		solo.waitForActivity(StartActivity.class);
		solo.assertCurrentActivity("Assertion of StartScreen", StartActivity.class);
	}
	/**
	 * Variation 3 - Case 2:
	 */
	public void testValidUsernameAndPasswordCaseTwo(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, userName);
		solo.enterText(1, "WRONG_PASSWORD");
		solo.clickOnButton("Login");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
		
	}
	/**
	 * Variation 3 - Case 3 Requires no internet connection.
	 * @pre: no internet connection
	 */
	public void testValidUsernameAndPasswordCaseThree(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
		solo.enterText(0, userName); //Correct username
		solo.enterText(1, password); //Correct password
		solo.clickOnButton("Login");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
		
	}
	
	@Override
	public void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}

}
