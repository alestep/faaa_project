package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.HighScorePresenter;

/**
 * View which displays a global high score and the current player's ranking
 * @author weCharade
 */
public class HighScoreActivity extends GenericActivity {

	private TableLayout myTable;
	private HighScorePresenter presenter;
	private TextView globalRanking;
	private RefreshProgressBar refresh;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new HighScorePresenter(this));
		
		//Set the title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.highscore);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_refresh_home); 
		
		//Get references to instances
		myTable = (TableLayout) findViewById(R.id.table);
		globalRanking = (TextView) findViewById(R.id.globalRanking);
		presenter = (HighScorePresenter) super.getPresenter();

		/*
		 * This class uses a RefreshProgressBar to visualize that data is fetched in the background
		 */
		refresh = new RefreshProgressBar(this, (ImageButton) findViewById(R.id.refresh));
	}
	
	@Override
	public void onStart(){
		super.onStart();
		presenter.updateHighScores(myTable);
	}
	
	/**
	 * Set current user's global ranking
	 * @param globalRankingPosition
	 * @param totalNumberOfUsers
	 */
	public void updateGlobalRanking(int globalRankingPosition, int totalNumberOfUsers) {
		globalRanking.setText("Your global ranking position is " + globalRankingPosition + " out of " + totalNumberOfUsers);
	}
	
	/**
	 * Refresh the screen
	 * @param view
	 */
	public void onClickRefresh(View view){
		presenter.updateHighScores(myTable);
	}
	
	/**
	 * Go to StartActivity
	 * @param view
	 */
	public void onClickHome(View view){
		presenter.goToStartActivity();
	}
	
	@Override
	protected RefreshProgressBar getProgressBar() {
		return refresh;
	}

}
