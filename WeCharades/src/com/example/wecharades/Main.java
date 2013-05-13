package com.example.wecharades;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		/*
        Button b1 = (Button) findViewById(R.id.button1);
        
        b1.setOnClickListener(new OnClickListener(){
		
        	@Override
        	public void onClick(View w) {
			Intent intent = new Intent(Main.this, VideoCapture.class);
			startActivity(intent);
        	}
        });*/
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
	public void startGameview(View view){
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}

}
