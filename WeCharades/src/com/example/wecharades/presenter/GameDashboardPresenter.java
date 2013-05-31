package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.wecharades.model.Game;
import com.example.wecharades.model.Player;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.GuessCharadeActivity;
import com.example.wecharades.views.ShowCharadeWordActivity;

/**
 * Presenter-class intended to gather information used to display the game dashboard
 * @author weCharade
 */
public class GameDashboardPresenter extends Presenter {

	private GameDashboardActivity activity;
	private Game game;
	private ArrayList<Turn> turnList;
	private ArrayList<Button> buttonList;

	/**
	 * Create an instance of GameDashboardPresenter
	 * @param activity	Reference to the GameDashboardActivity
	 */
	public GameDashboardPresenter(GameDashboardActivity activity) {

		super(activity);
		this.activity = activity;

	}

	/**
	 * Create a dashboard of the Game and its six turns
	 * @param table
	 */
	public void createDashboard(TableLayout table) {
		//Get the game from the clicked object in StartActivity
		game = (Game) activity.getIntent().getSerializableExtra("Game");

		//Retrieve a turnList from DataController for a specific game
		turnList = dc.getTurns(game);
		if(turnList != null) {
			Collections.sort(turnList);
			buttonList = getAllButtons(table);

			activity.setTitle("Game with " + game.getOpponent(dc.getCurrentPlayer()));
			updateScore();

			updateButtons(turnList, buttonList);
		}

	}

	/**
	 * Retrieve scores for the players involved in a specific game
	 */
	private void updateScore() { //TODO: use dc.getGameScore()

		TreeMap<Player, Integer> gM = dc.getGameScore(game);
		activity.updateScore(gM.get(dc.getCurrentPlayer()), gM.get(game.getOpponent(dc.getCurrentPlayer())));
	}

	/**
	 * Run through the current table and connect a Button-object to every cell
	 * @param table	
	 * @return		List of all buttons in the table
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
	 * @param turnList		A list of turns in ascending order based on turn number
	 * @param buttonList	A list of buttons
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
	 * @param turn		Turn-object from which information is gathered
	 * @param button	Button-object where information is displayed
	 */
	private void updateButtonInformation(Turn turn, Button button) {

		String buttonText = "";

		//The button is locked for turns with greater turnNumber than the current turnNumber of the game
		if (turn.getTurnNumber() > game.getTurnNumber()) {

			buttonText = "Locked";
			button.setEnabled(false);
		}

		/*
		 * The points are displayed on a button in the following scenarios. The game.isFinished() must be
		 * present in order to be able to show a finished game.
		 */
		else if(turn.getState() == Turn.FINISH || game.isFinished() || turn.getTurnNumber() < game.getTurnNumber()) {

			//Set current user's points received for the specific turn
			buttonText = (turn.getAnsPlayer().equals(dc.getCurrentPlayer())) ? 
					turn.getAnsPlayerScore() + " points" 
					: turn.getRecPlayerScore() + " points";
			button.setEnabled(false);

			//The button shows "Record video" if the current user is the player who should record
		} else if (turn.getState() == Turn.INIT && turn.getRecPlayer().equals(dc.getCurrentPlayer())) {

			buttonText = "Record video";
			button.setOnClickListener(buttonListener(false, turn)); //the player should record video

			//The button shows "Guess charade " if the current user is the player who should guess
		} else if (turn.getState() == Turn.VIDEO && turn.getAnsPlayer().equals(dc.getCurrentPlayer())){

			buttonText = "Guess charade";
			button.setOnClickListener(buttonListener(true, turn)); //the player should guess charade

			//The button is locked and showing waiting in other cases
		} else {
			button.setEnabled(false);
			buttonText = "Waiting...";
		}
		button.setText(buttonText);
	} 

	/**
	 * Directs the user to either GuessCharadeActivity or ShowCharadeWordActivity depending on
	 * the current user's status as recording or guessing player.
	 * @param ansPlayer
	 * @param turn
	 * @return
	 */
	private OnClickListener buttonListener(final boolean ansPlayer, final Turn turn) {

		//The same OnClickListener is used for all buttons, since the same thing is intended to happen
		OnClickListener buttonListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(ansPlayer) {
					//Go to GuessCharadeActivity
					Intent intent = new Intent (activity.getApplicationContext(), GuessCharadeActivity.class);
					intent.putExtra("Turn", turn);
					activity.startActivity(intent);
				}
				else {
					//Go to ShowCharadeWordActivity
					Intent intent = new Intent (activity.getApplicationContext(), ShowCharadeWordActivity.class);
					intent.putExtra("Turn", turn);
					activity.startActivity(intent);
				}
			}
		};
		return buttonListener;
	}
}
