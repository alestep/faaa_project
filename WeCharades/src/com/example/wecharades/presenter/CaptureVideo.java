package com.example.wecharades.presenter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wecharades.R;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.VideoUploadActivity;
/**
 * 
 * @author Adam Lewestam
 *Fix isIntentAvailable Method
 */
public class CaptureVideo extends Activity {

	final static int REQUEST_VIDEO_CAPTURED = 1;
	public static Uri uriVideo = null;
	private Intent intentCamera;
	private Turn turn;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//TODO Can we do like this?
		this.turn = (Turn) getIntent().getSerializableExtra("Turn");
		dispatchTakeVideoIntent();
	}
	private void dispatchTakeVideoIntent(){
		intentCamera = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
		intentCamera.putExtra("android.intent.extra.durationLimit", 8);
		intentCamera.putExtra("android.intent.extra.videoQuality", 1);
		startActivityForResult(intentCamera, REQUEST_VIDEO_CAPTURED);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == RESULT_OK){
			if(requestCode == REQUEST_VIDEO_CAPTURED){
				uriVideo = data.getData();
				//Toast.makeText(CaptureVideo.this,uriVideo.getPath(),Toast.LENGTH_LONG).show();
				//finishActivity(REQUEST_VIDEO_CAPTURED);
				Intent intentShowVideo = new Intent(CaptureVideo.this, VideoUploadActivity.class);
				intentShowVideo.putExtra("Turn", turn);
				startActivity(intentShowVideo);
			}
		}
		else if(resultCode == RESULT_CANCELED){
			uriVideo = null;
			Toast.makeText(CaptureVideo.this,"Cancelled!",Toast.LENGTH_LONG).show();
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

