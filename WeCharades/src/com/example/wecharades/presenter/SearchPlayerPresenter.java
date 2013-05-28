package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import android.widget.ListView;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.views.SearchPlayerActivity;
import com.parse.ParseException;
import com.parse.ParsePush;

public class SearchPlayerPresenter extends Presenter {
	
	private SearchPlayerActivity activity;
	
	
	/**
	 * 
	 * @param activity
	 */
	public SearchPlayerPresenter(SearchPlayerActivity activity) {
		super(activity);
		this.activity = (SearchPlayerActivity) activity;
	}
	
	public void update(String s){
		performSearch(s);
	}

	private void performSearch(String searchString) {
		try {

			ListView view = (ListView) activity.findViewById(R.id.result_list);
			TextView text = (TextView) activity.findViewById(R.id.empty_list_item);
			text.setText("No results found!");
			view.setEmptyView(text);
			
			SortedSet<String> list = dc.getAllOtherPlayerNames().subSet(searchString, searchString + Character.MAX_VALUE);
			TreeSet<String> sentInvitations = dc.getSentInvitationsAsUsernames();
			ArrayList<String> resultList = new ArrayList<String>(list);
			if (!list.isEmpty())
				view.setAdapter(new SearchPlayerAdapter(activity, resultList, sentInvitations));
		} catch (DatabaseException e) {
			activity.showErrorDialog(e.prettyPrint());
		}
		
	}

	public void invite(String invitee) {
		try {
			dc.sendInvitation(dc.getPlayer(invitee));
			sendNotificationtoOtherPlayer(invitee);
		} catch (DatabaseException e){
			activity.showErrorDialog(e.prettyPrint());
		}
		
	}

	private void sendNotificationtoOtherPlayer(String invitee) {
		ParsePush push = new ParsePush();
		System.out.println(invitee);
		push.setChannel(invitee);
		push.setMessage("Charade invitation from: " + dc.getCurrentPlayer().getName());
		try {
			push.send();
		} catch (ParseException e) {
			System.out.println("ParseException");
			push.sendInBackground();
		}
		System.out.println("4");
	}

}
