package com.example.wecharades;

import java.util.ArrayList;

public interface DBInterface {
	
	public boolean pushGame(Game theGame);
	
	public ArrayList<Game> getGames();
	
}
