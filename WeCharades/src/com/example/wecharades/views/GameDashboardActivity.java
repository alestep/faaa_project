package com.example.wecharades.views;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.GameDashboardPresenter;

public class GameDashboardActivity extends GenericActivity {

	private TableLayout myTable;
	private TextView title;
	private TextView yourScore;
	private TextView opponentsScore;
	GameDashboardPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new GameDashboardPresenter(this));
		setContentView(R.layout.game_screen);
		presenter = (GameDashboardPresenter) super.getPresenter();
		title = (TextView) findViewById(R.id.titleText);
		yourScore = (TextView) findViewById(R.id.yourScore);
		opponentsScore = (TextView) findViewById(R.id.opponentScore);
		myTable = (TableLayout) findViewById(R.id.table);
	}
	
	public void onStart(){
		super.onStart();
		presenter.createDashboard(myTable);
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return title;
	}
	
	public void updateScore(int currentPlayersScore, int otherPlayerScore) {
		yourScore.setText("Your score: "+ currentPlayersScore + " points");
		opponentsScore.setText("Opponent's score: "+ otherPlayerScore + " points");
	}
}
