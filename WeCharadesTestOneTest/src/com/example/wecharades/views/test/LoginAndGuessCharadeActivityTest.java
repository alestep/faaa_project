package com.example.wecharades.views.test;
 
import android.test.ActivityInstrumentationTestCase2;

import com.example.wecharades.views.GameDashboardActivity;
import com.example.wecharades.views.LoginActivity;
import com.example.wecharades.views.StartActivity;
import com.jayway.android.robotium.solo.Solo;
 
/**
 *
 * @author Adam
 *Test class to test the LoginActivity and GuessCharadeActivity Test ID: T02, T07.
 */
 
public class LoginAndGuessCharadeActivityTest extends
                ActivityInstrumentationTestCase2<LoginActivity> {
       
        private Solo solo;
       
        public LoginAndGuessCharadeActivityTest() {
                super(LoginActivity.class);
                // TODO Auto-generated constructor stub
        }
 
        protected void setUp() throws Exception {
                super.setUp();
                solo = new Solo(getInstrumentation(),getActivity());
        }
//      /**
//       * Variation 1
//       */
//      public void testEmptyFieldsLogin(){
//              solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//              solo.enterText(0, "");
//              solo.enterText(1, "");
//              solo.clickOnButton("Login");
//              solo.waitForDialogToOpen(5000);
//              solo.clickOnButton("OK");
//      }
//      /**
//       * Variation 2
//       */
//      public void testPasswordEmptyFieldLogin(){
//              solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//              solo.enterText(0,"adam");
//              solo.clickOnButton("Login");
//              solo.waitForDialogToOpen(5000);
//              solo.clickOnButton("OK");
//      }
//      /**
//       * Variation 3 - Case 1
//       */
//      public void testValidUsernameAndPasswordCaseOne(){
//              solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//              solo.enterText(0, "adam");
//              solo.enterText(1, "adam92");
//              solo.clickOnButton("Login");
//              solo.waitForActivity(StartActivity.class);
//              solo.assertCurrentActivity("Assertion of StartScreen", StartActivity.class);
//      }
//      /**
//       * Variation 3 - Case 2
//       */
//      public void testValidUsernameAndPasswordCaseTwo(){
//              solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//              solo.enterText(0, "adam");
//              solo.enterText(1, "WRONG_PASSWORD");
//              solo.clickOnButton("Login");
//              solo.waitForDialogToOpen(5000);
//              solo.clickOnButton("OK");
//             
//      }
//      /**
//       * Variation 3 - Case 3 Requires no internet connection. TODO: turn internet autmatically off.
//       */
//      public void testValidUsernameAndPasswordCaseThree(){
//              solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
//              solo.enterText(0, "adam");
//              solo.enterText(1, "WRONG_PASSWORD");
//              solo.clickOnButton("Login");
//              solo.waitForDialogToOpen(5000);
//              solo.clickOnButton("OK");
//             
//      }
        /**
         * Test ID: T07. Variation One. Uses precondition 1
         */
        public void testGuessCharadeVideoGuessWrong(){
                solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
                solo.enterText(0, "adam");
                solo.enterText(1, "adam92");
                solo.clickOnButton("Login");
                solo.waitForActivity(StartActivity.class);
                /*---------------------------------------*/
                solo.clickOnText("Antz");
                solo.waitForActivity(GameDashboardActivity.class);
                solo.clickOnButton("Guess charade");
                solo.waitForDialogToOpen(2000);
                solo.waitForDialogToClose(3000);
                solo.enterText(0, "LOL");
               
                solo.clickOnImageButton(0);
                solo.waitForDialogToOpen(5000);
                solo.clickOnButton("Retry");
                solo.waitForDialogToClose(5000);
        }
        /**
         * Variation 2 - requires the right word. Precondition: Comment away row 99-102 which update the database.
         */
        public void testGuessCharadeVideoGuessRight(){
                solo.assertCurrentActivity("Check on LoginActivity", LoginActivity.class);
                solo.enterText(0, "adam");
                solo.enterText(1, "adam92");
                solo.clickOnButton("Login");
                solo.waitForActivity(StartActivity.class);
                /*---------------------------------------*/
                solo.clickOnText("Antz");
                solo.waitForActivity(GameDashboardActivity.class);
                solo.clickOnButton("Guess charade");
                solo.waitForDialogToOpen(2000);
                solo.waitForDialogToClose(3000);
                solo.enterText(0, "skriva");
                solo.clickOnImageButton(0);
                solo.waitForDialogToOpen(5000);
                solo.clickOnButton("Continue");
                solo.waitForDialogToClose(5000);
                solo.waitForActivity(GameDashboardActivity.class);
               
        }
       
        @Override
        public void tearDown() throws Exception{
                solo.finishOpenedActivities();
        }
 
}