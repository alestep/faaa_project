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
	//View myView;
	RegisterPresenter presenter;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new RegisterPresenter(this));
		setContentView(R.layout.register);
		
		// Set the presenter
		presenter = (RegisterPresenter) super.getPresenter();

		//Getting the view associated with this Activity
		//myView = getWindow().getDecorView().findViewById(android.R.id.content);

		// Importing all assets like buttons, text fields
		inputNickname 		=	(EditText) 		findViewById(R.id.registerName);
		inputEmail 			=	(EditText) 		findViewById(R.id.registerEmail);
		inputPassword 		=	(EditText) 		findViewById(R.id.registerPassword);
		inputRepeatPassword =	(EditText) 		findViewById(R.id.registerRepeatPassword);
		registerProgress 	=	(ProgressBar) 	findViewById(R.id.progress);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		presenter.setListeners(inputRepeatPassword);
	}

	/**
	 * Registers a new user - if success go to the StartScreen, if fail show error messages
	 * @param view
	 */
	public void onClickRegister(View view) {
		presenter.registerUser(
				inputNickname.getText().toString(),
				inputEmail.getText().toString().toLowerCase(),
				inputPassword.getText().toString(),
				inputRepeatPassword.getText().toString(), registerProgress);	
	}

	@Override
	protected ProgressBar getProgressSpinner() {
		// TODO Auto-generated method stub
		return null;
	}
}
