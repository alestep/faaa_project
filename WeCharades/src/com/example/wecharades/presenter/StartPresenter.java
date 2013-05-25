package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeMap;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


import com.example.wecharades.model.DCMessage;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.StartActivity;
import com.parse.PushService;

/**
 * 
 * @author Alexander
 *
 */
public class StartPresenter extends Presenter implements Observer{

	private StartActivity activity;
	//private LinkedHashMap<String, ArrayList<Game>> listMap; 
	private final static String [] headers = {"Your turn", "Opponent's turn", "Finished games"};

	// Adapter for ListView Contents and the actual listview
	//private SeparatedListAdapter adapter;
	private ListView gameListView;
	private SeparatedListAdapter adapter;
	private Map<Game, Map<Player, Integer>> score;

	public StartPresenter(StartActivity activity) {
		super(activity);
		this.activity = activity;
		dc.addObserver(this);
	}
	public void notificationUpdate(){
		ArrayList<Game> arrayGames = dc.getGames();
		PushService.subscribe(activity.getApplicationContext(),"HEJ", StartActivity.class);
		Set<String> setOfAllSubscriptions = PushService.getSubscriptions(activity.getApplicationContext());
		List<String> list = new ArrayList<String>(setOfAllSubscriptions);
		Collections.sort(arrayGames);
		Collections.sort(list);
		Log.d("Here", "Before for loop");
		
		for(Game g : arrayGames){
			String gameIDcurrentPlayer = g.getGameId() + dc.getCurrentPlayer().getParseId();
			String gameIDopponentPlayer = g.getGameId() + g.getOpponent(dc.getCurrentPlayer()).getParseId();
			Log.d("Here", gameIDcurrentPlayer);
			Log.d("Here", gameIDopponentPlayer);
			for(String s : list){	

				if(!s.equals(gameIDcurrentPlayer) && !s.equals(gameIDopponentPlayer)){
					PushService.subscribe(activity.getApplicationContext(), gameIDopponentPlayer, StartActivity.class);
					PushService.subscribe(activity.getApplicationContext(),gameIDcurrentPlayer, StartActivity.class);
					Log.d("if1","current added");
					break;
				}
				else if(g.isFinished() && (s.equals(gameIDcurrentPlayer) || s.equals(gameIDopponentPlayer))){
					Log.d("Here", "else if");
					PushService.unsubscribe(activity.getApplicationContext(), gameIDcurrentPlayer);
					PushService.unsubscribe(activity.getApplicationContext(), gameIDopponentPlayer);
				}
			}		
		}
	}

	public void setGameListView(ListView gameListView){
		this.gameListView = gameListView;
	}

	public void initiate(){
		String string = dc.getCurrentPlayer().getName();
		activity.setAccountName(string);
	}

	public void update(){
		updateList(dc.getGames());
		dc.getInvitations();
	}


	/**
	 * Private Method - Called when a new updated game list is received from the database.
	 */
	private void updateList(ArrayList<Game> gameList){
		LinkedHashMap<String, ArrayList<Game>> listMap = new LinkedHashMap<String, ArrayList<Game>>();
		score = new TreeMap<Game, Map<Player, Integer>>();
		parseList(listMap, gameList);

		createListView(listMap);
	}
	
	/**
	 * Private method which is called after an updated list of invitations is received.
	 */
	private void setInvitationStatus(List<Invitation> invites){
		activity.setInvitations(invites.size());
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
	private void parseList(LinkedHashMap<String, ArrayList<Game>> listMap, ArrayList<Game> gameList) {
		for (String s : headers) {
			listMap.put(s, new ArrayList<Game>());
		}
		for (Game g : gameList) {
			score.put(g, dc.getGameScore(g));
			if (g.isFinished())
				listMap.get("Finished games").add(g);
			else if (g.getCurrentPlayer().equals(dc.getCurrentPlayer()) && !g.isFinished())
				listMap.get("Your turn").add(g);
			else
				listMap.get("Opponent's turn").add(g);
		}
	}

	public void createListView(LinkedHashMap<String, ArrayList<Game>> listMap){
		adapter = new SeparatedListAdapter(activity);
		for (String s : headers) {
			if(!listMap.get(s).isEmpty()) {
				adapter.addSection(s, new GameAdapter(activity, listMap.get(s), dc.getCurrentPlayer(), score));		
			}
		}

		// Set the adapter on the ListView holder 
		gameListView.setAdapter(adapter);

		// Listen for Click events
		gameListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long duration) {
				Game game = (Game) adapter.getItem(position-1);
				Intent intent = new Intent(activity, GameDashboardActivity.class);
				intent.putExtra("Game", game);
				activity.startActivity(intent);
			}
		});
	}

	/**
	 * Log out the current user
	 */
	public void logOut() {
		dc.logOutPlayer(activity);
		goToLoginActivity();
	}

	/**
	 * Called in order to unregister this presenter from the list of observers in the db.
	 */
	public void unRegisterObserver(){
		dc.deleteObserver(this);
	}

	/**
	 * Called whenever a message is received from the DataController
	 * 	This method will override the default, but will pass on the message
	 * 	to super when appropriate
	 * @param obs - The observer
	 * @param obj - The object included in the message
	 */
	public void update(Observable obs, Object obj) {
		if(obj.getClass().equals(DCMessage.class)
				&& obj != null){
			DCMessage dcm = (DCMessage) obj;
			if (dcm.getMessage() == DCMessage.DATABASE_GAMES){
				updateList((ArrayList<Game>) dcm.getData());
			} else if (dcm.getMessage() == DCMessage.INVITATIONS){
				setInvitationStatus((List<Invitation>) dcm.getData());
			}
		}
	}
}
