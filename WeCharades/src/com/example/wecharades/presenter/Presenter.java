package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wecharades.model.DataController;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.GenericActivity;
import com.example.wecharades.views.LoginActivity;

public abstract class Presenter implements Observer{

	protected DataController dc;
	protected GenericActivity activity;
	
	/**
	 * Needed in order to use parse commands
	 * @param context - the context (the activity: use 'this' most often)
	 */
	public Presenter(GenericActivity activity) {
		this.activity = activity;
		this.dc = DataController.getDataController(activity);
		dc.addObserver(this);
	}
	
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
		progressSpinner.setVisibility(4);
		//disable buttons
		enableOrDisableViews(view);
	}
	
	/**
	 * Go to the login screen
	 */
	public void goToLoginActivity() {
		Intent i = new Intent(activity.getApplicationContext(), LoginActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		activity.startActivity(i);
		// Close current view
		//TODO I do not think we should do this? at least not for the start screen!
		activity.finish();
	}
	
	/**
	 * Called whenever an activity is closed.
	 */
	public void saveState(){
		dc.saveState(activity);
	}
	
	@Override
	public void update(Observable dataController, Object obj){
		if(dataController.getClass().equals(DataController.class) 
				&& obj != null && obj.getClass().equals(DatabaseException.class)){
			//activity
		}
	}
}
