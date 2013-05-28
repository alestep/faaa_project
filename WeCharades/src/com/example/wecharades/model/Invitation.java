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
	private Player inviter;
	private Player invitee;
	private Date timeOfInvite;

	public Invitation(Player inviter, Player invitee) {
		this.inviter = inviter;
		this.invitee = invitee;
	}
	
	public Invitation(Player inviter, Player invitee, Date timeOfInvite) {
		this.inviter = inviter;
		this.invitee = invitee;
		this.timeOfInvite = timeOfInvite;
	}
	
	public void setTime(Date date){
		this.timeOfInvite = date;
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
	
	@Override
	public boolean equals(Object obj){
		return obj != null
				&& obj.getClass().equals(Invitation.class)
				&& this.equals((Invitation) obj) ;
	}
	
	public boolean equals(Invitation otherInv){
		return otherInv != null
				&& this.getInvitee().equals(otherInv.getInvitee())
				&& this.getInviter().equals(otherInv.getInviter());
	}
	
	@Override
	public int hashCode(){
		return (getInviter() + "//" + getInvitee()).hashCode();
	}
	
}
