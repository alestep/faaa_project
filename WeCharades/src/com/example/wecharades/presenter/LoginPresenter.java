package com.example.wecharades.presenter;

import android.content.Intent;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;

public class LoginPresenter extends Presenter{
	
	private LoginActivity activity;
	
	public LoginPresenter(LoginActivity activity) {
		super(activity);
		this.activity = activity;
	}

	public void login(String username, String password){
		try {
			//If this fails, the user will get a message and the subsequent code will not be run
			dc.loginPlayer(username, password);
			Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
			activity.startActivity(i);
			activity.finish();//We do not need the login-activity any more
		} catch (DatabaseException e) {
			activity.showMessage(e.prettyPrint());
		}
	}
}
