package com.example.wecharades.controller;

import android.content.Context;

import com.parse.Parse;

public abstract class Presenter {
	public void initialize(Context context){
		Parse.initialize(context, "p34ynPRwEsGIJ29jmkGbcp0ywqx9fgfpzOTjwqRF", "RZpVAX3oaJcZqTmTwLvowHotdDKjwsi6kXb4HJ0R");
	}
}
