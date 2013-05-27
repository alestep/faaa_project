package com.example.wecharades.presenter;
/**
 * TODO: CREATE DIRECTORIES AND SHIT ON FTP.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.io.CopyStreamException;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.wecharades.model.Database;
import com.example.wecharades.model.DatabaseException;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.StartActivity;
import com.example.wecharades.views.VideoUploadActivity;
import com.parse.ParsePush;

public class VideoUploadPresenter extends Presenter {

	private VideoUploadActivity activity;
	private UploadVideo upload;
	private Turn turn;
	private String serverPath;

	public VideoUploadPresenter(VideoUploadActivity activity) {
		super(activity);
		this.activity = activity;
		this.turn = (Turn) activity.getIntent().getSerializableExtra(Database.TURN);
	}

	/**
	 * Starts the VideoUpload
	 * @param context
	 * @param path
	 */
	public void uploadVideo(Context context, String path) {
//		final Context c = context;
//		final String p = path;
		setServerStorageLocation();
		upload = new UploadVideo(context, path);
		upload.execute();
		//Check if the user has internet connection
//		if(isNetworkConnected()) {
//			setServerStorageLocation();
//			upload = new UploadVideo(context, path);
//			upload.execute();
//		} else {
//			AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//			builder.setTitle("Error!")
//			.setMessage("You've got no internet connection!")
//			.setCancelable(false)
//			.setPositiveButton("Try again!", new DialogInterface.OnClickListener() {
//				public void onClick(DialogInterface dialog, int id) {
//					//Try again...
//					uploadVideo(c,p);
//				}
//			})
//			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//				public void onClick(DialogInterface dialog, int id) {
//					//Go to homecreen
//					Intent intent = new Intent(activity.getApplicationContext(), StartActivity.class);
//					activity.startActivity(intent);
//					activity.finish();	
//					dialog.cancel();
//				}
//			});
//			AlertDialog alert = builder.create();
//			alert.show();
//		}
	}

	/**
	 * Initiate and start the video.
	 * @param videoView
	 */
	public void playVideo(VideoView videoView,String path) {		
		try {
			videoView.setOnPreparedListener(new OnPreparedListener() {

				@Override
				public void onPrepared(MediaPlayer mp) {
					mp.setLooping(true);		
				}
			});
			videoView.setVideoPath(path);
			videoView.setMediaController(new MediaController(activity));
			videoView.start();
			videoView.requestFocus();
		} catch (Exception e) {
			Log.e("Video", "error: " + e.getMessage(), e);
		}
	}

	/**
	 * Sets the storage location of the videofile for the FTP-server. 
	 * @return
	 */
	private void setServerStorageLocation() {
		String gameID = turn.getGameId();
		String serverPath = "/APP/GAMES/" + gameID + ".mp4";
		this.serverPath = serverPath;
	}

	/**	
	 * Lets the player to re-record the video and deletes the current file.
	 * @param path
	 */
	public void reRecord(String path) {
		File file = new File(path);
		file.delete();
		Intent intent = new Intent(activity.getApplicationContext(), CaptureVideo.class);
		intent.putExtra(Database.TURN, turn);
		activity.startActivity(intent);
		activity.finish();	
	}
	private void updateModel(){
		try {
			dc.updateTurn(turn);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	private void pushNotficationtoOtherPlayer(){
		ParsePush push = new ParsePush();
		push.setChannel(dc.getGame(turn.getGameId()).getOpponent(dc.getCurrentPlayer()).getName());
		push.setMessage("Your turn against: " + turn.getRecPlayer().getName());
		push.sendInBackground();
	}

	private class UploadVideo extends AsyncTask<Void, Long, Boolean>{

		private ProgressDialog mDialog;
		Context mContext;
		private String SAVE_PATH;

		public UploadVideo(Context context, String path){
			mContext = context;
			SAVE_PATH = path;
			mDialog = new ProgressDialog(mContext);
		}

		@Override
		protected void onPreExecute(){
			mDialog.setTitle("Uploading Charade");
			mDialog.setMessage("Please Wait");
			mDialog.setCancelable(false);
			mDialog.setCanceledOnTouchOutside(false);
			mDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();

				}
			});

			mDialog.show();
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			FTPClient ftp = null;

			try{
				ftp = new FTPClient();
				ftp.connect("ftp.mklcompetencia.se", 21);

				if (ftp.login("mklcompetencia.se", "ypkq4w")){
					ftp.enterLocalPassiveMode();
					ftp.setFileType(FTP.BINARY_FILE_TYPE);					
					//ftpCreateDirectoryTree(ftp, serverPath);				
					FileInputStream in = new FileInputStream(new File(SAVE_PATH));
					boolean result = ftp.storeFile(serverPath, in);					
					in.close();
					if (result) 
						Log.v("upload result", "succeeded");
					ftp.logout();
					ftp.disconnect();
				}
			}
			catch (SocketException e){
				Log.v("download result", e.getMessage());
			}
			catch (UnknownHostException e){
				Log.v("download result", e.getMessage());
			}
			catch (FTPConnectionClosedException e){
				Log.v("download result", e.getMessage());
			}
			catch (CopyStreamException e){
				Log.v("download result", e.getMessage());
			}
			catch (IOException e){
				Log.v("download result", e.getMessage());
			}
			catch (Exception e){
				Log.v("download result","failed " + e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPostExecute(Boolean result){
			if(mDialog.isShowing()){
				mDialog.dismiss();
				turn.setVideoLink(serverPath);
				turn.setState(Turn.VIDEO);
				updateModel();
				pushNotficationtoOtherPlayer();
				//Send to startscreen on success
				Intent intent = new Intent(activity.getApplicationContext(), StartActivity.class);
				activity.startActivity(intent);
				activity.finish();
			}
		}
	}
}
