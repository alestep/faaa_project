package com.example.wecharades.presenter;

import android.content.Context;

import com.example.wecharades.model.DatabaseException;

public class LoginPresenter extends Presenter{
	private Context context;
	public LoginPresenter(Context context) {
		//TODO: not sure if this is correct...@anton
		super(context);
		this.context = context;
	}
	
	public void login(String username, String password){
			try {
				Database.loginPlayer(username, password);
			} catch (DatabaseException e) {
				//TODO: better error managing
				showToast(context, e.getMessage());
			}
	}
}
