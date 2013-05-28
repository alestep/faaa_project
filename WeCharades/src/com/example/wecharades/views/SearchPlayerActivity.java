package com.example.wecharades.views;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.R;
import com.example.wecharades.model.LoadProgressBar;
import com.example.wecharades.presenter.SearchPlayerPresenter;

/**
 * 
 * @author Alexander
 *
 */
public class SearchPlayerActivity extends GenericActivity {
	
	private EditText searchBox;
	private SearchPlayerPresenter presenter;
	
	/**
	 * 
	 */ //TODO extend generic acitivity and presenter
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new SearchPlayerPresenter(this));

		
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.search_player_screen);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_other); 
		presenter = (SearchPlayerPresenter) super.getPresenter();
		
		// Get reference to search box
		searchBox = (EditText) findViewById(R.id.search_window);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		searchBox.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEARCH) {
					onClickSearch(v);
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
	/**
	 * 
	 * @param view
	 */
	public void onClickSearch(View view){
		presenter.update(searchBox.getText().toString());
		searchBox.setText("");
		
	}
	
	public void invite(String invitee){
		presenter.invite(invitee);
	}
	
	public void onClickHome(View v){
		startActivity(new Intent(this, StartActivity.class));
	}

	@Override
	protected LoadProgressBar getProgressBar() {
		// TODO Auto-generated method stub
		return null;
	}
}
