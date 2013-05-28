package com.example.wecharades.model;

import android.content.Context;
import android.widget.ProgressBar;

public class LoadProgressBar implements IProgress {

	private ProgressBar progressBar;
	private Context context;
	
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
