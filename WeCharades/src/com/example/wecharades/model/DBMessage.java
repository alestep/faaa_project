package com.example.wecharades.model;

import java.util.List;
import java.util.Map;


/**
 * A class to have better control over types when sending observer messages from database.
 * @author Anton Dahlström
 *
 */
public class DBMessage implements IMessage{

	/*
	 * Standard message types are declared here
	 */
	public static final int 
	UNDEFINED			= 0
	, ERROR 			= 10
	, MESSAGE			= 20
	, GAMELIST			= 30
	, INVITATIONS		= 40;

	int message;
	Object data;

	@SuppressWarnings("rawtypes")
	public DBMessage(int message, Object data){
		this.data = data;
		//We make some type controls to increase the validity of provided data.
		if(data != null){
			switch(message){
			case(ERROR)		: if(data.getClass().equals(DatabaseException.class)){this.message = message;} else{this.message = UNDEFINED;} break;
			case(MESSAGE)	: if(data.getClass().equals(String.class)){this.message = message;} else{this.message = UNDEFINED;} break;
			case(GAMELIST)	: 
				if(data instanceof Map){
					if(!((Map) data).isEmpty()){
						if(((Map) data).keySet().iterator().next().getClass().equals(Game.class)){
							this.message = message;
						} else{
							this.message = UNDEFINED;
						}
					} else{
						//If the list is empty, we can safely ignore containing type
						this.message = message;
					}
				} else{this.message = UNDEFINED;} break;
			case(INVITATIONS): 	
				if(data instanceof List){
					if(!((List) data).isEmpty()){
						if(((List) data).iterator().next().getClass().equals(Invitation.class)){
							this.message = message;
						} else{
							this.message = UNDEFINED;
						}
					} else{
						//If the list is empty, we can safely ignore containing type
						this.message = message;
					}
				} else{this.message = UNDEFINED;} break;
			
			default : this.message = UNDEFINED; break;
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
