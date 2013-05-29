package com.example.wecharades.views;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.wecharades.R;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.presenter.InvitationPresenter;

/**
 * View which displays a user's invitations, both received and sent
 * @author weCharade
 */
public class InvitationActivity extends GenericActivity {
	
	private InvitationPresenter presenter;
	private RefreshProgressBar refresh;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState, new InvitationPresenter(this));
		
		//Set the title bar
        setContentView(R.layout.invitation_screen);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_refresh_home); 
        
        //Get references to instances
		presenter = (InvitationPresenter) getPresenter();
		
		/*
		 * This class uses a RefreshProgressBar to visualize that data is fetched in the background
		 */
		refresh = new RefreshProgressBar(this, (ImageButton) findViewById(R.id.refresh));	}
	
	@Override
	protected void onStart() {
		super.onStart();
		presenter.initialize();
	}
	
	/**
	 * Accept or reject an invitation
	 * @param invitation
	 * @param response
	 */
	public void setInvitation(Invitation invitation, boolean response) {
		presenter.setInvitation(invitation, response);
	}
	
	/**
	 * Go to StartActivity
	 * @param v
	 */
	public void onClickHome(View v){
		presenter.goToStartActivity();
	}
	
	/**
	 * Refresh the screen
	 * @param v
	 */
	public void onClickRefresh(View v){
		presenter.update();
	}
	
	@Override
	protected RefreshProgressBar getProgressBar() {
		return refresh;
	}
}
