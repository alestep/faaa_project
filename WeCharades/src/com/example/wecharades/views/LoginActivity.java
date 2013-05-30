package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.wecharades.R;
import com.example.wecharades.presenter.LoginPresenter;

/**
 * View which displays the login screen
 * @author weCharade
 */
public class LoginActivity extends GenericActivity {
	
	private EditText inputUsername;
	private EditText inputPassword;
	private LoadProgressBar loginProgress;
	private LoginPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new LoginPresenter(this));
		setContentView(R.layout.login);

		//Get references to instances
		inputUsername = (EditText) findViewById(R.id.login_username);
		inputPassword = (EditText) findViewById(R.id.login_password);
		presenter = (LoginPresenter) super.getPresenter();
		
		/*
		 * This class uses a LoadProgressBar to visualize that data is fetched in the background
		 */
		loginProgress = new LoadProgressBar((ProgressBar) findViewById(R.id.progress));

	}

	@Override
	public void onStart() {
		super.onStart();
		presenter.setListeners(inputPassword);
	}

	/**
	 * On click login button - if success go to StartActivity, else an error message is shown
	 * @param view - the view
	 */
	public void onClickLogin(View view) {
		//Retrieve input texts from username and password fields
		presenter.login(inputUsername.getText().toString().toLowerCase(), inputPassword.getText().toString());
	}
	
	/**
	 * Go to the screen to get a new password
	 * @param view
	 */
	public void onClickForgotPassword(View view) {
		Intent i = new Intent(getApplicationContext(), ResetPasswordActivity.class);
		startActivity(i);
	}

	/**
	 * Go to register screen
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
