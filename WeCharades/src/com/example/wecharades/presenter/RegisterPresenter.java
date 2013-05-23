package com.example.wecharades.presenter;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.RegisterActivity;
import com.example.wecharades.views.StartActivity;

public class RegisterPresenter extends Presenter {

	private RegisterActivity activity;
	private String inputNickname;
	private String inputEmail;
	private String inputPassword;
	private String inputRepeatPassword;
	private View myView;
	private ProgressBar registerProgress;
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
	public void registerUser(String inputNickname, String inputEmail, String inputPassword, String inputRepeatPassword, View myView, ProgressBar registerProgress) {
		this.inputNickname = inputNickname;
		this.inputEmail = inputEmail;
		this.inputPassword = inputPassword;
		this.inputRepeatPassword = inputRepeatPassword;
		this.myView = myView;
		this.registerProgress = registerProgress;
		RegisterTask register = new RegisterTask();
		register.execute();
	}

	private class RegisterTask extends AsyncTask<Void, Long, Boolean>{

		private int exceptionState = 0;
		private final static int NO_EXCEPTION = 0;
		private final static int CAUGHT_EXCEPTION = 1;

		public RegisterTask(){

		}
		@Override
		protected void onPreExecute(){
			//Show the progress spinner
			showProgressSpinner(myView, registerProgress);
		}

		@Override
		protected Boolean doInBackground(Void... arg0) {
			boolean registerSucceeded = false;
			try {
				dc.registerPlayer(inputNickname, inputEmail, inputPassword, inputRepeatPassword);
				registerSucceeded = true;
			} catch (DatabaseException e) {
				dbException = e;
				exceptionState = CAUGHT_EXCEPTION;
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
			if(exceptionState == CAUGHT_EXCEPTION){
				activity.showMessage(dbException.prettyPrint());
				exceptionState = NO_EXCEPTION;
			}
			hideProgressSpinner(myView, registerProgress);
		}
	}
}
