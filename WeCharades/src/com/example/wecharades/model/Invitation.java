package com.example.wecharades.model;

import java.io.Serializable;
import java.util.Date;

/**
 * This class represents an invitation between two players
 */
public class Invitation implements Serializable {
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = -5910239110421116360L;
	
	private Player inviter;
	private Player invitee;
	private Date timeOfInvite = new Date();

	/**
	 * Simple Constructor with two players. Intended for creation within the application,
	 * 	such as when sending an invitation.
	 * @param inviter - The player who sent the invite
	 * @param invitee - The player who will receive the invite
	 */
	public Invitation(Player inviter, Player invitee) {
		this.inviter = inviter;
		this.invitee = invitee;
	}
	
	/**
	 * Constructor containing a date of creation. Intended for creating an invite from database data
	 * @param inviter - The player who sent the invite
	 * @param invitee - The player who will receive the invite
	 * @param timeOfInvite - the time of creation
	 */
	public Invitation(Player inviter, Player invitee, Date timeOfInvite) {
		this.inviter = inviter;
		this.invitee = invitee;
		this.timeOfInvite = timeOfInvite;
	}

	/**
	 * Get the player who sent the invite
	 * @return A Player representation
	 */
	public Player getInviter() {
		return inviter;
	}

	/**
	 * Get the player who will receive the invitation
	 * @return A Player representation
	 */
	public Player getInvitee() {
		return invitee;
	}

	/**
	 * Get the time of creation for this invitation
	 * @return a cloned Date representation
	 */
	public Date getTimeOfInvite() {
		return (Date) timeOfInvite.clone();
	}
	
	/**
	 * Checks if two Invitation are equal
	 * @return a boolean
	 */
	@Override
	public boolean equals(Object obj){
		return obj != null
				&& obj.getClass().equals(Invitation.class)
				&& this.getInvitee().equals(((Invitation) obj).getInvitee())
				&& this.getInviter().equals(((Invitation) obj).getInviter());
	}
	
	/**
	 * Returns the hashCode for this object
	 */
	@Override
	public int hashCode(){
		return (getInviter().getParseId() + getInvitee().getParseId()).hashCode() + timeOfInvite.hashCode();
	}
	
}
