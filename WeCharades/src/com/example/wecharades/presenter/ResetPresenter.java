package com.example.wecharades.presenter;

import com.example.wecharades.model.DatabaseException;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;

public class ResetPresenter extends Presenter {
	
	private Activity activity;
	public ResetPresenter(Activity activity) {
		super(activity);
		this.activity = activity;
	}
	
	public void resetPassword(String email) throws DatabaseException {
		boolean success = false;
		try {
			Database.resetPassword(email);
			success = true;
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getCode(), e.getMessage());
		} finally {
			if(success) {
				//TODO: Send a message to show that an email has been sent
			}
		}
	}	
}
