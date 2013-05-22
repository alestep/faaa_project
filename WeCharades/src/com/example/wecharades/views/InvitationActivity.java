package com.example.wecharades.views;

import com.example.wecharades.model.Invitation;
import com.example.wecharades.presenter.InvitationPresenter;

import android.app.ListActivity;
import android.os.Bundle;

public class InvitationActivity extends ListActivity {
	InvitationPresenter presenter;
	
	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		presenter = new InvitationPresenter(this);
	}
	
	/**
	 * 
	 */
	@Override
	protected void onStart() {
		super.onStart();
		presenter.update();
	}

	public void setInvitation(Invitation invitation, boolean response) {
		presenter.setInvitation(invitation, response);
		
	}
}
