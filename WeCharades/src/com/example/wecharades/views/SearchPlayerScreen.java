package com.example.wecharades.views;

import com.example.wecharades.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class SearchPlayerScreen extends Activity {
	
	private ListView searchResults;
	private EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_player_screen);

		// Get a reference to the ListView holder
		searchResults = (ListView) this.findViewById(R.id.search_result_list);

		View header = LayoutInflater.from(this).inflate(R.layout.search_screen_header, searchResults, false);

		searchResults.addHeaderView(header);
		
		et = (EditText) findViewById(R.id.search_window);
		
		String [] array = {"Bajs", "Kiss"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, R.layout.result_list_item, array);
		searchResults.setAdapter(adapter);
	}
	
	public void onClickSearch(View view) {
		et.getText().toString();
	}
}
