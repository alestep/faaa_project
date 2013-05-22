package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.example.wecharades.model.DatabaseException;
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
	private LinkedHashMap<String, ArrayList<Game>> listMap;
	private final static String [] headers = {"Your turn", "Opponent's turn", "Finished games"};
	
	public StartPresenter(StartActivity activity) {
		super(activity);
		this.activity = activity;
	}
	
	public void update(){
		String string = dc.getCurrentPlayer().getName();
		activity.setDisplayName(string);
		listMap = new LinkedHashMap<String, ArrayList<Game>>();
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
			
			for (String s : headers) {
				listMap.put(s, new ArrayList<Game>());
			}
			
			for (Game g : gameList) {
				if (g.isFinished())
					listMap.get("Finished games").add(g);
				else if (g.getCurrentPlayer().equals(dc.getCurrentPlayer()) && !g.isFinished())
					listMap.get("Your turn").add(g);
				else
					listMap.get("Opponent's turn").add(g);
			}
			
		}catch(DatabaseException e){
			activity.showMessage(e.prettyPrint());
		}
	}

	/**
	 * 
	 * @param adapter
	 * @return
	 */
	public SeparatedListAdapter setAdapter(SeparatedListAdapter adapter) {
		for (String s : headers) {
			if(!listMap.get(s).isEmpty())
				adapter.addSection(s, new GameAdapter(activity, listMap.get(s), dc.getCurrentPlayer()));		
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
		dc.logOutPlayer(activity);
		goToLoginActivity();
	}
	
}
