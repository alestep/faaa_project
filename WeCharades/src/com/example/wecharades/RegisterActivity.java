package com.example.wecharades;

import com.parse.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	Button btnRegister;
	Button btnLinkToLogin;
	EditText inputNickname;
	EditText inputEmail;
	EditText inputPassword;
	EditText inputRepeatPassword;
	TextView registerErrorMsg;

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

		// Register Button Click event
		btnRegister.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View view) {
				
				String name = inputNickname.getText().toString();
				String email = inputEmail.getText().toString().toLowerCase(); //To avoid case sensitivity problems...
				String password = inputPassword.getText().toString();
				String repeatPassword = inputRepeatPassword.getText().toString();

				//My own validation check...
				//TODO Check if it is possible to compare the two password inputs as an ParseException?
				if(name == null || name.length() == 0) {
					registerErrorMsg.setText("Please enter a valid name");
				} else if (badPassword(password)) {
					registerErrorMsg.setText("Please enter a valid password of minimum 6 characters");
				} else if (!password.equals(repeatPassword)) {
					registerErrorMsg.setText("You password doesn't match. Please try again!");
				}  else {

					ParseUser user = new ParseUser();
					user.setUsername(name.toLowerCase());
					user.put("naturalUsername", name); //to keep the input username, e.g capital letter
					user.setPassword(password);
					user.setEmail(email);

					user.signUpInBackground(new SignUpCallback() {
						@Override
						public void done(ParseException e) {
							if (e == null) {
								// Successful registration - Launch Dashboard Screen
								Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);
								// Close all views before launching Dashboard
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
								} else {
									//Unknown error - Error code until all problems fixed...
									registerErrorMsg.setText("Oops! Something went wrong. Please try again." + e.getCode());
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
}