package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.app.Activity;

import com.example.wecharades.model.Player;
import com.example.wecharades.views.SearchPlayerActivity;

public class SearchPlayerPresenter extends Presenter {
	
	private SearchPlayerActivity activity;
	ArrayList<Player> players;
	
	/**
	 * 
	 * @param activity
	 */
	public SearchPlayerPresenter(Activity activity) {
		super(activity);
		this.activity = (SearchPlayerActivity) activity;
	}
	
	

	public void performSearch(String searchString) {
		
	}

}
