package com.example.wecharades.presenter;

import android.content.Intent;

import com.example.wecharades.model.Player;
import com.example.wecharades.views.AccountActivity;
import com.example.wecharades.views.GameInstructionsActivity;
import com.example.wecharades.views.StartActivity;

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
				currentPlayer.getGlobalRanking(),
				currentPlayer.getGlobalScore(),
				currentPlayer.getNumberOfFinishedGames(),
				currentPlayer.getNumberOfWonGames(),
				currentPlayer.getNumberOfLostGames(),
				currentPlayer.getNumberOfDrawGames());

	}

	/**
	 * Called when Game Instructions button is clicked
	 */
	public void gameInstructions() {
		Intent i = new Intent(activity.getApplicationContext(), GameInstructionsActivity.class);
		activity.startActivity(i);
	}

	/**
	 * Called when Delete Account button is clicked
	 */
	public void deleteAccount() {
		//This doesn't do anything atm. TODO: fix!
		dc.deleteAccount();
	}
	
	/**
	 * Log out the current user
	 */
	public void logOut() {
		dc.logOutPlayer();
		goToLoginActivity();
	}
}
