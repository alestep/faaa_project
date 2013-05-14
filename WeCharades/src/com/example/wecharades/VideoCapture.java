/**package com.example.wecharades;


import java.io.IOException;
import com.example.wecharades.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class VideoCapture extends Activity implements OnClickListener, SurfaceHolder.Callback {
	MediaRecorder recorder;
	SurfaceHolder holder;
	private boolean recording = false;
	private int state = 0;
	//Button recordButton = (Button) findViewById(R.id.recordButton);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //No title of the application
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove the status bar
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //Forces landscape orientation which is what the camera uses.

		recorder = new MediaRecorder();
		initRecorder();
		setContentView(R.layout.videocapture);

		SurfaceView cameraView = (SurfaceView) findViewById(R.id.cameraview);
		holder = cameraView.getHolder();
		holder.addCallback(this);

		cameraView.setClickable(true);
		cameraView.setOnClickListener(this);
	}

	private void initRecorder() {
		recorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);//default AudioSource
		recorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT);//default VideoSource

		CamcorderProfile highCameraProfile = CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH);//skapa en profil specificerar egenskaperna hos filen som kommer ut
		recorder.setProfile(highCameraProfile);
		recorder.setOutputFile("/sdcard/videocapture_example.mp4");//where to save the videofile.
		recorder.setMaxDuration(50000); // MAXDuration 10 seconds
		recorder.setMaxFileSize(20000000); // MAXSIZE 20 megabytes
	}

	private void prepareRecorder() {
		recorder.setPreviewDisplay(holder.getSurface());

		try {
			recorder.prepare();

		} catch (IllegalStateException e) {
			finish();
		} catch (IOException e) {
			finish();
		}

	}
	@Override
	public void onClick(View v) {
		
		if (state == 1) {
			recorder.stop();
			//recording = false;
			state = 2;
			
			// Let's initRecorder so we can record again
			//initRecorder();
			//prepareRecorder();

			
		}
		if (state == 2){
			Intent intent = new Intent(VideoCapture.this, ShowVideo.class);
			startActivity(intent);
			
		}
		else {
			state = 1;
			recorder.start();
		}
	}

	public void surfaceCreated(SurfaceHolder holder) {//manadatory from the interface, calls directly when the surface is created.
		prepareRecorder();
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		if (state == 1) {
			recorder.stop();
			state = 0;
		}
		recorder.release();
		//finish();
	}



}*/
