package com.example.wecharades.model;

/**
 * Declares that an implementing class is a message, containing an integer 
 * 	message and data linked to that message.
 */
public interface IMessage {
	
	/**
	 * Intended to get the included message - used for determening types
	 * @return A message (preferably stored as final values in the implementing class)
	 */
	public int getMessage();
	
	/**
	 * Get the accompanying data. Can be typecasted according to the message.
	 * @return Object - the data object of the message
	 */
	public Object getData();
}
