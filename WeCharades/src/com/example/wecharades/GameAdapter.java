package com.example.wecharades;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wecharades.model.Game;

public class GameAdapter extends ArrayAdapter<Game> {

	private ArrayList<Game> games;
	private LayoutInflater li;
	private Context context;

	public GameAdapter(Context context, ArrayList<Game> items) {
		super(context, 0, items);
		this.games = items;
		this.context = context;
		li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
					//TODO: Bestäm hur vi ska göra med detta. Skall vi skicka med username till denna klass eller ej?
					title.setText( true ? game.getPlayerId2().getName() : game.getPlayerId1().getName()); 
				if(subtitle != null)
					//TODO: Undersök hur vi kan hämta score här.
					subtitle.setText("The score is 5-6");
		}
		return v;
	}
}


