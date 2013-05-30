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

	/**
	 * Create a new DCMessage with a message and data.
	 * 	If provided data is of wrong type, the message will be changed to UNDEFINED.
	 * @param message
	 * @param data
	 */
	@SuppressWarnings("rawtypes")
	public DCMessage(int message, Object data){
		this.data = data;
		//We make some type controls to increase the validity of provided data.
		if(data != null){
			switch(message){
			case(10)	: if(data.getClass().equals(String.class)) 	{this.message = MESSAGE;} else{this.message = UNDEFINED;} break;
			case(20)	: if(data.getClass().equals(String.class))	{this.message = ERROR;} else{this.message = UNDEFINED;} break;
			case(30)	: if(data instanceof List){
				if(!((List) data).isEmpty()){
					if(((List) data).iterator().next().getClass().equals(Game.class)){
						this.message = message;
					}
				} else{
					this.message = message;
				}
			} else{this.message = message;} break;
//					&& (
//							!((List) data).isEmpty() 
//							&& ((List) data).get(0).getClass().equals(Game.class)
//							)
//							||	((List) data).isEmpty()
//					)//if
//			{this.message = message;} else{this.message = UNDEFINED;} break;
			case(40)	: if(data instanceof List 
					&& (
							!((List) data).isEmpty() 
							&& ((List) data).get(0).getClass().equals(Invitation.class)
							)
							||	((List) data).isEmpty()
					)//if
			{this.message = message;} else{this.message = UNDEFINED;} break;
			default		: this.message = UNDEFINED; break;
			}
		} else{
			this.message = UNDEFINED;
		}
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
