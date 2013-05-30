package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.wecharades.R;
import com.example.wecharades.presenter.ResetPresenter;

/**
 * View which displays makes it possible for a user to reset and receive a new password by email
 * @author weCharade
 */
public class ResetPasswordActivity extends GenericActivity {

	private EditText emailInput;
	private LoadProgressBar resetProgress;
	private ResetPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new ResetPresenter(this));
		
		//Set the title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.resetpassword);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_back); 
		
		//Get references to instances
		presenter = (ResetPresenter) super.getPresenter();
		emailInput = (EditText) findViewById(R.id.resetPassword);
		
		/*
		 * This class uses a LoadProgressBar to visualize that data is fetched in the background
		 */
		resetProgress = new LoadProgressBar(this, (ProgressBar) findViewById(R.id.progress));
	}

	@Override
	public void onStart(){
		super.onStart();
		presenter.setListeners(emailInput);
	}

	/**
	 * The user should enter his or her e-mail to receive a new password
	 * @param view
	 */
	public void onClickResetPassword(View view) {
		presenter.resetPassword(emailInput.getText().toString());
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
		return resetProgress;
	}
}