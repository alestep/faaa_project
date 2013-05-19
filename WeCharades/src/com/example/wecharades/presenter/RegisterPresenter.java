package com.example.wecharades.presenter;

import android.app.Activity;
import android.content.Intent;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.StartScreen;

public class RegisterPresenter extends Presenter {

	private Activity activity;
	public RegisterPresenter(Activity activity) {
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
	public void registerUser(String inputNickname, String inputEmail, String inputPassword, String inputRepeatPassword) throws DatabaseException {
		boolean loginSucceeded = false;
		try {
			Database.registerPlayer(inputNickname, inputEmail, inputPassword, inputRepeatPassword);
			loginSucceeded = true;
		} catch (DatabaseException e) {
			//TODO: e.getCode() not working. - Want it to work to be able to use ErrorMessage.java in the model package
			throw new DatabaseException(e.getCode(), e.getMessage());
			//showToast(activity.getApplicationContext() , e.getMessage());
		} finally {
			if(loginSucceeded) {
				Intent i = new Intent(activity.getApplicationContext(), StartScreen.class);
				activity.startActivity(i);
				activity.finish();
			}
		}
	}
}
