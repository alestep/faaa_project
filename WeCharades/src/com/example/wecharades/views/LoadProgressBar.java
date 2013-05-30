package com.example.wecharades.views;

import android.content.Context;
import android.widget.ProgressBar;

/**
 * Help class intended to display a spinner when data is fetched in the background
 * @author weCharade
 */
public class LoadProgressBar implements IProgress {

	private ProgressBar progressBar;
	private Context context;
	
	/**
	 * Create an instance by setting the activity's context and receiving an instance of Progressbar
	 * @param context
	 * @param progressBar
	 */
	public LoadProgressBar(Context context, ProgressBar progressBar) {
		this.context = context;
		this.progressBar = progressBar;
	}

	@Override
	public void show() {
		progressBar.setVisibility(ProgressBar.VISIBLE);
	}

	@Override
	public void hide() {
		progressBar.setVisibility(ProgressBar.INVISIBLE);
	}

}
