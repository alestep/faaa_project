package com.example.wecharades.views;
/** TODO: 
 * Next step is to get the right word and if the user guess right a score point should be logged in the game logic.
 * 
 * 
 */

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.VideoView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.GuessCharadePresenter;



public class GuessCharadeActivity extends Activity  {

	

	final String TAG = "PlayStreamedVideo";
	private VideoView videoView;
	private GuessCharadePresenter presenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guessvideo);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		videoView = (VideoView) findViewById(R.id.streamedVideoSurface);
		
		presenter = new GuessCharadePresenter(this);
		presenter.downloadVideo(GuessCharadeActivity.this, videoView);

		//download = new DownloadVideo(GuessCharadeActivity.this, SAVE_PATH, videoView);
		//download.execute();

	}





}

