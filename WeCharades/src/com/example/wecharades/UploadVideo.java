package com.example.wecharades;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.TokenPair;
import com.dropbox.client2.session.Session.AccessType;

public class UploadVideo extends Activity implements OnClickListener {
   
	
	/** Dropbox Key and AccessType Information*/
	final static private String APP_KEY = "qaf79ngsv26o0dd";
	final static private String APP_SECRET = "4dz3ga69350v2ul";
	final static private AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
	final static private String ACCOUNT_PREFS_NAME = "prefs";
	final static private String ACCESS_KEY_NAME = "ACCESS_KEY";
	final static private String ACCESS_SECRET_NAME = "ACCESS_SECRET";
	/**--------------------------------------------------------------*/
	private DropboxAPI<AndroidAuthSession> mDBApi;
	private static final String TAG = "UploadVideo";
	private final String GAME_DIR = "/GAMES/GAME_BETWEEN_USER_A_USER_B/"; // THIS IS WHERE A UNIQUE FOLDERNAME MUST EXIST FOR EACH GAME.
	private Button linkButton;
	private Button uploadButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload);
		linkButton = (Button) findViewById(R.id.linkButton);
		linkButton.setOnClickListener(this);
		uploadButton = (Button) findViewById(R.id.uploadButton);
		uploadButton.setOnClickListener(this);
		
		AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
		AndroidAuthSession session = new AndroidAuthSession(appKeys, ACCESS_TYPE);
		mDBApi = new DropboxAPI<AndroidAuthSession>(session);
	}
	public void onClick(View v) {
		if(v.getId()==R.id.uploadButton){
			Log.d(TAG,"uploadbutton tryckt");
			uploadFile();
			Log.d(TAG, "If no exception, file should be uploaded");
		}
		if(v.getId()==R.id.linkButton){
			connectToDropbox();
			Log.d(TAG,"CONNECTING TO DROPBOX");
		}

	}
	private void connectToDropbox(){
		mDBApi.getSession().startAuthentication(UploadVideo.this);
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
                Log.i(TAG, "Error authenticating", e);
            }
        }
    }
	private void uploadFile(){
		Thread thread = new Thread(new Runnable(){
		    @Override
		    public void run() {
		        try {
		        	FileInputStream inputStream = null;
		    		try {
		    			File file = new File(ShowVideo.path);
		    			inputStream = new FileInputStream(file);
		    			Entry newEntry = mDBApi.putFile(GAME_DIR + ShowVideo.fileName, inputStream, file.length(), null, null);
		    		} catch (Exception e) {
		    			System.out.println("Something went wrong: " + e);
		    		} finally {
		    			if (inputStream != null) {
		    				try {
		    					inputStream.close();
		    				} 
		    				catch (IOException e) {
		    					Log.d(TAG, "IOException" + e.getMessage());
		    				}
		    			}
		    		}
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		});

		thread.start(); 
		
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
