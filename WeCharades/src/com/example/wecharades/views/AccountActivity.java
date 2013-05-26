package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.AccountPresenter;

public class AccountActivity extends GenericActivity {
	private TextView username, globalRanking, playedGames, wonGames, lostGames, drawGames;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_screen);
		presenter  = new AccountPresenter(this);
		username = (TextView) findViewById(R.id.username);
		globalRanking = (TextView) findViewById(R.id.globalRanking);
		playedGames = (TextView) findViewById(R.id.playedGames);
		wonGames = (TextView) findViewById(R.id.wonGames);
		lostGames = (TextView) findViewById(R.id.lostGames);
		drawGames = (TextView) findViewById(R.id.drawGames);
	}

	@Override
	public void onStart() {
		super.onStart();
		((AccountPresenter) presenter).update();
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Called when Game Instructions button is clicked
	 * @param view
	 */
	public void onClickGameInstructions(View view) {
		((AccountPresenter) presenter).gameInstructions();
	}
	
	/**
	 * Called when Logout button is clicked
	 * @param view
	 */
	public void onClickLogout(View view) {
		((AccountPresenter) presenter).logOut();
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
	public void updatePlayerInformation(String newUsername,
			int globalScore, int numberOfFinishedGames, int numberOfWonGames,
			int numberOfLostGames, int numberOfDrawGames) {
		username.setText(newUsername);
		//TODO fix global ranking by calculating position
		globalRanking.setText(Integer.toString(0) + " ("+ globalScore +" points)");
		playedGames.setText(Integer.toString(numberOfFinishedGames));
		wonGames.setText(Integer.toString(numberOfWonGames));
		lostGames.setText(Integer.toString(numberOfLostGames));
		drawGames.setText(Integer.toString(numberOfDrawGames));
	}

	@Override
	protected ProgressBar getProgressSpinner() {
		// TODO Auto-generated method stub
		return null;
	}


}
