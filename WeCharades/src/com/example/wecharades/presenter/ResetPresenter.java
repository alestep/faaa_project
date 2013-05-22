package com.example.wecharades.presenter;


import android.content.Intent;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.ResetPasswordActivity;
	

public class ResetPresenter extends Presenter {

	private ResetPasswordActivity activity;
	public ResetPresenter(ResetPasswordActivity activity) {
		super(activity);
		this.activity = activity;
	}
	
	public void resetPassword(String email) {
		boolean success = false;
		try {
			dc.resetPassword(email);
			success = true;
		} catch (DatabaseException e) {
			activity.showMessage(e.prettyPrint());
		} finally {
			if(success) {
				activity.showSuccessMessage("You got mail!");
			}
		}
	}

	public void goToRegisterActivity() {
		Intent i = new Intent(activity.getApplicationContext(), LoginActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		activity.startActivity(i);
		// Close Registration View
		activity.finish();
	}	
}