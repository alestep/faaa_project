package com.example.wecharades.views;

import android.app.ListActivity;
import android.os.Bundle;
import com.example.wecharades.presenter.SearchResultPresenter;

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
		presenter.update();
	}

	public void invite(String invitee){
		presenter.invite(invitee);
	}
}
