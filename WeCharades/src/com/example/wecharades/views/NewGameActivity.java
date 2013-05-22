package com.example.wecharades.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wecharades.R;

public class NewGameActivity extends Activity {
	
	public final static String TAG = "NewGameScreen";
	
	//TODO Implement a presenter and extend generic activity if possible
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);
	}
	
	/**
	 * Starts new game with random opponent
	 * @param view
	 */
	public void onClickRandom(View view) {
		Log.d(TAG, "Clicked Find random player");
	}
	
	/**
	 * Directs user to search screen
	 * @param view
	 */
	public void onClickSearchPlayer(View view) {
		Log.d(TAG, "Clicked Search for player");
		Intent intent = new Intent (getApplicationContext(), SearchPlayerActivity.class);
		startActivity(intent);
	}
}
