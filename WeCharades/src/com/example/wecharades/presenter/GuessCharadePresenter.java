package com.example.wecharades.presenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.io.CopyStreamException;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Environment;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.wecharades.R;
import com.example.wecharades.model.Game;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.GuessCharadeActivity;
import com.example.wecharades.views.StartActivity;

public class GuessCharadePresenter extends Presenter {

	private GuessCharadeActivity activity;
	private DownloadVideo download;
	private VideoView videoView;
	private final String SAVE_PATH = Environment.getExternalStorageDirectory().getPath()+"/PresentVideo.mp4";//TODO: Fix ftp storage
	//	private File SAVE_PATHTWO = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
	//	private String SAVE_PATHTHREE = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).toString() + "/PresentVideo.mp4";
	private Turn turn;
	public String currentWord;
	public CountDownTimer timer;

	public static final int NO_DOWNLOAD = 0;
	public static final int DOWNLOAD_FINISHED = 1;
	public int downloadState = NO_DOWNLOAD;

	public GuessCharadePresenter(GuessCharadeActivity activity, Turn turn) {
		super(activity);
		this.turn = turn;
		this.activity = activity;
	}

	public void initialize(VideoView videoView) {
		initializeTimer();
		this.videoView = videoView;
		downloadVideo(activity, videoView);
	}

	public void updateModel(){
		dc.updateTurn(turn);
	}

	/**
	 * Creates a timer to control the gameTime
	 * @param timerView
	 */

	public void initializeTimer (){
		timer = new CountDownTimer(30000, 100) {

			public void onTick(long millisUntilFinished) {
				activity.setTime(String.valueOf(millisUntilFinished / 1000));
				if (millisUntilFinished>10000){
					activity.setTime(String.valueOf(millisUntilFinished / 1000));
				}
				else{
					activity.setTime((millisUntilFinished / 1000 + "." + (millisUntilFinished%1000)/100));
				}	 
			}

			public void onFinish() {
				activity.gameState = GuessCharadeActivity.GAME_FINISHED;
				videoView.stopPlayback();
				turn.setRecPlayerScore(0);
				turn.setAnsPlayerScore(0);
				turn.setState(Turn.FINISH);
				updateModel();
				videoView.stopPlayback();
				activity.showNegativeDialog("Game over", "The right word is " + currentWord.toLowerCase(), "OK");
				Intent intent = new Intent(activity, StartActivity.class);/*TODO:GameDashboard.class*/
				intent.putExtra("Game", getGame());
				activity.startActivity(intent);
				activity.finish();
			}
		};
	}
	
	 /**
	  * Stops the timer
	  */
	 public void stopTimer(){
		 timer.cancel();
	 }
	 
	/**
	 * Call this method to initiate video download from server.
	 * @param context
	 * @param videoView
	 */
	public void downloadVideo(Context context, VideoView videoView){
		this.videoView = videoView;
		download = new DownloadVideo(context, SAVE_PATH);
		download.execute();
	}
	/**
	 * Sets video specifications and initiates the video.
	 */
	public void playVideo() {
		try {
			videoView.setOnPreparedListener(new OnPreparedListener() {

				@Override
				public void onPrepared(MediaPlayer mp) {
					mp.setLooping(true);          
				}
			});
			videoView.setVideoPath(SAVE_PATH);
			videoView.start();
		} catch (Exception e) {
			Log.e("Video", "error: " + e.getMessage(), e);
		}
	}
	/**
	 * Adds a random number of random letters to a String object.
	 * @param turn
	 * @return the shuffled string
	 */
	private String shuffleWord(){
		currentWord = turn.getWord(); //TODO: Replace
		String alphabet = "abcdefghijklmnopqrstuvwxyzåäö";
		alphabet = shuffle(alphabet);
		alphabet = alphabet.substring(alphabet.length() - randomNumber(7,4));
		String guessWord = currentWord + alphabet;    
		guessWord = shuffle(guessWord);
		return guessWord;
	}
	/**
	 * Shuffles a String
	 * @param input
	 * @return The shuffled string
	 */
	private String shuffle(String input){
		List<Character> characters = new ArrayList<Character>();
		for(char c:input.toCharArray()){
			characters.add(c);
		}
		StringBuilder output = new StringBuilder(input.length());
		while(characters.size()!=0){
			int randPicker = (int)(Math.random()*characters.size());
			output.append(characters.remove(randPicker));
		}
		return output.toString();
	}
	/**
	 * Randoms a number between two limits.
	 * @param high Upper limit.
	 * @param low Lower limit.
	 * @return the random number.
	 */
	private int randomNumber(int high, int low){
		Random r = new Random();
		return (r.nextInt(high-low) + low);
	}
	/**
	 * Checks if the users word matches the current word.
	 * @param answerWord
	 * @return True if answerWord matches currentWord.
	 */
	public boolean checkRightWord(String answerWord){
		return answerWord.equalsIgnoreCase(currentWord);
	}

