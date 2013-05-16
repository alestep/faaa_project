package com.example.wecharades.views;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.widget.Toast;
import android.widget.VideoView;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.TokenPair;
import com.example.wecharades.R;
import com.example.wecharades.UploadFile;



public class ShowVideo extends Activity{
	/** Dropbox Key and AccessType Information*/
	final static private String APP_KEY = "qaf79ngsv26o0dd";
	final static private String APP_SECRET = "4dz3ga69350v2ul";
	final static private AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
	final static private String ACCOUNT_PREFS_NAME = "prefs";
	final static private String ACCESS_KEY_NAME = "ACCESS_KEY";
	final static private String ACCESS_SECRET_NAME = "ACCESS_SECRET";
	/**--------------------------------------------------------------*/
	private DropboxAPI<AndroidAuthSession> mDBApi;

	UploadFile upload;
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
		Button dbButton = (Button) findViewById(R.id.dropboxButton);
		dbButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
			if(v.getId() == R.id.dropboxButton)
				mDBApi.getSession().startAuthentication(ShowVideo.this);
			}
		});
		
		yesButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(v.getId() == R.id.yesButton){
				UploadFile upload = new UploadFile(ShowVideo.this,mDBApi,path);
				upload.execute();
				}
			}
		});
		/*noButton.setOnClickListener(new OnClickListener() {
			public void onClick(View w) {
						File file = new File(path);
						boolean deleted = false;
						deleted = file.delete();
						Log.d("TAG", Boolean.toString(deleted));
						Intent intent = new Intent(ShowVideo.this, CaptureVideo.class);
						startActivity(intent);

			}
		});*/

		ww = (VideoView) findViewById(R.id.satisfiedVideoView);
		path = getRealPathFromURI(CaptureVideo.uriVideo);
		fileName = getFileNameFromUrl(path);

		AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
		AndroidAuthSession session = new AndroidAuthSession(appKeys, ACCESS_TYPE);
		mDBApi = new DropboxAPI<AndroidAuthSession>(session);
	}
	public void onTaskCompleted (){
		Log.d("TAG", "DIN MAMMA");
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

	public String getRealPathFromURI(Uri contentUri) {
		String[] proj = { MediaStore.Images.Media.DATA };
		Cursor cursor = managedQuery(contentUri, proj, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}

	/**DROPBOX-METHOD------------------------------------------*/
	@Override
	protected void onResume() {
		super.onResume();
		AndroidAuthSession session = mDBApi.getSession();

		// The next part must be inserted in the onResume() method of the
		// activity from which session.startAuthentication() was called, so
		// that Dropbox authentication completes properly.
		if (session.authenticationSuccessful()) {
			try {
				// Mandatory call to complete the auth
				session.finishAuthentication();

				// Store it locally in our app for later use
				TokenPair tokens = session.getAccessTokenPair();
				storeKeys(tokens.key, tokens.secret);
				//setLoggedIn(true);
			} catch (IllegalStateException e) {
				showToast("Couldn't authenticate with Dropbox:" + e.getLocalizedMessage());
				Log.i("TAG", "Error authenticating", e);
			}
		}
	}
	/**
	 * Shows keeping the access keys returned from Trusted Authenticator in a local
	 * store, rather than storing user name & password, and re-authenticating each
	 * time (which is not to be done, ever).
	 *
	 * @return Array of [access_key, access_secret], or null if none stored
	 */
	private String[] getKeys() {
		SharedPreferences prefs = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
		String key = prefs.getString(ACCESS_KEY_NAME, null);
		String secret = prefs.getString(ACCESS_SECRET_NAME, null);
		if (key != null && secret != null) {
			String[] ret = new String[2];
			ret[0] = key;
			ret[1] = secret;
			return ret;
		} else {
			return null;
		}
	}

	/**
	 * Shows keeping the access keys returned from Trusted Authenticator in a local
	 * store, rather than storing user name & password, and re-authenticating each
	 * time (which is not to be done, ever).
	 */
	private void storeKeys(String key, String secret) {
		// Save the access key for later
		SharedPreferences prefs = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
		Editor edit = prefs.edit();
		edit.putString(ACCESS_KEY_NAME, key);
		edit.putString(ACCESS_SECRET_NAME, secret);
		edit.commit();
	}

	private void clearKeys() {
		SharedPreferences prefs = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
		Editor edit = prefs.edit();
		edit.clear();
		edit.commit();
	}

	private AndroidAuthSession buildSession() {
		AppKeyPair appKeyPair = new AppKeyPair(APP_KEY, APP_SECRET);
		AndroidAuthSession session;

		String[] stored = getKeys();
		if (stored != null) {
			AccessTokenPair accessToken = new AccessTokenPair(stored[0], stored[1]);
			session = new AndroidAuthSession(appKeyPair, ACCESS_TYPE, accessToken);
		} else {
			session = new AndroidAuthSession(appKeyPair, ACCESS_TYPE);
		}

		return session;
	}
	private void showToast(String msg) {
		Toast error = Toast.makeText(this, msg, Toast.LENGTH_LONG);
		error.show();
	}


}
