package com.example.wecharades.views.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.wecharades.presenter.AccountPresenter;
import com.example.wecharades.views.AccountActivity;
import com.example.wecharades.views.GameInstructionsActivity;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;
/**
 * TestClass to test the account activity screen function. Test ID: T10.
 * @author weCharade
 *
 */
public class AccountActivityRobotiumTest extends
                ActivityInstrumentationTestCase2<StartActivity> {
 
        private Solo solo;
        private String username = "adam";
        private String password = "adam92";
       
        public AccountActivityRobotiumTest() {
                super(StartActivity.class);
               
        }
 
        protected void setUp() throws Exception {
                super.setUp();
                solo = new Solo(getInstrumentation(), getActivity());
        }
       
        public void testAccountScreen(){
                solo.assertCurrentActivity("initially startAcivity", StartActivity.class);
                login();
                solo.clickOnButton(username);
                solo.waitForActivity(AccountActivity.class);
                solo.clickOnButton("Instructions");
                solo.waitForActivity(GameInstructionsActivity.class);
                solo.goBack();
                solo.waitForActivity(GameInstructionsActivity.class);
                solo.clickOnButton("Logout");
        }
        
       
        private void login(){
                solo.waitForActivity(LoginActivity.class);
                solo.enterText(0, username);
                solo.enterText(1, password);
                solo.clickOnButton("Login");
                solo.waitForActivity(StartActivity.class);
        }
 
        protected void tearDown() throws Exception {
                solo.finishOpenedActivities();
                super.tearDown();
        }
 
}
