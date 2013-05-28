package com.example.wecharades.views;


import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.example.wecharades.R;
import com.example.wecharades.model.RefreshProgressBar;
import com.example.wecharades.presenter.SearchPlayerPresenter;

/**
 * 
 * @author Alexander
 *
 */
public class SearchPlayerActivity extends GenericActivity {
	
	private EditText searchBox;
	private SearchPlayerPresenter presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new SearchPlayerPresenter(this));

		
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.search_player_screen);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_home); 
		
        // Get references to instances
        presenter = (SearchPlayerPresenter) super.getPresenter();
		searchBox = (EditText) findViewById(R.id.search_window);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		presenter.setListeners(searchBox);
	}
	
	/**
	 * Perform a search
	 * @param view
	 */
	public void onClickSearch(View view){
		presenter.update(searchBox.getText().toString());
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
	 * Go back to Home screen
	 * @param v
	 */
	public void onClickHome(View v){
		presenter.goToStartActivity();
	}

	@Override
	protected RefreshProgressBar getProgressBar() {
		return null;
	}
}
