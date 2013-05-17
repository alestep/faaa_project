package com.example.wecharades.views;

import com.example.wecharades.R;
import com.example.wecharades.R.id;
import com.example.wecharades.R.layout;
import com.example.wecharades.presenter.LoginPresenter;
import com.example.wecharades.presenter.Presenter;
import com.example.wecharades.presenter.ResetPresenter;
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
import android.widget.ScrollView;
import android.widget.TextView;


public class ResetPasswordActivity extends Activity {

	EditText emailInput;
	TextView errorMsg;
	ProgressBar resetProgress;
	View myView;
	ResetPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resetpassword);
		//initializing the presenter
		presenter = new ResetPresenter(getApplicationContext());

		//Parse Stuff - Copy and Paste this into every onCreate method to be able to use Parse
		presenter.initialize();

		//Getting the view associated with this Activity
		myView = getWindow().getDecorView().findViewById(android.R.id.content);
		emailInput				= (EditText) findViewById(R.id.resetPassword);
		errorMsg				= (TextView) findViewById(R.id.error);
		resetProgress			= (ProgressBar) findViewById(R.id.progress);
		presenter.setProgressSpinnerInvisible(resetProgress);
	}

	/**
	 * The user should enter it's e-mail to receive a new password
	 * @param arg0
	 */
	public void onClickResetPassword(View arg0) {
		//Showing the progress spinner
		presenter.showProgressSpinner(myView, resetProgress);


		String email = emailInput.getText().toString();
		ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
			@Override
			public void done(ParseException e) {

				//Hiding the progress spinner
				presenter.hideProgressSpinner(myView, resetProgress);

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

	/**
	 * Go to login screen
	 * @param view
	 */
	public void onClickLoginScreen(View view) {
		Intent i = new Intent(getApplicationContext(),
				LoginActivity.class);
		startActivity(i);
		finish();
	}

	/**
	 * Go to registration screen
	 * @param view
	 */
	public void onClickRegistrationScreen(View view) {
		Intent i = new Intent(getApplicationContext(),
				LoginActivity.class);
		startActivity(i);
		finish();
	}
}