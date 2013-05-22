package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
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

	public void updateUsername(String newUsername) {
		username.setText(newUsername);
	}

	public void updateRanking(int newGlobalRanking, int globalScore) {
		globalRanking.setText("Global ranking: " + newGlobalRanking + " ("+ globalScore +" points)");
	}

	public void updatePlayedGames(int newPlayedGames) {
		playedGames.setText("Played games: " + newPlayedGames);
	}

	public void updateWonGames(int newWonGames) {
		wonGames.setText("Won games: " + newWonGames);
	}

	public void updateLostGames(int newLostGames) {
		lostGames.setText("Lost games: " + newLostGames);
	}

	public void updateDrawGames(int newDrawGames) {
		drawGames.setText("Draw games: " + newDrawGames);
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onClickGameInstructions(View view) {
		((AccountPresenter) presenter).gameInstructions();
	}

	public void onClickDeleteAccount(View view) {
		((AccountPresenter) presenter).deleteAccount();
	}


}
