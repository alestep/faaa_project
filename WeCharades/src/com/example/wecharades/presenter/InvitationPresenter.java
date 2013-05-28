package com.example.wecharades.presenter;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import android.widget.ListView;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.DCMessage;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.views.InvitationActivity;


public class InvitationPresenter extends Presenter implements Observer{
	
	private InvitationActivity activity;
	private SeparatedListAdapter adapter;
	
	public InvitationPresenter(InvitationActivity activity) {
		super(activity);
		this.activity = activity;
		dc.addObserver(this);
	}

	public void update() {
		activity.showProgressBar();
		dc.getInvitations();
	}

	public void setInvitation(Invitation invitation, boolean response) {
		try {
			if (response)
				dc.acceptInvitation(invitation);
			else	
				dc.rejectInvitation(invitation);
		}catch (DatabaseException e) {
			activity.showErrorDialog(e.prettyPrint());
		}
	}
	
	/**
	 * Called whenever an update is received from a class this presenter subscribes to.
	 */
	public void update(Observable obs, Object obj){
		if(obj != null && obj.getClass().equals(DCMessage.class)){
			DCMessage dcm = (DCMessage) obj;
			if(dcm.getMessage() == DCMessage.INVITATIONS){
				List<Invitation> invList = (List<Invitation>) dcm.getData();
				LinkedList<Invitation> sentList = new LinkedList<Invitation>();
				LinkedList<Invitation> receivedList = new LinkedList<Invitation>();
				for(Invitation inv : invList){
					if(inv.getInviter().equals(dc.getCurrentPlayer())){
						sentList.add(inv);
					} else{
						receivedList.add(inv);
					}
				}
				activity.hideProgressBar();
				setAdapter(receivedList, sentList);
			}
		}
		super.update(obs, obj);
	}
	
	private void setAdapter(List<Invitation> receivedList, List<Invitation> sentList) {
		ListView view = (ListView) activity.findViewById(R.id.list);
		TextView text = (TextView) activity.findViewById(R.id.empty_list_item);
		text.setText("No invitations found!");
		view.setEmptyView(text);
		adapter = new SeparatedListAdapter(activity);
		if (!receivedList.isEmpty())
			adapter.addSection("Received invitations", new InvitationAdapter(activity, receivedList, dc.getCurrentPlayer()));
		if(!sentList.isEmpty())
			adapter.addSection("Sent invitations", new InvitationAdapter(activity, sentList, dc.getCurrentPlayer()));
		view.setAdapter(adapter);
	}
	
		
}
