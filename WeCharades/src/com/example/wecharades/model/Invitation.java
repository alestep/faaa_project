package com.example.wecharades.model;

import java.io.Serializable;
import java.util.Date;

/**
 * This class represents an invitation
 * @author Anton Dahlstr�m
 *
 */
public class Invitation implements Serializable {
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -5910239110421116360L;
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
	
	public int hashCode(){
		return (inviter.getParseId() + invitee.getParseId()).hashCode();
	}
	
}
