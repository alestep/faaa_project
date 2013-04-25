package com.example.wecharades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class ShowVideo extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showvideo);
		
		VideoView ww = (VideoView) findViewById(R.id.satisfiedVideoView);
		ww.setVideoPath("/sdcard/videocapture_example.mp4");// this can probably be save instead by send with extras or something...
		//set some kind of rotation to the displayed VideoView
		ww.setMediaController(new MediaController(this));
		ww.start();
		
		Button yesButton = (Button) findViewById(R.id.yesButton);
		Button noButton  = (Button) findViewById(R.id.NoButton);
		yesButton.setOnClickListener(this);
		noButton.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.yesButton){
			//DO SOMETHING
			Log.d("ShowVideo.java", "The yesButton was clicked.");// TEMPORARY
		}
		else{
			Intent intent = new Intent(ShowVideo.this, VideoCapture.class);
			startActivity(intent);
		}
		
	}

}
