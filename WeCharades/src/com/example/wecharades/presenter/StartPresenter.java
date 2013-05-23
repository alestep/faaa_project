package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import com.example.wecharades.model.DataController;
import android.util.Log;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.StartActivity;

/**
 * 
 * @author Alexander
 *
 */
public class StartPresenter extends Presenter implements Observer{

	private StartActivity activity;
	private LinkedHashMap<String, ArrayList<Game>> listMap;
	private final static String [] headers = {"Your turn", "Opponent's turn", "Finished games"};

	private Map<Game, Map<Player, Integer>> score;

	public StartPresenter(StartActivity activity) {
		super(activity);
		this.activity = activity;
		//Register this activity to listen to calls form the datacontroller
		dc.addObserver(this);
	}

	public void update(){
		String string = dc.getCurrentPlayer().getName();
		activity.setAccountName(string);
		listMap = new LinkedHashMap<String, ArrayList<Game>>();
		score = new TreeMap<Game, Map<Player, Integer>>();
		parseList(dc.getGames());
		setInvitationStatus();
	}

	/*
	 * Called when a new updated game list is received from the database.
	 */
	private void updateFromDb(ArrayList<Game> dbGames){
		listMap = new LinkedHashMap<String, ArrayList<Game>>();
		parseList(dbGames);
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
	private void parseList(ArrayList<Game> gameList) {
		for (String s : headers) {
			listMap.put(s, new ArrayList<Game>());
		}
		for (Game g : gameList) {
			score.put(g, dc.getGameScore(g)); //TODO: make three maps for every state below
			if (g.isFinished())
				listMap.get("Finished games").add(g);
			else if (g.getCurrentPlayer().equals(dc.getCurrentPlayer()) && !g.isFinished())
				listMap.get("Your turn").add(g);
			else
				listMap.get("Opponent's turn").add(g);
		}
	}

	/**
	 * 
	 * @param adapter
	 * @return
	 */
	public SeparatedListAdapter setAdapter(SeparatedListAdapter adapter) {
		for (String s : headers) {
			if(!listMap.get(s).isEmpty()) {
				adapter.addSection(s, new GameAdapter(activity, listMap.get(s), dc.getCurrentPlayer(), score));		
			}
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
		}catch (DatabaseException e){
			activity.showMessage(e.prettyPrint());
		}


	}

	/**
	 * Log out the current user
	 */
	public void logOut() {
		dc.logOutPlayer(activity);
		goToLoginActivity();
	}

	/**
	 * Called in order to deregister this presenter from the list of observers in the db.
	 */
	public void unRegisterObserver(){
		dc.deleteObserver(this);
	}

	/**
	 * Called whenever a message is reveived from the DataController
	 * 	This method will override the default, but will pass on the message
	 * 	to super when appropriate
	 * @param obs - The observer
	 * @param obj - The object included in the message
	 */
	@Override
	public void update(Observable obs, Object obj) {
		if(obs.getClass().equals(DataController.class)
				&& obj != null){
			if(obj instanceof ArrayList
					&& !((ArrayList) obj).isEmpty()
					&& ((ArrayList) obj).get(0).getClass().equals(Game.class) ){
				updateFromDb((ArrayList<Game>) obj);
			}
		} else{
			//If this 
			super.update(obs, obj);
		}
	}

}
