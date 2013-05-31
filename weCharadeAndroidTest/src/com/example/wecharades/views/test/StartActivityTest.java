package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;

import com.example.wecharades.R;
import com.example.wecharades.views.StartActivity;

public class StartActivityTest extends
		ActivityInstrumentationTestCase2<StartActivity> {

	public StartActivityTest() {
		super(StartActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	private StartActivity activity;

	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
	}
	
	/**
	 * 
	 */
	public void testSetInvitations() {
		activity.setInvitations(2); // > 1
		ImageButton invitations = (ImageButton) activity.findViewById(R.id.invitations);
		int i = R.drawable.invitation;
		invitations.setImageResource(R.drawable.invitation);

	}
	

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
}
