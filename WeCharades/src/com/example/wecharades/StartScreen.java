package com.example.wecharades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class StartScreen extends ListActivity {
    /** Called when the activity is first created. */
	
	private ArrayList<Item> items = new ArrayList<Item>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
        
        createGames();
        items = queryGames();
        
        //items = DatabaseConnector.getList(); //Här kan vi skicka med användarnamneet så vi vet vems data som skall hämtas.
        View header = View.inflate(this, R.layout.new_game_header, null);
        ListView lv = getListView();
        lv.addHeaderView(header);
        
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
        
    }
    
    private ArrayList<Item> queryGames() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.addAll(getYourTurn());
		items.addAll(getOpponentsTurn());
		items.addAll(getFinishedGames());
		
		return items;
		
	}
   
	private Collection<? extends Item> getOpponentsTurn() {
		final ArrayList<Item> items = new ArrayList<Item>();
	    ParseQuery queryOpponent = new ParseQuery("Game");
	    queryOpponent.whereEqualTo("turn", "opponent");
	    queryOpponent.findInBackground(new FindCallback() {

			@Override
			public void done(List<ParseObject> OpponentList, ParseException e) {
	            if (e != null) {
	            	Log.d("score", "Error: " + e.getMessage());
	            }else {
	                items.add(new SectionItem("Opponent's turn"));
	                for (ParseObject po : OpponentList) {
	                	items.add(new ActiveGameItem((po.getString("player")), po.getString("score")));
	                }
	            }
	            
			}
	    });
		return items;
	    
	}

	private Collection<? extends Item> getFinishedGames() {
		final ArrayList<Item> items = new ArrayList<Item>();
		ParseQuery queryFinished = new ParseQuery("Game");
	    queryFinished.whereEqualTo("turn", "finished");
	    queryFinished.findInBackground(new FindCallback() {

			@Override
			public void done(List<ParseObject> FinishedList, ParseException e) {
	            if (e != null) {
	                Log.d("score", "Error: " + e.getMessage());
	            }else {
	                items.add(new SectionItem("Opponent's turn"));
	                for (ParseObject po : FinishedList) {
	                	items.add(new FinishedGameItem((po.getString("player")), po.getString("score")));
	                }
	            }
	            
			}
	    });
		return items;
	}

	private Collection<? extends Item> getYourTurn() {
		final ArrayList<Item> items = new ArrayList<Item>();
		ParseQuery queryYour = new ParseQuery("Game");
	    queryYour.whereEqualTo("turn", "your");
	    queryYour.findInBackground(new FindCallback() {

			@Override
			public void done(List<ParseObject> YourList, ParseException e) {
	            if (e != null) {
	            	Log.d("score", "Error: " + e.getMessage());
	            }else {
	                items.add(new SectionItem("Opponent's turn"));
	                for (ParseObject po : YourList) {
	                	items.add(new ActiveGameItem((po.getString("player")), po.getString("score")));
	                }
	            }
	            
			}
	    });
		return items;
	}

	private void createGames() {
        ParseObject game = new ParseObject("Game");
        game.put("gameID", 1);
        game.put("player", "Fredrik");
        game.put("turn", "opponent");
        game.put("score", "7 - 3");
        game.put("gameID", 2);
        game.put("player", "Patrik");
        game.put("turn", "your");
        game.put("score", "3 - 7");
        game.put("gameID", 3);
        game.put("player", "Marcus");
        game.put("turn", "finished");
        game.put("score", "4 - 3");
        game.put("gameID", 4);
        game.put("player2", "Robert");
        game.put("status", "finished");
        game.put("score", "3 - 3");
        game.saveInBackground();
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