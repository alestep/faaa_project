package com.example.wecharades.views;

import com.example.wecharades.R;
import com.example.wecharades.SeparatedListAdapter;
import com.example.wecharades.R.id;
import com.example.wecharades.R.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class SearchPlayerScreen extends Activity {
	
	private ListView searchResults;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_player_screen);

		// Get a reference to the ListView holder
		searchResults = (ListView) this.findViewById(R.id.search_result_list);

		View header = LayoutInflater.from(this).inflate(R.layout.search_screen_header, searchResults, false);

		searchResults.addHeaderView(header);
		
		String [] array = {"Bajs", "Kiss"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, R.layout.result_list_item, array);
		searchResults.setAdapter(adapter);
	}
}
