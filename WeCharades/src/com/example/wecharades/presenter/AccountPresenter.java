package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.content.Intent;

import com.example.wecharades.model.DatabaseException;
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
		activity.showProgressBar();
		Player currentPlayer = dc.getCurrentPlayer();
		activity.updatePlayerInformation(
				currentPlayer.getName(),
				getGlobalRanking(),
				currentPlayer.getGlobalScore(),
				currentPlayer.getPlayedGames(),
				currentPlayer.getWonGames(),
				currentPlayer.getLostGames(),
				currentPlayer.getDrawGames());

		activity.hideProgressBar();
	}

	private int getGlobalRanking() {
		int globalRanking = 0;
		try{
			ArrayList<Player> allPlayers = dc.getAllPlayerObjects();

			Collections.sort(allPlayers, new Comparator<Player>(){
				@Override
				public int compare(Player p1, Player p2) {
					return p2.getGlobalScore() - p1.getGlobalScore();
				}
			});
			
			for(int i = 0; i < allPlayers.size(); i++) {
				if(allPlayers.get(i).equals(dc.getCurrentPlayer()))
					globalRanking = i + 1;
			}
		} catch(DatabaseException e) {
			activity.showErrorDialog(e.prettyPrint());
		}
		return globalRanking;
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
