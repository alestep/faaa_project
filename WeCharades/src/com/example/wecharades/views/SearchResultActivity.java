package com.example.wecharades.views;

import android.os.Bundle;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.SearchResultPresenter;

public class SearchResultActivity extends GenericActivity {
	SearchResultPresenter presenter;
	/**
	 *
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new SearchResultPresenter(this));
		setContentView(R.layout.list_screen);
		presenter = (SearchResultPresenter) super.getPresenter();
	}
	
	/**
	 * 
	 */
	@Override
	protected void onStart() {
		super.onStart();
		presenter.update();
	}

	public void invite(String invitee){
		//presenter.invite(invitee);
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}
}
