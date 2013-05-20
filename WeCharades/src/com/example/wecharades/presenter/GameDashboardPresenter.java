package com.example.wecharades.presenter;

import java.util.ArrayList;

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
		//This requires that the lists are equally long, which they always should be (not tested)
		for(Turn turn : turnList) {
			Button button = (Button) buttonList.remove(0);
			updateButton(turn, button);
		}
	}

	/**
	 * Makes a string based on if it's the current player's turn to answer, to record video or if the turn was already played
	 * @param turn
	 */
	private void updateButton(Turn turn, Button button) {
		//TODO: button.setId() or similar, probably based on turn.getId -ish...
		//TODO: look up setTag() and getTag();
		String string = "";
		if(game.isFinished() || (turn.getTurnNumber() < game.getTurn()) ) {
			if(turn.getAnsPlayer().getParseId() == getCurrentUser().getObjectId()) {
				string = turn.getAnsPlayerScore() + " points";
				button.setEnabled(false);
			} else {
				button.setEnabled(false);
				string = turn.getRecPlayerScore() + " points";
			}
		} else if(turn.getTurnNumber() == game.getTurn()) {
			if(turn.getAnsPlayer().getParseId() == getCurrentUser().getObjectId()) {
				string = "Guess word!";
			} else {
				string = "Record Video";
			}
		} else {
			button.setEnabled(false);
			string = "Locked";
		}
		button.setText(string);
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
