package com.example.wecharades.views.test;

import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.ResetPasswordActivity;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class ResetPasswordActivityTest extends
ActivityInstrumentationTestCase2<ResetPasswordActivity> {

	private Solo solo;

	public ResetPasswordActivityTest() {
		super(ResetPasswordActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(),getActivity());
	}
	/**
	 * Variation 1
	 */
	public void testEmptyEmail(){
		solo.assertCurrentActivity("ResetPasswordActivity", ResetPasswordActivity.class);
		solo.clickOnButton("Send me a new password");
		solo.waitForDialogToOpen(3000);
		solo.clickOnButton("OK");
		solo.waitForDialogToClose(3000);
	}
	/**
	 * Variation 2
	 */
	public void testInvalidEmail(){
		solo.assertCurrentActivity("ResetPasswordActivity", ResetPasswordActivity.class);
		solo.enterText(0, "invalidEmail");
		solo.clickOnButton("Send me a new password");
		solo.waitForDialogToOpen(3000);
		solo.clickOnButton("OK");
		solo.waitForDialogToClose(3000);
	}
	/**
	 * Variation 3 Case 1 and 2. Case 2 needs to be done without internetconnection.
	 */
	public void testValidEmail(){
		solo.assertCurrentActivity("ResetPasswordActivity", ResetPasswordActivity.class);
		solo.enterText(0, "adamlewestam@gmail.com");
		solo.clickOnButton("Send me a new password");
		solo.waitForText("Email has been sent!");
		solo.assertCurrentActivity("LoginScreen", LoginActivity.class);
	}



	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();	
	}

}
