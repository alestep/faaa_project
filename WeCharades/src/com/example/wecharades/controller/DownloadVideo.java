package com.example.wecharades.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.VideoView;

public class DownloadVideo extends AsyncTask<Void, Long, Boolean> {

	private String TAG = "DownloadVideo";
	
	private ProgressDialog mDialog;
	Context mContext;
	private String SAVE_PATH;
	private VideoView ww;

	public DownloadVideo(Context context,String path, VideoView ww) {
		mContext=context;
		SAVE_PATH = path;
		mDialog = new ProgressDialog(mContext);
		this.ww = ww;

	}
	
	@Override
	protected void onPreExecute(){
		mDialog.setTitle("Downloading Charade");
		mDialog.setMessage("Please Wait");
		mDialog.show();
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		FTPClient con = null;

		try{
			con = new FTPClient();
			con.connect("ftp.mklcompetencia.se", 21);

			if (con.login("mklcompetencia.se", "ypkq4w")){
				con.enterLocalPassiveMode(); // important!
				con.setFileType(FTP.BINARY_FILE_TYPE);
				OutputStream out = new FileOutputStream(new File(SAVE_PATH));
				boolean result = con.retrieveFile("/APP/PresentVideo.mp4", out);
				out.close();
				if (result) 
					Log.v("download result", "succeeded");
				con.logout();
				con.disconnect();
			}
		}
		catch (Exception e){
			Log.v("download result","failed");
			e.printStackTrace();
		}
		return null;	
	}
	
	@Override
	protected void onPostExecute(Boolean result){
		if(mDialog.isShowing()){
			mDialog.dismiss();
			playVideo();
		}
	}
	private void playVideo() {
		try {
			ww.setVideoURI(Uri.parse(SAVE_PATH));
			//videoView.setMediaController(new MediaController(this));
			ww.start();
		} catch (Exception e) {
			Log.e(TAG, "error: " + e.getMessage(), e);
		}
	}
}
