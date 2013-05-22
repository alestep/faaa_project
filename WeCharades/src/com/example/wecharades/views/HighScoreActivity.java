package com.example.wecharades.views;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.HighScorePresenter;

public class HighScoreActivity extends GenericActivity {

	private TableLayout myTable;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.highscore);
		presenter = (HighScorePresenter) new HighScorePresenter(this);
		myTable = (TableLayout) findViewById(R.id.table);
	}
	
	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}

}
