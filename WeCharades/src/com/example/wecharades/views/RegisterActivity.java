package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.LoadProgressBar;
import com.example.wecharades.presenter.RegisterPresenter;


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
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.register);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_other); 
		
		// Get references to instances
		presenter 			= 	(RegisterPresenter) super.getPresenter();
		inputNickname 		=	(EditText) 		findViewById(R.id.registerName);
		inputEmail 			=	(EditText) 		findViewById(R.id.registerEmail);
		inputPassword 		=	(EditText) 		findViewById(R.id.registerPassword);
		inputRepeatPassword =	(EditText) 		findViewById(R.id.registerRepeatPassword);
		registerProgress 	=	new LoadProgressBar(this, (ProgressBar)	findViewById(R.id.progress));
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
				inputRepeatPassword.getText().toString());	
	}

	@Override
	protected LoadProgressBar getProgressBar() {
		return registerProgress;
	}
}