	public Game getGame(){
		return dc.getGame(turn.getGameId());
	}//TODO: Oklar metod?

	/**
	 *
	 * @author Adam
	 *
	 */
	private class DownloadVideo extends AsyncTask<Void, Long, Boolean> {

		private Dialog dialog;
		Context mContext;
		private String SAVE_PATH;

		public DownloadVideo(Context context,String path) {
			mContext=context;
			SAVE_PATH = path;
		}

		@Override
		protected void onPreExecute(){
			downloadState = NO_DOWNLOAD;
			dialog = new Dialog(mContext);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.dialog_progress);
			dialog.setCanceledOnTouchOutside(false);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

			TextView title = (TextView) dialog.findViewById(R.id.progressTitle);
			title.setText("Downloading charade");

			TextView text = (TextView) dialog.findViewById(R.id.progressText);
			text.setText("Please wait");

			Button button = (Button) dialog.findViewById(R.id.ok);
			button.setText("Cancel");

			button.setOnClickListener(new OnClickListener() {          

				@Override
				public void onClick(View v) {
					dialog.dismiss();
					activity.finish();

					final Dialog mDialog = new Dialog(activity);
					mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					mDialog.setContentView(R.layout.dialog_negative_two);
					mDialog.setCanceledOnTouchOutside(false);
					mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));               

					TextView title = (TextView) dialog.findViewById(R.id.negativeTitle);
					title.setText("Downloading charade");

					TextView text = (TextView) dialog.findViewById(R.id.negativeText);
					text.setText("Download cancelled");

					Button button1 = (Button) dialog.findViewById(R.id.dismiss);
					button1.setText("Download later");

					Button button2 = (Button) dialog.findViewById(R.id.back);
					button2.setText("Download now");

					button1.setOnClickListener(new OnClickListener() {          

						@Override
						public void onClick(View v) {
							mDialog.dismiss();
							activity.finish();
						}
					});

					button2.setOnClickListener(new OnClickListener() {          

						@Override
						public void onClick(View v) {
							mDialog.dismiss();
							new DownloadVideo(mContext,SAVE_PATH).execute();
						}
					});
					mDialog.show();
				}
			});
			dialog.show();
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			boolean result = false;
			FTPClient con = null;
			try{
				con = new FTPClient();
				con.connect("ftp.mklcompetencia.se", 21);
				if (con.login("mklcompetencia.se", "ypkq4w")){
					con.enterLocalPassiveMode(); // important!
					System.out.println(turn.getVideoLink());
					con.setFileType(FTP.BINARY_FILE_TYPE);
					OutputStream out = new FileOutputStream(new File(SAVE_PATH));
					result = con.retrieveFile(turn.getVideoLink(), out);
					out.close();
					if (result) {
						Log.v("download result", "succeeded");
					}                                              
					con.logout();
					con.disconnect();
				}
			}
			catch (SocketException e){
				Log.v("download result Socket", e.getMessage());
				cancel(true);
			}
			catch (UnknownHostException e){
				Log.v("download result Unknown", e.getMessage());
				cancel(true);
			}
			catch (FTPConnectionClosedException e){
				Log.v("download result FTP CONNECTIONCLOSED", e.getMessage());
				cancel(true);
			}
			catch (CopyStreamException e){
				Log.v("download result COPYSTREAM", e.getMessage());
				cancel(true);
			}
			catch (IOException e){
				Log.v("download result IOE", e.getMessage());
				cancel(true);
			}
			catch (Exception e){
				Log.v("download result just exception","failed " + e.getMessage());
				cancel(true);
			}
			return null;  
		}


		@Override
		protected void onPostExecute(Boolean result){
			if(dialog.isShowing()){
				dialog.dismiss();
				activity.showToast("Download success!");
				activity.setPossibleLetters(shuffleWord().toUpperCase());
				downloadState = DOWNLOAD_FINISHED;
				timer.start();
				playVideo();
			}
		}

		@Override
		protected void onCancelled(Boolean result){
			if(dialog.isShowing()){
				dialog.dismiss();

				final Dialog dialog = new Dialog(activity);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.dialog_negative_two);
				dialog.setCanceledOnTouchOutside(false);
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));               

				TextView title = (TextView) dialog.findViewById(R.id.negativeTitle);
				title.setText("Downloading charade");

				TextView text = (TextView) dialog.findViewById(R.id.negativeText);
				text.setText("Download failed, try again!");

				Button button1 = (Button) dialog.findViewById(R.id.dismiss);
				button1.setText("Retry later");

				Button button2 = (Button) dialog.findViewById(R.id.back);
				button2.setText("Retry now");

				button1.setOnClickListener(new OnClickListener() {          

					@Override
					public void onClick(View v) {
						dialog.dismiss();
						activity.finish();
					}
				});

				button2.setOnClickListener(new OnClickListener() {          

					@Override
					public void onClick(View v) {
						dialog.dismiss();
						new DownloadVideo(mContext,SAVE_PATH).execute();
					}
				});

				dialog.show();
			}
		}
	}

	public void showNegativeDialog(String negativeTitle, String negativeText, String buttonText1, String buttonText2) {
		final Dialog dialog = new Dialog(activity);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_negative_two);
		dialog.setCanceledOnTouchOutside(false);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));               

		TextView title = (TextView) dialog.findViewById(R.id.negativeTitle);
		title.setText(negativeTitle);

		TextView text = (TextView) dialog.findViewById(R.id.negativeText);
		text.setText(negativeText);

		Button button1 = (Button) dialog.findViewById(R.id.dismiss);
		button1.setText(buttonText1);

		Button button2 = (Button) dialog.findViewById(R.id.back);
		button2.setText(buttonText2);

		button1.setOnClickListener(new OnClickListener() {          

			@Override
			public void onClick(View v) {
				dialog.dismiss();
				turn.setRecPlayerScore(2);//TODO: what score should rec player get if answerplayer exits?
				turn.setAnsPlayerScore(0);//TODO: 0 score if exits this turn.
				turn.setState(Turn.FINISH);
				updateModel();
				Intent intent = new Intent(activity, StartActivity.class);/*TODO:GameDashboard.class*/
				intent.putExtra("Game", getGame());
				activity.startActivity(intent);
				activity.finish();
			}
		});

		button2.setOnClickListener(new OnClickListener() {          

			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		dialog.show();

	}

	public void evaluateGuess(String answerWord) {
		if(checkRightWord(answerWord)){
			videoView.stopPlayback();
			stopTimer();
			activity.gameState = 0;

			//Update relevant information
			turn.setRecPlayerScore(3);
			turn.setAnsPlayerScore(5);
			turn.setState(Turn.FINISH);
			updateModel();

			final Dialog dialog = new Dialog(activity);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.dialog_positive);
			dialog.setCanceledOnTouchOutside(false);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));        

			TextView title = (TextView) dialog.findViewById(R.id.positiveTitle);
			title.setText("Charade");

			TextView text = (TextView) dialog.findViewById(R.id.positiveText);
			text.setText("You guessed right");

			Button button = (Button) dialog.findViewById(R.id.dismiss);
			button.setText("Continue");

			button.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					dialog.dismiss();
					Intent intent = new Intent(activity, GameDashboardActivity.class);
					intent.putExtra("Game", getGame());
					activity.startActivity(intent);
					activity.finish();
				}
			});
			dialog.show();
		}
		else{	
			activity.showNegativeDialog("Charade", "You guesssed wrong, hurry up!", "Retry");
		}    

	}
}
