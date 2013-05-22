package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.widget.ListAdapter;

import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.InvitationActivity;


public class InvitationPresenter extends Presenter {
	
	private InvitationActivity activity;
	
	public InvitationPresenter(InvitationActivity activity) {
		super(activity);
		this.activity = activity;
	}

	private void setAdapter() {
		ArrayList<Invitation> invitationList = dc.getInvitations();

		activity.getListView().setAdapter(new InvitationAdapter(activity, invitationList));
	}

	public void update() {
		setAdapter();
		
	}

	public void setInvitation(Invitation invitation, boolean respone) {
		
	}

}
