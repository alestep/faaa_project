package com.example.wecharades.views;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.HighScorePresenter;

public class HighScoreActivity extends GenericActivity {

	private TableLayout myTable;
	private HighScorePresenter presenter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new HighScorePresenter(this));
		setContentView(R.layout.highscore);
		presenter = (HighScorePresenter) super.getPresenter();
		myTable = (TableLayout) findViewById(R.id.table);
		presenter.updateHighScores(myTable);
	}
	
	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}

}
