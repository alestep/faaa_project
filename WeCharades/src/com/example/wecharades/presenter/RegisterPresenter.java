package com.example.wecharades.presenter;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.LoadProgressBar;
import com.example.wecharades.views.RegisterActivity;
import com.example.wecharades.views.StartActivity;

public class RegisterPresenter extends Presenter {

	private RegisterActivity activity;
	private String inputNickname;
	private String inputEmail;
	private String inputPassword;
	private String inputRepeatPassword;
	private DatabaseException dbException;

	public RegisterPresenter(RegisterActivity activity) {
		super(activity);
		this.activity = activity;
	}

	/**
	 * Method called when the user clicks the register button
	 * @param context
	 * @param inputNickname
	 * @param inputEmail
	 * @param inputPassword
	 * @param inputRepeatPassword
	 */
	public void registerUser(String inputNickname, String inputEmail, String inputPassword, String inputRepeatPassword) {
		this.inputNickname = inputNickname;
		this.inputEmail = inputEmail;
		this.inputPassword = inputPassword;
		this.inputRepeatPassword = inputRepeatPassword;
		RegisterTask register = new RegisterTask();
		register.execute();
	}

	public void setListeners(EditText repeatPassword) {
		repeatPassword.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					activity.onClickRegister(v);
					return true;
				} else {
					return false;
				}
			}
		});

	}

	private class RegisterTask extends AsyncTask<Void, Long, Boolean>{

		public RegisterTask(){

		}
		@Override
		protected void onPreExecute(){
			//Show the progress spinner
			activity.showProgressBar();
			activity.disableView();
		}

		@Override
		protected Boolean doInBackground(Void... arg0) {
			boolean registerSucceeded = false;
			try {
				dc.registerPlayer(inputNickname, inputEmail, inputPassword, inputRepeatPassword);
				registerSucceeded = true;
			} catch (DatabaseException e) {
				dbException = e;
			}
			finally {
				if(registerSucceeded) {
					Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
					activity.startActivity(i);
					activity.finish();
				}
			}
			return null;
		}

		@Override
		protected void onPostExecute(Boolean result){
			if(dbException != null){
				activity.showNegativeDialog("Error", dbException.prettyPrint(), "OK");
			}
			activity.hideProgressBar();
			activity.enabledView();
		}
	}
}
