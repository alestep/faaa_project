package com.example.wecharades.views;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wecharades.R;
//import com.example.wecharades.presenter.SimplePresenter;
/**
 * 
 * @author Alexander
 *
 */
public class SearchPlayerActivity extends GenericActivity {
	
	private EditText searchBox;
	
	/**
	 * 
	 */ //TODO extend generic acitivity and presenter
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//super.onCreate(savedInstanceState, new SimplePresenter(this));
		
		// Sets the View Layer
		setContentView(R.layout.search_player_screen);
		
		// Get reference to search box
		searchBox = (EditText) findViewById(R.id.search_window);
		
	}
	
	/**
	 * 
	 * @param view
	 */
	public void onClickSearch(View view){
		Intent intent = new Intent(this, SearchResultActivity.class);
		intent.putExtra("username", searchBox.getText().toString());
		searchBox.setText("");
		startActivity(intent);
		
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}
}
