package com.example.wecharades.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.ErrorMessage;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;

public class LoginPresenter extends Presenter{
	private LoginActivity activity;
	public LoginPresenter(Activity activity) {
		//TODO: implement some kind of if( activity instnaceof LoginActivity) function here, not sure how to do it right
		super(activity);
		this.activity = (LoginActivity) activity;
	}

	public void login(String username, String password){

		//TODO: couldn't find a better solution at this point - remove this comment if it's "good enough"
		boolean loginSucceeded = false;
		try {
			Database.loginPlayer(username, password);
			loginSucceeded = true;
		} catch (DatabaseException e) {
			activity.showErrorMessage(e.prettyPrint());
		} finally {
			if(loginSucceeded) {
				Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
				activity.startActivity(i);
				activity.finish();
			}
		}
	}
}
