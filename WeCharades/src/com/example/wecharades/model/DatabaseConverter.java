package com.example.wecharades.model;

import com.parse.ParseObject;

/**
 * This class handle the conversion from database objects to
 * 	the respective Java classes used for the internal representation.
 * @author weCharade
 *
 */
public class DatabaseConverter {

	/*
	 * We need a DataController in order to access stored users locally.
	 * 	TODO we should move the caching of players to another class in order to reduce dependencies!
	 */
	DataController dc;

	
	public DatabaseConverter(DataController dc){
		this.dc = dc;
	}

	//A protected method to parse a ParseObject to a game
	protected Game parseGame(ParseObject game) throws DatabaseException{
		if(game.getClassName().equals(Database.GAME)){
			return new Game(
					game.getObjectId(),
					dc.getPlayerById(game.getString(Database.GAME_PLAYER_1)),
					dc.getPlayerById(game.getString(Database.GAME_PLAYER_2)),
					dc.getPlayerById(game.getString(Database.GAME_PLAYER_CURRENT)),
					game.getInt(Database.GAME_TURN), 
					game.getBoolean(Database.GAME_FINISH),
					game.getUpdatedAt());
		} else{
			return null;
		}
	}

	//A method to parse ParseObject turns into turns
	protected Turn parseTurn(ParseObject turn) throws DatabaseException{
		if(turn.getClassName().equals(Database.TURN)){
			return new Turn(
					turn.getParseObject(Database.TURN_GAME).getObjectId(),
					turn.getInt(Database.TURN_TURN), 
					turn.getInt(Database.TURN_STATE), 
					turn.getString(Database.TURN_WORD), 
					turn.getString(Database.TURN_VIDEOLINK), 
					dc.getPlayerById(turn.getString(Database.TURN_PLAYER_REC)),
					turn.getInt(Database.TURN_PLAYER_REC_SCORE),
					dc.getPlayerById(turn.getString(Database.TURN_PLAYER_ANS)), 
					turn.getInt(Database.TURN_PLAYER_ANS_SCORE) 
					);
		} else{
			return null;
		}
	}

	//A method to parse ParseObject players to players
	protected Player parsePlayer(ParseObject player){
		if(player != null && player.getClassName().equals(Database.PLAYER)) {
			return new Player(
					player.getObjectId(), 
					player.getString(Database.PLAYER_USERNAME_NATURAL), 
					player.getInt(Database.PLAYER_GLOBALSCORE),
					player.getInt(Database.PLAYER_GAMES_PLAYED),
					player.getInt(Database.PLAYER_GAMES_WON),
					player.getInt(Database.PLAYER_GAMES_LOST),
					player.getInt(Database.PLAYER_GAMES_DRAW));
		} else{
			return null;
		}
	}

	protected Invitation parseInvitation(ParseObject invitation) throws DatabaseException{
		if(invitation.getClassName().equals(Database.INVITE)){
			return new Invitation(
					dc.getPlayerById(invitation.getString(Database.INVITE_INVITER))
					, dc.getPlayerById(invitation.getString(Database.INVITE_INVITEE))
					, invitation.getCreatedAt());
		} else{
			return null;
		}
	}

}
