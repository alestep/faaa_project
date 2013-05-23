package com.example.wecharades.views;

public interface IMessage {
	
	/**
	 * Method to show a message. Mainly intended to show error messages to the user.
	 * @param message - the message to be shown
	 */
	public void showMessage(String message);
}
