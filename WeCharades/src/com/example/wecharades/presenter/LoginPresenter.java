package com.example.wecharades.presenter;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;

public class LoginPresenter extends Presenter{

	private LoginActivity activity;
	private String username;
	private String password;
	private View myView;
	private ProgressBar loginProgress;
	private DatabaseException dbException;

	public LoginPresenter(LoginActivity activity) {
		super(activity);
		this.activity = activity;
	}

	public void login(String username, String password, View myView, ProgressBar loginProgress){
		this.username = username;
		this.password = password;
		this.myView = myView;
		this.loginProgress = loginProgress;
		Login login = new Login();
		login.execute();
	}
	private class Login extends AsyncTask<Void, Long, Boolean>{

		private int exceptionState = 0;
		private final static int INITIAL_MODE = 0;
		private final static int CAUGHT_EXCEPTION = 1;

		public Login(){

		}
		@Override
		protected void onPreExecute(){
			//Show the progress spinner
			showProgressSpinner(myView, loginProgress);
		}

		@Override
		protected Boolean doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			try {
				//If this fails, the user will get a message and the subsequent code will not be run
				dc.loginPlayer(activity, username, password);
				Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
				activity.startActivity(i);
				activity.finish();//We do not need the login-activity any more
			} catch (DatabaseException e) {
				dbException = e;
				exceptionState = CAUGHT_EXCEPTION;
			}	
			return null;
		}
		@Override
		protected void onPostExecute(Boolean result){
			if(exceptionState == CAUGHT_EXCEPTION){
				activity.showMessage(dbException.prettyPrint());
				exceptionState = INITIAL_MODE;
			}

			//Hide the progress spinner
			hideProgressSpinner(myView, loginProgress);
		}
	}
}
