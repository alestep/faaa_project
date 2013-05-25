package com.example.wecharades.presenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

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

	public void setListeners(EditText password) {		
		password.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					activity.onClickLogin(v);
					return true;
				} else {
					return false;
				}
			}
		});
		
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
		private final static int NO_EXCEPTION = 0;
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
			boolean loginSucceeded = false;
			try {
				dc.loginPlayer(activity, username, password);
				Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
				activity.startActivity(i);
				activity.finish();//We do not need the login-activity any more
			} catch (DatabaseException e) {
				dbException = e;
				exceptionState = CAUGHT_EXCEPTION;
			}
			finally{
				if(loginSucceeded){
					Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
					activity.startActivity(i);
					activity.finish();//We do not need the login-activity any more
				}
			}
			return null;
		}
		@Override
		protected void onPostExecute(Boolean result){
			if(exceptionState == CAUGHT_EXCEPTION){
				AlertDialog.Builder builder = new AlertDialog.Builder(activity);
				builder.setTitle("Error!")
				.setMessage(dbException.prettyPrint())
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
				AlertDialog alert = builder.create();
				alert.show();
				exceptionState = NO_EXCEPTION;
			}
			hideProgressSpinner(myView, loginProgress);	
		}
	}
}
