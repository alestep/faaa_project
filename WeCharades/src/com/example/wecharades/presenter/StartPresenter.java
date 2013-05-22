package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import android.util.Log;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.StartActivity;
import com.parse.ParseUser;

/**
 * 
 * @author Alexander
 *
 */
public class StartPresenter extends Presenter {
	
	private StartActivity activity;
	private Map<String, ArrayList<Game>> separatedList;
	private final static String [] headers = {"Your turn", "Opponent's turn", "Finished games"};
	private Player player;
	
	public StartPresenter(StartActivity activity) {
		super(activity);
		this.activity = activity;
		separatedList = new TreeMap<String, ArrayList<Game>>();
		try {
			player = db.getPlayer(getCurrentUser().getUsername());
		}catch (Exception e){
			
		}
		//Checks if the there is any user logged in
		checkLogin();
	}
	
	public void update(){
		activity.setDisplayName(player.getName());
		//setInvitationStatus();
	}
	
	/**
	 * Check if the there is a user logged in. 
	 * 	Will call the activity and update username if this is true
	 * 
	 */
	public void checkLogin() {
		if(getCurrentUser() == null){
			goToLoginActivity();
		} else{
			model.setCurrentPlayer();//TODO should this be removed after we have created a more persistent model?
		}
	}
    
	/**
	 * 
	 */
	private void parseList() {
		try {
			//TODO This should talk to the DataFetcher later. Fungerar ej nu!
			ArrayList<Game> gameList = db.getGames(player);
			Log.d("TAG", "" + gameList.isEmpty()); //returnerar true?!
			for (String s : headers) {
				separatedList.put(s, new ArrayList<Game>());
			}
			
	        for (Game g : gameList) {
	        	if (g.isFinished())
	        		separatedList.get("Finished games").add(g);
	        	else if (g.getCurrentPlayer().equals(player) && !g.isFinished())
	        		separatedList.get("Opponent's turn").add(g);
	        	else
	        		separatedList.get("Your turn").add(g);
	        }
	        
		} catch (DatabaseException e){

		}
	}

	/**
	 * 
	 * @param adapter
	 * @return
	 */
	public SeparatedListAdapter setAdapter(SeparatedListAdapter adapter) {
		parseList();
		for (String s : separatedList.keySet()) {
			//if (!separatedList.get(s).isEmpty())
				adapter.addSection(s, new GameAdapter(activity, separatedList.get(s), player));		
		}
	
		return adapter;
	}
	
	/**
	 * 
	 */
	private void setInvitationStatus() {
		try {
			ArrayList<Invitation> invites = db.getInvitations(player);
			activity.setInvitations(invites.size());
				
		}catch (Exception e){
			
		}
				
			
	}
	
	/**
	 * Log out the current user
	 */
	public void logOut() {
		ParseUser.logOut();
		model.logOutCurrentPlayer();
		goToLoginActivity();
	}
	
}
