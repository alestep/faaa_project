package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.GuessCharadeActivity;
public class GameDashboardPresenter extends Presenter {

	private GameDashboardActivity activity;
	private Game game;

	public GameDashboardPresenter(GameDashboardActivity activity) {
		super(activity);
		this.activity = activity;
	}

	public void createDashboard(TableLayout table) {
		//Get the game from the clicked object in StartActivity
		this.game = (Game) activity.getIntent().getSerializableExtra("Game"); //TODO: check if null?
		generateTitle();
		ArrayList<Turn> turnList = getTurnList();
		ArrayList<Button> buttonList = getAllButtons(table);
		updateButtons(turnList, buttonList);
	}

	/**
	 * Returns an ArrayList with Turns
	 * @return
	 */
	private ArrayList<Turn> getTurnList() {
		ArrayList<Turn> turnList = null;
		try {
			//TODO: Get from Model instead?
			turnList = db.getTurns(game);
		} catch (DatabaseException e) {
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


	/**
	 * Update buttons with relevant information form the Turn object
	 * @param turnList
	 * @param buttonList
	 */
	private void updateButtons(ArrayList<Turn> turnList, ArrayList<Button> buttonList) {
		//This requires that the lists are equally long, which they always should be
		for(Turn turn : turnList) {
			Button button = (Button) buttonList.remove(0);
			updateButtonInformation(turn, button);
		}
	}

	/**
	 * Makes a string based on if it's the current player's turn to answer, to record video or if the turn was already played
	 * @param turn
	 */
	private void updateButtonInformation(Turn turn, Button button) {
		String string = "";
		if(game.isFinished() || (turn.getTurnNumber() < game.getTurn()) ) {
			if(turn.getAnsPlayer().getParseId().equals(getCurrentUser().getObjectId())) {
				string = turn.getAnsPlayerScore() + " points";
				button.setEnabled(false);
			} else if (turn.getRecPlayer().getParseId().equals(getCurrentUser().getObjectId())) {
				button.setEnabled(false);
				string = turn.getRecPlayerScore() + " points";
			} else {
				string = "error";
			}
		} else if(turn.getTurnNumber() == game.getTurn()) {
			//TODO: add at state: "waiting for opponent"
			if(turn.getAnsPlayer().getParseId().equals(getCurrentUser().getObjectId())) {
				string = "Guess word!";
				button.setOnClickListener(buttonListener(true, turn)); //the player should guess word
			} 
			// Checks if you are the "RecPlayer" AND already has uploaded a video
			else if (turn.getRecPlayer().getParseId().equals(getCurrentUser().getObjectId()) && !turn.getVideoLink().isEmpty()) {
				string = "Waiting...";
				//button.setEnabled(false); THE BUTTON IS CURRENTLY HIGHLIGHTED BUT DOESN'T LEAD ANYWHERE				
			} else {
				string = "Record Video";
				button.setOnClickListener(buttonListener(false, turn)); //the player should record video
			}
		} else {
			button.setEnabled(false);
			string = "Locked";
		}
		button.setText(string);
	} 

	private OnClickListener buttonListener(final boolean ansPlayer, final Turn turn) {
		OnClickListener buttonListener = new View.OnClickListener() {
			boolean isAnsPLayer = ansPlayer;
			Turn theTurn = turn;
			@Override
			public void onClick(View v) {
				if(isAnsPLayer) {
					//Go to GuessCharadeActivity
					Intent intent = new Intent (activity.getApplicationContext(), GuessCharadeActivity.class);
					intent.putExtra("Turn", theTurn);
					activity.startActivity(intent);
				}
				else {
					//Go to CaptureVideo
					Intent intent = new Intent (activity.getApplicationContext(), CaptureVideo.class);
					intent.putExtra("Turn", theTurn);
					activity.startActivity(intent);
				}
			}
		};
		return buttonListener;
	}

	private void generateTitle() {
		String opponent;
		if(getCurrentUser().getObjectId().equals(game.getPlayer1().getParseId())) {
			opponent = game.getPlayer2().getName();
		} else if (getCurrentUser().getObjectId().equals(game.getPlayer2().getParseId())){
			opponent = game.getPlayer1().getName();
		} else {
			opponent = "unknown";
		}
		activity.showMessage("Game between you and " + opponent);
	}
}
