package com.example.wecharades.views.test;

import com.example.wecharades.model.test.AutoGeneratedDatabaseTest;
import com.example.wecharades.model.test.ModelTest;

import junit.framework.TestSuite;



/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 2013-05-29 09:38
 * @author felixkarlsson
 * @version $Revision: 1.0 $
 */



public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2013-05-29 09:38
	 */
	public static void main(String[] args) {

		Class[] testClasses = {
				ModelTest.class,
				AutoGeneratedDatabaseTest.class
		};

		TestSuite suite = new TestSuite(testClasses);
	}
}
