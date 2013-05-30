package com.example.wecharades.presenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.io.CopyStreamException;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.wecharades.R;
import com.example.wecharades.model.Turn;
import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.GuessCharadeActivity;
import com.example.wecharades.views.StartActivity;


/**
 * Presenter-class intended to manage the download of video and gathering of information
 * to be able for the view to display the charade recorded by the opponent
 * @author weCharade
 *
 */
@SuppressLint("DefaultLocale")
public class GuessCharadePresenter extends Presenter {

	private GuessCharadeActivity activity;
	private DownloadVideo download;
	private VideoView videoView;

	//Storing path by finding the natural storing position for video files in the phone
	private final String SAVE_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).toString() + "/PresentVideo.mp4";
	private Turn turn;
	private String currentWord;
	private CountDownTimer timer;

	//Constants declared public in order to access them from class GuessCharadeActivity.
	public static final int DOWNLOAD_NOT_FINISHED = 0;
	public static final int DOWNLOAD_FINISHED = 1;
	public int downloadState = DOWNLOAD_NOT_FINISHED;

	/**
	 * Create an instance of GuessCharadePresenter. Important to get reference to the unique turn and store this.
	 * @param activity
	 * @param turn		Needs a reference to a 
	 */
	public GuessCharadePresenter(GuessCharadeActivity activity) {

		super(activity);
		this.activity = activity;
		this.turn = (Turn) this.activity.getIntent().getExtras().getSerializable("Turn");

	}

	/**
	 * Initializes the presenter and starts the download of charade video
	 * @param videoView
	 */
	public void initialize(VideoView videoView) {
		initializeTimer();
		this.videoView = videoView;
		downloadVideo(activity, videoView);
	}

	/**
	 * Creates a timer to control the gameTime
	 * @param timerView
	 */
	public void initializeTimer (){
		timer = new CountDownTimer(30000, 100) {

			@Override
			public void onTick(long millisUntilFinished) {
				
				//Show decimals only the last 10 seconds
				if (millisUntilFinished>10000){
					activity.setTime(String.valueOf(millisUntilFinished / 1000));
				}
				else{
					activity.setTime((millisUntilFinished / 1000 + "." + (millisUntilFinished%1000)/100));
				}

			}
			
			@Override
			public void onFinish() {
				activity.gameState = GuessCharadeActivity.GAME_FINISHED;
				videoView.stopPlayback();
				
				//If timer runs out both players receives a zero score
				turn.setRecPlayerScore(0);
				turn.setAnsPlayerScore(0);
				turn.setState(Turn.FINISH);
				dc.updateGame(turn);
				
				//Go to StartActivity
				Intent intent = new Intent(activity, StartActivity.class);
				intent.putExtra("Game", dc.getGame(turn.getGameId()));
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				activity.startActivity(intent);
				activity.finish();
			}
		};
	}

	/**
	 * Stop the timer
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
	 * Set video specifications and initiates the video.
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
		currentWord = turn.getWord();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		alphabet = shuffle(alphabet);
		
		//Get a random number of letters from the alphabet
		alphabet = alphabet.substring(alphabet.length() - randomNumber(7,4));
		String guessWord = currentWord + alphabet;
		
		//Shuffle alphabet letters and the right word
		guessWord = shuffle(guessWord);
		return guessWord;
	}
	/**
	 * Shuffles a String
	 * @param input The String that will be shuffled
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
	 * Randoms a number between two limits
	 * @param high 	Upper limit.
	 * @param low 	Lower limit.
	 * @return the random number.
	 */
	private int randomNumber(int high, int low){
		
		Random r = new Random();
		return (r.nextInt(high-low) + low);
		
	}
	
	/**
	 * Checks if the user's word guess matches the current word.
	 * @param answerWord
	 * @return True if answerWord matches currentWord
	 */
	public boolean checkRightWord(String answerWord){
		
		return answerWord.equalsIgnoreCase(currentWord);
		
	}

	/**
	 * Inner help-class intended to manage the download of video which is presented
	 * to the player who will try to guess the charade
	 * @author weCharade
	 */
	private class DownloadVideo extends AsyncTask<Void, Long, Boolean> {
		
		private Dialog dialog;
		private Context mContext;
		private String SAVE_PATH;
		
		public DownloadVideo(Context context, String path) {
			
			mContext = context;
			SAVE_PATH = path;
			
		}

		@Override
		protected void onPreExecute(){
			downloadState = DOWNLOAD_NOT_FINISHED;
			
			//Show a progress Dialog which makes it possible to cancel a download
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
					cancel(true);
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
					con.enterLocalPassiveMode();
					con.setFileType(FTP.BINARY_FILE_TYPE);
					File file = new File(SAVE_PATH);
					OutputStream out = new FileOutputStream(file);
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
			
			//Download is finished successfully and the guessing starts
			if(dialog.isShowing()){
				
				dialog.dismiss();
				activity.setPossibleLetters(shuffleWord().toUpperCase());
				downloadState = DOWNLOAD_FINISHED;
				timer.start();
				playVideo();
				
			}
		}

		@Override
		protected void onCancelled(Boolean result){
			
			//Some error occurred while downloading
			if(dialog.isShowing()){
				dialog.dismiss();
				
				//Set new dialog
				final Dialog dialog = new Dialog(activity);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.dialog_negative);
				dialog.setCanceledOnTouchOutside(false);
				dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));               

				TextView title = (TextView) dialog.findViewById(R.id.negativeTitle);
				title.setText("Downloading charade");

				TextView text = (TextView) dialog.findViewById(R.id.negativeText);
				text.setText("Download failed, try again!");

				Button button = (Button) dialog.findViewById(R.id.dismiss);
				button.setText("Retry later");

				button.setOnClickListener(new OnClickListener() {          

					@Override
					public void onClick(View v) {
						dialog.dismiss();
						if(!dialog.isShowing())
							activity.finish();
					}
				});
			}
			else {
				activity.finish();
			}

		}
	}

	/**
	 * Show a Dialog when user tries to exit while guessing and timer is on. 
	 * @param negativeTitle	Title of message
	 * @param negativeText	Message text
	 * @param buttonText1	Text on first button
	 * @param buttonText2	Text on second button
	 */
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
				stopTimer();

				//Player who records receives 2 points and player who exits receives 0 points
				turn.setRecPlayerScore(2);
				turn.setAnsPlayerScore(0);
				turn.setState(Turn.FINISH);
				dc.updateGame(turn);
				
				//Go back to StartActivity
				Intent intent = new Intent(activity, StartActivity.class);
				intent.putExtra("Game", dc.getGame(turn.getGameId()));
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				activity.startActivity(intent);
				activity.finish();
			}
		});

		button2.setOnClickListener(new OnClickListener() {          

			@Override
			public void onClick(View v) {
				
				//Continue guessing
				dialog.dismiss();
			}
		});

		dialog.show();

	}

	public void evaluateGuess(String answerWord) {
		if(checkRightWord(answerWord)){
			videoView.stopPlayback();
			stopTimer();
			activity.gameState = GuessCharadeActivity.GAME_NOT_FINISHED;

			//Update relevant information
			turn.setRecPlayerScore(3);
			turn.setAnsPlayerScore(5);
			turn.setState(Turn.FINISH);
			dc.updateGame(turn);

			//Create dialog
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
					stopTimer();
					Intent intent = new Intent(activity, GameDashboardActivity.class);
					intent.putExtra("Game", dc.getGame(turn.getGameId()));
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					activity.startActivity(intent);
					activity.finish();
				}
			});
			dialog.show();
		}
		else{
			
			//If guessed wrong, go back and continue guessing
			activity.showNegativeDialog("Charade", "You guesssed wrong, hurry up!", "Retry");
		}    

	}
}

