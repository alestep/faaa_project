package com.example.wecharades.views;

import android.os.Bundle;
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
		presenter = (HighScorePresenter) super.getPresenter();
		myTable = (TableLayout) findViewById(R.id.table);
		globalRanking = (TextView) findViewById(R.id.globalRanking);
		presenter.updateHighScores(myTable);
	}
	
	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateGlobalRanking(int globalRankingPosition) {
		globalRanking.setText("Your global ranking position is " + globalRankingPosition +" place");
		
	}

}
