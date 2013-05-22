package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.AccountPresenter;



public class AccountActivity extends GenericActivity {
	private TextView username, globalRanking, playedGames, lostGames, drawGames;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_screen);
		username = (TextView) findViewById(R.id.username);
		globalRanking = (TextView) findViewById(R.id.globalRanking);
		playedGames = (TextView) findViewById(R.id.playedGames);
		lostGames = (TextView) findViewById(R.id.lostGames);
		drawGames = (TextView) findViewById(R.id.drawGames);
		
		AccountPresenter presenter = new AccountPresenter(this);
		
	}
	
//	@Override
//	public void onCreate() {
//		
//	}
 	
	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void onClickGameInstructions(View view) {
		//TODO: go to new activity
	}
	
	public void onClickDeleteAccount(View view) {
		//TODO: implement
		//TODO: Are you SURE?
	}

	
}
