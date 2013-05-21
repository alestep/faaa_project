package com.example.wecharades.views;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.GameDashboardPresenter;

public class GameDashboardActivity extends GenericActivity {

	private TableLayout myTable;
	private TextView title;
	GameDashboardPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_screen);
		presenter = new GameDashboardPresenter(this);
		title = (TextView) findViewById(R.id.titleText);
		myTable = (TableLayout) findViewById(R.id.table);	


		// TEMPORARY GAMES AND PLAYERS
//		Player p1 = null;
//		try {
//			p1 = Database.getPlayerById("86MJ08m46V");
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Player p2 = null;
//		try {
//			p2 = Database.getPlayerById("GNR2rDKDly");
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(p1 != null || p2 != null) {
//			try {
//				Database.createGame(p1, p2);
//			} catch (DatabaseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			Log.d("null", "p1 eller p2 Šr null");
//		} 
		
//		Game g = null;
//		try {
//			g = Database.getGame("sgdgYN1nNG");
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		presenter.createDashboard(g, myTable);
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
