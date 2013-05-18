package com.example.wecharades;

import java.util.ArrayList;

import com.example.wecharades.model.Game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class GameAdapter extends ArrayAdapter<Game> {

	private Context context;
	private ArrayList<Game> items;
	private LayoutInflater vi;

	public GameAdapter(Context context, ArrayList<Game> items) {
		super(context,0, items);
		this.context = context;
		this.items = items;
		vi = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final Game i = items.get(position);
		if (i != null) {
				v = vi.inflate(R.layout.list_item_active_game, null);
				final TextView title = (TextView) v.findViewById(R.id.opponent);
				final TextView subtitle = (TextView) v.findViewById(R.id.score);
				
				if (title != null)
					//TODO: Best�m hur vi ska g�ra med detta. Skall vi skicka med username till denna klass eller ej?
					title.setText( true ? i.getPlayerId2().getName() : i.getPlayerId1().getName()); 
				if(subtitle != null)
					//TODO: Unders�k hur vi kan h�mta score h�r.
					subtitle.setText("The score is 5-6");
		}
		return v;
	}
}

