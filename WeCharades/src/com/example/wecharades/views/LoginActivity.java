package com.example.wecharades.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.LoginPresenter;
import com.example.wecharades.presenter.Presenter;
import com.parse.LogInCallback;
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
		LoginPresenter.initialize(this);

		//Getting the view associated with this Activity
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
		Presenter.setProgressSpinnerInvisible(loginProgress);
	}

	/**
	 * On click login button - if success go to StartActivity, on fail show error messages
	 * TODO: maybe not a good method, create smaller method with more specific tasks
	 * @param view - the view
	 */
	public void onClickLogin(View view) {
		//Show the progress spinner
		Presenter.showProgressSpinner(myView, loginProgress);
		
		//Using lowercase at login and registration to avoid case sensitivity problems
		String username = inputUsername.getText().toString().toLowerCase();
		//Should be case sensitive
		String password = inputPassword.getText().toString();

		//login through parse.com's standard function
		ParseUser.logInInBackground(username, password, new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException e) {
				Presenter.hideProgressSpinner(myView, loginProgress);
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
}
