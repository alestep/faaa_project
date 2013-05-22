package com.example.wecharades.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wecharades.R;
import com.example.wecharades.presenter.NewGamePresenter;

public class NewGameActivity extends Activity {
	
	private NewGamePresenter presenter;
	
	//TODO Implement a presenter and extend generic activity if possible
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);
		presenter = new NewGamePresenter(this);
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
}
