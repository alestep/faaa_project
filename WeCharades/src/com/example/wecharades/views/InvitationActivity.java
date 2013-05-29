package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.wecharades.R;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.model.RefreshProgressBar;
import com.example.wecharades.presenter.InvitationPresenter;

public class InvitationActivity extends GenericActivity {
	private InvitationPresenter presenter;
	private RefreshProgressBar refresh;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState, new InvitationPresenter(this));
        setContentView(R.layout.invitation_screen);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_refresh_home); 
        
        //Get references to instances
		presenter = (InvitationPresenter) getPresenter();
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

	@Override
	protected RefreshProgressBar getProgressBar() {
		return refresh;
	}
	
	/**
	 * Go back to Home screen
	 * @param v
	 */
	public void onClickHome(View v){
		presenter.goToStartActivity();
	}
	
	/**
	 * Updates the screen
	 * @param v
	 */
	public void onClickRefresh(View v){
		presenter.update();
	}
}
