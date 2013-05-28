package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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

		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.highscore);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_other); 

		myTable = (TableLayout) findViewById(R.id.table);
		globalRanking = (TextView) findViewById(R.id.globalRanking);

		presenter = (HighScorePresenter) super.getPresenter();
	}

	public void onStart(){
		super.onStart();
		presenter.updateHighScores(myTable);
	}

	public void updateGlobalRanking(int globalRankingPosition, int totalNumberOfUsers) {
		globalRanking.setText("Your global ranking position is " + globalRankingPosition + " out of " + totalNumberOfUsers);
	}

	@Override
	protected ProgressBar getProgressSpinner() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void onClickHome(View v){
		startActivity(new Intent(this, StartActivity.class));
	}

}
