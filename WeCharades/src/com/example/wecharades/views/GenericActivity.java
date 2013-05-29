package com.example.wecharades.views;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wecharades.R;
import com.example.wecharades.model.IProgress;
import com.example.wecharades.presenter.Presenter;

public abstract class GenericActivity extends Activity{
	
	//Presenter object, declared protected and therefore enabling access to extending classes
	protected Presenter presenter;
	
	/**
	 * onCreate-method which sets the presenter
	 * @param savedInstanceState
	 * @param presenter
	 */
	public void onCreate(Bundle savedInstanceState, Presenter presenter) {
		
		//Only send the Bundle-object to the super class 
		super.onCreate(savedInstanceState);
		this.presenter = presenter;
	}

	/**
	 * This method will return a ProgressBar in the form of a spinner.
	 * Use this spinner to give a visual queue to the user that something is happening
	 * in the background. 
	 * @return The progressbar of the view.
	 */
	protected abstract IProgress getProgressBar();


	/**
	 * Called to show progress spinning when waiting for the server
	 */
	public void showProgressBar() {
		if(getProgressBar() != null) {
			getProgressBar().show();
		}
	}

	/**
	 * Called to hide progress spinning when the server has responded
	 */
	public void hideProgressBar() {
		if(getProgressBar() != null) {
			getProgressBar().hide();
		}
	}

	/**
	 * Private help method to get all clickable objects in a list from a view.
	 * @param view
	 * @return an ArrayList with all Views within the parameter view
	 */
	private ArrayList<View> getAllChildren(View view) {
		
		//Check if the view is a "single" view
		if (!(view instanceof ViewGroup)) {
			ArrayList<View> viewArrayList = new ArrayList<View>();
			viewArrayList.add(view);
			return viewArrayList;
		}

		ArrayList<View> result = new ArrayList<View>();
		
		/*	Add all children of the ViewGroup and eventually return the 
		*	ArryaList containing the views.Childrens of a children in a ViewGroup are
		*	added to the list by recursively calling the method.
		*/
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
		
		//Loop through the list of views and enable them.
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
		
		//Loop through the list of views and disable them.
		for (View child : viewList) {
			child.setEnabled(false);
		}
	}

	/**
	 * Show a toast to the user.
	 * @param msg
	 */
	public void showToast(String msg) {
		
		//Declare and get reference to a LayoutInflater
		LayoutInflater inflater = getLayoutInflater();
		
		//Inflate custom Toast layout
		View layout = inflater.inflate(R.layout.toast_success, (ViewGroup) findViewById(R.id.toast_layout_root));
		
		TextView text = (TextView) layout.findViewById(R.id.toastText);
		text.setText(msg);
		
		//Create Toast, set duration and layout
		Toast toast = new Toast(getApplicationContext());
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();
	}

	/**
	 * Show a message to the user, most often an error. Uses a dialog-box with one button.
	 * @param error
	 */
	public void showNegativeDialog(String negativeTitle, String negativeText, String buttonText) {
		
		final Dialog dialog = new Dialog(this);
		
		//Actions to set custom Dialog layout and set properties
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_negative);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  
		dialog.setCanceledOnTouchOutside(false);        

		TextView title = (TextView) dialog.findViewById(R.id.negativeTitle);
		title.setText(negativeTitle);

		TextView text = (TextView) dialog.findViewById(R.id.negativeText);
		text.setText(negativeText);

		Button button = (Button) dialog.findViewById(R.id.dismiss);
		button.setText(buttonText);
		button.setOnClickListener(new OnClickListener() {          
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		dialog.show();
	}
	
	/**
	 * Show a message to the user, most often an error. Uses a dialog-box with two buttons.
	 * @param negativeTitle
	 * @param negativeText
	 * @param buttonText1
	 * @param buttonText2
	 */
	public void showNegativeDialog(String negativeTitle, String negativeText, String buttonText1, String buttonText2) {
		
		//Create new Dialog-object
		final Dialog dialog = new Dialog(this);
		
		//Actions to set custom Dialog layout and set properties
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_negative_two);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		dialog.setCanceledOnTouchOutside(false);

		TextView title = (TextView) dialog.findViewById(R.id.negativeTitle);
		title.setText(negativeTitle);
		
		TextView text = (TextView) dialog.findViewById(R.id.negativeText);
		text.setText(negativeText);
		
		Button button1 = (Button) dialog.findViewById(R.id.dismiss);
		button1.setText(buttonText1);
		
		button1.setOnClickListener(new OnClickListener() {          
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		
		Button button2 = (Button) dialog.findViewById(R.id.back);
		button2.setText(buttonText2);
	
		button2.setOnClickListener(new OnClickListener() {          
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		
		dialog.show();
	}

	/**
	 * Show a positive dialog to the user. Most often a success message
	 * @param error
	 */
	public void showPositiveDialog(String positiveTitle, String positiveText, String buttonText) {
		
		//Create new Dialog-object
		final Dialog dialog = new Dialog(this);
		
		//Actions to set custom Dialog layout and set properties
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_positive);
		dialog.setCanceledOnTouchOutside(false);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));               

		TextView title = (TextView) dialog.findViewById(R.id.positiveTitle);
		title.setText(positiveTitle);

		TextView text = (TextView) dialog.findViewById(R.id.positiveText);
		text.setText(positiveText);

		Button button = (Button) dialog.findViewById(R.id.dismiss);
		button.setText(buttonText);
		
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				dialog.dismiss();

			}
		});
		dialog.show();
	}
	
	/**
	 * Show a progress dialog to the user. 
	 * @param error
	 */
	public void showProgressDialog(String positiveTitle, String positiveText, String buttonText) {
		//TODO: To be implemented
	}
	


	@Override
	protected void onStop(){
		//Save the model to disk whenever an activity is closed.
		presenter.saveState();
		super.onStop();
	}

	/**
	 * Get the presenter associated with an activity.
	 * @return A presenter
	 */
	protected Presenter getPresenter(){
		return presenter;
	}

}
