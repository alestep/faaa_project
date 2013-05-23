package com.example.wecharades.presenter;


import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.ResetPasswordActivity;
	

public class ResetPresenter extends Presenter {

	private ResetPasswordActivity activity;
	private String email;
	private View myView;
	private ProgressBar resetProgress;
	private DatabaseException dbException;
	
	public ResetPresenter(ResetPasswordActivity activity) {
		super(activity);
		this.activity = activity;
	}
	
	public void resetPassword(String email, View myView, ProgressBar resetProgress) {
		this.email = email;
		this.myView = myView;
		this.resetProgress = resetProgress;
		ResetPasswordTask reset = new ResetPasswordTask();
		reset.execute();
		
	}

	public void goToRegisterActivity() {
		Intent i = new Intent(activity.getApplicationContext(), LoginActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		activity.startActivity(i);
		// Close Registration View
		activity.finish();
	}
	
	private class ResetPasswordTask extends AsyncTask<Void, Long, Boolean>{

		private int exceptionState = 0;
		private final static int NO_EXCEPTION = 0;
		private final static int CAUGHT_EXCEPTION = 1;

		public ResetPasswordTask(){

		}
		@Override
		protected void onPreExecute(){
			//Show the progress spinner
			showProgressSpinner(myView, resetProgress);
		}

		@Override
		protected Boolean doInBackground(Void... arg0) {
			try {
				dc.resetPassword(email);
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
			}
			else{
				activity.showSuccessMessage("You got mail!");
			}
			exceptionState = NO_EXCEPTION;
			hideProgressSpinner(myView, resetProgress);
		}
	}
}