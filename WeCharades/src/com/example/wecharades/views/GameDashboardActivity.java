package com.example.wecharades.views;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Player;
import com.example.wecharades.presenter.GameDashboardPresenter;
import com.parse.Parse;

public class GameDashboardActivity extends GenericActivity {

	private TableLayout myTable;
	private TextView title;
	GameDashboardPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_screen);
		//TODO it doesn't work with presenter.initialize() :S No clue why!
		Parse.initialize(this, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
		//presenter.initialize();
		presenter = new GameDashboardPresenter(this);
		title = (TextView) findViewById(R.id.titleText);
		myTable = (TableLayout) findViewById(R.id.table);	

		//TODO: Get game from the DB instead to be able to check if the Turn-functions work! 
		
		// TEMPORARY GAMES AND PLAYERS
		Player p1 = new Player("id1", "Felix");
		Player p2 = new Player("id2", "Alex");
		
		Game g = new Game("unique_id", p1, p2, p1, 1, false, null);
		presenter.createDashboard(g, myTable);
		
	}

	public void updateButton(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return title;
	}
}
