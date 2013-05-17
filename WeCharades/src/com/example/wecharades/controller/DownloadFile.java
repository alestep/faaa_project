package com.example.wecharades.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.VideoView;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxFileInfo;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.ProgressListener;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;

public class DownloadFile extends AsyncTask<Void, Long, Boolean> {

	DropboxAPI<AndroidAuthSession> dDBApi;
	Context dContext;
	private final  ProgressDialog uDialog;
	private long dFileLen;
	private String SAVE_PATH;
	private VideoView mVideoView;

	public DownloadFile(Context context,DropboxAPI<AndroidAuthSession> mDBApi, String path, VideoView videoView) {
		dDBApi=mDBApi;
		dContext=context.getApplicationContext();
		SAVE_PATH = path;
		mVideoView = videoView;

		uDialog = new ProgressDialog(context);
		uDialog.setMax(100);
		uDialog.setMessage("Downloading VideoCharade");
		uDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		uDialog.show();
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		BufferedOutputStream out=null;
		try {
			File file = new File(SAVE_PATH);
			out = new BufferedOutputStream(new FileOutputStream(file));
			DropboxFileInfo file2 = dDBApi.getFile("/GAMES/GAME_BETWEEN_USER_A_USER_B/" + "Presentvideo.mp4", null,out, new ProgressListener() {
				
				@Override
				public long progressInterval() {
					// Update the progress bar every half-second
					return 500;
				}
				@Override
				public void onProgress(long bytes, long total) {
					dFileLen = total;
					publishProgress(bytes);
				}
			});
		} catch (DropboxException e) {
			Log.e("DbExampleLog", "Something went wrong while downloading.");
		} catch (FileNotFoundException e) {
			Log.e("DbExampleLog", "File not found.");
		} catch (IOException e) {
			Log.e("DbExampleLog", "Another Exception:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {}
			}
		}
		return null;
	}
	@Override
	protected void onProgressUpdate(Long... progress) {
		int percent = (int)(100.0*(double)progress[0]/dFileLen + 0.5);
		uDialog.setProgress(percent);
	}
	@Override
	protected void onPostExecute(Boolean result) {
		uDialog.dismiss();
		super.onPostExecute(result);
	}

}
