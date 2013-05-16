package com.example.wecharades;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class ResetPasswordActivity extends Activity {
	Button btnResetPassword;
	Button btnLinkToRegisterScreen;
	Button btnLinkToLoginScreen;
	EditText emailInput;
	TextView errorMsg;
	ProgressBar resetProgress;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Copy and Paste this into every onCreate method to be able to use Parse
		Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R"); 

		//Setting the view
		setContentView(R.layout.resetpassword);

		//Getting some info...
		emailInput				= (EditText) findViewById(R.id.resetPassword);
		errorMsg				= (TextView) findViewById(R.id.error);
		btnLinkToRegisterScreen = (Button) findViewById(R.id.btnLinkToRegisterScreen);
		btnLinkToLoginScreen	= (Button) findViewById(R.id.btnLinkToLoginScreen);
		resetProgress			= (ProgressBar) findViewById(R.id.progress);
		resetProgress.setVisibility(4); //set to invisible

		btnResetPassword = (Button) findViewById(R.id.btnResetPassword);
		btnResetPassword.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//Showing the progress spinner
				showProgressSpinner();

				String email = emailInput.getText().toString();
				ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
					@Override
					public void done(ParseException e) {

						//Hiding the progress spinner
						hideProgressSpinner();

						if (e == null) {
							// Success
							// TODO Use a Toast instead ...
							errorMsg.setTextColor(Color.parseColor("#458B00"));
							errorMsg.setText("You got mail!");
							//Toast.makeText(getApplicationContext(), "You got mail!", Toast.LENGTH_SHORT).show();

						} else {
							// Something went wrong - Looking at ParseExceptions...
							// Found a list of exceptions: https://www.parse.com/docs/android/api/constant-values.html
							if (e.getCode() == 204 || e.getCode() == 125) {
								errorMsg.setText("Please enter a valid email");
							} else if (e.getCode() == 205) {
								errorMsg.setText("Email not found - Please register");
							} else if (e.getCode() == 100) {
								errorMsg.setText("Please check your internet connection");
							} else {
								//Unknown error - Error code in the end for the developing stage
								errorMsg.setText("Oops! Something went wrong. The server says: " + e.getMessage());
							}
						}
					}
				});


			}
		});

		// Link to Login Screen
		btnLinkToLoginScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						LoginActivity.class);
				startActivity(i);
				finish();
			}
		});

		// Link to Register Screen
		btnLinkToRegisterScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						RegisterActivity.class);
				startActivity(i);
				finish();
			}
		});
	}

	//TODO: Where should we put these, they are used in both RegisterActivity and LoginActivity
	//TODO: Consider using threads instead...
	private void showProgressSpinner() {
		//show the spinner
		resetProgress.setVisibility(0);
		//disable all clickable objects
		btnResetPassword.setEnabled(false);
		btnLinkToRegisterScreen.setEnabled(false);
		btnLinkToLoginScreen.setEnabled(false);
		emailInput.setEnabled(false);

	}

	private void hideProgressSpinner() {
		//hide the spinner
		resetProgress.setVisibility(8);
		//re-enable all clickable objects
		btnResetPassword.setEnabled(true);
		btnLinkToRegisterScreen.setEnabled(true);
		btnLinkToLoginScreen.setEnabled(true);
		emailInput.setEnabled(true);
	}
}