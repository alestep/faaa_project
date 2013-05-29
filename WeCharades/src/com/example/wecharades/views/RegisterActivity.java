package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.wecharades.R;
import com.example.wecharades.presenter.RegisterPresenter;

/**
 * View which displays the registration screen
 * @author weCharade
 */
public class RegisterActivity extends GenericActivity {
	
	private EditText inputNickname;
	private EditText inputEmail;
	private EditText inputPassword;
	private EditText inputRepeatPassword;
	private LoadProgressBar registerProgress;
	private RegisterPresenter presenter;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new RegisterPresenter(this));
		
		//Set the title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.register);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_back); 
		
		// Get references to instances
		presenter = (RegisterPresenter) super.getPresenter();
		inputNickname = (EditText) findViewById(R.id.registerName);
		inputEmail = (EditText) findViewById(R.id.registerEmail);
		inputPassword =	(EditText) findViewById(R.id.registerPassword);
		inputRepeatPassword = (EditText) findViewById(R.id.registerRepeatPassword);
		
		/*
		 * This class uses a LoadProgressBar to visualize that data is fetched in the background
		 */
		registerProgress = new LoadProgressBar(this, (ProgressBar) findViewById(R.id.progress));
	}
	
	@Override
	public void onStart() {
		super.onStart();
		presenter.setListeners(inputRepeatPassword);
	}

	/**
	 * Registers a new user - if success go to the StartScreen, else an error message shown
	 * @param view
	 */
	public void onClickRegister(View view) {
		presenter.registerUser(
				inputNickname.getText().toString(),
				inputEmail.getText().toString().toLowerCase(),
				inputPassword.getText().toString(),
				inputRepeatPassword.getText().toString());	
	}
	
	/**
	 * Go back to Login screen
	 * @param v
	 */
	public void onClickBack(View v){
		presenter.goToLoginActivity();
	}

	@Override
	protected LoadProgressBar getProgressBar() {
		return registerProgress;
	}
}
