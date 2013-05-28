package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.wecharades.R;
import com.example.wecharades.views.AccountActivity;
import com.example.wecharades.views.GameInstructionsActivity;
import com.example.wecharades.views.HighScoreActivity;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;
/**
 * TestClass to test the account activity screen function. Test ID: T10.
 * @author Adam
 *
 */
public class AccountHighScoreActivityTest extends
                ActivityInstrumentationTestCase2<StartActivity> {
 
        private Solo solo;
       
        public AccountHighScoreActivityTest() {
                super(StartActivity.class);
               
        }
 
        protected void setUp() throws Exception {
                super.setUp();
                solo = new Solo(getInstrumentation(), getActivity());
        }
//        public void testHighScoreScreen(){
//                solo.assertCurrentActivity("initially startAcivity", StartActivity.class);
//                login();
//                solo.clickOnImageButton(R.id.global_score);
//                solo.waitForActivity(HighScoreActivity.class);
//                solo.waitForActivity(HighScoreActivity.class);
//                solo.goBack();
//        }
       
        public void testAccountScreen(){
                solo.assertCurrentActivity("initially startAcivity", StartActivity.class);
                login();
                solo.clickOnButton("adam");
                solo.waitForActivity(AccountActivity.class);
                solo.clickOnButton("Instructions");
                solo.waitForActivity(GameInstructionsActivity.class);
                solo.goBack();
                solo.waitForActivity(GameInstructionsActivity.class);
                solo.clickOnButton("Logout");
        }
 
       
        private void login(){
                solo.waitForActivity(LoginActivity.class);
                solo.enterText(0, "adam");
                solo.enterText(1, "adam92");
                solo.clickOnButton("Login");
                solo.waitForActivity(StartActivity.class);
        }
 
        protected void tearDown() throws Exception {
                solo.finishOpenedActivities();
                super.tearDown();
        }
 
}
