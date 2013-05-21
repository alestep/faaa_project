package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.RegisterPresenter;


public class RegisterActivity extends GenericActivity {
	
	Button btnRegister;
	Button btnLinkToLogin;
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
		
		// Set the presenter
		presenter = new RegisterPresenter(this);

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


		presenter.registerUser(
				inputNickname.getText().toString(),
				inputEmail.getText().toString().toLowerCase(),
				inputPassword.getText().toString(),
				inputRepeatPassword.getText().toString());

		//Hide the progress spinner
		presenter.hideProgressSpinner(myView, registerProgress);
	}

	/**
	 * Go to login screen
	 * @param view
	 */
	public void onClickLogin(View view) {
		presenter.goToLoginActivity();
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return registerErrorMsg;
	}
}
