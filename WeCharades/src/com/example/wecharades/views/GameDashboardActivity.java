package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.RefreshProgressBar;
import com.example.wecharades.presenter.GameDashboardPresenter;

public class GameDashboardActivity extends GenericActivity {

	private TableLayout myTable;
	private TextView title;
	private TextView yourScore;
	private TextView opponentsScore;
	private RefreshProgressBar refresh;
	private GameDashboardPresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new GameDashboardPresenter(this));
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.game_screen);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_refresh); 
		
		//Get references to instances
		presenter = (GameDashboardPresenter) super.getPresenter();
		title = (TextView) findViewById(R.id.titleText);
		yourScore = (TextView) findViewById(R.id.yourScore);
		opponentsScore = (TextView) findViewById(R.id.opponentScore);
		myTable = (TableLayout) findViewById(R.id.table);
		refresh = new RefreshProgressBar(this, (ImageButton) findViewById(R.id.refresh));
	}
	
	public void onStart(){
		super.onStart();
		presenter.createDashboard(myTable);
	}
	
	public void updateScore(int currentPlayersScore, int otherPlayerScore) {
		yourScore.setText(Integer.toString(currentPlayersScore));
		opponentsScore.setText(Integer.toString(otherPlayerScore));
	}
	
	public void setTitle(String title) {
		this.title.setText(title);
	}

	@Override
	protected RefreshProgressBar getProgressBar() {
		return refresh;
	}
	
	public void onClickRefresh(View v) {
		presenter.createDashboard(myTable);
	}
	
	public void onClickHome(View v){
		startActivity(new Intent(this, StartActivity.class));
	}
}
