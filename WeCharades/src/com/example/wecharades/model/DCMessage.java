package com.example.wecharades.model;

import java.util.ArrayList;

import com.example.wecharades.views.IMessage;

/**
 * A class to have better control over types when sending observer messages.
 * @author Anton Dahlström
 *
 */
public class DCMessage implements IMessage{
	public static final int 
		UNDEFINED			= 0
		, MESSAGE 			= 10
		, ERROR				= 20
		, DATABASE_GAMES 	= 30
		, INVITATIONS 		= 40;
	
	int message;
	Object data;
	
	public DCMessage(int message, Object data){
		switch(message){
		case(10)	: if(data instanceof String) 	{this.message = MESSAGE; break;}
		case(20)	: if(data instanceof Exception)	{this.message = ERROR; break;}
		case(30)	: if(data instanceof ArrayList 
						&& (
								!((ArrayList) data).isEmpty() 
								&& ((ArrayList) data).get(0).getClass().equals(Game.class)
							)
						||	((ArrayList) data).isEmpty()
						)//if
						{this.message = DATABASE_GAMES; break;}
		case(40)	: if(data instanceof ArrayList 
						&& (
								!((ArrayList) data).isEmpty() 
								&& ((ArrayList) data).get(0).getClass().equals(Invitation.class)
							)
						||	((ArrayList) data).isEmpty()
						)//if
						{this.message = INVITATIONS; break;};
		default		: this.message = UNDEFINED; break;
		}
		this.data = data;
	}

	public int getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
}
