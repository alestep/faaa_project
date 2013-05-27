package com.example.wecharades.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.model.Invitation;
import com.example.wecharades.presenter.InvitationPresenter;

public class InvitationActivity extends GenericActivity {
	InvitationPresenter presenter;
	
	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		super.onCreate(savedInstanceState, new InvitationPresenter(this));
        
        setContentView(R.layout.list_screen);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar_other); 
        
		presenter = (InvitationPresenter) getPresenter();
	}
	
	/**
	 * 
	 */
	@Override
	protected void onStart() {
		super.onStart();
		presenter.update();
	}

	public void setInvitation(Invitation invitation, boolean response) {
		presenter.setInvitation(invitation, response);
		
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ProgressBar getProgressSpinner() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void onClickHome(View v){
		startActivity(new Intent(this, StartActivity.class));
	}
}
