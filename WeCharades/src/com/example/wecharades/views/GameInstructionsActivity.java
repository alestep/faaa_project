package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.wecharades.R;
import com.example.wecharades.presenter.SimplePresenter;

public class GameInstructionsActivity extends GenericActivity {
	
	private SimplePresenter presenter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new SimplePresenter(this));
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.gameinstructions);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_home);
		
		this.presenter = (SimplePresenter) super.getPresenter();
		
	}

	@Override
	protected IProgress getProgressBar() {
		//Activity is not in need of IProgress-instance since nothing is fetched from database
		return null;
	}
	
	/**
	 * Go to Start Activity
	 * @param v
	 */
	public void onClickHome(View v){
		presenter.goToStartActivity();
	}
}
