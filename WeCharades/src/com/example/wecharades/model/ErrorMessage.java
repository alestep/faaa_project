package com.example.wecharades.model;

public class ErrorMessage {
	/**
	 * Generates a proper error message based on the link below
	 * https://www.parse.com/docs/android/api/constant-values.html#com.parse.ParseException.INCORRECT_TYPE
	 * @param code
	 * @return
	 */
	public static String generateErrorMessage(int code) {
		String message = "Unknown error. Code: " + code;
		if(code == 100) {
			message = "Please check your internet connection";
		} else if (code == 101) {
			//OBJECT_NOT_FOUND
			message = "Invalid username or password";
		} else if (code == 200) {
			message = "Missing username";
		} else if (code == 201) {
			message = "Password missing";
		} else if (code == 202) {
			message = "Username already in use.";
		} else if (code == 203) {
			message = "E-mail already in use";
		} else if (code == 204) {
			message = "E-mail missing";
		} else if (code == 205) {
			message = "E-mail not found";
		} else if (code == 1) {
			message = "Internal server error";
		} else if (code == 125) {
			message = "Invalid e-mail address";
		}
		return message;
	}
}
