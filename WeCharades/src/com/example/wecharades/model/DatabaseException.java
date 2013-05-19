package com.example.wecharades.model;

public class DatabaseException extends Exception{

	/**
	 * This is something that could be nice to have
	 */
	private static final long serialVersionUID = -7327895517752379103L;
	private int code;
	private String prettyMessage;

	/**
	 * Generate a message, with e.getMessage() will give: codes + message
	 * @param code - the chosen error code (based on parse.com's exceptions)
	 * @param message - the message to display
	 */
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	public DatabaseException(int code, String message){
		super(message);
		this.code = code;
		this.prettyMessage = setPrettyPrint(message);
	}

	private String setPrettyPrint(String message) {
		//TODO Swtich case check code
		switch (code) {
			case 1: message = "Internal server error";
			break;
			case 100: message = "Please check your internet connection";
			break;
			case 101: message = "Invalid username or password";
			break;
			case 125: message = "Invalid e-mail address";
			break;
			case 200: message = "Username missing";
			break;
			case 201: message = "Password missing";
			break;
			case 202: message = "Username already in use";
			break;
			case 203: message = "E-mail already in use";
			break;
			case 204: message = "E-mail missing";
			break;
			case 205: message = "E-mail not found";
			break;
		}

		return message;
	}

	public String prettyPrint() {
		return prettyMessage;
	}

	public int getCode() {
		return code;
	}

}
