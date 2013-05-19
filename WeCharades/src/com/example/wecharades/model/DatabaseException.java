package com.example.wecharades.model;

public class DatabaseException extends Exception{
	
	/**
	 * This is something that could be nice to have
	 */
	private static final long serialVersionUID = -7327895517752379103L;

	/**
	 * Generate a message, with e.getMessage() will give: code + message
	 * @param code - the chosen error code
	 * @param message - the message to display
	 */
	private int code;
	public DatabaseException(int code, String message){
		super("Error code " + code + ": " + message);
		code = this.code;
	}

	public int getCode() {
		return code;
	}
	
}
