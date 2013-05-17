package com.example.wecharades.presenter;

import android.content.Context;

import com.example.wecharades.model.DatabaseException;

public class LoginPresenter extends Presenter{
	
	public static void login(Context context, String username, String password){
			try {
				Database.loginPlayer(username, password);
			} catch (DatabaseException e) {
				showToast(context, e.getMessage());
			}
	}
}
