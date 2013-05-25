package com.example.wecharades.views;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.HighScorePresenter;

public class HighScoreActivity extends GenericActivity {

	private TableLayout myTable;
	private HighScorePresenter presenter;
	private TextView globalRanking;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new HighScorePresenter(this));
		setContentView(R.layout.highscore);
		myTable = (TableLayout) findViewById(R.id.table);
		globalRanking = (TextView) findViewById(R.id.globalRanking);
		
		presenter = (HighScorePresenter) super.getPresenter();
	}
	
	public void onStart(){
		super.onStart();
		presenter.updateHighScores(myTable);
	}
	
	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateGlobalRanking(int globalRankingPosition, int totalNumberOfUsers) {
		globalRanking.setText("Your global ranking position is: " + globalRankingPosition + " out of " + totalNumberOfUsers);
	}

	@Override
	protected ProgressBar getProgressSpinner() {
		// TODO Auto-generated method stub
		return null;
	}

}
