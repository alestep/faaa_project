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
//		if(isNetworkConnected()) { //TODO KOlla lite på detta sen
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
		Intent intent = new Intent(activity.getApplicationContext(), CaptureVideoActivity.class);
		intent.putExtra(Database.TURN, turn);
		activity.startActivity(intent);
		activity.finish();	
	}
	private void updateModel(){
		dc.updateGame(turn);
	}
	private void pushNotficationtoOtherPlayer(){
		ParsePush push = new ParsePush();
		Log.d("",dc.getGame(turn.getGameId()).getOpponent(dc.getCurrentPlayer()).getName());
		push.setChannel(dc.getGame(turn.getGameId()).getOpponent(dc.getCurrentPlayer()).getName());
		push.setMessage("Your turn against: " + turn.getRecPlayer().getName());
		try {
			push.send();
		} catch (ParseException e) {
			push.sendInBackground();
		}
	}

	private class UploadVideo extends AsyncTask<Void, Long, Boolean>{

		private Dialog dialog;
		Context mContext;
		private String SAVE_PATH;

		public UploadVideo(Context context, String path){
			mContext = context;
			SAVE_PATH = path;
			dialog = new Dialog(mContext);
		}

		@Override
		protected void onPreExecute(){
			
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
					cancel(true);
					
				}
				
			});
			

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
			if(dialog.isShowing()){
				dialog.dismiss();
				activity.showNegativeDialog("Error", "Upload failed", "Try again");
			}
		}

		@Override
		protected void onPostExecute(Boolean result){
			if(dialog.isShowing()){
				dialog.dismiss();
				turn.setVideoLink(serverPath);
				turn.setState(Turn.VIDEO);
				updateModel();
				pushNotficationtoOtherPlayer();
				goToStartActivity();
			}
		}
	}
}
