package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.example.wecharades.views.LoginActivity;
import com.parse.Parse;
import com.parse.ParseUser;

public abstract class Presenter {

	/**
	 * Needed in order to use parse commands
	 * @param context - the context (the activity: use 'this' most often)
	 */
	private Activity activity;
	public Presenter(Activity activity) {
		this.activity = activity;
	}
	
	//TODO - this should be moved to the database - we should also make the database an object (possibly singleton)!
	public void initialize(){
		Parse.initialize(activity.getApplicationContext(), "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
	}
	
	/**
	 * Enables access to username ------------------- use getCurrentuser.getUsername() instead! @alexander 
	 * @return the current user's username
	 */
	/*
	public String getCurrentUser(){
		return ParseUser.getCurrentUser().getUsername();
	}*/
	
	/**
	 * Enable or disable all clickable objects in view
	 * @param view
	 */
	private void enableOrDisableViews(View view) {
		ArrayList<View> allViewObject = getAllChildren(view);
		for (View child : allViewObject) {
			if (child instanceof TextView) {
				if(child.isEnabled()) {
					child.setEnabled(false);
				} else {
					child.setEnabled(true);
				}
			}
		}
	}

	/**
	 * To get all clickable objects in a list from a view
	 * @param view
	 * @return an ArrayList with all Views within the parameter view
	 */
	private ArrayList<View> getAllChildren(View view) {

		if (!(view instanceof ViewGroup)) {
			ArrayList<View> viewArrayList = new ArrayList<View>();
			viewArrayList.add(view);
			return viewArrayList;
		}

		ArrayList<View> result = new ArrayList<View>();

		ViewGroup vg = (ViewGroup) view;
		for (int i = 0; i < vg.getChildCount(); i++) {

			View child = vg.getChildAt(i);

			ArrayList<View> viewArrayList = new ArrayList<View>();
			viewArrayList.add(view);
			viewArrayList.addAll(getAllChildren(child));

			result.addAll(viewArrayList);
		}
		return result;
	}
	
	/**
	 * A method to show a toast
	 * @param context
	 * @param msg
	 */
	protected void showToast(Context context, String msg) {
		Toast error = Toast.makeText(context, msg, Toast.LENGTH_LONG);
		error.show();
	}

	public void setProgressSpinnerInvisible(ProgressBar progressSpinner) {
		progressSpinner.setVisibility(4);
	}

	/**
	 * Called to show progress spinning when waiting for the server
	 * TODO: Where should we put these, they are used in both RegisterActivity, LoginActivity and ResetPasswordActivity
	 * TODO: Consider using threads instead...
	 */
	public void showProgressSpinner(View view, ProgressBar progressSpinner) {
		//show the spinner
		progressSpinner.setVisibility(0);
		//Enable buttons
		enableOrDisableViews(view);
	}

	/**
	 * Called to hide progress spinning when the server has responded
	 */
	public void hideProgressSpinner(View view, ProgressBar progressSpinner) {
		//hide the progress spinner
		progressSpinner.setVisibility(8);
		//disable buttons
		enableOrDisableViews(view);
	}
	
	public ParseUser getCurrentUser() {
		return ParseUser.getCurrentUser();
	}
	
	/**
	 * Go to the login screen
	 */
	public void goToLoginActivity() {
		Intent i = new Intent(activity.getApplicationContext(), LoginActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		activity.startActivity(i);
		// Close Registration View
		activity.finish();
		
	}
}
