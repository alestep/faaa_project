package com.example.wecharades;

import com.example.wecharades.model.test.ModelTest;
import junit.framework.TestSuite;

public class TestAll {
	public static void main(String[] args) {
		TestSuite suite= new TestSuite();
		 suite.addTest(new ModelTest());
	}
}
