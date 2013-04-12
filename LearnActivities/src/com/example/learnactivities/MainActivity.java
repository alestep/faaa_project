package com.example.learnactivities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText et = (EditText) findViewById(R.id.editText1);
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener(){
        	
			public void onClick(View arg0) {
				Intent intent = new Intent (MainActivity.this, Second.class);
				intent.putExtra("thetext", et.getText().toString());
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
