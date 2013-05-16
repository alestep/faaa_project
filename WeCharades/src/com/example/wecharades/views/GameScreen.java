package com.example.wecharades.views;

import com.example.wecharades.R;
import com.example.wecharades.R.id;
import com.example.wecharades.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GameScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_screen);
		
		TextView tv = (TextView) findViewById(R.id.game_screen_username);
		tv.setText(getIntent().getExtras().getString("username"));
    }

}
