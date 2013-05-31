package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.example.wecharades.R;
import com.example.wecharades.presenter.SeparatedListAdapter;
import com.example.wecharades.views.StartActivity;

/**
 * This class tests relevant methods in the <code>StartActivity</code> class.
 * It does not test methods related to the application's life cycle events,
 * such as onCreate(), onStart() and so on.
 * It does not test methods in the form of onClickX();
 * @author weCharade
 */

public class StartActivityTest extends
ActivityInstrumentationTestCase2<StartActivity> {

	public StartActivityTest() {
		super(StartActivity.class);
	}

	private StartActivity activity;

	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
	}

	/**
	 * Test setAccountName()
	 * @throws Throwable
	 */
	public void testSetAccountName_1()
			throws Throwable {

		final Button account = (Button) activity.findViewById(R.id.account);
		final String string = "test";
		runTestOnUiThread(new Runnable() {
			@Override
			public void run() {

				activity.setAccountName(string);		
				assertEquals(string, account.getText().toString());
			}
		});
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}


}
