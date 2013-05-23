package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.views.InvitationActivity;

public class InvitationAdapter extends ArrayAdapter<Invitation> {
	private LayoutInflater li;
	private ArrayList<Invitation> invites;
	private InvitationActivity activity;
	
	public InvitationAdapter(InvitationActivity activity, ArrayList<Invitation> invites) {
		super(activity, 0, invites);
		this.invites = invites;
		this.activity = activity;
		li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final Invitation invitation = invites.get(position);
		if (invitation != null) {
				v = li.inflate(R.layout.received_invite_item, null);
				final TextView invitor = (TextView) v.findViewById(R.id.inviter);
				if (invitor != null)
					invitor.setText(invitation.getInviter().getName());
			}
			
			final Button accept = (Button) v.findViewById(R.id.accept);
			final Button reject = (Button) v.findViewById(R.id.reject);
			
			accept.setOnClickListener(new OnClickListener(){ 
				@Override
				public void onClick(View v){
					accept.setEnabled(false);
					reject.setEnabled(false);
					accept.setText("Accepted");
					activity.setInvitation(invitation, true);	
				}
			});
			
			reject.setOnClickListener(new OnClickListener(){ 
				@Override
				public void onClick(View v){
					accept.setEnabled(false);
					reject.setEnabled(false);
					reject.setText("Rejected");
					activity.setInvitation(invitation, false);	
				}
			}); 
				
		return v;
	}
}