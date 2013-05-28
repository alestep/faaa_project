package com.example.wecharades.model;

import com.example.wecharades.R;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class RefreshProgressBar implements IProgress {
	private Animation rotation;
	ImageButton button;
	private Context context;
	
	public RefreshProgressBar(Context context, ImageButton button) {
		this.button = button;
		this.context = context;
	}
	
	private void setAnimation () {
		rotation = AnimationUtils.loadAnimation(context, R.anim.refresh_anim);
		rotation.setRepeatCount(Animation.INFINITE);
	}

	@Override
	public void show() {
		setAnimation();
		button.startAnimation(rotation);
	}
	
	@Override
	public void hide() {
		button.clearAnimation();
	}
}
