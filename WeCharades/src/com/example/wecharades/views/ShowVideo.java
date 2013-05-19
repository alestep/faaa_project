package com.example.wecharades.views;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.wecharades.R;
import com.example.wecharades.controller.UploadVideo;

/**
 * 
 * @author Adam
 *TODO: Fix the  design in the xml file showvideo.xml.
 */

public class ShowVideo extends Activity{
	protected static final String TAG = "";
	UploadVideo upload;
	public static String path = "";
	public static String fileName;
	private VideoView ww;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Forces landscape orientation which is what the camera uses.
		setContentView(R.layout.showvideo);
		Button yesButton = (Button) findViewById(R.id.yesButton);
		Button noButton  = (Button) findViewById(R.id.NoButton);		
		ww = (VideoView) findViewById(R.id.satisfiedVideoView);
		
		path = getPathFromURI(CaptureVideo.uriVideo);
		fileName = getFileNameFromUrl(path);
		
		playVideo();
		
		yesButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(v.getId() == R.id.yesButton){
					upload = new UploadVideo(ShowVideo.this, path, fileName);
					upload.execute();
				}
			}
		});
		
		noButton.setOnClickListener(new OnClickListener() {
			public void onClick(View w) {
						File file = new File(path);
						boolean deleted = false;
						deleted = file.delete();
						Log.e(TAG, Boolean.toString(deleted));
						Intent intent = new Intent(ShowVideo.this, CaptureVideo.class);
						startActivity(intent);

			}
		});
	}

	private void playVideo(){
		ww.setVideoURI(CaptureVideo.uriVideo);
		ww.setMediaController(new MediaController(this));
		ww.start();
		ww.requestFocus();
	}
	public static String getFileNameFromUrl(String path) {
		String[] pathArray = path.split("/");
		return pathArray[pathArray.length - 1];
	}

	public String getPathFromURI(Uri contentUri) {
		String[] proj = { MediaStore.Images.Media.DATA };
		Cursor cursor = managedQuery(contentUri, proj, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}

}


	


