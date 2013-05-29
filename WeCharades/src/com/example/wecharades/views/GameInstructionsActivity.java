package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.wecharades.R;
import com.example.wecharades.presenter.SimplePresenter;

/**
 * View which displays the game instructions
 * @author weCharade
 */
public class GameInstructionsActivity extends GenericActivity {

	private SimplePresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new SimplePresenter(this));

		//Set the title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.gameinstructions);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_home);

		this.presenter = (SimplePresenter) super.getPresenter();

	}
	
	/**
	 * Go to StartActivity
	 * @param v
	 */
	public void onClickHome(View v){
		presenter.goToStartActivity();
	}

	/*
	 * Activity is considered not to be in need of displaying an IProgress-instance.
	 * This method will therefore never be called, and it is OK to return null.
	 */
	@Override
	protected IProgress getProgressBar() {
		return null;
	}
}
