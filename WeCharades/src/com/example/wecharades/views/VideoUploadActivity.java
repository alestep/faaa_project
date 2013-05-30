package com.example.wecharades.views;


import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.VideoUploadPresenter;


/**
 * View which displays the screen where a user uploads a video to the server
 * @author weCharade
 */

public class VideoUploadActivity extends GenericActivity{
	
	private String path = "";
	public static String fileName;
	private VideoView videoView;
	private VideoUploadPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new VideoUploadPresenter(this));
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.show_video);
		
		//Get references to instances
		presenter = (VideoUploadPresenter) super.getPresenter();
		videoView = (VideoView) findViewById(R.id.satisfiedVideoView);
		path = getPathFromURI(CaptureVideoActivity.uriVideo);	
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		presenter.playVideo(videoView,path);
	}

	/**
	 * Upload video if the user is satisfied with the capture
	 * @param view
	 */
	public void onClickSatisfied(View view) {
		videoView.stopPlayback();
		presenter.uploadVideo(VideoUploadActivity.this, path);
	}

	/**
	 * Re-record video if the user is not satisfied with the capture
	 * @param w
	 */
	public void onClickNotSatisfied(View view) {
		presenter.reRecord(path);
	}
	
	/**
	 * 
	 * @param contentUri
	 * @return
	 */
	private String getPathFromURI(Uri contentUri) {
		String[] proj = { MediaStore.Images.Media.DATA };
		Cursor cursor = managedQuery(contentUri, proj, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}

	/*
	 * Activity is considered not to be in need of displaying an IProgress-instance.
	 * This method will therefore never be called, and it is OK to return null.
	 */
	@Override
	protected IProgress getProgressBar() {
		return null;
	}
}





