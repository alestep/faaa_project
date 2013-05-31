package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import android.content.Intent;
import android.util.Log;

import com.example.wecharades.model.DCMessage;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.PushService;

/**
<<<<<<< HEAD
 * Presenter-class intended to provide StartActivity with relevant information
 * and manage communication with DataController and other Model-instances.
 * Class implements the Observer interface and observes changes in the DataController-class
 * @author weCharade
=======
 * 
 * @author weCharade
 *
>>>>>>> master
 */
public class StartPresenter extends Presenter implements Observer{

	private StartActivity activity;

	//Headers in the sectioned ListView
	private final static String [] headers = {"Your turn", "Opponent's turn", "Finished games"};

	// Adapter for ListView Contents and the actual ListView
	private SeparatedListAdapter adapter;
	
	//Map which keeps track of games, its player and the players' scores.
	private Map<Game, Map<Player, Integer>> score;


	/**
	 * Create an instance of StartPresenter
	 * @param activity
	 */
	public StartPresenter(StartActivity activity) {
		super(activity);
		this.activity = activity;
		dc.addObserver(this);
	}

	/**
	 * Register (or install) user's device in parse.com's push notification system
	 */
	public void createNotificationInstallation() {
		PushService.setDefaultPushCallback(activity.getApplicationContext(), StartActivity.class);
		try {
			ParseInstallation.getCurrentInstallation().save();
		} catch (ParseException e) {
			Log.e("ParseException push notifications", "Failed to create push installation");
		}
		ParseAnalytics.trackAppOpened(activity.getIntent());
	}

	/**
	 * Initiates the view
	 */
	public void initiate(){
		/*
		 * If intent has has BooleanExtra it will be direct the user to login screen. Why this is done is more 
		 * specifically described AccountPresenter-class @see com.example.wecharades.AccountPresenter#logOut().
		 * We don't need to use flag FLAG_ACTIVITY_CLEAR_TOP because LoginActivity was finished after it
		 * was used first time.
		 */
		if(activity.getIntent().getBooleanExtra("finish", false)){
			dc.logOutPlayer(activity);
			activity.startActivity(new Intent(activity, LoginActivity.class));
			activity.finish();
			
		} else {
			
			activity.setAccountName(dc.getCurrentPlayer().getName());
			
			//Update PushService
			PushService.subscribe(activity.getApplicationContext(), dc.getCurrentPlayer().getName(), StartActivity.class);
			
		}
	}

	/**
	 * Updates the view
	 */
	public void update(){
		
		//Add DataController observer
		dc.addObserver(this);
		updateList(dc.getGames());
		dc.fetchGames();
		dc.getInvitations();
		activity.showProgressBar();

	}

	/**
	 * Private Method - Called when a new updated game list is received from the database.
	 */
	private void updateList(ArrayList<Game> gameList){
		LinkedHashMap<String, ArrayList<Game>> listMap = new LinkedHashMap<String, ArrayList<Game>>();
		
		//Create a new score TreeMap and trash the old one
		score = new TreeMap<Game, Map<Player, Integer>>();
		parseList(listMap, gameList);

		createListView(listMap);
	}

	/**
	 * Private method which is called after an updated list of invitations is received.
	 */
	private void setInvitationStatus(List<Invitation> invites){
		//Calls the setInvitations-method in StartActivity and passes information about how many invitation has been received
		activity.setInvitations(dc.getReceivedInvitations().size());
	}

	/**
	 * Check if the there is a user logged in. 
	 * 	@return if a user is logged in
	 * 
	 */
	public boolean checkLogin() {
		if(dc.getCurrentPlayer() == null) {
			//Direct the user to Login screen
			goToLoginActivity();
			return false;
		}
		else{	
			createNotificationInstallation();
			return true;
		}
	}

	/**
	 * Convert a ArrayList of games into a Map where the games are separated
	 * @param listMap	LinkedHashMap where sections and connected game lists are stored
	 * @param gameList	All games the user is involved in
	 */
	private void parseList(LinkedHashMap<String, ArrayList<Game>> listMap, ArrayList<Game> gameList) {
		
		//Add all headers and connect them to a ArrayList<Game>
		for (String s : headers) {
			listMap.put(s, new ArrayList<Game>());
		}
		
		//Separate the game list into a Map depending on the state of the game
		for (Game g : gameList) {
			
			//Retrieve Map of scores for a specific game and put into score-Map
			score.put(g, dc.getGameScore(g));
			if (g.isFinished())
				listMap.get("Finished games").add(g);
			
			//Games in which it is current user's turn
			else if (g.getCurrentPlayer().equals(dc.getCurrentPlayer()) && !g.isFinished())
				listMap.get("Your turn").add(g);
			
			//Games in which it is opponent's turn
			else
				listMap.get("Opponent's turn").add(g);
		}
	}

	/**
	 * Create the ListView and set the Adapter for the displaying of the items
	 * @param listMap
	 */
	public void createListView(LinkedHashMap<String, ArrayList<Game>> listMap){
		adapter = new SeparatedListAdapter(activity);
		
		//Iterate over the headers and add sections if they contain a non-empty list
		for (String s : headers) {
			if(!listMap.get(s).isEmpty()) {
				
				/*
				 * Add new section by providing the section header and an instance of GameAdapter with appropriate
				 * parameters
				 */
				adapter.addSection(s, new GameAdapter(activity, listMap.get(s), dc.getCurrentPlayer(), score));		
			}
		}
		activity.setGameList(adapter);
	}

	/**
	 * Called whenever a message is received from the DataController
	 * This method will override the default, but will pass on the message
	 * to super when appropriate
	 * @param obs - The observer
	 * @param obj - The object included in the message
	 */
	private int recent = 0;
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable obs, Object obj) {
		//Check if obj is of the right class
		if(obj.getClass().equals(DCMessage.class)
				&& obj != null){
			
			//Cast obj to a DCMessage
			DCMessage dcm = (DCMessage) obj;
			
			/*
			 * The update-method listens for both DATABASE_GAMES and INVITATIONS messages. In order not finish
			 * update to early, the updating process is finished when messages of both types has arrived
			 */
			if (dcm.getMessage() == DCMessage.DATABASE_GAMES){
				recent++;
				updateList((ArrayList<Game>) dcm.getData());
			} else if (dcm.getMessage() == DCMessage.INVITATIONS){
				recent++;
				setInvitationStatus((List<Invitation>) dcm.getData());
			} else{
				recent++;
				//Send message to superclass as well
				super.update(obs, obj);
			}
			if(recent == 2){
				activity.hideProgressBar();
				recent = 0;
			}
		}
	}
}
