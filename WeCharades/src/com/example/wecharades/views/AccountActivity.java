package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.AccountPresenter;

/**
 * View which displays account information
 * @author weCharade
 */
public class AccountActivity extends GenericActivity {

	private AccountPresenter presenter;
	private RefreshProgressBar refresh;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new AccountPresenter(this));

		//Set the title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.account_screen);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_refresh_home); 

		//Get references to instances.
		presenter = (AccountPresenter) super.getPresenter();
		
		/*
		 * This class uses a RefreshProgressBar to visualize that the screen is refreshed
		 */
		refresh = new RefreshProgressBar(this, (ImageButton) findViewById(R.id.refresh));
	}

	@Override
	public void onStart() {
		super.onStart();

		//Update the background information
		presenter.update();
	}

	/**
	 * Go to GameInstructionsActivity
	 * @param view
	 */
	public void onClickGameInstructions(View view) {
		startActivity(new Intent(this, GameInstructionsActivity.class));
		finish();
	}

	/**
	 * To to LoginActivity
	 * @param view
	 */
	public void onClickLogout(View view) {
		presenter.logOut();
	}

	/**
	 * Refresh the screen
	 * @param view
	 */
	public void onClickRefresh(View view){
		presenter.update();
	}

	/**
	 * Go to StartActivity
	 * @param view
	 */
	public void onClickHome(View view){
		presenter.goToStartActivity();
	}


	/**
	 * Update player information and statistics
	 * @param newUsername
	 * @param newGlobalRanking
	 * @param globalScore
	 * @param numberOfFinishedGames
	 * @param numberOfWonGames
	 * @param numberOfLostGames
	 * @param numberOfDrawGames
	 */
	public void updatePlayerInformation(String newUsername, int globalRanking,
			int globalScore, int numberOfFinishedGames, int numberOfWonGames,
			int numberOfLostGames, int numberOfDrawGames) {

		TextView username = (TextView) findViewById(R.id.username);
		TextView ranking = (TextView) findViewById(R.id.globalRanking);
		TextView playedGames = (TextView) findViewById(R.id.playedGames);
		TextView wonGames = (TextView) findViewById(R.id.wonGames);
		TextView lostGames = (TextView) findViewById(R.id.lostGames);
		TextView drawGames = (TextView) findViewById(R.id.drawGames);

		username.setText(newUsername);
		ranking.setText(Integer.toString(globalRanking) + " ("+ globalScore +" points)");
		playedGames.setText(Integer.toString(numberOfFinishedGames));
		wonGames.setText(Integer.toString(numberOfWonGames));
		lostGames.setText(Integer.toString(numberOfLostGames));
		drawGames.setText(Integer.toString(numberOfDrawGames));
	}

	@Override
	protected RefreshProgressBar getProgressBar() {
		return refresh;
	}
}
