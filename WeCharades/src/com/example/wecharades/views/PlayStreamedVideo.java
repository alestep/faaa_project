package com.example.wecharades.views;
/** TODO: 
 * Next step is to get the right word and if the user guess right a score point should be logged in the game logic.
 * 
 * 
 */

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.wecharades.R;
import com.example.wecharades.controller.DownloadVideo;


public class PlayStreamedVideo extends Activity  {

	private final String GAME_DIR = "/GAMES/GAME_BETWEEN_USER_A_USER_B/"; // THIS IS WHERE A UNIQUE FOLDERNAME MUST EXIST FOR EACH GAME. GET GAME_ID FROM PARSE AND LATER CREATE AN UNIQUE FOLDER
	private final String SAVE_PATH = Environment.getExternalStorageDirectory().getPath()+"/PresentVideo.mp4";

	final String TAG = "PlayStreamedVideo";
	private VideoView videoView;
	private MediaController mediaController;
	private DownloadVideo download;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.guessvideo);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		videoView = (VideoView) findViewById(R.id.streamedVideoSurface);

		download = new DownloadVideo(PlayStreamedVideo.this, SAVE_PATH, videoView);
		download.execute();

	}





}

