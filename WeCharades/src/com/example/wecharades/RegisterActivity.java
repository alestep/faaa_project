package com.example.wecharades;

import com.parse.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	Button btnRegister;
	Button btnLinkToLogin;
	EditText inputNickname;
	EditText inputEmail;
	EditText inputPassword;
	EditText inputRepeatPassword;
	TextView registerErrorMsg;
	ProgressBar registerProgress;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		//Parse Stuff - Copy and Paste this into every onCreate method to be able to use Parse
		Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");

		// Importing all assets like buttons, text fields
		inputNickname = (EditText) findViewById(R.id.registerName);
		inputEmail = (EditText) findViewById(R.id.registerEmail);
		inputPassword = (EditText) findViewById(R.id.registerPassword);
		inputRepeatPassword = (EditText) findViewById(R.id.registerRepeatPassword);
		btnRegister = (Button) findViewById(R.id.btnRegister);
		btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);
		registerErrorMsg = (TextView) findViewById(R.id.register_error);
		registerProgress = (ProgressBar) findViewById(R.id.progress);
		registerProgress.setVisibility(4); //set to invisible


		// Register Button Click event
		btnRegister.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View view) {
				
				//Showing the progress spinner
				showProgressSpinner();
				String name = inputNickname.getText().toString();
				String email = inputEmail.getText().toString().toLowerCase(); //To avoid case sensitivity problems...
				String password = inputPassword.getText().toString();
				String repeatPassword = inputRepeatPassword.getText().toString();

				//My own validation check...
				//TODO: Check if it is possible to compare the two password inputs as an ParseException?
				if(name == null || name.length() == 0) {
					hideProgressSpinner();
					registerErrorMsg.setText("Please enter a valid name");
				} else if (badPassword(password)) {
					hideProgressSpinner();
					registerErrorMsg.setText("Please enter a valid password of minimum 6 characters");
				} else if (!password.equals(repeatPassword)) {
					hideProgressSpinner();
					registerErrorMsg.setText("You password doesn't match. Please try again!");
				}  else {

					ParseUser user = new ParseUser();
					user.setUsername(name.toLowerCase());
					user.put("naturalUsername", name);		//to keep the input username, e.g capital letter
					user.put("globalScore", 0); 			//globalScore is set to zero when register
					user.setPassword(password);
					user.setEmail(email);
					
					
					user.signUpInBackground(new SignUpCallback() {
						@Override
						public void done(ParseException e) {
							hideProgressSpinner();
							if (e == null) {
								// Successful registration - Launch Start Screen
								Intent dashboard = new Intent(getApplicationContext(), StartScreen.class);
								//Close all views befora launching start screen
								dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(dashboard);
								// Close Registration Screen
								finish();
							} else {
								// Sign up didn't succeed. Looking at ParseExceptions...
								// Found a list of exceptions: https://www.parse.com/docs/android/api/constant-values.html
								if (e.getCode() == 202) {
									registerErrorMsg.setText("The username is already in use");
								} else if (e.getCode() == 203) {
									registerErrorMsg.setText("The email is already registered");
								} else if (e.getCode() == 125) {
									registerErrorMsg.setText("Please enter a valid e-mail");
								} else if (e.getCode() == 100) {
									registerErrorMsg.setText("Please check your internet connection!");
								} else {
									//Unknown error - Error code until all problems fixed...
									registerErrorMsg.setText("Oops! Something went wrong. The server says: " + e.getMessage());
								}
							}
						}
					});
				}
			}
		});

		// Link to Login Screen
		btnLinkToLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(i);
				// Close Registration View
				finish();
			}
		});
	}

	private boolean badPassword(String password) {
		//Only two criterias for now...
		//TODO Fix stronger restrictions??
		return (password == null || password.length() < 5);
	}
	
	//TODO: Where should we put these, they are used in both RegisterActivity and LoginActivity
	//TODO: Consider using threads instead...
	private void showProgressSpinner() {
		//show the spinner
		registerProgress.setVisibility(0);
		//disable all clickable objects
		btnRegister.setEnabled(false);
		btnLinkToLogin.setEnabled(false);
		inputNickname.setEnabled(false);
		inputEmail.setEnabled(false);
		inputPassword.setEnabled(false);
		inputRepeatPassword.setEnabled(false);
	}
	
	private void hideProgressSpinner() {
		//hide the spinner
		registerProgress.setVisibility(8);
		//re-enable all clickable objects
		btnRegister.setEnabled(true);
		btnLinkToLogin.setEnabled(true);
		inputNickname.setEnabled(true);
		inputEmail.setEnabled(true);
		inputPassword.setEnabled(true);
		inputRepeatPassword.setEnabled(true);
	}
}
