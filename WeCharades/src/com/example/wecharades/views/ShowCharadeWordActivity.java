package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.Database;
import com.example.wecharades.model.Turn;
import com.example.wecharades.presenter.SimplePresenter;

/**
 * View which displays the word a user should visualize
 * @author weCharade
 */
public class ShowCharadeWordActivity extends GenericActivity {
	
	private Turn turn;
	private SimplePresenter presenter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new SimplePresenter(this));
		setContentView(R.layout.show_charade_word_screen);
		
		presenter = (SimplePresenter) super.getPresenter();
		this.turn = (Turn) getIntent().getExtras().get(Database.TURN);
		TextView charadeWord = (TextView) findViewById(R.id.charadeWord);
		charadeWord.setText(turn.getWord());
	}
	
	/**
	 * Go to CaptureVideoActivity, where charade word should be visualized
	 * @param v
	 */
	public void onClickRecord(View v) {
		Intent intent = new Intent (this, CaptureVideoActivity.class);
		intent.putExtra(Database.TURN, turn);
		startActivity(intent);
		finish();
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
