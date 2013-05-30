package com.example.wecharades.views;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.example.wecharades.R;

/**
 * Help class intended to display a spinner when screen is refreshed
 * @author weCharade
 */
public class RefreshProgressBar implements IProgress {
	private Animation rotation;
	ImageButton button;
	private Context context;
	
	/**
	 * Create an instance by setting the activity's context and receiving an instance of ImageButton
	 * @param context
	 * @param button
	 */
	public RefreshProgressBar(Context context, ImageButton button) {
		this.button = button;
		this.context = context;
	}
	
	private void setAnimation () {
		//Define the animation
		rotation = AnimationUtils.loadAnimation(context, R.anim.refresh_anim);
		rotation.setRepeatCount(Animation.INFINITE);
	}

	@Override
	public void show() {
		setAnimation();
		button.startAnimation(rotation);
		button.setClickable(false);
	}
	
	@Override
	public void hide() {
		button.setClickable(true);
		button.clearAnimation();
	}
}
