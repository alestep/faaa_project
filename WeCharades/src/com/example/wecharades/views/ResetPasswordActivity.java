package com.example.wecharades.views;

import com.example.wecharades.R;
import com.example.wecharades.R.id;
import com.example.wecharades.R.layout;
import com.example.wecharades.model.DatabaseException;
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


public class ResetPasswordActivity extends GenericActivity {

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
		presenter = new ResetPresenter(this);

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
	public void onClickResetPassword(View view) {
		//TODO: progress spinner not working :(

		//Showing the progress spinner
		presenter.showProgressSpinner(myView, resetProgress);

		presenter.resetPassword(emailInput.getText().toString());

		//Hiding the progress spinner
		presenter.hideProgressSpinner(myView, resetProgress);


	}

	/**
	 * Go to login screen
	 * @param view
	 */
	public void onClickLoginScreen(View view) {
		presenter.goToLoginActivity();
	}

	/**
	 * Go to registration screen
	 * @param view
	 */
	public void onClickRegistrationScreen(View view) {
		presenter.goToRegisterActivity();
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return errorMsg;
	}

	public void showSuccessMessage(String message) {
		errorMsg.setTextColor(Color.parseColor("#458B00"));
		errorMsg.setText(message);
	}
}