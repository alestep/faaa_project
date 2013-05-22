package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import android.app.Activity;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.SearchResultActivity;

public class SearchResultPresenter extends Presenter {
	
	private SearchResultActivity activity;
	private TreeSet<String> usernames;
	
	
	/**
	 * 
	 * @param activity
	 */
	public SearchResultPresenter(Activity activity) {
		super(activity);
		this.activity = (SearchResultActivity) activity;
	}
	
	public void update(){
		performSearch(activity.getIntent().getExtras().getString("username"));
	}
	
	/**
	 * 
	 */
	public void setPlayersList () {
		usernames = new TreeSet<String>(new Comparator<String>() {
			public int compare(String s1, String s2){
				return s1.compareToIgnoreCase(s2);
			}
		});

		try {
			usernames = dc.getAllPlayerNames();//I removed getAllOtherPlayerNames for now... just to test some shitz
		} catch (DatabaseException e) {
			// TODO When GenericActivity implemented, activity.showMessage(e.prettyPrint());
		}
	}

	private void performSearch(String searchString) {
		setPlayersList();
		SortedSet<String> resultList = usernames.subSet(searchString, searchString + Character.MAX_VALUE);
		ArrayList<String> list = new ArrayList<String>(resultList);
		activity.getListView().setAdapter(new SearchResultAdapter(activity, list));
		
	}

	public void invite(String invitee) {
		try {
			dc.sendInvitation(dc.getPlayer(invitee));
		} catch (Exception e){
			e.getMessage();
		}
		
	}
}
