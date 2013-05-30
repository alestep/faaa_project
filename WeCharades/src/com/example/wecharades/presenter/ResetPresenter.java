package com.example.wecharades.presenter;


import android.os.AsyncTask;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.ResetPasswordActivity;

/**
 * Presenter-class intended to manage reset of user's password procedure and related information handling
 * @author weCharade
 */
public class ResetPresenter extends Presenter {

	private ResetPasswordActivity activity;
	private String email;
	private DatabaseException dbException;
	
	/**
	 * Create an instance of ResetPresenter
	 * @param activity
	 */
	public ResetPresenter(ResetPasswordActivity activity) {
		super(activity);
		this.activity = activity;
	}
	
	/**
	 * Listen for press Done-button on keyboard
	 * @param emailInput
	 */
	public void setListeners(EditText emailInput) {		
		emailInput.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					//Reset password if button is pressed
					activity.onClickResetPassword(v);
					return true;
				} else {
					return false;
				}
			}
		});

	}

	/**
	 * Reset the password
	 * @param email
	 */
	public void resetPassword(String email) {
		this.email = email;
		
		//Initiates the reset password process
		ResetPasswordTask reset = new ResetPasswordTask();
		reset.execute();
	}
	
	/**
	 * Private inner class managing reset password process
	 * @author weCharade
	 */
	private class ResetPasswordTask extends AsyncTask<Void, Long, Boolean>{

		private int exceptionState = 0;
		private final static int NO_EXCEPTION = 0;
		private final static int CAUGHT_EXCEPTION = 1;
		
		@Override
		protected void onPreExecute(){
			//Indicate that data is processed
			activity.showProgressBar();
			activity.disableView();
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
				//Error was received during reset password process
				activity.showNegativeDialog("Error", dbException.prettyPrint(), "OK");
			}
			else{
				//Email was successfully sent and a toast is displayed to the user
				activity.showToast("Email has been sent");
				
				//Leave this activity and go to LoginActivity
				goToLoginActivity();
			}
			exceptionState = NO_EXCEPTION;
			activity.hideProgressBar();
			activity.enabledView();
		}
	}
}