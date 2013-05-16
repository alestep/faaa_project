package com.example.wecharades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		//Parse Stuff - Copy and Paste this into every onCreate method to be able to use Parse
		Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");

		// Importing all assets like buttons, text fields
		inputUsername		= (EditText) findViewById(R.id.loginUsername);
		inputPassword		= (EditText) findViewById(R.id.loginPassword);
		btnLogin			= (Button) findViewById(R.id.btnLogin);
		btnLinkToRegister	= (Button) findViewById(R.id.btnLinkToRegisterScreen);
		btnForgotPassword	= (Button) findViewById(R.id.btnForgotPassword);
		loginErrorMsg		= (TextView) findViewById(R.id.login_error);
		loginProgress		= (ProgressBar) findViewById(R.id.progress);
		loginProgress.setVisibility(4); //set to invisible




		// Link to Register Screen
		btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						RegisterActivity.class);
				startActivity(i);
				finish();
			}
		});
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
	private void showProgressSpinner() {
		//show the spinner
		loginProgress.setVisibility(0);
		//disable all clickable objects
		btnLogin.setEnabled(false);
		btnLinkToRegister.setEnabled(false);
		btnForgotPassword.setEnabled(false);
		inputUsername.setEnabled(false);
		inputPassword.setEnabled(false);
	}

	/**
	 * Called to hide progress spinning when the server has responded
	 */
	private void hideProgressSpinner() {
		//hide the spinner
		loginProgress.setVisibility(8);
		//re-enable all clickable objects
		btnLogin.setEnabled(true);
		btnLinkToRegister.setEnabled(true);
		btnForgotPassword.setEnabled(true);
		inputUsername.setEnabled(true);
		inputPassword.setEnabled(true);
	}
}
