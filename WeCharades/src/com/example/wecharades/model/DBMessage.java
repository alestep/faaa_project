package com.example.wecharades.model;

import java.util.List;
import java.util.Map;

import com.example.wecharades.views.IMessage;

/**
 * A class to have better control over types when sending observer messages from database.
 * @author Anton Dahlström
 *
 */
public class DBMessage implements IMessage{

	public static final int 
	UNDEFINED			= 0
	, ERROR 			= 10
	, GAMELIST			= 20
	, INVITATIONS		= 30;

int message;
Object data;

public DBMessage(int message, Object data){
	switch(message){
	case(10)	: if(data.getClass().equals(DatabaseException.class)){this.data = data; break;} 
	case(20)	: if(data instanceof Map
						&& ( 
								(!((Map) data).isEmpty() 
										&& ((Map) data).entrySet().iterator().next().getClass().equals(Game.class))
								|| ((Map) data).isEmpty()
							)
					)
					{this.message = message; break;}
	case(30)	: if(data instanceof List
						&& (	
								(!((List) data).isEmpty()
									&& ((List) data).iterator().next().getClass().equals(Invitation.class) 
								)
								|| ((List) data).isEmpty()
							)
					)
					{this.message = message; break;}
	default 	: this.message = UNDEFINED; break;
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
