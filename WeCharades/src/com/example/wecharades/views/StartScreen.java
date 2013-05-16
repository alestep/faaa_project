package com.example.wecharades.views;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wecharades.ActiveGameItem;
import com.example.wecharades.DatabaseConnector;
import com.example.wecharades.EntryAdapter;
import com.example.wecharades.Item;
import com.example.wecharades.R;
import com.example.wecharades.controller.Database;
import com.parse.Parse;
import com.parse.ParseUser;

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
//		username = (TextView) findViewById(R.id.viewName);
//		String name = (String) currentUser.getString("naturalUsername");
//		username.setText(name); 

		items = DatabaseConnector.getList(); //Här kan vi skicka med användarnamneet så vi vet vems data som skall hämtas.

		EntryAdapter adapter = new EntryAdapter(this, items);
		setListAdapter(adapter);

//		createGames();			// Made by Alex
//		items = queryGames();	// Made by Alex

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

//	private ArrayList<Item> queryGames() {
//		ArrayList<Item> items = new ArrayList<Item>();
//		items.addAll(getYourTurn());
//		items.addAll(getOpponentsTurn());
//		items.addAll(getFinishedGames());
//
//		return items;
//
//	}
//
//	private Collection<? extends Item> getOpponentsTurn() {
//		final ArrayList<Item> items = new ArrayList<Item>();
//		ParseQuery queryOpponent = new ParseQuery("Game");
//		queryOpponent.whereEqualTo("turn", "opponent");
//		queryOpponent.findInBackground(new FindCallback() {
//
//			@Override
//			public void done(List<ParseObject> OpponentList, ParseException e) {
//				if (e != null) {
//					Log.d("score", "Error: " + e.getMessage());
//				}else {
//					items.add(new SectionItem("Opponent's turn"));
//					for (ParseObject po : OpponentList) {
//						items.add(new ActiveGameItem((po.getString("player")), po.getString("score")));
//					}
//				}
//
//			}
//		});
//		return items;
//
//	}
//
//	private Collection<? extends Item> getFinishedGames() {
//		final ArrayList<Item> items = new ArrayList<Item>();
//		ParseQuery queryFinished = new ParseQuery("Game");
//		queryFinished.whereEqualTo("turn", "finished");
//		queryFinished.findInBackground(new FindCallback() {
//
//			@Override
//			public void done(List<ParseObject> FinishedList, ParseException e) {
//				if (e != null) {
//					Log.d("score", "Error: " + e.getMessage());
//				}else {
//					items.add(new SectionItem("Opponent's turn"));
//					for (ParseObject po : FinishedList) {
//						items.add(new FinishedGameItem((po.getString("player")), po.getString("score")));
//					}
//				}
//
//			}
//		});
//		return items;
//	}
//
//	private Collection<? extends Item> getYourTurn() {
//		final ArrayList<Item> items = new ArrayList<Item>();
//		ParseQuery queryYour = new ParseQuery("Game");
//		queryYour.whereEqualTo("turn", "your");
//		queryYour.findInBackground(new FindCallback() {
//
//			@Override
//			public void done(List<ParseObject> YourList, ParseException e) {
//				if (e != null) {
//					Log.d("score", "Error: " + e.getMessage());
//				}else {
//					items.add(new SectionItem("Opponent's turn"));
//					for (ParseObject po : YourList) {
//						items.add(new ActiveGameItem((po.getString("player")), po.getString("score")));
//					}
//				}
//
//			}
//		});
//		return items;
//	}
//
//	private void createGames() {
//		ParseObject game = new ParseObject("Game");
//		game.put("gameID", 1);
//		game.put("player", "Fredrik");
//		game.put("turn", "opponent");
//		game.put("score", "7 - 3");
//		game.put("gameID", 2);
//		game.put("player", "Patrik");
//		game.put("turn", "your");
//		game.put("score", "3 - 7");
//		game.put("gameID", 3);
//		game.put("player", "Marcus");
//		game.put("turn", "finished");
//		game.put("score", "4 - 3");
//		game.put("gameID", 4);
//		game.put("player2", "Robert");
//		game.put("status", "finished");
//		game.put("score", "3 - 3");
//		game.saveInBackground();
//	}


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

	public void createGame(View view){
		Database.createGame(ParseUser.getCurrentUser().getUsername(), "felix");
	}
}