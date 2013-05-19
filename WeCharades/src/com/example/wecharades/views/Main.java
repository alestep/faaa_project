package com.example.wecharades.views;

import com.example.wecharades.R;
import com.example.wecharades.R.id;
import com.example.wecharades.R.layout;
import com.example.wecharades.R.menu;
import com.example.wecharades.controller.Database;
import com.parse.Parse;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		System.out.println(Environment.getExternalStorageDirectory());
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(this);

		//Copy and Paste this into every onCreate method to be able to use Parse
		Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R"); 

		//Check if the user is logged in or saved in the cache
		ParseUser currentUser = ParseUser.getCurrentUser();
		if(currentUser == null ) {
			// user is not logged in, show login screen
			Intent login = new Intent(getApplicationContext(), LoginActivity.class);
			login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(login);
			// Closing dashboard screen
			finish();
		}

	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.button1){
			Intent intent = new Intent(Main.this, CaptureVideo.class);
			startActivity(intent);
		}
		if(v.getId()==R.id.button2){
			Log.d("TAG","tryckt");
			Intent intentTwo = new Intent(Main.this, PlayStreamedVideo.class);
			startActivity(intentTwo);
		}

	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Called when user clicks gameview-button
	 */

	public void createGame(View view){
		Database.createGame(ParseUser.getCurrentUser().getUsername(), "felix");
	}

}
