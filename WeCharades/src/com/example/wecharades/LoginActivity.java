package com.example.wecharades;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wecharades.views.ResetPasswordActivity;
import com.example.wecharades.views.StartScreen;
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

		// Login button Click Event
		btnLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				//Using lowercase at login and registration to avoid case sensitivity problems
				String username = inputUsername.getText().toString().toLowerCase();
				//Should be case sensitive
				String password = inputPassword.getText().toString();

				/** 
				 * TODO: Be able to login using e-mail?
				 * 		 Probably using getUsername() and parse the username  
				 **/
				ParseUser.logInInBackground(username, password, new LogInCallback() {
					@Override
					public void done(ParseUser user, ParseException e) {
						if (user != null) {
							// Successful login! - Launch dashboard screen
							Intent dashboard = new Intent(getApplicationContext(), StartScreen.class);

							// Close all views before launching Dashboard
							dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(dashboard);

							// Close Login Screen
							finish();
						} else {
							// Signup failed. Look at the ParseException to see what happened. - Error code submitted until all bugs fixed
							loginErrorMsg.setText(e.getMessage());
						}
					}
				});
			}
		});


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

		// Link to Forgot Password
		btnForgotPassword.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						ResetPasswordActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
}
