/**
 * @authos
 */
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

public class LoginPresenter extends Presenter{

	private LoginActivity activity;
	private String username;
	private String password;
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

	public void login(String username, String password){
		this.username = username;
		this.password = password;
		Login login = new Login();
		login.execute();
	}

	private class Login extends AsyncTask<Void, Long, Boolean>{

		private int exceptionState = 0;
		private DatabaseException dbException = null;

		public Login(){
		}
		@Override
		protected void onPreExecute(){
			//Show the progress spinner
			activity.showProgressBar();
			activity.disableView();
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
			if(dbException != null){
				activity.showErrorDialog(dbException.prettyPrint());
			}
			activity.hideProgressBar();
			activity.enabledView();
		}
	}
}

