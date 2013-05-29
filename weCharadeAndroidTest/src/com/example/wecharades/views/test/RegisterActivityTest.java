package com.example.wecharades.views.test;

import com.example.wecharades.views.RegisterActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
/**
 * Test class to test the RegisterActivity. Test ID: T01 in the Acceptance testing.
 * @author Adam
 *
 */
public class RegisterActivityTest extends
		ActivityInstrumentationTestCase2<RegisterActivity> {

	private Solo solo;
	
	public RegisterActivityTest() {
		super(RegisterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	/**
	 * Variation 1
	 */
	public void testEmptyFields(){
		solo.assertCurrentActivity("Assert RegisterActivity", RegisterActivity.class);
		solo.clickOnButton("Register");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
		solo.waitForDialogToClose(5000);
		
	}
	/**
	 * Variation 2
	 */
	public void testUsernameRestEmptyFields(){
		solo.assertCurrentActivity("Assert RegisterActivity", RegisterActivity.class);
		solo.enterText(0, "a");
		solo.clickOnButton("Register");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
		solo.waitForDialogToClose(5000);
	}
	/**
	 * Variation 3
	 */
	public void testUnvalidEmail(){
		solo.assertCurrentActivity("Assert RegisterActivity", RegisterActivity.class);
		solo.enterText(0, "validUsername");
		solo.enterText(1, "abc.se");
		solo.clickOnButton("Register");
		solo.waitForDialogToOpen(5000);
		solo.clickOnButton("OK");
		solo.waitForDialogToClose(5000);
	}
	/**
	 * Variation 4
	 */
	public void testUnvalidPassword(){
		solo.assertCurrentActivity("Assert RegisterActivity", RegisterActivity.class);
		solo.enterText(0, "validUsername");
		solo.enterText(1, "valid@email.se");
		solo.enterText(2,"myPw");
		solo.clickOnButton("Register");
		solo.waitForDialogToOpen(3000);
		solo.clickOnButton("OK");
		solo.waitForDialogToClose(3000);
	}
	/**
	 * Variation 5
	 */
	public void testMissmatchPassword(){
		solo.assertCurrentActivity("Assert RegisterActivity", RegisterActivity.class);
		solo.enterText(0, "validUsername");
		solo.enterText(1, "valid@email.se");
		solo.enterText(2,"myPw");
		solo.enterText(3,"missMatch");
		solo.clickOnButton("Register");
		solo.waitForDialogToOpen(3000);
		solo.clickOnButton("OK");
		solo.waitForDialogToClose(3000);
	}
	/**
	 * Variation 6 - All 4 different cases are depending on if there is a user already registered in the database or if there exists an internetconnection.
	 */
	public void testCorrectInputs(){
		solo.assertCurrentActivity("Assert RegisterActivity", RegisterActivity.class);
		solo.enterText(0, "validUsername");
		solo.enterText(1, "valid@email.com");
		solo.enterText(2,"validPassword");
		solo.enterText(3,"validPassword");
		solo.clickOnButton("Register");
		solo.waitForActivity(StartActivity.class);
		solo.assertCurrentActivity("StartActivity is viewed.", StartActivity.class);
	}
	
	@Override
	public void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}
	
}
