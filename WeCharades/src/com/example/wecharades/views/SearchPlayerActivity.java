package com.example.wecharades.views;


import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.example.wecharades.R;
import com.example.wecharades.presenter.SearchPlayerPresenter;

/**
 * View which displays a search functionality and makes it possible to search
 * for a player by entering his or her username
 * @author weCharade
 */
public class SearchPlayerActivity extends GenericActivity {
	
	private EditText searchBox;
	private SearchPlayerPresenter presenter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new SearchPlayerPresenter(this));

		//Set the title bar
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.search_player_screen);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_home); 
		
        // Get references to instances
        presenter = (SearchPlayerPresenter) super.getPresenter();
		searchBox = (EditText) findViewById(R.id.search_window);
	}

	@Override
	public void onStart() {
		super.onStart();
		presenter.setListeners(searchBox);
	}
	
	/**
	 * Perform a search
	 * @param view
	 */
	public void onClickSearch(View view){
		presenter.performSearch(searchBox.getText().toString());
		searchBox.setText("");
		
	}
	
	/**
	 * Send invitation to player
	 * @param invitee
	 */
	public void invite(String invitee){
		presenter.invite(invitee);
	}
	
	/**
	 * Go back to StartActivity
	 * @param v
	 */
	public void onClickHome(View v){
		presenter.goToStartActivity();
	}
	
	/*
	 * Activity is considered not to be in need of displaying an IProgress-instance.
	 * This method will therefore never be called, and it is OK to return null.
	 */
	@Override
	protected RefreshProgressBar getProgressBar() {
		return null;
	}
}
