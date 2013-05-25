package com.example.wecharades.presenter;

import java.util.List;
import java.util.Observable;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.DCMessage;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.views.InvitationActivity;


public class InvitationPresenter extends Presenter {
	
	private InvitationActivity activity;
	private View parentView;
	//ArrayList<Invitation> invitationList;
	
	public InvitationPresenter(InvitationActivity activity) {
		super(activity);
		this.activity = activity;
		dc.addObserver(this);
		parentView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
	}

	private void setAdapter(List<Invitation> invitationList) {
			ListView view = (ListView) activity.findViewById(R.id.list);
			TextView text = (TextView) activity.findViewById(R.id.empty_list_item);
			text.setText("No invitations found!");
			view.setEmptyView(text);
			view.setAdapter(new InvitationAdapter(activity, invitationList));
	}

	public void update() {
		dc.getInvitations();
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
	
	/**
	 * Called whenever an update is received from a class this presenter subscribes to.
	 */
	public void update(Observable obs, Object obj){
		if(obj != null && obj.getClass().equals(DCMessage.class)){
			DCMessage dcm = (DCMessage) obj;
			if(dcm.getMessage() == DCMessage.INVITATIONS){
				setAdapter((List<Invitation>) dcm.getData());
			}
		}
	}

}
