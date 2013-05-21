package com.example.wecharades.views;

import com.example.wecharades.R;
import com.example.wecharades.presenter.SearchResultPresenter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchResultActivity extends ListActivity {
	SearchResultPresenter presenter;
	
	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		presenter = new SearchResultPresenter(this);
		presenter.setPlayersList();
		getListView().setAdapter(presenter.performSearch(getIntent().getExtras().getString("username")));
		
	}
	
	/**
	 * 
	 */
	@Override
	protected void onStart() {
		super.onStart();
		presenter.setPlayersList();
	}
}
