package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.wecharades.R;
import com.example.wecharades.model.IProgress;
import com.example.wecharades.presenter.NewGamePresenter;

public class NewGameActivity extends GenericActivity {
	
	private NewGamePresenter presenter;
	
	//TODO Implement a presenter and extend generic activity if possible
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new NewGamePresenter(this));

		
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.new_game);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_other); 
		presenter = (NewGamePresenter) super.getPresenter();
	}
	
	/**
	 * Starts new game with random opponent
	 * @param view
	 */
	public void onClickRandom(View view) {
		presenter.randomInvitation();
	}
	
	/**
	 * Directs user to search screen
	 * @param view
	 */
	public void onClickSearchPlayer(View view) {
		Intent intent = new Intent (getApplicationContext(), SearchPlayerActivity.class);
		startActivity(intent);
	}

	@Override
	protected IProgress getProgressBar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void onClickHome(View v){
		startActivity(new Intent(this, StartActivity.class));
	}
}
