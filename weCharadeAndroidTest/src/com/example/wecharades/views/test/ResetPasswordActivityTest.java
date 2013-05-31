package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.ResetPasswordActivity;
import com.jayway.android.robotium.solo.Solo;
/**
 * Test class to test the ResetPassword activity. Test ID: T03
 * @author weCharade
 * @see Acceptance Test document.
 * @pre valid email adress.
 */
public class ResetPasswordActivityTest extends
ActivityInstrumentationTestCase2<ResetPasswordActivity> {

	private Solo solo;
	private String validEmail ="adamlewestam@gmail.com";
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
	 * @pre Case 2 needs to be done without internet connection.
	 * Variation 3. Case 1 and 2.
	 */
	public void testValidEmail(){
		solo.assertCurrentActivity("ResetPasswordActivity", ResetPasswordActivity.class);
		solo.enterText(0, validEmail);
		solo.clickOnButton("Send me a new password");
		solo.waitForText("Email has been sent!");
		solo.assertCurrentActivity("LoginScreen", LoginActivity.class);
	}



	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();	
	}

}
