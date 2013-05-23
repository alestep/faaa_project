package com.example.wecharades.views;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.wecharades.R;
import com.example.wecharades.presenter.SearchPlayerPresenter;
import com.example.wecharades.presenter.SimplePresenter;

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
		setContentView(R.layout.search_player_screen);
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

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}
}
