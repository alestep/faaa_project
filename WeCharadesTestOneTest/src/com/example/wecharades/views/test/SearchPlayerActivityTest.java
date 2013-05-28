package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.NewGameActivity;
import com.example.wecharades.views.SearchPlayerActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;
/**
 * Test class to test the search player function. Test ID: T04
 * @author Adam
 *
 */
public class SearchPlayerActivityTest extends ActivityInstrumentationTestCase2<NewGameActivity> {

	private Solo solo;
	
	public SearchPlayerActivityTest() {
		super(NewGameActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());	
	}
	/**
	 * Variation 1
	 */
	public void testPlayAgainstPlayer() throws InterruptedException{
		solo.assertCurrentActivity("Assert NewgameActivity", NewGameActivity.class);
		solo.clickOnButton("Find player");
		solo.waitForActivity(SearchPlayerActivity.class);
		solo.assertCurrentActivity("Search player screen", SearchPlayerActivity.class);
		solo.clickOnEditText(0);
		solo.enterText(0, "al");
		solo.sendKey(Solo.ENTER);
		solo.waitForText("Play");
	}
	/**
	 * Variation 2
	 */
	public void testRandomPlayerFunction(){
		solo.assertCurrentActivity("Assert NewgameActivity", NewGameActivity.class);
		solo.clickOnButton("Find random player");
		solo.waitForText("Invitation Sent");
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
		super.tearDown();
	}
	
}
