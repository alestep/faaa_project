package com.example.wecharades.presenter;

import java.util.ArrayList;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Player;
import com.example.wecharades.views.StartActivity;

/**
 * Presenter-help-class intended to manage the filling of ListView-items on the start view.
 * @author weCharade
 */
public class GameAdapter extends ArrayAdapter<Game> {
	
	private StartActivity activity;
	private ArrayList<Game> games;
	private Player user;
	private Map<Game, Map<Player, Integer>> score;
	
	/**
	 * Create an instance of GameAdapter
	 * @param activity		The activity connected to the Adapter
	 * @param games			List of Game-items which should be displayed
	 * @param currentPlayer	
	 * @param score			Nested Map with Game as outer key and Map a value, with Player as key and score as value
	 */
	public GameAdapter(StartActivity activity, ArrayList<Game> games, Player user, Map<Game, Map<Player, Integer>> score) {
		
		//Do not provide any layout resource id to the super-class, hence the zero value.
		super(activity, 0, games);
		this.activity = activity;
		this.score = score;
		this.games = games;
		this.user = user;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v = convertView;
		LayoutInflater li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final Game game = games.get(position);
		
		if (game != null) {
			
			v = li.inflate(R.layout.list_item_game, null);
			final TextView title = (TextView) v.findViewById(R.id.opponent);
			final TextView subtitle = (TextView) v.findViewById(R.id.score);
			
			//Check which of the players in the game who is the user in order to know which name to display
			Player opponent = game.getPlayer1().equals(user) ? game.getPlayer2() : game.getPlayer1();
			
			if (title != null)
				
				title.setText(opponent.getName());
			
			if(subtitle != null) {
				
				int currentPlayerScore	= score.get(game).get(user);
				int opponentScore		= score.get(game).get(opponent);
				subtitle.setText("The score is " + currentPlayerScore + " - " + opponentScore);
				
			}
		}
		
		return v;
		
	}
}


