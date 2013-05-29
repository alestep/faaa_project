package com.example.wecharades.model;

import java.util.List;


/**
 * A class to have better control over types when sending observer messages.
 * @author Anton Dahlström
 *
 */
public class DCMessage implements IMessage{
	public static final int 
	UNDEFINED				=  0
	, MESSAGE 				= 10
	, ERROR					= 20
	, DATABASE_GAMES 		= 30
	, INVITATIONS			= 40;

	int message;
	Object data;

	public DCMessage(int message, Object data){
		if(data != null){
			switch(message){
			case(10)	: if(data instanceof String) 	{this.message = MESSAGE; break;}
			case(20)	: if(data instanceof String)	{this.message = ERROR; break;}
			case(30)	: if(data instanceof List 
					&& (
							!((List) data).isEmpty() 
							&& ((List) data).get(0).getClass().equals(Game.class)
							)
							||	((List) data).isEmpty()
					)//if
			{this.message = message; break;}
			case(40)	: if(data instanceof List 
					&& (
							!((List) data).isEmpty() 
							&& ((List) data).get(0).getClass().equals(Invitation.class)
							)
							||	((List) data).isEmpty()
					)//if
			{this.message = message; break;};
			default		: this.message = UNDEFINED; break;
			}
		} else{
			this.message = UNDEFINED;
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
