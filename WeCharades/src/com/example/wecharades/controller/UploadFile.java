package com.example.wecharades.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.DropboxAPI.UploadRequest;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.example.wecharades.views.ShowVideo;

public class UploadFile extends AsyncTask<Void, Long, Boolean> {

	DropboxAPI<AndroidAuthSession> dDBApi;
	Context dContext;
	//protected final  ProgressDialog uDialog;
	private long dFileLen;
	private String SAVE_PATH;
	private String mErrorMsg;
	private UploadRequest mRequest;
	private ProgressDialog mDialog;

	public UploadFile(Context context,DropboxAPI<AndroidAuthSession> mDBApi, String path) {
		dContext=context.getApplicationContext();
		dDBApi=mDBApi;
		SAVE_PATH = path;
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		FileInputStream inputStream = null;
		try {
			File file = new File(ShowVideo.path);
			inputStream = new FileInputStream(file);
			Entry newEntry = dDBApi.putFileOverwrite("/GAMES/GAME_BETWEEN_USER_A_USER_B/" + "PresentVideo.mp4", inputStream, file.length(), null);
		} 

		catch (DropboxException e) {
			Log.e("DbExampleLog", "Something went wrong while downloading.");
		} catch (FileNotFoundException e) {
			Log.e("DbExampleLog", "File not found.");
		} catch (IOException e) {
			Log.e("DbExampleLog", "Another Exception:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Log.e("DbExampleLog", "Another Exception:" + e.getMessage());
			e.printStackTrace();
		} 
		finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} 
				catch (IOException e) {

				}
			}
		}
		return null;
	}
}


