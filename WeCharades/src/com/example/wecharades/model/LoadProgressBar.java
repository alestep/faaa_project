package com.example.wecharades.model;

import android.content.Context;
import android.widget.ProgressBar;

public class LoadProgressBar extends ProgressBar implements IProgress {

	public LoadProgressBar(Context context) {
		super(context);
		
	}

	@Override
	public void show() {
		setVisibility(ProgressBar.VISIBLE);
		
	}

	@Override
	public void hide() {
		setVisibility(ProgressBar.INVISIBLE);
	}

}
