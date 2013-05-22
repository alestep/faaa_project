package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import android.app.Activity;

import com.example.wecharades.model.Player;
import com.example.wecharades.views.SearchResultActivity;

public class SearchResultPresenter extends Presenter {
	
	private SearchResultActivity activity;
	private ArrayList<Player> players;
	private SortedSet<String> usernames;
	
	
	/**
	 * 
	 * @param activity
	 */
	public SearchResultPresenter(Activity activity) {
		super(activity);
		this.activity = (SearchResultActivity) activity;
	}
	
	/**
	 * 
	 */
	public void setPlayersList () {
		try {
			players = Database.getPlayers();
		} catch (Exception e) {
			e.getMessage();
		}
		
		usernames = new TreeSet<String>(new Comparator<String>() {
			  public int compare(String s1, String s2) {
				    return s1.compareToIgnoreCase(s2);
				  }
		});
		
		for (Player p : players) {
			if (!p.getName().equals(model.getCurrentPlayer().getName()))
				usernames.add(p.getName());
		}
	}

	public SearchResultAdapter performSearch(String searchString) {
		setPlayersList();
		SortedSet<String> resultList = usernames.subSet(searchString, searchString + Character.MAX_VALUE);
		ArrayList<String> list = new ArrayList<String>(resultList);
		//TODO: Kolla om det går att hämta ListViewn här. Dvs gör metoden till void!
		//activity.getListView().setAdapter(new SearchResultAdapter(activity.getApplicationContext(), list));
		return new SearchResultAdapter(activity, list);
		
	}

	public void invite(String invitee) {
		try {
			db.invitePlayer(db.getPlayer(getCurrentUser().getUsername()), db.getPlayer(invitee));
		} catch (Exception e){
			e.getMessage();
		}
		
	}
}
