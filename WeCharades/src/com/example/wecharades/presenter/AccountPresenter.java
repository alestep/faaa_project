package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.content.Intent;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.AccountActivity;
import com.example.wecharades.views.GameInstructionsActivity;
import com.example.wecharades.views.StartActivity;

/**
 * Presenter-class intended to present and gather information about the user's account
 * @author weCharade
 */
public class AccountPresenter extends Presenter {
	
	private AccountActivity activity;
	
	/**
	 * Create an instance of AccountPresenter
	 * @param activity	Reference to the AccountActivity-instance
	 */
	public AccountPresenter(AccountActivity activity) {
		super(activity);
		this.activity = activity;
	}
	
	/**
	 * Update the user's information
	 */
	public void update() {
		//Indicate that data is fetched
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

	/**
	 * Calculate the user's global ranking by comparing the user's global (total) score against others
	 * @return The user's global ranking
	 */
	private int getGlobalRanking() {
		int globalRanking = 0;
		try{
			//Retrieve list of all players and order them by global score
			ArrayList<Player> allPlayers = dc.getAllPlayerObjects();
			Collections.sort(allPlayers, new Comparator<Player>(){
				
				@Override
				public int compare(Player p1, Player p2) {
					return p2.getGlobalScore() - p1.getGlobalScore();
				}
			});
			
			//Search for the user in the ordered list
			for(int i = 0; i < allPlayers.size(); i++) {
				if(allPlayers.get(i).equals(dc.getCurrentPlayer()))
					globalRanking = i + 1;
			}
		} catch(DatabaseException e) {
			activity.showNegativeDialog("Error", e.prettyPrint(), "OK");
		}
		return globalRanking;
	}

	/**
	 * Log out the current user
	 */
	public void logOut() {
		//Inform the database that the user want to log out
		dc.logOutPlayer(activity);
		
		/*
		 * Call is made to StartActivity, which surely is in the bottom of activity-stack. Add a flag to clear stack
		 * and from StartActivity a call is made to the Login screen and StartActivity is finished. By doing this we
		 * assure that Login screen is at the bottom of the activity-stack and a press on back button, while placed 
		 * on Login screen, will result in that the application is closed
		 */
		Intent intent = new Intent(activity, StartActivity.class);
		intent.putExtra("finish", true);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		activity.startActivity(intent);
		activity.finish();
	}
}
