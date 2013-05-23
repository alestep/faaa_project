package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.widget.ListView;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.views.InvitationActivity;


public class InvitationPresenter extends Presenter {
	
	private InvitationActivity activity;
	ArrayList<Invitation> invitationList;
	
	public InvitationPresenter(InvitationActivity activity) {
		super(activity);
		this.activity = activity;
	}

	private void setAdapter() {
			ListView view = (ListView) activity.findViewById(R.id.list);
			TextView text = (TextView) activity.findViewById(R.id.empty_list_item);
			text.setText("No invitations found!");
			view.setEmptyView(text);
			view.setAdapter(new InvitationAdapter(activity, invitationList));
	}

	public void update() {
		if(invitationList == null){
			try {
				invitationList = dc.getInvitations();
			} catch (DatabaseException e) {
				activity.showMessage(e.prettyPrint());
			}
		}
		setAdapter();
	}

	public void setInvitation(Invitation invitation, boolean response) {
		try {
			if (response)
				dc.acceptInvitation(invitation);
			else	
				dc.rejectInvitation(invitation);
		}catch (DatabaseException e) {
			activity.showMessage(e.prettyPrint());
		}
	}

}
