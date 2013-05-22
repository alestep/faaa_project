package com.example.wecharades.views;

import android.os.Bundle;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.presenter.InvitationPresenter;

public class InvitationActivity extends GenericActivity {
	InvitationPresenter presenter;
	
	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new InvitationPresenter(this));
		setContentView(R.layout.list_screen);
		presenter = (InvitationPresenter) getPresenter();
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

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}
}
