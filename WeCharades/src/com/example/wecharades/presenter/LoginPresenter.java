/**
 * @authos
 */
package com.example.wecharades.presenter;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.R;
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
		private final static int NO_EXCEPTION = 0;
		private final static int CAUGHT_EXCEPTION = 1;

		public Login(){

		}
		@Override
		protected void onPreExecute(){
			//Show the progress spinner
			activity.showProgressSpinner();
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

				final Dialog dialog = new Dialog(activity);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setCanceledOnTouchOutside(false);
				dialog.setContentView(R.layout.dialog_error);
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));               

				TextView errorText = (TextView) dialog.findViewById(R.id.errorText);
				errorText.setText(dbException.prettyPrint());

				Button ok = (Button) dialog.findViewById(R.id.ok);
				ok.setOnClickListener(new OnClickListener() {          
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				
				dialog.show();
				exceptionState = NO_EXCEPTION;
			}
			activity.hideProgressSpinner();
			activity.enabledView();
		}
	}
}

