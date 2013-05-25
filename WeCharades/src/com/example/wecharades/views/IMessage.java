package com.example.wecharades.views;

public interface IMessage {
	
	/**
	 * Intended to get the included message - used for determening types
	 * @return A message (preferably stored as final values in the implementing class)
	 */
	public int getMessage();
	
	/**
	 * Get the accompanying data. Can be typecasted according to the message.
	 * @return Object
	 */
	public Object getData();
}
