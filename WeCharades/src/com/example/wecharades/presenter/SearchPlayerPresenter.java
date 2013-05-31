package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.R;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.views.SearchPlayerActivity;
import com.parse.ParseException;
import com.parse.ParsePush;

/**
 * Presenter-class intended to enable search for player and gathering information making it possible
 * @author weCharade
 */
public class SearchPlayerPresenter extends Presenter {

	private SearchPlayerActivity activity;
	
	/**
	 * Create an instance of SearchPlayerPresenter
	 * @param activity
	 */
	public SearchPlayerPresenter(SearchPlayerActivity activity) {
		super(activity);
		this.activity = (SearchPlayerActivity) activity;
	}
	
	/**
	 * Listen for press Done-button on keyboard
	 * @param searchBox
	 */
	public void setListeners(EditText searchBox) {
		searchBox.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEARCH) {
					//Search for player by calling onClickSearch-method in acitivty
					activity.onClickSearch(v);
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
	/**
	 * Search for a player
	 * @param searchString	String which user has entered
	 */
	public void performSearch(String searchString) {
		try {

			ListView view = (ListView) activity.findViewById(R.id.result_list);
			
			//This TextView is displayed if no invitations were found
			TextView text = (TextView) activity.findViewById(R.id.empty_list_item);
			text.setText("No results found!");
			view.setEmptyView(text);

			SortedSet<String> list = dc.getAllOtherPlayerNames().subSet(searchString, searchString + Character.MAX_VALUE);
			
			//Create a list of player who the player cannot send an invitation to:
			TreeSet<String> alreadySent 	= new TreeSet<String>();
			TreeSet<String> alreadyPlaying 	= new TreeSet<String>();
			
			for(Invitation inv : dc.getSentInvitations()){
				//Add all usernames the user has sent invitations to
				alreadySent.add(inv.getInvitee().getName());
			}
			
			for(Game g : dc.getGames()){
				//We should only disallow non-finished games
				if(!g.isFinished()){
					alreadyPlaying.add(g.getOpponent(dc.getCurrentPlayer()).getName());
				}
			}
			
			
			ArrayList<String> resultList = new ArrayList<String>(list);
			if (!list.isEmpty())
				//Set the adapter for the view and create a new instance of SearchPlayerAdapter which manages ListView filling
				view.setAdapter(new SearchPlayerAdapter(activity, resultList, alreadySent, alreadyPlaying));
		} catch (DatabaseException e) {
			activity.showNegativeDialog("Error", e.prettyPrint(), "OK");
		}
	}
	
	/**
	 * Send invitation to player and update database
	 * @param invitee
	 */
	public void invite(String invitee) {
		try {
			//inform DataController that a invitation should be sent
			dc.sendInvitation(dc.getPlayer(invitee));
			//send notification to the invitee
			sendNotificationtoOtherPlayer(invitee);
		} catch (DatabaseException e){
			activity.showNegativeDialog("Error", e.prettyPrint(), "OK");
		}

	}
	
	/**
	 * Send notification about invitation
	 * @param invitee
	 */
	private void sendNotificationtoOtherPlayer(String invitee) {
		ParsePush push = new ParsePush();
		push.setChannel(invitee);
		push.setMessage("Charade invitation from: " + dc.getCurrentPlayer().getName());
		try {
			push.send();
		} catch (ParseException e) {
			//Failure to send results in that the push notification will be sent in a background thread
			push.sendInBackground();
		}
	}
}
