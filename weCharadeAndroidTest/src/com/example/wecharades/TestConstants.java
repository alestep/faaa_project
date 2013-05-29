package com.example.wecharades;

import java.util.ArrayList;
import java.util.Date;
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
			VIDEOLINK		= "",
			REC_PLAYER_NAME	= "recName",
			ANS_PLAYER_NAME	= "ansName",
			REC_PLAYER_ID	= "recId",
			ANS_PLAYER_ID	= "ansId";
	public static final boolean	NOT_FINISHED		= false;
	
	public static Player recPlayer = new Player(REC_PLAYER_ID, REC_PLAYER_NAME, GLOBAL_SCORE_REC, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
	public static Player ansPlayer = new Player(ANS_PLAYER_ID, ANS_PLAYER_NAME, GLOBAL_SCORE_ANS, PLAYED_GAMES, WON_GAMES, LOST_GAMES, DRAW_GAMES);
	
	public static Game g1 = new Game(GAME_ID1, recPlayer, ansPlayer, ansPlayer, TURN_NUMBER_1, NOT_FINISHED, new Date());
	public static Game g2 = new Game(GAME_ID2, recPlayer, ansPlayer, ansPlayer, TURN_NUMBER_1, NOT_FINISHED, new Date());
	public static Turn t1 = new Turn(GAME_ID1, TURN_NUMBER_1, STATE, CHARADEWORD_1,VIDEOLINK, recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
	public static Turn t2 = new Turn(GAME_ID1, TURN_NUMBER_2, STATE, CHARADEWORD_2,VIDEOLINK, ansPlayer, GLOBAL_SCORE_ANS, recPlayer, GLOBAL_SCORE_REC);
	public static Turn t3 = new Turn(GAME_ID1, TURN_NUMBER_3, STATE, CHARADEWORD_3,VIDEOLINK, recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
	public static Turn t4 = new Turn(GAME_ID1, TURN_NUMBER_4, STATE, CHARADEWORD_4,VIDEOLINK, ansPlayer, GLOBAL_SCORE_ANS, recPlayer, GLOBAL_SCORE_REC);
	public static Turn t5 = new Turn(GAME_ID1, TURN_NUMBER_5, STATE, CHARADEWORD_5,VIDEOLINK, recPlayer, GLOBAL_SCORE_REC, ansPlayer, GLOBAL_SCORE_ANS);
	public static Turn t6 = new Turn(GAME_ID1, TURN_NUMBER_6, STATE, CHARADEWORD_6,VIDEOLINK, ansPlayer, GLOBAL_SCORE_ANS, recPlayer, GLOBAL_SCORE_REC);

}
