package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.wecharades.GameAdapter;
import com.example.wecharades.R;
import com.example.wecharades.SeparatedListAdapter;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.parse.ParseUser;

/**
 * 
 * @author Alexander
 *
 */
public class StartPresenter extends Presenter {
	
	private static final String TAG = "Start Presenter";
	private StartActivity activity;
	private Map<String, ArrayList<Game>> separatedList;
	
	/**
	 * 
	 * @param activity
	 */
	public StartPresenter(Activity activity) {
		super(activity);
		this.activity = (StartActivity) activity;
		separatedList = new HashMap<String, ArrayList<Game>>();

	}
    
	/**
	 * 
	 */
	private void parseGameLists() {
		try {
			ArrayList<Game> gameList = Database.getGames(Database.getPlayer(getCurrentUser().getUsername()));
	        for (Game g : gameList) {
	        	if (g.isFinished())
	        		putInList("Finished games", g);
	        	else if (g.getCurrentPlayer().getName().toLowerCase().equals(getCurrentUser()) && !g.isFinished())
	        		putInList("Opponent's turn", g);        
	        	else
	        		putInList("Your turn", g);
	        }
	        
		} catch (DatabaseException e){
			Log.d(TAG, e.getMessage());
		}
	}

	private void putInList(String s, Game g) {
		separatedList.put(s, new ArrayList<Game>());
		separatedList.get(s).add(g);
	}

	/**
	 * 
	 * @param adapter
	 * @return
	 */
	public SeparatedListAdapter setAdapter(SeparatedListAdapter adapter) {
		parseGameLists();
		// TODO: Sortera listan
		for (String s : separatedList.keySet()) {
			adapter.addSection(s, new GameAdapter(activity.getApplicationContext(), separatedList.get(s)));		
		}
	
		return adapter;
	}
	
	/**
	 * 
	 * @param displayUser
	 */
	public void checkLogin(View displayUser) {
		ParseUser currentUser = getCurrentUser();
	    if(currentUser == null ) {
	    	// user is not logged in, show login screen
	    	goToLoginActivity();
	    }else {
	    	//Sets the current user's user name
	    	((TextView) displayUser).setText(currentUser.get("naturalUsername").toString());
	    }
		
	}
	
	/**
	 * 
	 */
	public void logOut() {
		ParseUser.logOut();
		goToLoginActivity();
	}
}
