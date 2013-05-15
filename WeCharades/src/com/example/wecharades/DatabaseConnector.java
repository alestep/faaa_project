package com.example.wecharades;

import java.util.ArrayList;
public class DatabaseConnector {

	public static ArrayList<Item> getList() {
		ArrayList<Item> items = new ArrayList<Item>();

		items.addAll(getYourTurn());
		items.addAll(getOpponentsTurn());
		items.addAll(getFinishedGames());
		
		return items;
	}
	
	private static ArrayList<Item> getYourTurn() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new SectionItem("Your turn"));
		items.add(new ActiveGameItem("Peter", "The score is 7-4"));
		items.add(new ActiveGameItem("Alexander", "The score is 4-5"));
		items.add(new ActiveGameItem("Anders", "The score is 6-4"));
		return items;
		
	}
	
	private static ArrayList<Item> getOpponentsTurn() {
		ArrayList<Item> items = new ArrayList<Item>();
        items.add(new SectionItem("Opponent's turn"));
		items.add(new ActiveGameItem("Richard", "The score is 7-4"));
		items.add(new ActiveGameItem("Arne", "The score is 4-5"));
		items.add(new ActiveGameItem("Fredrik", "The score is 6-4"));
		return items;
	}
	private static ArrayList<Item> getFinishedGames() {
		ArrayList<Item> items = new ArrayList<Item>();
	    items.add(new SectionItem("Finished games"));
		items.add(new FinishedGameItem("Adam", "You won 7-4"));
		items.add(new FinishedGameItem("Anton", "You lost 4-5"));
		items.add(new FinishedGameItem("Felix", "You won 6-4"));
		return items;
	}
}

