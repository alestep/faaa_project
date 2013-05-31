package com.example.wecharades.views;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wecharades.model.Database;
import com.example.wecharades.model.Turn;

/**
 * View which displays video capturing
 * @author weCharade
 *
 */
public class CaptureVideoActivity extends Activity {

	final static int REQUEST_VIDEO_CAPTURED = 1;
	public static Uri uriVideo = null;
	private Intent intentCamera;
	private Turn turn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//reference to the current of the game
		this.turn = (Turn) getIntent().getSerializableExtra(Database.TURN);
		dispatchTakeVideoIntent();
	}
	
	/**
	 * Initiates the device's built in video recording application.
	 */
	private void dispatchTakeVideoIntent(){
			intentCamera = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
			intentCamera.putExtra(android.provider.MediaStore.EXTRA_DURATION_LIMIT, 8);
			intentCamera.putExtra(android.provider.MediaStore.EXTRA_VIDEO_QUALITY, 1);
			intentCamera.putExtra(android.provider.MediaStore.EXTRA_SIZE_LIMIT, 12);
			startActivityForResult(intentCamera, REQUEST_VIDEO_CAPTURED);	
	}
	/**
	 * Starts the VideoUploadActivity on a successful recording with the camera.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == RESULT_OK){
			if(requestCode == REQUEST_VIDEO_CAPTURED){
				uriVideo = data.getData();
				Intent intentShowVideo = new Intent(this, VideoUploadActivity.class);
				intentShowVideo.putExtra(Database.TURN, turn);
				startActivity(intentShowVideo);
				finishActivity(REQUEST_VIDEO_CAPTURED);
				finish();
			}
		}
		else if(resultCode == RESULT_CANCELED){
			uriVideo = null;
			Toast.makeText(this,"Canceled!",Toast.LENGTH_LONG).show();
			finish();
		}
	}
	
}

