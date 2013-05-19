package com.example.wecharades.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.wecharades.model.Game;
/**
 * TODO: F� en instans av Game n�r denna �r klass �r klaar.
 */
public class UploadVideo extends AsyncTask<Void, Long, Boolean>{

	private final String TAG = "UploadVideo";

	private ProgressDialog mDialog;
	Context mContext;
	private String SAVE_PATH;
	private String fileName;
	//private Game currentGame;
	private String GAME_DIR;

	public UploadVideo(Context context, String path, String fileName){
		mContext = context;
		SAVE_PATH = path;
		this.fileName = fileName;
		mDialog = new ProgressDialog(mContext);
		//currentGame = game;
	}
	@Override
	protected void onPreExecute(){
		mDialog.setTitle("Uploading Charade");
		mDialog.setMessage("Please Wait");
		mDialog.show();
	}

	@Override
	protected Boolean doInBackground(Void... params) {
			FTPClient ftp = null;

			try{
				ftp = new FTPClient();
				ftp.connect("ftp.mklcompetencia.se", 21);

				if (ftp.login("mklcompetencia.se", "ypkq4w")){
					ftp.enterLocalPassiveMode(); // important!
					ftp.setFileType(FTP.BINARY_FILE_TYPE);
					FileInputStream in = new FileInputStream(new File(SAVE_PATH));
					boolean result = ftp.storeFile("/APP/" + "PresentVideo.mp4", in);					
					in.close();
					if (result) 
						Log.v("upload result", "succeeded");
					ftp.logout();
					ftp.disconnect();
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
		return null;
	}

	@Override
	protected void onPostExecute(Boolean result){
		if(mDialog.isShowing()){
			mDialog.dismiss();
		}
	}
	

}


