package com.example.wecharades.views;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.R;
import com.example.wecharades.model.LoadProgressBar;
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
	private RefreshProgressBar refresh;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new SearchPlayerPresenter(this));

		
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.search_player_screen);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_refresh_home); 
		
        // Get references to instances
        presenter = (SearchPlayerPresenter) super.getPresenter();
		searchBox = (EditText) findViewById(R.id.search_window);
		refresh = new RefreshProgressBar(this, (ImageButton) findViewById(R.id.refresh));
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
		startActivity(new Intent(this, StartActivity.class));
		finish();
	}
	
	/**
	 * Refresh screen
	 * @param v
	 */
	public void onClickRefresh(View v){
		presenter.update(searchBox.getText().toString());
	}

	@Override
	protected RefreshProgressBar getProgressBar() {
		return refresh;
	}
}
