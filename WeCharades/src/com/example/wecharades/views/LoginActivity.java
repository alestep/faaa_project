package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.LoadProgressBar;
import com.example.wecharades.presenter.LoginPresenter;


public class LoginActivity extends GenericActivity {
	EditText inputUsername;
	EditText inputPassword;
	TextView loginErrorMsg;
	LoadProgressBar loginProgress;
	View myView;
	LoginPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new LoginPresenter(this));
		setContentView(R.layout.login);

		// Importing all assets like buttons, text fields
		inputUsername		= (EditText) findViewById(R.id.login_username);
		inputPassword		= (EditText) findViewById(R.id.login_password);
		loginProgress		= new LoadProgressBar(this, (ProgressBar) findViewById(R.id.progress));

		//initializing the presenter
		presenter = (LoginPresenter) super.getPresenter();
	}

	@Override
	public void onStart() {
		super.onStart();
		presenter.setListeners(inputPassword);
	}

	/**
	 * On click login button - if success go to StartActivity, on fail show error messages
	 * TODO: maybe not a good method, create smaller method with more specific tasks
	 * @param view - the view
	 */
	public void onClickLogin(View view) {
		presenter.login(inputUsername.getText().toString().toLowerCase(), inputPassword.getText().toString());

	}
	/**
	 * Link to the screen to get a new password
	 * @param view
	 */
	public void onClickForgotPassword(View view) {
		Intent i = new Intent(getApplicationContext(), ResetPasswordActivity.class);
		startActivity(i);
	}

	/**
	 * Link to register screen
	 * @param view
	 */
	public void onClickRegister(View view) {
		Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
		startActivity(i);
	}

	@Override
	protected LoadProgressBar getProgressBar() {
		return loginProgress;
	}
}
