package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.GameDashboardActivity;
public class GameDashboardPresenter extends Presenter {

	private GameDashboardActivity activity;
	private Game game;

	public GameDashboardPresenter(GameDashboardActivity activity) {
		super(activity);
		this.activity = activity;
	}

	public void createDashboard(Game game, TableLayout table) {
		this.game = game;
		generateTitle();

		//TODO: This needs to be tested: look at GameDashboardActivity!
		//ArrayList<Turn> turnList = getTurnList();
		//ArrayList<Button> buttonList = getAllButtons(table);
		//updateButtons(turnList, buttonList);
	}

	private ArrayList<Turn> getTurnList() {
		ArrayList<Turn> turnList = new ArrayList<Turn>();
		try {
			turnList = Database.getTurns(game);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return turnList;
	}
	
	/**
	 * This method runs through all buttons in the current table
	 * @param table
	 */
	private ArrayList<Button> getAllButtons(TableLayout table) {
		ArrayList<Button> buttonList = new ArrayList<Button>();
		for(int i = 0; i < table.getChildCount(); i++) {
			TableRow row = (TableRow) table.getChildAt(i);
			for(int j = 0; j < row.getChildCount(); j++) {
				Button btn = (Button) row.getChildAt(j);
				buttonList.add(btn);
			}
		}
		return buttonList;
	}

	
	//TODO: test this!!!
	private void updateButtons(ArrayList<Turn> turnList, ArrayList<Button> buttonList) {
		HashMap<String, Button> map = new HashMap<String, Button>();
		int i = 0;
		
		for(Turn turn : turnList) {
			map.put(getButtonText(turn), buttonList.remove(i));
			i++;
		}
		for (Map.Entry<String, Button> entry : map.entrySet()) {
			String s = entry.getKey();
			Button b = entry.getValue();
			b.setText(s); //TODO: here you need to figure out if the buttons should be clickable ... maybe 
		}
	}

	/**
	 * Makes a string based on if it's the current player's turn to answer, to record video or if the turn was already played
	 * @param turn
	 */
	private String getButtonText(Turn turn) {
		String string = "";
		if(game.isFinished() || (turn.getTurnNumber() < game.getTurn()) ) {
			if(turn.getAnsPlayer().getParseId() == getCurrentUser().getObjectId()) {
				//TODO disable button
				string = turn.getAnsPlayerScore() + " points";
			} else {
				//TODO disable button
				string = turn.getRecPlayerScore() + " points";
			}
		} else if(turn.getTurnNumber() == game.getTurn()) {
			if(turn.getAnsPlayer().getParseId() == getCurrentUser().getObjectId()) {
				string = "Guess word!";
			} else {
				string = "Record Video";
			}
		} else {
			//TODO disable button
			string = "Locked";
		}
		// activity.updateButton(string);
		return string;
	} 

	private void generateTitle() {
		String opponent;
		if(getCurrentUser().getObjectId() == game.getPlayerId1().getParseId()) {
			opponent = game.getPlayerId2().getName();
		} else if (getCurrentUser().getObjectId() == game.getPlayerId2().getParseId()){
			opponent = game.getPlayerId1().getName();
		} else {
			opponent = "unknown";
		}
		activity.showMessage("Game between you and " + opponent);
	}
}
