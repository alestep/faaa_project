package com.example.wecharades.presenter;

import java.util.ArrayList;

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

public class GameAdapter extends ArrayAdapter<Game> {

	private ArrayList<Game> games;
	private LayoutInflater li;
	private StartActivity activity;
	private Player currentPlayer; //TODO This may be moved to our generic activity later

	public GameAdapter(StartActivity activity, ArrayList<Game> games, Player currentPlayer) {
		super(activity, 0, games);
		this.games = games;
		this.activity = activity;
		this.currentPlayer = currentPlayer;
		li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final Game game = games.get(position);
		if (game != null) {
				v = li.inflate(R.layout.list_item_active_game, null);
				final TextView title = (TextView) v.findViewById(R.id.opponent);
				final TextView subtitle = (TextView) v.findViewById(R.id.score);
				
				if (title != null)
					title.setText(game.getPlayer1().equals(currentPlayer) ? game.getPlayer2().getName() : game.getPlayer1().getName());
				if(subtitle != null)
					//TODO: Undersök hur vi kan hämta score här.
					subtitle.setText("The score is 5-6");
		}
		return v;
	}
}


