package com.example.wecharades.presenter;

import android.app.Activity;

import com.example.wecharades.model.DatabaseException;

public class LoginPresenter extends Presenter{
	private Activity activity;
	public LoginPresenter(Activity activity) {
		//TODO: not sure if this is correct...@anton
		super(activity);
		this.activity = activity;
	}
	//TODO: FIND A WAY TO SEND THE USER TO ANOTHER INTENT IF SUCCESSFUL OR FAIL!!!!
	public void login(String username, String password){
			try {
				Database.loginPlayer(username, password);
			} catch (DatabaseException e) {
				//TODO: better error managing
				showToast(activity.getApplicationContext(), e.getMessage());
			}
	}
}
