package com.example.wecharades.presenter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.R;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.RegisterActivity;
import com.example.wecharades.views.StartActivity;

public class RegisterPresenter extends Presenter {

	private RegisterActivity activity;
	private String inputNickname;
	private String inputEmail;
	private String inputPassword;
	private String inputRepeatPassword;
	private View parentView;
	private DatabaseException dbException;

	public RegisterPresenter(RegisterActivity activity) {
		super(activity);
		this.activity = activity;
		parentView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
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

		private int exceptionState = 0;
		private final static int NO_EXCEPTION = 0;
		private final static int CAUGHT_EXCEPTION = 1;

		public RegisterTask(){

		}
		@Override
		protected void onPreExecute(){
			//Show the progress spinner
			activity.showProgressSpinner(getAllChildren(parentView));
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
				
				final Dialog dialog = new Dialog(activity);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
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
			activity.hideProgressSpinner(getAllChildren(parentView));
		}
	}
}
