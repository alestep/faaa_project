package com.example.wecharades.views;

import com.example.wecharades.R;
import com.example.wecharades.SeparatedListAdapter;
import com.example.wecharades.model.Game;
import com.example.wecharades.presenter.Database;
import com.example.wecharades.presenter.SearchResultPresenter;
import com.example.wecharades.presenter.StartPresenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

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
