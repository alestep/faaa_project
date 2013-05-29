package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.IProgress;
import com.example.wecharades.model.RefreshProgressBar;
import com.example.wecharades.presenter.HighScorePresenter;

public class HighScoreActivity extends GenericActivity {

	private TableLayout myTable;
	private HighScorePresenter presenter;
	private TextView globalRanking;
	private RefreshProgressBar refresh;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new HighScorePresenter(this));

		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.highscore);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_refresh_home); 
		
		//Get references to instances
		myTable = (TableLayout) findViewById(R.id.table);
		globalRanking = (TextView) findViewById(R.id.globalRanking);
		refresh = new RefreshProgressBar(this, (ImageButton) findViewById(R.id.refresh));
		presenter = (HighScorePresenter) super.getPresenter();
	}

	public void onStart(){
		super.onStart();
		presenter.updateHighScores(myTable);
	}

	public void updateGlobalRanking(int globalRankingPosition, int totalNumberOfUsers) {
		globalRanking.setText("Your global ranking position is " + globalRankingPosition + " out of " + totalNumberOfUsers);
	}
	
	public void onClickRefresh(View view){
		presenter.updateHighScores(myTable);
	}

	@Override
	protected RefreshProgressBar getProgressBar() {
		return refresh;
	}
	
	public void onClickHome(View view){
		presenter.goToStartActivity();
	}

}
