package com.example.wecharades.presenter;

import java.util.ArrayList;

import android.app.Activity;
import android.util.Log;

import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Game;
import com.example.wecharades.views.StartActivity;

public class StartPresenter extends Presenter {
	
	private static final String TAG = "Start Presenter";
	private StartActivity start;
	private ArrayList<Game> yourTurnList;
	private ArrayList<Game> opponentsTurnList;
	private ArrayList<Game> finishedList;
	
	public StartPresenter(Activity start) {
		super(start);
		this.start = (StartActivity) start;
		yourTurnList = new ArrayList<Game>();
		opponentsTurnList = new ArrayList<Game>();
		finishedList = new ArrayList<Game>();
	}
	
	/**
	 * 
	 * @return the list of games in which it is the current user's turn
	 */
    public ArrayList<Game> getYourTurnList() {
    	return yourTurnList;
    }
    
    /**
     * 
     * @return the list of games in which it is the current user's opponent's turn
     */
    public ArrayList<Game> getOpponentsTurnList() {
    	return opponentsTurnList;
    }
    
    /**
     * 
     * @return the list of the current user's finished games
     */
    public ArrayList<Game> getFinishedList() {
    	return finishedList;
    }
    
	/**
	 * 
	 */
	public void parseGameLists(String currentUser) {
		try {
			ArrayList<Game> gameList = new ArrayList<Game>();
			gameList = Database.getGames(Database.getPlayer(currentUser));
			Log.d(TAG, " " + gameList.isEmpty());
	        for (Game g : gameList) {
	        	if (g.isFinished())
	        		finishedList.add(g);
	        	else if (g.getCurrentPlayer().getName().toLowerCase().equals(currentUser) && !g.isFinished())
	        		yourTurnList.add(g);                   
	        	else
	        		opponentsTurnList.add(g);
	        }
		} catch (DatabaseException e){
			Log.d(TAG, e.getMessage());
		}
	}
}
