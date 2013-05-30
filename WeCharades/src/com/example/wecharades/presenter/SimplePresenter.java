package com.example.wecharades.presenter;

import com.example.wecharades.views.GenericActivity;

/**
 * Presenter-class intended to be used when an activity is not in need of being
 * provided with any extra functionality
 * @author weCharade
 */
public class SimplePresenter extends Presenter {

	/**
	 * Create an instance of SimplePresenter
	 * @param activity
	 */
	public SimplePresenter(GenericActivity activity) {
		super(activity);
	}

}
