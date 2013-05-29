package com.example.wecharades.presenter;

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
	SeparatedListAdapterTest.class,
	RegisterPresenterTest.class,
	GameAdapterTest.class,
	ResetPresenterTest.class,
	SimplePresenterTest.class,
	AccountPresenterTest.class,
	StartPresenterTest.class,
	SearchPlayerAdapterTest.class,
	InvitationPresenterTest.class,
	SearchPlayerPresenterTest.class,
	HighScorePresenterTest.class,
	PresenterTest.class,
	GameDashboardPresenterTest.class,
	LoginPresenterTest.class,
	NewGamePresenterTest.class,
	VideoUploadPresenterTest.class,
	SimpleArrayAdapterTest.class,
	GuessCharadePresenterTest.class,
	InvitationAdapterTest.class,
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
