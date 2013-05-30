package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.HighScoreActivity;

/**
 * Presenter-class intended to manage information connected to the HighScoreActivity
 * @author weCharade
 */
public class HighScorePresenter extends Presenter {

	HighScoreActivity activity;

	/**
	 * Create an instance of HighScorePresenter
	 * @param activity
	 */
	public HighScorePresenter(HighScoreActivity activity) {
		super(activity);
		this.activity = activity;
	}

	/**
	 * Create a table with high scores
	 * @param table
	 */
	public void updateHighScores(TableLayout table){
		
		//Indicate something being fetched in the background
		activity.showProgressBar();
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
			globalRanking = allPlayers.indexOf(dc.getCurrentPlayer()) +1;
			
			//Display all player's ranking in list if total number of players are less than 10, else display top 10.
			updateHighScoreList(new ArrayList<Player>(allPlayers.subList(0, allPlayers.size() < 9 ? allPlayers.size() : 9)), getAllTextViews(table));
			activity.updateGlobalRanking(globalRanking, allPlayers.size());
			
		} catch(DatabaseException e) {
			activity.showNegativeDialog("Error", e.prettyPrint(), "OK");
		}
		activity.hideProgressBar();

	}

	/** 
	 * Update the scoreList
	 * @param playerList	List of players to display
	 * @param tvList		List of TextViews where highscore should be displayed
	 */
	private void updateHighScoreList(ArrayList<Player> playerList, ArrayList<TextView> tvList) {
		int i = 0;

		for(Player p : playerList) {
			i++;
			if(p.equals(dc.getCurrentPlayer())) {
				tvList.get(0).setTypeface(null, Typeface.BOLD);
				tvList.get(1).setTypeface(null, Typeface.BOLD);
				tvList.get(2).setTypeface(null, Typeface.BOLD);
			}
			tvList.get(0).setVisibility(View.VISIBLE);
			tvList.remove(0).setText(Integer.toString(i));
			tvList.get(0).setVisibility(View.VISIBLE);
			tvList.remove(0).setText(p.getName());
			tvList.get(0).setVisibility(View.VISIBLE);
			tvList.remove(0).setText(p.getGlobalScore() + " points");
		}
	}

	/**
	 * Retrieve a list of all TextViews in a table
	 * @param table	TableLayout where TextViews are stored
	 * @return	ArrayList containing all TextViews
	 */
	private ArrayList<TextView> getAllTextViews(TableLayout table) {
		ArrayList<TextView> tvList = new ArrayList<TextView>();
		for(int i = 0; i < table.getChildCount(); i++) {
			TableRow row = (TableRow) table.getChildAt(i);
			for(int j = 0; j < row.getChildCount(); j++) {
				TextView tv = (TextView) row.getChildAt(j);
				tv.setVisibility(View.GONE);
				tvList.add(tv);
			}
		}
		return tvList;
	}

}
