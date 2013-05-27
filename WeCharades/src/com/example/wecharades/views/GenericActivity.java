package com.example.wecharades.views;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wecharades.presenter.Presenter;

public abstract class GenericActivity extends Activity{

	protected Presenter presenter;
	protected ArrayList<View> myView;

	public void onCreate(Bundle savedInstanceState, Presenter presenter) {
		super.onCreate(savedInstanceState);
		this.presenter = presenter;
	}

	//To be implemented by subclasses
	public abstract TextView getTextArea();

	//To be implemented by subclasses
	protected abstract ProgressBar getProgressSpinner();
	

	/**
	 * Called to show progress spinning when waiting for the server
	 */
	public void showProgressSpinner(ArrayList<View> view) {
		if(getProgressSpinner() != null) {
			//show the spinner
			getProgressSpinner().setVisibility(ProgressBar.VISIBLE);
			//Enable buttons
			enableOrDisableViews(view);
		}
	}

	/**
	 * Called to hide progress spinning when the server has responded
	 */
	public void hideProgressSpinner(ArrayList<View> view) {
		if(getProgressSpinner() != null) {
			//hide the progress spinner
			getProgressSpinner().setVisibility(ProgressBar.INVISIBLE);
			//disable buttons
			enableOrDisableViews(view);
		}
	}
	
	/**
	 * 
	 */
	public void showErrorDialog(){
		
	}
	
	/**
	 * 
	 */
	public void showSuccessDialog(){ 
		
	}

	/**
	 * Enable or disable all clickable objects in view
	 * @param view
	 */
	private void enableOrDisableViews(ArrayList<View> viewList) {
		for (View child : viewList) {
			if (child instanceof TextView) {
				if(child.isEnabled()) {
					child.setEnabled(false);
				} else {
					child.setEnabled(true);
				}
			}
		}
	}

	public void showMessage(String error) {
		getTextArea().setText(error);
	}


	@Override
	protected void onStop(){
		presenter.saveState();
		super.onStop();
	}

	protected Presenter getPresenter(){
		return presenter;
	}

}
