package com.example.wecharades.presenter;

import android.content.Intent;

import com.example.wecharades.model.Player;
import com.example.wecharades.views.AccountActivity;
import com.example.wecharades.views.GameInstructionsActivity;

public class AccountPresenter extends Presenter {

	private AccountActivity activity;
	public AccountPresenter(AccountActivity activity) {
		super(activity);
		this.activity = activity;
	}

	public void update() {
		Player currentPlayer = dc.getCurrentPlayer();

		activity.updatePlayerInformation(
				currentPlayer.getName(),
				currentPlayer.getGlobalScore(),
				currentPlayer.getPlayedGames(),
				currentPlayer.getWonGames(),
				currentPlayer.getLostGames(),
				currentPlayer.getDrawGames());
	}

	/**
	 * Called when Game Instructions button is clicked
	 */
	public void gameInstructions() {
		Intent i = new Intent(activity.getApplicationContext(), GameInstructionsActivity.class);
		activity.startActivity(i);
	}
	
	/**
	 * Log out the current user
	 */
	public void logOut() {
		dc.logOutPlayer(activity);
		goToLoginActivity();
	}
}
