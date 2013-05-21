package com.example.wecharades.views;

import com.example.wecharades.R;
import com.example.wecharades.R.id;
import com.example.wecharades.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NewGameScreen extends Activity {
	
	public final static String TAG = "NewGameScreen";
	
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
