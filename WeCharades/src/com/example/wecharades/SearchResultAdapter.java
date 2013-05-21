package com.example.wecharades;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultAdapter extends ArrayAdapter<String> {
	private ArrayList<String> resultList;
	private LayoutInflater li;

	public SearchResultAdapter(Context context, ArrayList<String> resultList) {
		super(context, 0, resultList);
		this.resultList = resultList;
		li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		final String s = resultList.get(position);
		if (s != null) {
			v = li.inflate(R.layout.result_list_item, null);
			final TextView username = (TextView) v.findViewById(R.id.username);
			if (username != null)
				username.setText(s); 
		}
		else {
			// TODO: LŠgg till en NoResults-screen
		}
		final Button play = (Button) v.findViewById(R.id.play);
		play.setOnClickListener(new OnClickListener(){ 
			@Override
			public void onClick(View v){
				play.setText("Sent");
				play.setEnabled(false);
			}
		});  
		return v;
	}
}
