package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.TreeSet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.views.SearchPlayerActivity;

/**
 * Presenter-help-class intended to manage the filling of ListView-items on the search view.
 * @author weCharade
 */
public class SearchPlayerAdapter extends ArrayAdapter<String> {
	
	private ArrayList<String> resultList;
	private SearchPlayerActivity activity;
	private TreeSet<String> alreadyPlaying;
	private TreeSet<String> alreadySent;
	
	/**
	 * Create an instance of SearchPlayerAdapter
	 * @param activity			Activity from which adapter was created
	 * @param resultList		List of players that matches a given search-string
	 * @param alreadySent		List of players which user already sent invitation to
	 * @param alreadyPlaying	List of players which user is already playing against
	 */
	public SearchPlayerAdapter(SearchPlayerActivity activity, ArrayList<String> resultList, TreeSet<String> alreadySent, TreeSet<String> alreadyPlaying) {
		
		//Do not provide any layout resource id to the super-class, hence the zero value.
		super(activity, 0, resultList);
		this.alreadyPlaying = alreadyPlaying;
		this.alreadySent = alreadySent;
		this.resultList = resultList;
		this.activity = activity;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;
		LayoutInflater li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final String s = resultList.get(position);

		if (s != null) {
				//Inflate the layout for search result items
				v = li.inflate(R.layout.list_item_search_result, null);
				final TextView username = (TextView) v.findViewById(R.id.username);
				if (username != null)
					username.setText(s); 
		}

		/*
		 * The search result items are displayed as player names with a button to the right, making it possible for the
		 * user to invite this player. A user shouldn't be able to invite another player who he or she already invited 
		 * or has an ongoing game with. However, these players are still displayed in the search result list, but disabled
		 * and with information on button in order to reduce confusion
		 */
		final Button play = (Button) v.findViewById(R.id.play);

		if (alreadySent.contains(s)) {
			play.setEnabled(false);
			play.setClickable(false);
			play.setText("Inv.Sent");
		}
		if (alreadyPlaying.contains(s)) {
			play.setEnabled(false);
			play.setClickable(false);
			play.setText("Ongoing game");
		}

		play.setOnClickListener(new OnClickListener(){ 

			@Override
			public void onClick(View v){
				play.setEnabled(false);	
				play.setClickable(false);
				play.setText("Sent");
				
				//Sent invitation to player with user name s
				activity.invite(s);	
	
			}
		}); 
		
		return v;
	}
}
