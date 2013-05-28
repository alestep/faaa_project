package com.example.wecharades.views;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
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
	//protected ArrayList<View> myView;

	public void onCreate(Bundle savedInstanceState, Presenter presenter) {
		super.onCreate(savedInstanceState);
		this.presenter = presenter;
	}

	//To be implemented by subclasses
	/**
	 * This method will return an area of the screen to print messages on
	 * @return a TextView to set text on
	 */
	public abstract TextView getTextArea();

	//To be implemented by subclasses
	/**
	 * This method will return a ProgressBar in the form of a spinner.
	 * 	Use this spinner to give a visual que to the user that something is happening
	 * 	in the background. 
	 * @return The progressbar of the view.
	 */
	protected abstract ProgressBar getProgressSpinner();
	

	/**
	 * Called to show progress spinning when waiting for the server
	 */
	public void showProgressSpinner() {
		if(getProgressSpinner() != null) {
			//show the spinner
			getProgressSpinner().setVisibility(ProgressBar.VISIBLE);
		}
	}

	/**
	 * Called to hide progress spinning when the server has responded
	 */
	public void hideProgressSpinner() {
		if(getProgressSpinner() != null) {
			//hide the progress spinner
			getProgressSpinner().setVisibility(ProgressBar.INVISIBLE);
		}
	}
	
	//TODO move this to gen.act.?
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
	 * Enable all clickable objects in view.
	 * @param view a List containing all elements of the view to enable
	 */
	public void enabledView() {
		List<View> viewList = getAllChildren(this.getWindow().getDecorView().findViewById(android.R.id.content));
		for (View child : viewList) {
			child.setEnabled(true);
		}
	}
	/**
	 * Disable or disable all clickable objects in view.
	 * @param view a List containing all elements of the view to disable
	 */
	public void disableView() {
		List<View> viewList = getAllChildren(this.getWindow().getDecorView().findViewById(android.R.id.content));
		for (View child : viewList) {
			child.setEnabled(false);
		}
	}
	
	/**
	 * Show a toast to the user.
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

	/**
	 * Show a message to the user. This is most often error states.
	 * @param error
	 */
	public void showMessage(String error) {
		getTextArea().setText(error);
	}


	@Override
	protected void onStop(){
		//We save the model to disk whenever an activity is closed.
		presenter.saveState();
		super.onStop();
	}

	/**
	 * Get the presenter associated with this activity.
	 * 	This can be typecast to the appropriate presenter type on return.
	 * @return A presenter
	 */
	protected Presenter getPresenter(){
		return presenter;
	}

}
