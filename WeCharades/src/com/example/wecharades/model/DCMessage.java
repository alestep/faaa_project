package com.example.wecharades.model;

import java.util.List;


/**
 * A class to have better control over types when sending observer messages.
 * @author Anton Dahlström
 *
 */
public class DCMessage implements IMessage{
	
	/*
	 * Standard message types are declared here
	 */
	public static final int 
	UNDEFINED				=  0
	, MESSAGE 				= 10
	, ERROR					= 20
	, DATABASE_GAMES 		= 30
	, INVITATIONS			= 40;

	int message;
	Object data;

	@SuppressWarnings("rawtypes")
	public DCMessage(int message, Object data){
		//We make some type controls to increase the validity of provided data.
		if(data != null){
			switch(message){
			case(10)	: if(data.getClass().equals(String.class)) 	{this.message = MESSAGE; break;}
			case(20)	: if(data.getClass().equals(String.class))	{this.message = ERROR; break;}
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
	
	/**
	 * Get the message code
	 * @return an messege expressed as an int
	 */
	@Override
	public int getMessage() {
		return message;
	}

	/**
	 * The attached data
	 * 	@return an Object with data
	 */
	@Override
	public Object getData() {
		return data;
	}
}
