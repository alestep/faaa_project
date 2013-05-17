package com.example.wecharades.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.wecharades.ActiveGameItem;
import com.example.wecharades.EntryAdapter;
import com.example.wecharades.Item;
import com.example.wecharades.SectionItem;
import com.example.wecharades.GameItem;
import com.example.wecharades.R;
import com.example.wecharades.R.id;
import com.example.wecharades.R.layout;
import com.example.wecharades.SeparatedListAdapter;

import com.example.wecharades.model.Game;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wecharades.controller.Database;


public class StartScreen extends Activity {

	private Button btnLogout;
	private TextView username;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game_header);

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
	}

	private ArrayList<Item> getGameList() {
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			ArrayList<Game> games = Database.getGames(ParseUser.getCurrentUser().getUsername());
			items.add(new SectionItem("Your turn"));
			for (Game g : games) {
				
			}
		}catch (ParseException e){
			Log.d("TEXT", e.getMessage());
		}

		return items;
	}
	
	/**
	 * Logout and go back to login screen
	 * @param view
	 */
	public void onClickLogout(View view) {
		ParseUser.logOut();
		//Redirecting to LoginActivity
		Intent login = new Intent(getApplicationContext(), LoginActivity.class);
		login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(login);
		// Closing start screen
		finish();
	}
	
	/**
	 * Go to New Game screen
	 * @param view
	 */
	public void onClickNewGame(View view) {
		Intent intent = new Intent(StartScreen.this, NewGameScreen.class);
		startActivity(intent);
	}
	
	/**
	 * Nothing happens so far...
	 * @param view
	 */
	public void onClickAccount(View view) {
		Log.d("Clicked", "Account");
	}
	
	
/*
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		if(!items.get(position-1).isSection() && items.get(position-1).isActive()){
			ActiveGameItem item = (ActiveGameItem) items.get(position-1);
			Intent intent = new Intent(StartScreen.this, GameScreen.class);
			intent.putExtra("username", item.getTitle());
			startActivity(intent);


			Toast.makeText
			(this, "You clicked " + item.getTitle() , Toast.LENGTH_SHORT).show();

		}

		super.onListItemClick(l, v, position-1, id);
	}
*/

	public void createGame(View view) throws ParseException{
		Database.createGame(ParseUser.getCurrentUser().getUsername(), "felix");
	}
}