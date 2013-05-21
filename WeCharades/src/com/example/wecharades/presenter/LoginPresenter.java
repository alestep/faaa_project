package com.example.wecharades.presenter;

import android.content.Intent;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;

public class LoginPresenter extends Presenter{
	
	private LoginActivity activity;
	
	public LoginPresenter(LoginActivity activity) {
		super(activity);
		this.activity = (LoginActivity) activity;
	}

	public void login(String username, String password){
		try {
			//If this fails, the user will get a message and the subsequent code will not be run
			db.loginPlayer(username, password);
			//saves the current player in the model if successfull!
			model.setCurrentPlayer();
			Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
			activity.startActivity(i);
			activity.finish();//We do not need the login-activity any more
		} catch (DatabaseException e) {
			activity.showMessage(e.prettyPrint());
		}
		//TODO: couldn't find a better solution at this point - remove this comment if it's "good enough"
		//Because db.loginPlayer is the method that throws the error, we could simply continue with the rest of code.
		// A finally-block should only be used if you want the code to be executed regardless of the result. 
		// Se my solution above :-)
		/*boolean loginSucceeded = false;
		try {
			db.loginPlayer(username, password);
			loginSucceeded = true;
		} catch (DatabaseException e) {
			activity.showMessage(e.prettyPrint());
		} finally {
			if(loginSucceeded) {
				Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
				activity.startActivity(i);
				activity.finish();
			}
		}*/
	}
}
