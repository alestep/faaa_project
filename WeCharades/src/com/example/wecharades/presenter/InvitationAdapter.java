package com.example.wecharades.presenter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.InvitationActivity;

/**
 * Presenter-help-class which manages the filling of ListView-items on the Invitation view.
 * @author weCharade
 */
public class InvitationAdapter extends ArrayAdapter<Invitation> {
	
	private List<Invitation> invitations;
	private InvitationActivity activity;
	private Player player;
	
	/**
	 * Create an instance of InvitationAdapter
	 * @param activity
	 * @param invitations
	 * @param player
	 */
	public InvitationAdapter(InvitationActivity activity, List<Invitation> invitations, Player player) {
		
		//Do not provide any layout resource id to the super-class, hence the zero value.
		super(activity, 0, invitations);
		this.invitations = invitations;
		this.activity = activity;
		this.player = player;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v = convertView;
		LayoutInflater li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		final Invitation invitation = invitations.get(position);
		if (invitation != null) {
			
			/*
			 * Check if current user is inviter or invitee in order to know
			 * which visual layout to inflate
			 */
			if(invitation.getInvitee().equals(player)){
	
				v = li.inflate(R.layout.list_item_received_invitation, null);
				final TextView invitor = (TextView) v.findViewById(R.id.inviter);
				if (invitor != null)
					invitor.setText(invitation.getInviter().getName());
				
				final ImageButton accept = (ImageButton) v.findViewById(R.id.accept);
				final ImageButton reject = (ImageButton) v.findViewById(R.id.reject);
				
				accept.setOnClickListener(new OnClickListener(){ 
					@Override
					public void onClick(View v){
						//Disable both buttons and accept invitation by giving true-value
						accept.setEnabled(false);
						reject.setEnabled(false);
						activity.setInvitation(invitation, true);	
					}
				});

				reject.setOnClickListener(new OnClickListener(){ 
					@Override
					public void onClick(View v){
						//Disable both buttons and reject invitation by giving false-value
						accept.setEnabled(false);
						reject.setEnabled(false);
						activity.setInvitation(invitation, false);	
					}
				});
				
			} else {
				//Display invitations the user has sent
				v = li.inflate(R.layout.list_item_sent_invitation, null);
				final TextView invitee = (TextView) v.findViewById(R.id.invitee);
				if (invitee != null)
					invitee.setText(invitation.getInvitee().getName());
			}
		}
		return v;
	}


}