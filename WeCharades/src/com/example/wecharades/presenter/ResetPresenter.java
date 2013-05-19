package com.example.wecharades.presenter;


import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.ResetPasswordActivity;

import android.app.Activity;
	

public class ResetPresenter extends Presenter {

	private ResetPasswordActivity activity;
	public ResetPresenter(ResetPasswordActivity activity) {
		super(activity);
		this.activity = activity;
	}
	
	public void resetPassword(String email) {
		boolean success = false;
		try {
			Database.resetPassword(email);
			success = true;
		} catch (DatabaseException e) {
			activity.showErrorMessage(e.prettyPrint());
		} finally {
			if(success) {
				activity.showSuccessMessage("You got mail!");
			}
		}
	}	
}