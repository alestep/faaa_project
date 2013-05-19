package com.example.wecharades.views;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wecharades.GameAdapter;
import com.example.wecharades.R;
import com.example.wecharades.SeparatedListAdapter;
import com.example.wecharades.model.Game;
import com.example.wecharades.presenter.StartPresenter;
import com.parse.Parse;
import com.parse.ParseUser;


public class StartActivity extends Activity {
 
        protected static final String TAG = "StartScreen";
        public final static String ITEM_TITLE = "title";
        public final static String ITEM_CAPTION = "caption";
        
        private StartPresenter presenter;
        
        // Adapter for ListView Contents
        private SeparatedListAdapter adapter;
 
        // ListView Contents
        private ListView journalListView;
 
        // String which represents the user's user name
        private String currentUser;
        private String currentUserId;
 
        public Map<String, ?> createItem(String title, String caption){
                Map<String, String> item = new HashMap<String, String>();
                item.put(ITEM_TITLE, title);
                item.put(ITEM_CAPTION, caption);
                return item;
        }
 
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                
                // Sets the presenter
                presenter = new StartPresenter (this);
                
                presenter.initialize();
                
                // Sets the View Layer
                setContentView(R.layout.start_screen);
 
                // Get a reference to the ListView holder
                journalListView = (ListView) this.findViewById(R.id.list_journal);
 
                View header = LayoutInflater.from(this).inflate(R.layout.start_screen_header, journalListView, false);
 
                journalListView.addHeaderView(header);
                
                // Create the ListView Adapter
                adapter = new SeparatedListAdapter(this);
 
                //Copy and Paste this into every onCreate method to be able to use Parse
                Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
 
                //Check if the user is logged in or saved in the cache
                //TODO: Fixa en central isLoggedIn()-funktion senare?
                ParseUser user = ParseUser.getCurrentUser();
                if(user == null ) {
                        // user is not logged in, show login screen
                        Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                        login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(login);
                        finish();
                }else {
                        //Sets the current user's user name
                        currentUser = ParseUser.getCurrentUser().getUsername();
                        TextView tv = (TextView) findViewById(R.id.textView1);
                        //TODO: Fixa så att det är natural username istället.
                        tv.setText(currentUser);
                }
                
                presenter.parseGameLists(currentUser); 
                
                ArrayList<Game> yourTurnList = presenter.getYourTurnList();
                Log.d(TAG, " " + yourTurnList.isEmpty());
                ArrayList<Game> opponentsTurnList = presenter.getOpponentsTurnList();
                ArrayList<Game> finishedList = presenter.getFinishedList();
                
                
                if (!yourTurnList.isEmpty()) {
                        GameAdapter yourTurnAdapter = new GameAdapter(this, yourTurnList);
                        adapter.addSection("Your turn", yourTurnAdapter);
                }
                               
                if (!opponentsTurnList.isEmpty()) {
                        GameAdapter opponentsTurnAdapter = new GameAdapter(this, opponentsTurnList);
                        adapter.addSection("Opponent's turn", opponentsTurnAdapter);
                }
 
                if (!finishedList.isEmpty()) {
                        GameAdapter finishedAdapter = new GameAdapter(this, finishedList);
                        adapter.addSection("Finished games", finishedAdapter);
                }
 
                // Set the adapter on the ListView holder
                journalListView.setAdapter(adapter);
 
                // Listen for Click events
                journalListView.setOnItemClickListener(new OnItemClickListener() {
 
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long duration) {
                                Game item = (Game) adapter.getItem(position-1);
                                Toast.makeText(getApplicationContext(), item.getPlayerId2().getName(), Toast.LENGTH_SHORT).show();
                        }
                });
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
                Log.d("Clicked", "New Game");
                Button b = (Button) view;
                //presenter.showToast(getApplicationContext(), b.getText().toString());
                Intent intent = new Intent (getApplicationContext(), NewGameScreen.class);
                Toast.makeText(getApplicationContext(), b.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
        }
 
        /**
         * Nothing happens so far...
         * @param view
         */
        public void onClickAccount(View view) {
                Log.d("Clicked", "Account");
                Button b = (Button) view;
                Toast.makeText(getApplicationContext(), b.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (getApplicationContext(), Main.class);
                startActivity(intent);
        }

}