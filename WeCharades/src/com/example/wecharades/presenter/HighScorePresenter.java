package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.wecharades.model.Player;
import com.example.wecharades.views.HighScoreActivity;

public class HighScorePresenter extends Presenter {

	HighScoreActivity activity;
	public HighScorePresenter(HighScoreActivity activity) {
		super(activity);
		this.activity = activity;
	}
	
	public void updateHighScores (TableLayout table) {
		//TODO: implement dc.getTopTenPlayers()
		//updateHighScoreList(dc.getTopTenPlayers(), getAllButtons(table));
	}
	
	private void updateHighScoreList(ArrayList<Player> playerList, ArrayList<TextView> tvList) {
		int i = 0;
		for(Player p : playerList) {
			i++;
			tvList.remove(0).setText(i+".");
			tvList.remove(0).setText(p.getName());
			tvList.remove(0).setText(p.getGlobalScore());
		}
	}
		
	
	private ArrayList<TextView> getAllButtons(TableLayout table) {
		ArrayList<TextView> tvList = new ArrayList<TextView>();
		for(int i = 0; i < table.getChildCount(); i++) {
			TableRow row = (TableRow) table.getChildAt(i);
			for(int j = 0; j < row.getChildCount(); j++) {
				TextView tv = (TextView) row.getChildAt(j);
				tvList.add(tv);
			}
		}
		return tvList;
	}

}
