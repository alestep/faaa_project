package com.example.wecharades.views;
/** TODO:
 * REGISTER SCORE POINTS IF GUESSED RIGHT
 * DO NOT DOWNLOAD EVERYTIME. OVERRIDE THE ONRESUME and ONPAUSE?
 *
 */

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.wecharades.R;
import com.example.wecharades.model.Turn;
import com.example.wecharades.presenter.GuessCharadePresenter;

/**
 * View which displays the part of the game where guessing is done
 * @author weCharade
 */
public class GuessCharadeActivity extends GenericActivity  { 
	
	private TextView possibleLetters;
	private EditText answerWord;
	private VideoView videoView;
	private GuessCharadePresenter presenter;
	private TextView timerView;
	
	/*
	 * Constants declared public in order to access them from class GuessCharadePresenter.
	 * NO_GAME is the initial state and is used to evaluate how to act when the a game is resumed.
	 */
	public int gameState = NO_GAME;
	public static final int NO_GAME = 0;
	public  static final int GAME_FINISHED = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new GuessCharadePresenter(this, (Turn) getIntent().getExtras().getSerializable("Turn")));
		setContentView(R.layout.guessvideo);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		//Get references to instances
		answerWord = (EditText) findViewById(R.id.editAnswerCharade);
		videoView = (VideoView) findViewById(R.id.streamedVideoSurface);
		possibleLetters = (TextView) findViewById(R.id.possibleLetters);
		possibleLetters.setVisibility(4);
		timerView = (TextView) findViewById(R.id.timerView);
		timerView.setVisibility(4);
		presenter = (GuessCharadePresenter) super.getPresenter();
	}

	/**
	 * Initializes the presenter
	 */
	@Override
	public void onStart() {
		presenter.initialize(videoView);
		super.onStart();
	}

	/**
	 * Resumes the view
	 */
	@Override
	protected void onResume(){
		
		//Resumes the video streaming if download is finished and the turn is not ongoing TODO: Kolla om detta är rätt?
		if(presenter.downloadState == GuessCharadePresenter.DOWNLOAD_FINISHED && gameState == NO_GAME){
			presenter.playVideo();
		}
		super.onResume();
	}

	/**
	 * Shows the time left
	 * @param time
	 */
	public void setTime(String time) {
		timerView.setVisibility(0);
		timerView.setText(time);
	}

	/**
	 * Shows the possible letters which together build the charade word
	 * @param letters
	 */
	public void setPossibleLetters(String letters){
		//Do not want to display the possible letters yet
		possibleLetters.setVisibility(0);
		possibleLetters.setText(letters);
	}

	/**
	 * TODO: Should register the score and so on if the user has guessed the right words.
	 * @param view
	 */
	public void onClickGuess(View view){
		presenter.evaluateGuess(answerWord.getText().toString());                  
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		//Evaluate a back press.
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			
			//Makes the user aware of that he or she will lose the turn if pushing back-button while video is streaming
			if(presenter.downloadState != GuessCharadePresenter.NO_DOWNLOAD)
				presenter.showNegativeDialog("Warning", "If you exit you will lose this turn", "Exit", "Return");
			
			//If a turn is not active, a back press results in that GuessCharadeAcitivty finishes
			else{
				finish();
			}
			return true;
		}
		
		//Makes the user aware of that he or she will lose the turn if pushing menu-button while video is streaming
		if ((keyCode == KeyEvent.KEYCODE_MENU)) {
			presenter.showNegativeDialog("Warning", "If you exit you will lose this turn", "Exit", "Return");
			return true;
		}
		return false;
	}
	
	/*
	 * Activity is considered not to be in need of displaying an IProgress-instance.
	 * This method will therefore never be called, and it is OK to return null.
	 */
	@Override
	protected IProgress getProgressBar() {
		return null;
	}
}
