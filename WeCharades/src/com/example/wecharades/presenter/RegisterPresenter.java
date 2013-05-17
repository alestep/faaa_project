package com.example.wecharades.presenter;

import android.content.Context;

import com.example.wecharades.model.DatabaseException;

public class RegisterPresenter extends Presenter {
	
	private Context context;
	public RegisterPresenter(Context context) {
		//TODO: not sure if this is correct... @anton
		super(context);
		this.context = context;
	}
	

	/**
	 * Method called when the user clicks the register button
	 * @param context
	 * @param inputNickname
	 * @param inputEmail
	 * @param inputPassword
	 * @param inputRepeatPassword
	 */
	public void registerUser(String inputNickname, String inputEmail, String inputPassword, String inputRepeatPassword){
		try {
			Database.registerPlayer(inputNickname, inputEmail, inputPassword, inputRepeatPassword);
		} catch (DatabaseException e) {
			//TODO: better error managing
			showToast(context, e.getMessage());
		}
	}
}
