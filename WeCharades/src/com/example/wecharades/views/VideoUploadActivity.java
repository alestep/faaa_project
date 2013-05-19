package com.example.wecharades.views;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;
import com.example.wecharades.R;
import com.example.wecharades.presenter.CaptureVideo;
import com.example.wecharades.presenter.VideoUploadPresenter;


/**
 * @author Adam
 * TODO: Fix the  design in the xml file showvideo.xml.
 */

public class VideoUploadActivity extends Activity{
	protected static final String TAG = "";
	public static String path = "";
	public static String fileName;
	private VideoView videoView;
	private VideoUploadPresenter presenter;

	// TODO: onStart();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Forces landscape orientation which is what the camera uses.
		setContentView(R.layout.showvideo);
		presenter = new VideoUploadPresenter(this);
		videoView = (VideoView) findViewById(R.id.satisfiedVideoView);
		path = getPathFromURI(CaptureVideo.uriVideo);
		presenter.playVideo(videoView);
	}

	/**
	 * handles the yes button
	 * @param view
	 */
	public void onClickYes(View view) {
		presenter.uploadVideo(VideoUploadActivity.this, path);
	}

	/**
	 * Handles the no button
	 * @param w
	 */
	public void onClickNo(View view) {
		presenter.reRecord(path);
	}
	
	
	//TODO: fix a new method that's not using managedQuery(); @adam
	public String getPathFromURI(Uri contentUri) {
		String[] proj = { MediaStore.Images.Media.DATA };
		Cursor cursor = managedQuery(contentUri, proj, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}
}





