package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import android.app.Activity;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.SearchResultActivity;

public class SearchResultPresenter extends Presenter {
	
	private SearchResultActivity activity;
	//TODO Remove if not necessary
	//private ArrayList<Player> players;
	//private SortedSet<String> usernames;
	
	
	/**
	 * 
	 * @param activity
	 */
	public SearchResultPresenter(Activity activity) {
		super(activity);
		this.activity = (SearchResultActivity) activity;
	}
	
	public SearchResultAdapter performSearch(String searchString) {
		TreeSet<String> usernames = null;
		try {
			usernames = dc.getAllOtherPlayerNames();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO what is a sorted set, and do we need it? A TreeSet is somewhat sorted
		SortedSet<String> resultList = usernames.subSet(searchString, searchString + Character.MAX_VALUE);
		ArrayList<String> list = new ArrayList<String>(resultList);
		//TODO: Kolla om det går att hämta ListViewn här. Dvs gör metoden till void!
		//activity.getListView().setAdapter(new SearchResultAdapter(activity.getApplicationContext(), list));
		return new SearchResultAdapter(activity, list);
		
	}

	public void invite(String invitee) {
		try {
			dc.sendInvitation(dc.getPlayer(invitee));
		} catch (Exception e){
			e.getMessage();
		}
		
	}
}
