package com.example.wecharades.presenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.io.CopyStreamException;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.wecharades.R;
import com.example.wecharades.model.Database;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.CaptureVideoActivity;
import com.example.wecharades.views.StartActivity;
import com.example.wecharades.views.VideoUploadActivity;
import com.parse.ParseException;
import com.parse.ParsePush;

/**
 * Presenter-class intended to manage video uploading and provide information to
 * VideoUploadAcitity
 * @author weCharade
 */
public class VideoUploadPresenter extends Presenter {

	private VideoUploadActivity activity;
	private UploadVideo upload;
	private Turn turn;
	private String serverPath;

	/**
	 * Create instance of VideoUploadPresenter
	 * @param activity
	 */
	public VideoUploadPresenter(VideoUploadActivity activity) {
		super(activity);
		this.activity = activity;
		
		//Needs a reference to the current Turn-object in order to update its information
		this.turn = (Turn) activity.getIntent().getSerializableExtra(Database.TURN);
	}

	/**
	 * Starts the VideoUpload
	 * @param context
	 * @param path
	 */
	public void uploadVideo(Context context, String path) {
		setServerStorageLocation();
		
		//Initiate the uploading
		upload = new UploadVideo(context, path);
		upload.execute();
	}

	/**
	 * Initiate and start showing the video.
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
		Intent intent = new Intent(activity.getApplicationContext(), CaptureVideoActivity.class);
		intent.putExtra(Database.TURN, turn);
		activity.startActivity(intent);
		activity.finish();	
	}
	
	/**
	 * Update the model with new information stored in turn
	 */
	private void updateModel(){
		dc.updateGame(turn);
	}
	
	/**
	 * Send a notification to opponent
	 */
	private void pushNotficationtoOtherPlayer(){
		ParsePush push = new ParsePush();
		
		//Set the channel to the current game and send message to opponent
		push.setChannel(dc.getGame(turn.getGameId()).getOpponent(dc.getCurrentPlayer()).getName());
		push.setMessage("Your turn against: " + turn.getRecPlayer().getName());
		try {
			push.send();
		} catch (ParseException e) {
			//Failure to send results in that the push notification will be sent in a background thread
			push.sendInBackground();
		}
	}
	
	/**
	 * Private inner class managing the uploading process
	 * @author weCharade
	 */
	private class UploadVideo extends AsyncTask<Void, Long, Boolean>{
		
		private Dialog dialog;
		Context mContext;
		private String SAVE_PATH;

		/**
		 * Create an instance of UploadVideo
		 * @param context
		 * @param path
		 */
		public UploadVideo(Context context, String path){
			mContext = context;
			SAVE_PATH = path;
			
			//Create Dialog instance
			dialog = new Dialog(mContext);
		}

		@Override
		protected void onPreExecute(){
			
			//Show progress dialog indicating video is being uploaded

			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setCanceledOnTouchOutside(false);
			dialog.setContentView(R.layout.dialog_progress);
			dialog.setCanceledOnTouchOutside(false);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));               

			TextView progressTitle = (TextView) dialog.findViewById(R.id.progressTitle);
			progressTitle.setText("Uploading");

			TextView progressText = (TextView) dialog.findViewById(R.id.progressText);
			progressText.setText("Please wait");

			dialog.show();
			Button cancelButton = (Button) dialog.findViewById(R.id.ok);
			cancelButton.setOnClickListener(new OnClickListener(){
				
				@Override
				public void onClick(View v) {
					
					//Go to onCancelled-method
					cancel(true);

				}
			});

		}

		@Override
		protected Boolean doInBackground(Void... params) {
			FTPClient ftp = null;

			try{
				//Connect to FTP-server
				ftp = new FTPClient();
				ftp.connect("ftp.mklcompetencia.se", 21);
				
				//Login and create save path
				if (ftp.login("mklcompetencia.se", "ypkq4w")){
					ftp.enterLocalPassiveMode();
					ftp.setFileType(FTP.BINARY_FILE_TYPE);									
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
				cancel(true);
			}
			catch (UnknownHostException e){
				Log.v("download result", e.getMessage());
				cancel(true);
			}
			catch (FTPConnectionClosedException e){
				Log.v("download result", e.getMessage());
				cancel(true);
			}
			catch (CopyStreamException e){
				Log.v("download result", e.getMessage());
				cancel(true);
			}
			catch (IOException e){
				Log.v("download result", e.getMessage());
				cancel(true);
			}
			catch (Exception e){
				Log.v("download result","failed " + e.getMessage());
				cancel(true);
			}
			return null;
		}

		@Override
		protected void onCancelled(Boolean result) {
			//If error occurs; stop showing progress dialog and instead show an error dialog
			if(dialog.isShowing()){
				dialog.dismiss();
				activity.showNegativeDialog("Error", "Upload failed", "Try again");
			}
		}

		@Override
		protected void onPostExecute(Boolean result){
			//Uploaded was successful and user is directed to StartActivity
			if(dialog.isShowing()){
				dialog.dismiss();

				if(turn.getRecPlayer().equals(dc.getCurrentPlayer())){
					//Path to video on stored on server is connected to the turn
					turn.setVideoLink(serverPath);
					//State is set to VIDEO, which indicates that video has been uploaded
					turn.setState(Turn.VIDEO);
					updateModel();
					//Send notification to opponent
					pushNotficationtoOtherPlayer();
				}
				goToStartActivity();
			}
		}
	}
}
