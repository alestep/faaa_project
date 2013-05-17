package com.example.wecharades.controller;

import com.parse.ParseException;

public class LoginPresenter extends Presenter{
	public static void login(String username, String password){
		try {
			Database.loginPlayer(username, password);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
