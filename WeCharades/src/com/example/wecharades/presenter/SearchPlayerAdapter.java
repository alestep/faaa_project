package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.TreeSet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.views.SearchPlayerActivity;
import com.parse.ParsePush;

public class SearchPlayerAdapter extends ArrayAdapter<String> {
	private ArrayList<String> resultList;
	private LayoutInflater li;
	private SearchPlayerActivity activity;
	private TreeSet<String> sentInvitations;
	
	/**
	 * 
	 * @param activity
	 * @param resultList
	 * @param sentInvitations
	 */
	public SearchPlayerAdapter(SearchPlayerActivity activity, ArrayList<String> resultList, TreeSet<String> sentInvitations) {
		super(activity, 0, resultList);
		this.sentInvitations = sentInvitations;
		this.resultList = resultList;
		this.activity = activity;
		this.li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;
		final String s = resultList.get(position);

		if (s != null) {
				v = li.inflate(R.layout.list_item_search_result, null);
				final TextView username = (TextView) v.findViewById(R.id.username);
				if (username != null)
					username.setText(s); 
		}

		final Button play = (Button) v.findViewById(R.id.play);

		if (sentInvitations.contains(s)) {
			play.setEnabled(false);
			play.setClickable(false);
			play.setText("Sent");

		}

		play.setOnClickListener(new OnClickListener(){ 

			@Override
			public void onClick(View v){
				play.setEnabled(false);	
				play.setClickable(false);
				play.setText("Sent");
				activity.invite(s);	
	
			}
		}); 
		
		return v;
	}
}
