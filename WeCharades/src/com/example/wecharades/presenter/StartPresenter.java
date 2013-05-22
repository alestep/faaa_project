package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.views.StartActivity;

/**
 * 
 * @author Alexander
 *
 */
public class StartPresenter extends Presenter {
	
	private static final String TAG = "Start Presenter";
	private StartActivity activity;
	private Map<String, ArrayList<Game>> separatedList;
	
	
	public StartPresenter(StartActivity activity) {
		super(activity);
		this.activity = activity;
		separatedList = new HashMap<String, ArrayList<Game>>();
	}
	
	public void update(){
		String string = dc.getCurrentPlayer().getName();
		activity.setDisplayName(string);
		parseGameLists();
	}
	
	/**
	 * Check if the there is a user logged in. 
	 * 	Will call the activity and update username if this is true
	 * 
	 */
	public void checkLogin() {
		if(dc.getCurrentPlayer() == null){
			goToLoginActivity();
		}
	}
    
	/**
	 * 
	 */
	private void parseGameLists() {
		try {
			//TODO This should talk to the DataFetcher later.
			ArrayList<Game> gameList = dc.getGames();
			
			separatedList.put("Finished games", new ArrayList<Game>());
			separatedList.put("Opponent's turn", new ArrayList<Game>());
			separatedList.put("Your turn", new ArrayList<Game>());
			
	        for (Game g : gameList) {
	        	if (g.isFinished())
	        		separatedList.get("Finished games").add(g);
	        	else if (g.getCurrentPlayer().equals(dc.getCurrentPlayer()) && !g.isFinished())
	        		separatedList.get("Opponent's turn").add(g);
	        	else
	        		separatedList.get("Your turn").add(g);
	        }
	        
		} catch (DatabaseException e){
			Log.d(TAG, e.getMessage());
		}
	}

	/**
	 * 
	 * @param adapter
	 * @return
	 */
	public SeparatedListAdapter setAdapter(SeparatedListAdapter adapter) {
		// TODO: Sortera listan - DET FINNS FÄRDIGA KLASSER FÖR DETTA!
		for (String s : separatedList.keySet()) {
			adapter.addSection(s, new GameAdapter(activity, separatedList.get(s), dc.getCurrentPlayer()));		
		}
		return adapter;
	}
	
	/**
	 * Log out the current user
	 */
	public void logOut() {
		dc.logOutPlayer();
		goToLoginActivity();
	}
	
}
