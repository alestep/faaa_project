package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.R;
import com.example.wecharades.presenter.LoginPresenter;


public class LoginActivity extends GenericActivity {
	EditText inputUsername;
	EditText inputPassword;
	TextView loginErrorMsg;
	ProgressBar loginProgress;
	View myView;
	LoginPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new LoginPresenter(this));
		setContentView(R.layout.login);

		// Importing all assets like buttons, text fields
		inputUsername		= (EditText) findViewById(R.id.loginUsername);
		inputPassword		= (EditText) findViewById(R.id.loginPassword);
		loginErrorMsg		= (TextView) findViewById(R.id.login_error);
		loginProgress		= (ProgressBar) findViewById(R.id.progress);
		
		//Getting the view associated with this Activity
		myView = getWindow().getDecorView().findViewById(android.R.id.content);
		
		//initializing the presenter
		presenter = (LoginPresenter) super.getPresenter();

		presenter.setProgressSpinnerInvisible(loginProgress);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		inputUsername.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_NEXT) {
					TextView nextField = (TextView) inputUsername.focusSearch(View.FOCUS_DOWN);
					nextField.requestFocus();
					return true;
				} else {
					return false;
				}
			}
		});
		
		inputPassword.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					onClickLogin(v);
					return true;
				} else {
					return false;
				}
			}
		});
	}

	/**
	 * On click login button - if success go to StartActivity, on fail show error messages
	 * TODO: maybe not a good method, create smaller method with more specific tasks
	 * @param view - the view
	 */
	public void onClickLogin(View view) {
		presenter.login(inputUsername.getText().toString().toLowerCase(), inputPassword.getText().toString(), myView, loginProgress);

	}
	/**
	 * Link to the screen to get a new password
	 * @param view
	 */
	public void onClickForgotPassword(View view) {
		Intent i = new Intent(getApplicationContext(),
				ResetPasswordActivity.class);
		startActivity(i);
		//finish();
	}
	
	/**
	 * Link to register screen
	 * @param view
	 */
	public void onClickRegister(View view) {
		Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
		startActivity(i);
		//finish();
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return loginErrorMsg;
	}
	
}
