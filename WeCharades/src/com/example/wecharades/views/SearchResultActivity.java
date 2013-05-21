package com.example.wecharades.views;

import com.example.wecharades.presenter.SearchResultPresenter;
import android.app.ListActivity;
import android.os.Bundle;

public class SearchResultActivity extends ListActivity {
	SearchResultPresenter presenter;
	
	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		presenter = new SearchResultPresenter(this);
		
	}
	
	/**
	 * 
	 */
	@Override
	protected void onStart() {
		super.onStart();
		presenter.setPlayersList();
		getListView().setAdapter(presenter.performSearch(getIntent().getExtras().getString("username")));
	}
	
	public void invite(String invitee){
		presenter.invite(invitee);
	}
}
