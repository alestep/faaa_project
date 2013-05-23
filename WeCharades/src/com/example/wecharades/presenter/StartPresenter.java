package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;

import com.example.wecharades.model.DataController;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
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
		parseList(dc.getGames());
		setInvitationStatus();
	}
	
	/*
	 * Called when a new updated game list is received from the database.
	 */
	private void updateFromDb(ArrayList<Game> dbGames){
		try{
			ArrayList<Game> newList = dc.retrievedUpdatedGameList(dbGames);
		} catch(DatabaseException e){activity.showMessage(e.prettyPrint());}
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

	@Override
	public void update(Observable obs, Object obj) {
		if(obs.getClass().equals(DataController.class)
				&& obj != null){
			if(obj.getClass().equals(DatabaseException.class)){
				DatabaseException e = (DatabaseException) obj;
				activity.showMessage(e.prettyPrint());
			} else if (obj.getClass().equals(ArrayList.class)
					&& !((ArrayList) obj).isEmpty()){
				if( ((ArrayList) obj).get(0).getClass().equals(Game.class) ){
					updateFromDb((ArrayList<Game>) obj);
				}
			}
		}
	}

}
