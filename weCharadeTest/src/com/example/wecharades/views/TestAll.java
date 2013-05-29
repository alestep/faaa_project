package com.example.wecharades.views;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 2013-05-29 09:38
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	StartActivityTest.class,
	InvitationActivityTest.class,
	CaptureVideoActivityTest.class,
	ShowCharadeWordActivityTest.class,
	AccountActivityTest.class,
	HighScoreActivityTest.class,
	RegisterActivityTest.class,
	ResetPasswordActivityTest.class,
	GuessCharadeActivityTest.class,
	LoginActivityTest.class,
	NewGameActivityTest.class,
	GameInstructionsActivityTest.class,
	SearchPlayerActivityTest.class,
	VideoUploadActivityTest.class,
	GameDashboardActivityTest.class,
	GenericActivityTest.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
