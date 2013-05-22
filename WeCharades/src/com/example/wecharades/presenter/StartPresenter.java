package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.views.StartActivity;

/**
 * 
 * @author Alexander
 *
 */
public class StartPresenter extends Presenter {
	
	private StartActivity activity;
	private Map<String, ArrayList<Game>> separatedList;
	private final static String [] headers = {"Your turn", "Opponent's turn", "Finished games"};
	
	public StartPresenter(StartActivity activity) {
		super(activity);
		this.activity = activity;
		separatedList = new HashMap<String, ArrayList<Game>>();
	}
	
	public void update(){
		String string = dc.getCurrentPlayer().getName();
		activity.setDisplayName(string);
		parseList();
		//setInvitationStatus();
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
	private void parseList() {
		try {
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
		}catch(Exception e){
			
		}
	}

	/**
	 * 
	 * @param adapter
	 * @return
	 */
	public SeparatedListAdapter setAdapter(SeparatedListAdapter adapter) {
		for (String s : separatedList.keySet()) {
			adapter.addSection(s, new GameAdapter(activity, separatedList.get(s), dc.getCurrentPlayer()));		
		}
		return adapter;
	}
	
	/**
	 * 
	 */
	private void setInvitationStatus() {
		try {
			ArrayList<Invitation> invites = dc.getInvitations();
			activity.setInvitations(invites.size());
		}catch (Exception e){
			
		}
				
			
	}
	
	/**
	 * Log out the current user
	 */
	public void logOut() {
		dc.logOutPlayer();
		goToLoginActivity();
	}
	
}
