package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.presenter.Database;
import com.example.wecharades.presenter.GameDashboardPresenter;
import com.parse.ParseUser;

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
		presenter.createDashboard(myTable);
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
