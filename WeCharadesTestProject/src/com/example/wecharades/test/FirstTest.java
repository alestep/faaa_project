package com.example.wecharades.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;

public class FirstTest extends ActivityInstrumentationTestCase2<StartActivity> {

	private Solo solo;
	
	public FirstTest() {
		super(StartActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		solo =  new Solo(getInstrumentation(),getActivity());
	}
	public void testFirst() throws Exception{
//		solo.assertCurrentActivity("Check on first activity", StartActivity.class);
		fail(); //if right should fail on this line.
	}

}
