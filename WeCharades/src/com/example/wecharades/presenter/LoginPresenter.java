package com.example.wecharades.presenter;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;

/**
 * Presenter-class intended to manage the Login-procedure and related information handling
 * @author weCharade
 */
public class LoginPresenter extends Presenter{

	private LoginActivity activity;
	private String username;
	private String password;

	public LoginPresenter(LoginActivity activity) {
		super(activity);
		this.activity = activity;
	}
	
	/**
	 * Listen for press Done-button on keyboard
	 * @param password
	 */
	public void setListeners(EditText password) {		
		password.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					//Login if button is pressed
					activity.onClickLogin(v);
					return true;
				} else {
					return false;
				}
			}
		});

	}

	/**
	 * Login the user
	 * @param username
	 * @param password
	 */
	public void login(String username, String password){
		this.username = username;
		this.password = password;
		
		//Initiates the login process
		Login login = new Login();
		login.execute();
	}

	/**
	 * Private inner class managing login process
	 * @author weCharade
	 */
	private class Login extends AsyncTask<Void, Long, Boolean>{

		private DatabaseException dbException = null;

		public Login(){
		}
		@Override
		protected void onPreExecute(){
			//Indicate that data is processed
			activity.showProgressBar();
			activity.disableView();
		}

		@Override
		protected Boolean doInBackground(Void... arg0) {
			boolean loginSucceeded = false;
			try {
				
				//Send login information to DataController
				dc.loginPlayer(activity, username, password);
				loginSucceeded = true;
				
			} catch (DatabaseException e) {
				dbException = e;
			}
			finally{
				if(loginSucceeded){
					
					//Go to StartActivity
					Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
					activity.startActivity(i);
					
					//We do not need the login-activity any more
					activity.finish();
					
				}
			}
			return null;
		}
		@Override
		protected void onPostExecute(Boolean result){
			if(dbException != null){
				//Error was received during login-process
				activity.showNegativeDialog("Error", dbException.prettyPrint(), "OK");
			}
			activity.hideProgressBar();
			activity.enabledView();
		}
	}
}

