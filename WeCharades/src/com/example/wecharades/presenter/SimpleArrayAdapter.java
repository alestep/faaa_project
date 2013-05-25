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

public class SimpleArrayAdapter extends ArrayAdapter<String> {

	private ArrayList<String> headers;


	public SimpleArrayAdapter(StartActivity activity, ArrayList<String> headers) {
		super(activity, 0, headers);
		this.headers = headers;
		LayoutInflater li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
//		View v = convertView;
//
//		final Game game = games.get(position);
//		if (game != null) {
//			v = li.inflate(R.layout.list_item_active_game, null);
//			final TextView title = (TextView) v.findViewById(R.id.opponent);
//			final TextView subtitle = (TextView) v.findViewById(R.id.score);
//			Player opponent = game.getPlayer1().equals(currentPlayer) ? game.getPlayer2() : game.getPlayer1();
//			if (title != null)
//				title.setText(opponent.getName());
//			if(subtitle != null) {
//				int currentPlayerScore	= score.get(game).get(currentPlayer);
//				int opponentScore		= score.get(game).get(opponent);
//				subtitle.setText("The score is " + currentPlayerScore + " - " + opponentScore);
//			}
//		}
		return null;
	}
}


