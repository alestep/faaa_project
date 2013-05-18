package com.example.wecharades.model;

import java.util.Date;

/**
 * This class represents an invitation
 * @author Anton Dahlström
 *
 */
public class Invitation {
	Player inviter;
	Player invitee;
	Date timeOfInvite;

	public Invitation(Player inviter, Player invitee, Date timeOfInvite) {
		this.inviter = inviter;
		this.invitee = invitee;
		this.timeOfInvite = timeOfInvite;
	}

	public Player getInviter() {
		return inviter;
	}

	public Player getInvitee() {
		return invitee;
	}

	public Date getTimeOfInvite() {
		return timeOfInvite;
	}
	
}
