package com.example.wecharades.views;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.wecharades.R;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends Activity {
	Button btnLogin;
	Button btnLinkToRegister;
	Button btnForgotPassword;
	EditText inputUsername;
	EditText inputPassword;
	TextView loginErrorMsg;
	ProgressBar loginProgress;
	ScrollView myScrollView;
	View myView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		//Parse Stuff - Copy and Paste this into every onCreate method to be able to use Parse
		Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");

		//Testing to get the view associated with login.xml
		myView = getWindow().getDecorView().findViewById(android.R.id.content);

		// Importing all assets like buttons, text fields
		inputUsername		= (EditText) findViewById(R.id.loginUsername);
		inputPassword		= (EditText) findViewById(R.id.loginPassword);
		btnLogin			= (Button) findViewById(R.id.btnLogin);
		btnLinkToRegister	= (Button) findViewById(R.id.btnLinkToRegisterScreen);
		btnForgotPassword	= (Button) findViewById(R.id.btnForgotPassword);
		loginErrorMsg		= (TextView) findViewById(R.id.login_error);
		loginProgress		= (ProgressBar) findViewById(R.id.progress);
		myScrollView		= (ScrollView)findViewById(R.id.scrollView);
		loginProgress.setVisibility(4); //set to invisible
	}

	/**
	 * On click login button - if success go to StartActivity, on fail show error messages
	 * TODO: maybe not a good method, create smaller method with more specific tasks
	 * @param view
	 */
	public void onClickLogin(View view) {
		//Show the progress spinner
		showProgressSpinner();

		//Using lowercase at login and registration to avoid case sensitivity problems
		String username = inputUsername.getText().toString().toLowerCase();
		//Should be case sensitive
		String password = inputPassword.getText().toString();

		//login through parse.com's standard function
		ParseUser.logInInBackground(username, password, new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException e) {
				hideProgressSpinner();
				if (user != null) {
					// Successful login! - Launch StartScreen
					Intent startscreen = new Intent(getApplicationContext(), StartScreen.class);

					// Close all views before launching StartScreen
					startscreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(startscreen);

					// Close Login Screen
					finish();
				} else {
					// Signup failed. Look at the ParseException to see what happened.
					//e.getMessage() seems good enough!
					if (e.getCode() == 100) {
						loginErrorMsg.setText("Please check your internet connection!");
					} else {
						loginErrorMsg.setText(e.getMessage());
					}
				}
			}
		});
	}

	/**
	 * Link to the screen to get a new password
	 * @param view
	 */
	public void onClickForgotPassword(View view) {
		Intent i = new Intent(getApplicationContext(),
				ResetPasswordActivity.class);
		startActivity(i);
		finish();
	}
	/**
	 * Link to register screen
	 * @param view
	 */
	public void onClickRegister(View view) {
		Intent i = new Intent(getApplicationContext(),
				RegisterActivity.class);
		startActivity(i);
		finish();
	}

	/**
	 * Called to show progress spinning when waiting for the server
	 * TODO: Where should we put these, they are used in both RegisterActivity, LoginActivity and ResetPasswordActivity
	 * TODO: Consider using threads instead...
	 */
	public void showProgressSpinner() {
		//show the spinner
		loginProgress.setVisibility(0);
		//Enable buttons
		enableOrDisableViews();
	}

	/**
	 * Called to hide progress spinning when the server has responded
	 */
	public void hideProgressSpinner() {
		//hide the spinner
		loginProgress.setVisibility(8);
		//disable buttons
		enableOrDisableViews();
	}
	
	public void enableOrDisableViews() {
		ArrayList<View> allViewObject = getAllChildren(myView);
		for (View child : allViewObject) {
			if (child instanceof TextView) {
				if(child.isEnabled()) {
				child.setEnabled(false);
				} else {
					child.setEnabled(true);
				}
			}
		}
	}

	private ArrayList<View> getAllChildren(View v) {

		if (!(v instanceof ViewGroup)) {
			ArrayList<View> viewArrayList = new ArrayList<View>();
			viewArrayList.add(v);
			return viewArrayList;
		}

		ArrayList<View> result = new ArrayList<View>();

		ViewGroup vg = (ViewGroup) v;
		for (int i = 0; i < vg.getChildCount(); i++) {

			View child = vg.getChildAt(i);

			ArrayList<View> viewArrayList = new ArrayList<View>();
			viewArrayList.add(v);
			viewArrayList.addAll(getAllChildren(child));

			result.addAll(viewArrayList);
		}
		return result;
	}
}
