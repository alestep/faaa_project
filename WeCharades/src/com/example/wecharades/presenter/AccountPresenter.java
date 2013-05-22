package com.example.wecharades.presenter;

import com.example.wecharades.model.Player;
import com.example.wecharades.views.AccountActivity;

public class AccountPresenter extends Presenter {

	private AccountActivity activity;
	public AccountPresenter(AccountActivity activity) {
		super(activity);
		this.activity = activity;
	}

	public void update() {
		Player currentPlayer = dc.getCurrentPlayer();
		activity.updateUsername(currentPlayer.getName());
		activity.updateRanking(currentPlayer.getGlobalRanking(), dc.getCurrentPlayer().getGlobalScore());
		activity.updatePlayedGames(currentPlayer.getNumberOfFinishedGames());
		activity.updateWonGames(currentPlayer.getNumberOfWonGames());
		activity.updateLostGames(currentPlayer.getNumberOfLostGames());
		activity.updateDrawGames(currentPlayer.getNumberOfDrawGames());
	}
	
	public void gameInstructions() {
		// TODO IMPLEMENT!
		
	}
	
	public void deleteAccount() {
		// TODO IMPLEMENT! - validation check
		
	}

}
