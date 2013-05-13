package com.example.wecharades;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
        Button b1 = (Button) findViewById(R.id.button1);
        
        b1.setOnClickListener(new OnClickListener(){
		
        	@Override
        	public void onClick(View w) {
			Intent intent = new Intent(Main.this, VideoCapture.class);
			startActivity(intent);
        	}
        });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
