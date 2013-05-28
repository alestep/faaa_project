package com.example.wecharades.views;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wecharades.R;
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
	
	/**
	 * 
	 * @param msg
	 */
	public void showToast(String msg) {
		
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.toast_success, (ViewGroup) findViewById(R.id.toast_layout_root));

		TextView text = (TextView) layout.findViewById(R.id.toastText);
		text.setText(msg);

		Toast toast = new Toast(getApplicationContext());
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();
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
