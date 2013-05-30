package com.example.wecharades.presenter;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import android.widget.ListView;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.DCMessage;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.views.InvitationActivity;

/**
 * Presenter-class intended to manage information about invitations. Implements 
 * the Observer interface and therefore receives information when the DataController is updated
 * @author weCharade
 */
public class InvitationPresenter extends Presenter implements Observer{
	
	private InvitationActivity activity;
	private SeparatedListAdapter adapter;
	
	/**
	 * Creates an instance of InvitationPresenter
	 * @param activity
	 */
	public InvitationPresenter(InvitationActivity activity) {
		super(activity);
		this.activity = activity;
		
		//Add DataController observer
		dc.addObserver(this);
	}
	
	/**
	 * Creates a list of invitations from model
	 */
	public void initialize() {
		
		//Indicate that data is being fetched
		activity.showProgressBar();
		setAdapter(dc.getReceivedInvitations(), dc.getSentInvitations());
		
	}
	
	/**
	 * Create a call to DataController and by this initiate fetching of invitations
	 */
	public void update() {
		activity.showProgressBar();
		dc.getInvitations();
	}
	
	/**
	 * Accepts or rejects the invitation
	 * @param invitation The invitation waiting for response
	 * @param response
	 */
	public void setInvitation(Invitation invitation, boolean response) {

		if (response)
			dc.acceptInvitation(invitation);
		else	
			dc.rejectInvitation(invitation);
	}
	
	/**
	 * Sets the adapter and fills the list
	 * @param receivedList
	 * @param sentList
	 */
	private void setAdapter(List<Invitation> receivedList, List<Invitation> sentList) {
		ListView view = (ListView) activity.findViewById(R.id.invitationList);
		TextView text = (TextView) activity.findViewById(R.id.emptyInvitationList);
		
		//If doesn't contain any elements
		text.setText("No invitations found!");
		view.setEmptyView(text);
		
		adapter = new SeparatedListAdapter(activity);
		if (!receivedList.isEmpty())
			//add section in list
			adapter.addSection("Received invitations", new InvitationAdapter(activity, receivedList, dc.getCurrentPlayer()));
		if(!sentList.isEmpty())
			//add section in list
			adapter.addSection("Sent invitations", new InvitationAdapter(activity, sentList, dc.getCurrentPlayer()));
		view.setAdapter(adapter);
		
		activity.hideProgressBar();
	}
	
	/**
	 * Called whenever an update is received from a class this presenter subscribes to
	 */
	@Override
	public void update(Observable obs, Object obj){
		if(obj != null && obj.getClass().equals(DCMessage.class)){
			DCMessage dcm = (DCMessage) obj;
			if(dcm.getMessage() == DCMessage.INVITATIONS){
				activity.hideProgressBar();
				setAdapter(dc.getReceivedInvitations(), dc.getSentInvitations());
			}
		}
		super.update(obs, obj);
	}
}
