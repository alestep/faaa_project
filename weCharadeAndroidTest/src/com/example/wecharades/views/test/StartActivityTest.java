package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.example.wecharades.R;
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

	/**
	 * Test setGameList(final SeparatedListAdapter adapter)
	 * @throws Throwable
	 */
	public void testSetGameList_1()
			throws Throwable {
		//TODO: ask alexander how to get items from SeperatedListAdapter... 
		//TODO: 1) create adapter. 2) user setGameList(). 3) assertEquals getListItemsStuff...
		assertTrue(true);
	}

	/**
	 * test setInvitations()
	 * @throws Throwable
	 */
//	public void testSetInvitations()
//			throws Throwable {
//		//Not possible to test because it only changes an image and there's no way to programmatically se if the image has changed-
//	}
	protected void tearDown() throws Exception {
		super.tearDown();
	}


}
