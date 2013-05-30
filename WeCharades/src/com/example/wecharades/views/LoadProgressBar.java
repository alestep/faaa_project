package com.example.wecharades.views;

import android.widget.ProgressBar;

/**
 * Help class intended to display a spinner when data is fetched in the background
 * @author weCharade
 */
public class LoadProgressBar implements IProgress {

	private ProgressBar progressBar;
	
	/**
	 * Create an instance by setting the activity's context and receiving an instance of Progressbar
	 * @param progressBar
	 */
	public LoadProgressBar(ProgressBar progressBar) {
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
