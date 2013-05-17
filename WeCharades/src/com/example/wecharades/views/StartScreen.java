package com.example.wecharades.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.wecharades.ActiveGameItem;
import com.example.wecharades.Database;
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

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class StartScreen extends ListActivity {
	
	protected static final String TAG = "StartScreen";
	private Button btnLogout;
	private TextView username;
	private ArrayList<Item> items = new ArrayList<Item>();
    public final static String ITEM_TITLE = "title";
    public final static String ITEM_CAPTION = "caption";

    // SectionHeaders
    private final static String[] days = new String[]{"Mon", "Tue", "Wed", "Thur", "Fri"};

    // Section Contents
    private final static String[] notes = new String[]{"Ate Breakfast", "Ran a Marathan ...yah really", "Slept all day"};

    // MENU - ListView
    private ListView addJournalEntryItem;

    // Adapter for ListView Contents
    private SeparatedListAdapter adapter;

    // ListView Contents
    private ListView journalListView;

    public Map<String, ?> createItem(String title, String caption){
            Map<String, String> item = new HashMap<String, String>();
            item.put(ITEM_TITLE, title);
            item.put(ITEM_CAPTION, caption);
            return item;
    }

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
        // Interactive Tools
        final ArrayAdapter<String> journalEntryAdapter = new ArrayAdapter<String>(this, R.layout.add_journalentry_menuitem, new String[]{"Add Journal Entry"});

        // AddJournalEntryItem
        addJournalEntryItem = (ListView) this.findViewById(R.id.add_journalentry_menuitem);
        addJournalEntryItem.setAdapter(journalEntryAdapter);
        addJournalEntryItem.setOnItemClickListener(new OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long duration)
                    {
                        String item = journalEntryAdapter.getItem(position);
                        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
                    }
            });

        // Create the ListView Adapter
        adapter = new SeparatedListAdapter(this);
        ArrayAdapter<String> listadapter = new ArrayAdapter<String>(this, R.layout.list_item, notes);

        // Add Sections
        for (int i = 0; i < days.length; i++)
            {
                adapter.addSection(days[i], listadapter);
            }

        // Get a reference to the ListView holder
        journalListView = (ListView) this.findViewById(R.id.list_journal);

        // Set the adapter on the ListView holder
        journalListView.setAdapter(adapter);

        // Listen for Click events
        journalListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long duration) {
                    String item = (String) adapter.getItem(position);
                    Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
				}
            });
        
		items = getGameList(); //Här kan vi skicka med användarnamneet så vi vet vems data som skall hämtas.

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

	private ArrayList<Item> getGameList() {
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			ArrayList<Game> games = Database.getGames(ParseUser.getCurrentUser().getUsername());
			items.add(new SectionItem("Your turn"));
			for (Game g : games) {
				
			}
		}catch (ParseException e){
			Log.d(TAG, e.getMessage());
		}

		return items;
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

	public void createGame(View view){
		Database.createGame(ParseUser.getCurrentUser().getUsername(), "felix");
	}
}