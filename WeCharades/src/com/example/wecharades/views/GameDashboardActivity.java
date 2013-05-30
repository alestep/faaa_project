package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.GameDashboardPresenter;

/**
 * View which displays the game dashboard
 * @author weCharade
 */
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
		
		//Set the title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.game_screen);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_refresh_home); 
		
		//Get references to instances
		presenter = (GameDashboardPresenter) super.getPresenter();
		title = (TextView) findViewById(R.id.titleText);
		yourScore = (TextView) findViewById(R.id.yourScore);
		opponentsScore = (TextView) findViewById(R.id.opponentScore);
		myTable = (TableLayout) findViewById(R.id.table);
		
		//This class uses a RefreshProgressBar to visualize that data is fetched in the background
		refresh = new RefreshProgressBar(this, (ImageButton) findViewById(R.id.refresh));
	}
	
	@Override
	public void onStart(){
		super.onStart();
		presenter.createDashboard(myTable);
	}
	
	/**
	 * Updates both players' scores
	 * @param currentPlayersScore
	 * @param otherPlayerScore
	 */
	public void updateScore(int currentPlayersScore, int otherPlayerScore) {
		yourScore.setText(Integer.toString(currentPlayersScore));
		opponentsScore.setText(Integer.toString(otherPlayerScore));
	}
	
	/**
	 * Set title of the Game dashboard
	 * @param title
	 */
	public void setTitle(String title) {
		this.title.setText(title);
	}
	
	/**
	 * Refresh the the screen
	 * @param v
	 */
	public void onClickRefresh(View v) {
		presenter.createDashboard(myTable);
	}
	
	/**
	 * Go to StartActivity
	 * @param v
	 */
	public void onClickHome(View v){
		presenter.goToStartActivity();
	}
	
	@Override
	protected RefreshProgressBar getProgressBar() {
		return refresh;
	}
}
