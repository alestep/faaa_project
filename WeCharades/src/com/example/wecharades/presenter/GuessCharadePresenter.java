package com.example.wecharades.presenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class GuessCharadePresenter extends Presenter {

	private Activity activity;
	private DownloadVideo download;
	private VideoView videoView;
	private final String SAVE_PATH = Environment.getExternalStorageDirectory().getPath()+"/PresentVideo.mp4";
	
	public GuessCharadePresenter(Activity activity) {
		super(activity);
		this.activity = activity;
	}
	public void downloadVideo(Context context, VideoView videoView){
		this.videoView = videoView;
		download = new DownloadVideo(context, SAVE_PATH);
		download.execute();
	}
	private void playVideo() {
		try {
			videoView.setVideoURI(Uri.parse(SAVE_PATH));
			videoView.setMediaController(new MediaController(activity));
			videoView.start();
		} catch (Exception e) {
			Log.e("TAG", "error: " + e.getMessage(), e);
		}
	}
	
	private class DownloadVideo extends AsyncTask<Void, Long, Boolean> {

		private String TAG = "DownloadVideo";
		private ProgressDialog mDialog;
		Context mContext;
		private String SAVE_PATH;

		public DownloadVideo(Context context,String path) {
			mContext=context;
			SAVE_PATH = path;
			mDialog = new ProgressDialog(mContext);
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
				mDialog.setMessage("Download Successed!");
				mDialog.dismiss();
				playVideo();
			}
		}
	}

}
