package com.example.wecharades.model;

import java.util.List;
import java.util.Map;


/**
 * A class to have better control over types when sending observer messages from database.
 * @author Anton Dahlström
 *
 */
public class DBMessage implements IMessage{

	public static final int 
	UNDEFINED			= 0
	, ERROR 			= 10
	, MESSAGE			= 20
	, GAMELIST			= 30
	, INVITATIONS		= 40;

	int message;
	Object data;

	public DBMessage(int message, Object data){
		if(data != null){
			switch(message){
			case(ERROR)		: if(data.getClass().equals(DatabaseException.class)){this.message = message; break;}
			case(MESSAGE)	: if(data.getClass().equals(String.class)){this.message = message; break;}
			case(GAMELIST)	: if(data instanceof Map
					&& ( 
							(!((Map) data).isEmpty() 
									&& ((Map) data).keySet().iterator().next().getClass().equals(Game.class))
									|| ((Map) data).isEmpty()
							)
					)
			{this.message = message; break;}
			case(INVITATIONS): 	if(data instanceof List
					&& (	
							(!((List) data).isEmpty()
									&& ((List) data).iterator().next().getClass().equals(Invitation.class) 
									)
									|| ((List) data).isEmpty()
							)
					)
			{this.message = message; break;}
			default 		: this.message = UNDEFINED; break;
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
