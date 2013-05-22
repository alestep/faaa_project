package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import android.app.Activity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.SearchResultActivity;

public class SearchResultPresenter extends Presenter {
	
	private SearchResultActivity activity;
	
	
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

	private void performSearch(String searchString) {
		try {
			ListView view = (ListView) activity.findViewById(R.id.list);
			TextView text = (TextView) activity.findViewById(R.id.empty_list_item);
			text.setText("No results found!");
			view.setEmptyView(text);
			
			SortedSet<String> list = dc.getAllOtherPlayerNames().subSet(searchString, searchString + Character.MAX_VALUE);
			TreeSet<String> sentInvitations = dc.getSentInvitationsAsUsernames();
			ArrayList<String> resultList = new ArrayList<String>(list);
			if (!list.isEmpty())
				view.setAdapter(new SearchResultAdapter(activity, resultList, sentInvitations));
		} catch (DatabaseException e) {
			activity.showMessage(e.prettyPrint());
		}
		
	}

	public void invite(String invitee) {
		try {
			dc.sendInvitation(dc.getPlayer(invitee));
		} catch (DatabaseException e){
			activity.showMessage(e.prettyPrint());
		}
		
	}
}
