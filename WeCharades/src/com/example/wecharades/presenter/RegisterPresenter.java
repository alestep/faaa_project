package com.example.wecharades.presenter;

import android.content.Context;

import com.example.wecharades.model.DatabaseException;

public class RegisterPresenter extends Presenter {
	

	/**
	 * Method called when the user clicks the register button
	 * @param context
	 * @param inputNickname
	 * @param inputEmail
	 * @param inputPassword
	 * @param inputRepeatPassword
	 */
	public static void registerUser(Context context, String inputNickname, String inputEmail, String inputPassword, String inputRepeatPassword){
		try {
			Database.registerPlayer(inputNickname, inputEmail, inputPassword, inputRepeatPassword);
		} catch (DatabaseException e) {
			showToast(context, e.getMessage());
		}
	}
}
