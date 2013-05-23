package com.example.wecharades.presenter;

import java.util.ArrayList;

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

	public void updateHighScores(TableLayout table) {
		try {
			updateHighScoreList(dc.getTopTenPlayers(), getAllTextViews(table));
		} catch (DatabaseException e) {
			//TODO: prettyPrint()!
			e.printStackTrace();
		}
		
		int totalNumberOfPlayers = 0;
		try {
			totalNumberOfPlayers = dc.getAllPlayerNames().size();
		} catch (DatabaseException e) {
			// TODO prettyMessage
			e.printStackTrace();
		}
		//Update field for global ranking
		activity.updateGlobalRanking(dc.getCurrentPlayer().getGlobalRanking(), totalNumberOfPlayers);
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
			tvList.remove(0).setText(i+".");
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
