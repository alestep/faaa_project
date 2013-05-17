package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;

public abstract class Presenter {
	
	/**
	 * Needed in order to use parse commands
	 * @param context - the context (the activity: use 'this' most often)
	 */
	public static void initialize(Context context){
		Parse.initialize(context, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
	}
	
	/**
	 * Enable or disable all clickable objects in view
	 * @param view
	 */
	public static void enableOrDisableViews(View view) {
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
	private static ArrayList<View> getAllChildren(View view) {

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
	protected static void showToast(Context context, String msg) {
		Toast error = Toast.makeText(context, msg, Toast.LENGTH_LONG);
		error.show();
	}
}
