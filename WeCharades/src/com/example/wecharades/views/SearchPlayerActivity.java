package com.example.wecharades.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.SearchPlayerPresenter;

/**
 * 
 * @author Alexander
 *
 */
public class SearchPlayerActivity extends Activity {
	
	private ListView searchResults;
	private EditText searchBox;
	private SearchPlayerPresenter presenter;

	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_player_screen);
		
		// Set the presenter
		presenter = new SearchPlayerPresenter(this);
		
		// Get a reference to the ListView holder
		searchResults = (ListView) this.findViewById(R.id.search_result_list);
		
		// Get a reference to the EditText in which the user enters the search text
		searchBox = (EditText) findViewById(R.id.search_window);
		
		// Inflate the Search screen header in the ListView
		View header = LayoutInflater.from(this).inflate(R.layout.search_screen_header, searchResults, false);
		searchResults.addHeaderView(header);

		String [] array = {"Bajs", "Kiss"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, R.layout.result_list_item, array);
		searchResults.setAdapter(adapter);
	}
	
	@Override
	protected void onStart() {
		//TODO: Implement
	}
	
	/**
	 * 
	 * @param view
	 */
	public void onClickSearch(View view){
		presenter.performSearch(searchBox.getText().toString());
	}
}
