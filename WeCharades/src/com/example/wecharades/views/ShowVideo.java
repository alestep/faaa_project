package com.example.wecharades.views;

import java.io.File;

import com.example.wecharades.R;
import com.example.wecharades.R.id;
import com.example.wecharades.R.layout;

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



public class ShowVideo extends Activity implements OnClickListener {
	static String path = "";
	public static String fileName;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Forces landscape orientation which is what the camera uses.
		setContentView(R.layout.showvideo);
		Button yesButton = (Button) findViewById(R.id.yesButton);
		Button noButton  = (Button) findViewById(R.id.NoButton);
		yesButton.setOnClickListener(this);
		noButton.setOnClickListener(this);
		
		VideoView ww = (VideoView) findViewById(R.id.satisfiedVideoView);
		//ww.setVideoPath("/sdcard/videocapture_example.mp4");// this can probably be save instead by send with extras or something...
		ww.setVideoURI(CaptureVideo.uriVideo);
		ww.setMediaController(new MediaController(this));
		ww.start();
		ww.requestFocus();
		
		path = getRealPathFromURI(CaptureVideo.uriVideo);
		fileName = getFileNameFromUrl(path);
    }
	public static String getFileNameFromUrl(String path) {
        String[] pathArray = path.split("/");
        return pathArray[pathArray.length - 1];
    }


	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.yesButton){
			Log.d("ShowVideo.java", "The yesButton was clicked.");// TEMPORARY
			Intent intent = new Intent(ShowVideo.this, UploadVideo.class);
			startActivity(intent);
		}
		else{
			File file = new File(path);
			boolean deleted = false;
			deleted = file.delete();
			Log.d("TAG", Boolean.toString(deleted));
			Intent intent = new Intent(ShowVideo.this, CaptureVideo.class);
			startActivity(intent);
		}
		
	}
	public String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }


}
