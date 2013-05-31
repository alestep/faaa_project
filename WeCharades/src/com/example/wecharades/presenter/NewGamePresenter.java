package com.example.wecharades.presenter;

import com.example.wecharades.views.NewGameActivity;

/**
 * Presenter-class intended to manage requests from NewGameActivity
 * @author weCharade
 */
public class NewGamePresenter extends Presenter {
	
	public NewGamePresenter(NewGameActivity activity) {
		super(activity);
	}

	public void randomInvitation() {
		
		//User is queued and a game is created when another user joins the queue
		activity.showToast("Sending...");
		dc.putInRandomQueue();
	}

}
