package com.example.wecharades;

import com.example.wecharades.views.Friends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NewGameScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);
		
		Button random = (Button) findViewById(R.id.random);
		Button facebook = (Button) findViewById(R.id.facebook);
		Button friend = (Button) findViewById(R.id.friend);
		
		friend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(NewGameScreen.this, Friends.class));
			}
		});
	}
	
}
