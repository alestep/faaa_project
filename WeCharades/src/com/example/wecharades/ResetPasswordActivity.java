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
import android.widget.TextView;
import android.widget.Toast;


public class ResetPasswordActivity extends Activity {
	Button btnResetPassword;
	Button btnLinkToRegisterScreen;
	Button btnLinkToLoginScreen;
	EditText emailInput;
	TextView errorMsg;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Copy and Paste this into every onCreate method to be able to use Parse
		Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R"); 

		//Setting the view
		setContentView(R.layout.resetpassword);

		//Getting some info...
		emailInput = (EditText) findViewById(R.id.resetPassword);
		errorMsg = (TextView) findViewById(R.id.error);
		btnLinkToRegisterScreen = (Button) findViewById(R.id.btnLinkToRegisterScreen);
		btnLinkToLoginScreen = (Button) findViewById(R.id.btnLinkToLoginScreen);
		btnResetPassword = (Button) findViewById(R.id.btnResetPassword);
		btnResetPassword.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String email = emailInput.getText().toString();
				ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
					@Override
					public void done(ParseException e) {
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
							} else {
								//Unknown error - Error code in the end for the developing stage
								errorMsg.setText("Oops! Something went wrong. Please try again." + e.getCode());
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
}