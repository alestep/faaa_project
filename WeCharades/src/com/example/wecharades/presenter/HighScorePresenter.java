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

public class HighScorePresenter extends Presenter {

	HighScoreActivity activity;
	
	public HighScorePresenter(HighScoreActivity activity) {
		super(activity);
		this.activity = activity;
	}
	
	/**
	 * Creates an table with highscores
	 * @param table
	 */
	public void updateHighScores(TableLayout table){
		try{
			ArrayList<Player> allPlayers = dc.getAllPlayerObjects();
			Collections.sort(allPlayers, new Comparator<Player>(){
				@Override
				public int compare(Player p1, Player p2) {
					return p2.getGlobalScore() - p1.getGlobalScore();
				}
			});
			
			//int globalRanking = allPlayers.indexOf(dc.getCurrentPlayer());
			//TODO: fix the line above. probably returns false value because of hashcode() and equals()
			//Temporary fix below...
			int globalRanking = 0;
			for(int i = 0; i < allPlayers.size(); i++) {
				if(allPlayers.get(i).equals(dc.getCurrentPlayer()))
					globalRanking = i + 1;
			}
			updateHighScoreList(new ArrayList<Player>(allPlayers.subList(0, allPlayers.size() < 9 ? allPlayers.size() : 9)), getAllTextViews(table));
			activity.updateGlobalRanking(globalRanking, allPlayers.size());
		} catch(DatabaseException e) {
			activity.showErrorDialog(e.prettyPrint());
		}
	}

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
