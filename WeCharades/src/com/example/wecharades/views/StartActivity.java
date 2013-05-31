package com.example.wecharades.views;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.wecharades.R;
import com.example.wecharades.model.Game;
import com.example.wecharades.presenter.SeparatedListAdapter;
import com.example.wecharades.presenter.StartPresenter;


/**
 * View which displays the start or home screen of the game. The screen gives access to almost all screens
 * and is the first screen a user comes to when entering the game (if already logged in)
 * @author weCharade
 *
 */
public class StartActivity extends GenericActivity {

	private StartPresenter presenter;
	private ListView gameListView;
	private ImageButton invitations;
	private RefreshProgressBar refresh;
	private Button account;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new StartPresenter(this));

		//Set the title bar
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.start_screen);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_start);

		// Get references to instances
		presenter = (StartPresenter) super.getPresenter();
		gameListView = (ListView) findViewById(R.id.gameList);
		invitations = (ImageButton) findViewById(R.id.invitations);
		account = (Button) findViewById(R.id.account);

		//This class uses a RefreshProgressBar to visualize that data is fetched in the background
		refresh = new RefreshProgressBar(this, (ImageButton) findViewById(R.id.refresh));

		//Check if the user is logged in
		presenter.checkLogin();
		presenter.createNotificationInstallation();
	}

	@Override
	public void onStart(){
		super.onStart();
		presenter.initiate();
		if(!getIntent().getBooleanExtra("finish", false)){
			presenter.update();
		}
	}

	@Override
	public void onPause(){
		super.onPause();
		hideProgressBar();
	}

	/**
	 * Refresh the view
	 * @param v
	 */
	public void onClickRefresh(View v) {
		presenter.update();
	}

	/**
	 * Go to Invitation screen 
	 * @param v
	 */
	public void onClickInvitations(View v) {
		Intent intent = new Intent(this, InvitationActivity.class);
		startActivity(intent);
	}


	/**
	 * Go to New game screen 
	 * @param view
	 */
	public void onClickNewGame(View view) {
		Intent intent = new Intent (this, NewGameActivity.class);
		startActivity(intent);
	}

	/**
	 * Go to High score screen
	 * @param view
	 */
	public void onClickHighScore(View view) {
		Intent intent = new Intent (this, HighScoreActivity.class);
		startActivity(intent);
	}

	/**
	 * Go to Account screen
	 * @param view
	 */
	public void onClickUsername(View view) {
		Intent intent = new Intent (getApplicationContext(), AccountActivity.class);
		startActivity(intent);
	}

	/**
	 * Display the name of the current user
	 * @param user
	 */
	public void setAccountName(String user){
		account.setText(user);
	}

	/**
	 * Set the list of games which is displayed on the screen,
	 * add onItemClickListeners to every item in the list and handle clicks
	 * @param adapter
	 */
	public void setGameList(final SeparatedListAdapter adapter){
		//Final-declarations in order to reference from inner class later
		final Activity activity = this;

		// Set the adapter on the ListView holder 
		gameListView.setAdapter(adapter);

		// Listen for Click events
		gameListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long duration) {
				Game game = (Game) adapter.getItem(position);
				Intent intent = new Intent(activity, GameDashboardActivity.class);
				intent.putExtra("Game", game);
				startActivity(intent);
			}
		});
	}

	/**
	 * Display if any new invitations are received
	 * @param nrInvites
	 */
	public void setInvitations(int nrInvites){
		if(nrInvites>0) {
			invitations.setImageResource(R.drawable.invitation_new);
		}
		else {
			invitations.setImageResource(R.drawable.invitation);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about:
			startActivity(new Intent(this, GameInstructionsActivity.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected RefreshProgressBar getProgressBar() {
		return refresh;
	}
}