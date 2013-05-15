package com.example.wecharades;

import com.parse.Parse;
import com.parse.ParseUser;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DashboardActivity extends Activity {
	Button btnLogout;
	TextView name;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Copy and Paste this into every onCreate method to be able to use Parse
        Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R"); 
        
        //Check if the user is logged in or saved in the cache
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
        	//The user is logged in - show dashboard
        	setContentView(R.layout.dashboard);
        	
        	btnLogout = (Button) findViewById(R.id.btnLogout);
        	btnLogout.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
				public void onClick(View arg0) {
    				
    				ParseUser.logOut();
    				
    				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
    	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	        	startActivity(login);
    	        	// Closing dashboard screen
    	        	finish();
    			}
    		});
        } else {
        	// user is not logged in, show login screen
        	Intent login = new Intent(getApplicationContext(), LoginActivity.class);
        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(login);
        	// Closing dashboard screen
        	finish();
        }
    }
}