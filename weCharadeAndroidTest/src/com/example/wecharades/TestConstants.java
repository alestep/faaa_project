package com.example.wecharades;

import java.util.ArrayList;
import java.util.TreeMap;

import com.example.wecharades.model.Game;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.Model;
import com.example.wecharades.model.Player;
import com.example.wecharades.model.Turn;

public class TestConstants {
	
	public static Model m;
	public static TreeMap<Game, ArrayList<Turn>> gameList;
	public static ArrayList<Turn> turns;
	public static Game g1,g2;
	public static Player recPlayer, ansPlayer;
	public static Turn t1,t2,t3,t4,t5,t6;
	public static Invitation invitation;
	public static final int	GLOBAL_SCORE_REC= 5,
			GLOBAL_SCORE_ANS= 0,
			PLAYED_GAMES	= 0,
			WON_GAMES		= 0,
			LOST_GAMES		= 0,
			DRAW_GAMES		= 0,
			TURN_NUMBER_1	= 1,
			TURN_NUMBER_2	= 2,
			TURN_NUMBER_3	= 3,
			TURN_NUMBER_4	= 4,
			TURN_NUMBER_5	= 5,
			TURN_NUMBER_6	= 6,
			STATE			= 0;
	public static final String
			GAME_ID1		= "gameID1",
			GAME_ID2		= "gameID2",
			CHARADEWORD_1	= "horse",
			CHARADEWORD_2	= "monkey",
			CHARADEWORD_3	= "pistol",
			CHARADEWORD_4	= "Coffee",
			CHARADEWORD_5	= "Phone",
			CHARADEWORD_6	= "Car",									
			VIDEOLINK		= "";
	public static final boolean	NOT_FINISHED		= false;

}
