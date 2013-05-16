package com.example.wecharades;

import java.util.ArrayList;

import com.parse.Parse;
import com.parse.ParseUser;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class StartScreen extends ListActivity {
	
	Button btnLogout;
	TextView username;
	private ArrayList<Item> items = new ArrayList<Item>();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		View header = View.inflate(this, R.layout.new_game_header, null);
		ListView lv = getListView();
		lv.addHeaderView(header);

		
		//Copy and Paste this into every onCreate method to be able to use Parse
		Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R"); 

		//Check if the user is logged in or saved in the cache
		//TODO: Fixa en central isLoggedIn()-funktion senare?
		ParseUser currentUser = ParseUser.getCurrentUser();
		if(currentUser == null ) {
			
			// user is not logged in, show login screen
			Intent login = new Intent(getApplicationContext(), LoginActivity.class);
			login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(login);
			finish();
		}

		
		//Temporary show username field...
		username = (TextView) findViewById(R.id.viewName);
		String name = (String) currentUser.getString("naturalUsername");
		username.setText(name); 
		
		items = DatabaseConnector.getList(); //Här kan vi skicka med användarnamneet så vi vet vems data som skall hämtas.

		
		EntryAdapter adapter = new EntryAdapter(this, items);
		setListAdapter(adapter);

		Button b = (Button) findViewById(R.id.new_game_button);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(StartScreen.this, NewGameScreen.class);
				startActivity(intent);
			}
		});
		
		btnLogout = (Button) findViewById(R.id.btnLogout);
    	btnLogout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				ParseUser.logOut();
				//Redirecting to LoginActivity
				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	startActivity(login);
	        	// Closing start screen
	        	finish();
			}
		});

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		if(!items.get(position-1).isSection() && items.get(position-1).isActive()){
			ActiveGameItem item = (ActiveGameItem) items.get(position-1);
			Intent intent = new Intent(StartScreen.this, GameScreen.class);
			intent.putExtra("username", item.getTitle());
			startActivity(intent);


			Toast.makeText(this, "You clicked " + item.getTitle() , Toast.LENGTH_SHORT).show();

		}

		super.onListItemClick(l, v, position-1, id);
	}
}