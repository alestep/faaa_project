package com.example.wecharades.views;

import com.example.wecharades.R;
import com.example.wecharades.presenter.Presenter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.wecharades.presenter.RegisterPresenter;


public class RegisterActivity extends Activity {
	EditText inputNickname;
	EditText inputEmail;
	EditText inputPassword;
	EditText inputRepeatPassword;
	TextView registerErrorMsg;
	ProgressBar registerProgress;
	View myView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		//Getting the view associated with this Activity
		myView = getWindow().getDecorView().findViewById(android.R.id.content);
		//initializing parse.com connection
		RegisterPresenter.initialize(this);

		// Importing all assets like buttons, text fields
		inputNickname 		=	(EditText) 		findViewById(R.id.registerName);
		inputEmail 			=	(EditText) 		findViewById(R.id.registerEmail);
		inputPassword 		=	(EditText) 		findViewById(R.id.registerPassword);
		inputRepeatPassword =	(EditText) 		findViewById(R.id.registerRepeatPassword);
		registerErrorMsg 	=	(TextView) 		findViewById(R.id.register_error);
		registerProgress 	=	(ProgressBar) 	findViewById(R.id.progress);
		Presenter.setProgressSpinnerInvisible(registerProgress);

	}
	
	/**
	 * Registers a new user - if success go to the StartScreen, if fail show error messages
	 * @param view
	 */
	public void onClickRegister(View view) {

		//Show the progress spinner
		Presenter.showProgressSpinner(myView, registerProgress);
		RegisterPresenter.registerUser(
				getBaseContext(), inputNickname.getText().toString(),
				inputEmail.getText().toString().toLowerCase(),
				inputPassword.getText().toString(),
				inputRepeatPassword.getText().toString());
		//Hide the progress spinner
		Presenter.hideProgressSpinner(myView, registerProgress);
	}

	/**
	 * Go to login screen
	 * @param view
	 */
	public void onClickLogin(View view) {
		Intent i = new Intent(getApplicationContext(), LoginActivity.class);
		startActivity(i);
		// Close Registration View
		finish();
	}
}
