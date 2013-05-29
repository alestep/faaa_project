package com.example.wecharades.presenter;


import android.os.AsyncTask;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.ResetPasswordActivity;


public class ResetPresenter extends Presenter {

	private ResetPasswordActivity activity;
	private String email;
	//TODO private View parentView;
	private DatabaseException dbException;

	public ResetPresenter(ResetPasswordActivity activity) {
		super(activity);
		this.activity = activity;
	}

	public void resetPassword(String email) {
		this.email = email;
		ResetPasswordTask reset = new ResetPasswordTask();
		reset.execute();

	}
	
	public void setListeners(EditText emailInput) {		
		emailInput.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					activity.onClickResetPassword(v);
					return true;
				} else {
					return false;
				}
			}
		});

	}

	private class ResetPasswordTask extends AsyncTask<Void, Long, Boolean>{

		private int exceptionState = 0;
		private final static int NO_EXCEPTION = 0;
		private final static int CAUGHT_EXCEPTION = 1;
		
		@Override
		protected void onPreExecute(){
			//Show the progress spinner
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
				activity.showNegativeDialog("Error", dbException.prettyPrint(), "OK");
			}
			else{
				activity.showToast("Email has been sent");
				goToLoginActivity();
			}
			exceptionState = NO_EXCEPTION;
			activity.hideProgressBar();
			activity.enabledView();
		}
	}
}