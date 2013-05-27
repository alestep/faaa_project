package com.example.wecharades.views;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wecharades.model.Database;
import com.example.wecharades.model.Turn;
/**
 * 
 * @author Adam Lewestam
 *Fix isIntentAvailable Method
 */
public class CaptureVideoActivity extends Activity {

	final static int REQUEST_VIDEO_CAPTURED = 1;
	public static Uri uriVideo = null;
	private Intent intentCamera;
	private Turn turn;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.turn = (Turn) getIntent().getSerializableExtra(Database.TURN);
		dispatchTakeVideoIntent();
	}
	private void dispatchTakeVideoIntent(){
			intentCamera = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
			intentCamera.putExtra(android.provider.MediaStore.EXTRA_DURATION_LIMIT, 8);
			intentCamera.putExtra(android.provider.MediaStore.EXTRA_VIDEO_QUALITY, 1);
			//intentCamera.putExtra(android.provider.MediaStore.EXTRA_SIZE_LIMIT, 10);
			startActivityForResult(intentCamera, REQUEST_VIDEO_CAPTURED);	
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == RESULT_OK){
			if(requestCode == REQUEST_VIDEO_CAPTURED){
				uriVideo = data.getData();
				Intent intentShowVideo = new Intent(CaptureVideoActivity.this, VideoUploadActivity.class);
				intentShowVideo.putExtra(Database.TURN, turn);
				startActivity(intentShowVideo);
				finishActivity(REQUEST_VIDEO_CAPTURED);
				finish();
			}
		}
		else if(resultCode == RESULT_CANCELED){
			uriVideo = null;
			Toast.makeText(CaptureVideoActivity.this,"Canceled!",Toast.LENGTH_LONG).show();
			finish();
		}
	}

	public static boolean isIntentAvailable(Context context, String action) {
		final PackageManager packageManager = context.getPackageManager();
		final Intent intent = new Intent(action);
		List<ResolveInfo> list =
				packageManager.queryIntentActivities(intent,
						PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
	}
}

