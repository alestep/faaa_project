package com.example.wecharades.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.presenter.LoginPresenter;


public class LoginActivity extends Activity {
	EditText inputUsername;
	EditText inputPassword;
	TextView loginErrorMsg;
	ProgressBar loginProgress;
	View myView;
	LoginPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		//initializing the presenter
		presenter = new LoginPresenter(this);

		//Parse Stuff - Copy and Paste this into every onCreate method to be able to use Parse
		presenter.initialize();

		//Getting the view associated with this Activity
		myView = getWindow().getDecorView().findViewById(android.R.id.content);
		// Importing all assets like buttons, text fields
		inputUsername		= (EditText) findViewById(R.id.loginUsername);
		inputPassword		= (EditText) findViewById(R.id.loginPassword);
		loginErrorMsg		= (TextView) findViewById(R.id.login_error);
		loginProgress		= (ProgressBar) findViewById(R.id.progress);
		presenter.setProgressSpinnerInvisible(loginProgress);
	}

	/**
	 * On click login button - if success go to StartActivity, on fail show error messages
	 * TODO: maybe not a good method, create smaller method with more specific tasks
	 * @param view - the view
	 */
	public void onClickLogin(View view) {
		//TODO: the spinners doesn't work properly yet :(

		//Show the progress spinner
		presenter.showProgressSpinner(myView, loginProgress);
		
		//login
		try {
			presenter.login(inputUsername.getText().toString().toLowerCase(), inputPassword.getText().toString());
		} catch (DatabaseException e) {
			//maybe not proberly implemented "design pattern-wise" ... @anton
			//e.getCode() doesn't work - not sure why. I want to use an "universal" error handling system through ErrorMessage.java
			Log.d("Error Code", Integer.toString(e.getCode()));
			loginErrorMsg.setText(presenter.generateErrorMessage(e.getCode()));
		}
		//Hide the progress spinner
		presenter.hideProgressSpinner(myView, loginProgress);
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


public String catchException(String exception) {
	// TODO Auto-generated method stub
	return exception;
}
}
