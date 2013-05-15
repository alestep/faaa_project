package com.example.wecharades;

import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class StartScreen extends ListActivity {
    /** Called when the activity is first created. */
	
	private ArrayList<Item> items = new ArrayList<Item>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        items = DatabaseConnector.getList(); //Här kan vi skicka med användarnamneet så vi vet vems data som skall hämtas.

        View header = View.inflate(this, R.layout.new_game_header, null);
        ListView lv = getListView();
        lv.addHeaderView(header);
        
        EntryAdapter adapter = new EntryAdapter(this, items);
        setListAdapter(adapter);
        
        Button b = (Button) findViewById(R.id.new_game_button);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(StartScreen.this, NewGameScreen.class);
				startActivity(intent);
			}
			
		});
        
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	
    	if(!items.get(position-1).isSection() && items.get(position-1).isActive()){
    		ActiveGameItem item = (ActiveGameItem) items.get(position-1);
    		Intent intent = new Intent(StartScreen.this, GameScreen.class);
    		intent.putExtra("username", item.getTitle());
    		startActivity(intent);

    		
    		Toast.makeText(this, "You clicked " + item.getTitle() , Toast.LENGTH_SHORT).show();
    		
    	}
    	
    	super.onListItemClick(l, v, position-1, id);
    }
}