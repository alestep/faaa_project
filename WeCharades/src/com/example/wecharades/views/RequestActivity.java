package com.example.wecharades.views;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.RequestPresenter;
import com.example.wecharades.presenter.SeparatedListAdapter;

public class RequestActivity extends Activity {
	private RequestPresenter presenter;
	
	// Adapter for ListView Contents
	private SeparatedListAdapter adapter;
	
	/**
	 * 
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_screen);
		ListView requestList = (ListView) findViewById(R.id.list);
		presenter = new RequestPresenter(this);
		adapter = new SeparatedListAdapter(this);
	}
	

	public void onStart() {
		super.onStart();
	}
}
