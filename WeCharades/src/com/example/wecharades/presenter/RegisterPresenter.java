package com.example.wecharades.presenter;

import android.content.Intent;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.RegisterActivity;
import com.example.wecharades.views.StartScreen;

public class RegisterPresenter extends Presenter {

	private RegisterActivity activity;
	public RegisterPresenter(RegisterActivity activity) {
		super(activity);
		this.activity = activity;
	}

	/**
	 * Method called when the user clicks the register button
	 * @param context
	 * @param inputNickname
	 * @param inputEmail
	 * @param inputPassword
	 * @param inputRepeatPassword
	 */
	public void registerUser(String inputNickname, String inputEmail, String inputPassword, String inputRepeatPassword) {
		boolean loginSucceeded = false;
		try {
			Database.registerPlayer(inputNickname, inputEmail, inputPassword, inputRepeatPassword);
			loginSucceeded = true;
		} catch (DatabaseException e) {
			activity.showErrorMessage(e.prettyPrint());
		} finally {
			if(loginSucceeded) {
				Intent i = new Intent(activity.getApplicationContext(), StartScreen.class);
				activity.startActivity(i);
				activity.finish();
			}
		}
	}
}
