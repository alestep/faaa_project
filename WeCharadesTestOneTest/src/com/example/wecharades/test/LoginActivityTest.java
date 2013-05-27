package com.example.wecharades.test;

import com.example.wecharades.views.LoginActivity;
import com.jayway.android.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;

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
	
	public void testLoginButtonpress(){
		solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
	}

}
