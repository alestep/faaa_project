package com.example.wecharades.views;

import com.example.wecharades.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.presenter.RegisterPresenter;


public class RegisterActivity extends Activity {
	EditText inputNickname;
	EditText inputEmail;
	EditText inputPassword;
	EditText inputRepeatPassword;
	TextView registerErrorMsg;
	ProgressBar registerProgress;
	View myView;
	RegisterPresenter presenter;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		//initializing the presenter
		presenter = new RegisterPresenter(this);

		//Parse Stuff - Copy and Paste this into every onCreate method to be able to use Parse
		presenter.initialize();

		//Getting the view associated with this Activity
		myView = getWindow().getDecorView().findViewById(android.R.id.content);

		// Importing all assets like buttons, text fields
		inputNickname 		=	(EditText) 		findViewById(R.id.registerName);
		inputEmail 			=	(EditText) 		findViewById(R.id.registerEmail);
		inputPassword 		=	(EditText) 		findViewById(R.id.registerPassword);
		inputRepeatPassword =	(EditText) 		findViewById(R.id.registerRepeatPassword);
		registerErrorMsg 	=	(TextView) 		findViewById(R.id.register_error);
		registerProgress 	=	(ProgressBar) 	findViewById(R.id.progress);
		presenter.setProgressSpinnerInvisible(registerProgress);

	}

	/**
	 * Registers a new user - if success go to the StartScreen, if fail show error messages
	 * @param view
	 */
	public void onClickRegister(View view) {
		//TODO: progress spinners doesn't work yet!
		//Show the progress spinner
		presenter.showProgressSpinner(myView, registerProgress);
		try {
			presenter.registerUser(
					inputNickname.getText().toString(),
					inputEmail.getText().toString().toLowerCase(),
					inputPassword.getText().toString(),
					inputRepeatPassword.getText().toString());
		} catch (DatabaseException e) {
			registerErrorMsg.setText(presenter.generateErrorMessage(e.getCode()));
		}
		//Hide the progress spinner
		presenter.hideProgressSpinner(myView, registerProgress);
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
