package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.wecharades.model.Game;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.GuessCharadeActivity;
public class GameDashboardPresenter extends Presenter {

	private GameDashboardActivity activity;
	private Game game;
	private ArrayList<Turn> turnList;
	private ArrayList<Button> buttonList;

	public GameDashboardPresenter(GameDashboardActivity activity) {
		super(activity);
		this.activity = activity;
	}

	public void createDashboard(TableLayout table) {
		//Get the game from the clicked object in StartActivity
		game = (Game) activity.getIntent().getSerializableExtra("Game"); //TODO: check if null?
		turnList = dc.getTurns(game);
		buttonList = getAllButtons(table);

		generateTitle();
		updateScore();

		updateButtons(turnList, buttonList);
	}

	/**
	 * Total score per player at a specific game
	 */
	private void updateScore() { //TODO: use dc.getGameScore()
		int currentPLayersScore	= 0;
		int opponentsScore		= 0;
		for(Turn turn : turnList) {
			//TODO we could add a method "getPlayerScore(Player player)" in turn to get rid of this
			if( turn.getAnsPlayer().equals(dc.getCurrentPlayer()) ) {
				currentPLayersScore += turn.getAnsPlayerScore();
				opponentsScore		+= turn.getRecPlayerScore();
			}  else {
				currentPLayersScore += turn.getRecPlayerScore();
				opponentsScore		+= turn.getAnsPlayerScore();
			}

		}
		activity.updateScore(currentPLayersScore, opponentsScore);
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
	 * @param turnList - a list of turns in ascending order based on turn number
	 * @param buttonList - plain buttons
	 */
	private void updateButtons(ArrayList<Turn> turnList, ArrayList<Button> buttonList) {
		//This requires that the lists are equally long, which they always should be
		for(Turn turn : turnList) {
			Button button = (Button) buttonList.remove(0);
			updateButtonInformation(turn, button);
		}
	}

	/**
	 * Update button information based on information from the Turn object
	 * @param turn
	 */
	private void updateButtonInformation(Turn turn, Button button) {
		//TODO: Fix design stuff! enabled/disabled styles for example
		String buttonText = "";
		if (turn.getTurnNumber() > game.getTurnNumber()) {
			buttonText = "Locked!";
			button.setEnabled(false);
		}
		else if(turn.getState() == Turn.FINISH) {
			//Set current user's points received for the specific turn
			buttonText = (turn.getAnsPlayer().equals(dc.getCurrentPlayer())) ? 
					turn.getAnsPlayerScore() + " points" 
					: turn.getRecPlayerScore() + " points";
			button.setEnabled(false);

		} else if (turn.getState() == Turn.INIT && turn.getRecPlayer().equals(dc.getCurrentPlayer())) {
			buttonText = "Record Video\n" + "Charade: " + turn.getWord();
			button.setOnClickListener(buttonListener(false, turn)); //the player should record video
		
		} else if (turn.getState() == Turn.VIDEO && turn.getAnsPlayer().equals(dc.getCurrentPlayer())){
				buttonText = "Guess Charade!";
				button.setOnClickListener(buttonListener(true, turn)); //the player should guess charade
		
		} else {
			button.setEnabled(false);
			buttonText = "Waiting..."; //Currently highlighted but doesn't lead anywhere
		}
		button.setText(buttonText);
	} 

	//TODO this method is a bit special.
	private OnClickListener buttonListener(final boolean ansPlayer, final Turn turn) {
		OnClickListener buttonListener = new View.OnClickListener() {
			//boolean isAnsPLayer = ansPlayer;
			@Override
			public void onClick(View v) {
				if(ansPlayer) {
					//Go to GuessCharadeActivity
					Intent intent = new Intent (activity.getApplicationContext(), GuessCharadeActivity.class);
					intent.putExtra("Turn", turn);
					activity.startActivity(intent);
				}
				else {
					//Go to CaptureVideo
					Intent intent = new Intent (activity.getApplicationContext(), CaptureVideo.class);
					intent.putExtra("Turn", turn);
					activity.startActivity(intent);
				}
			}
		};
		return buttonListener;
	}

	private void generateTitle() {
		activity.showMessage("Game between you and " + game.getOpponent(dc.getCurrentPlayer()));
	}
}
