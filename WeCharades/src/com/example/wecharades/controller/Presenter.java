package com.example.wecharades.controller;

import android.content.Context;
import android.widget.Toast;

import com.parse.Parse;

public abstract class Presenter {
	
	/**
	 * Needed in order to use parse commands
	 * @param context - the context (the activity: use 'this' most often)
	 */
	public static void initialize(Context context){
		Parse.initialize(context, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
	}
	
	protected static void showToast(Context context, String msg) {
		Toast error = Toast.makeText(context, msg, Toast.LENGTH_LONG);
		error.show();
	}
}
