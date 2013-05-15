package com.example.wecharades;

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
