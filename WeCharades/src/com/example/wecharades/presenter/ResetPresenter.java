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
import com.example.wecharades.views.ResetPasswordActivity;
import com.example.wecharades.views.StartActivity;


public class ResetPresenter extends Presenter {

	private ResetPasswordActivity activity;
	private String email;
	private View parentView;
	private DatabaseException dbException;

	public ResetPresenter(ResetPasswordActivity activity) {
		super(activity);
		this.activity = activity;
		parentView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
	}

	public void resetPassword(String email, View myView, ProgressBar resetProgress) {
		this.email = email;
		ResetPasswordTask reset = new ResetPasswordTask();
		reset.execute();
		goToLoginActivity();

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
			activity.showProgressSpinner(getAllChildren(parentView));
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
			}
			else{

				AlertDialog.Builder builder = new AlertDialog.Builder(activity);
				builder.setTitle("Success!")
				.setMessage("You got mail!")
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Intent i = new Intent(activity.getApplicationContext(), StartActivity.class);
						activity.startActivity(i);
						activity.finish(); //We do not need the activity anymore
						dialog.cancel();
					}
				});
				AlertDialog alert = builder.create();
				alert.show();
			}
			exceptionState = NO_EXCEPTION;
			activity.hideProgressSpinner(getAllChildren(parentView));
		}
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
}