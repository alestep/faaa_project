package com.example.wecharades.views;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.wecharades.R;
/**
 * 
 * @author Alexander
 *
 */
public class SearchPlayerActivity extends Activity {
	
	private EditText searchBox;
	
	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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
}
