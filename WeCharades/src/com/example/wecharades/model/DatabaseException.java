package com.example.wecharades.model;

public class DatabaseException extends Exception{
	
	public DatabaseException(int code, String message){
		super("Error code " + code + ": " + message);
	}
	
}
