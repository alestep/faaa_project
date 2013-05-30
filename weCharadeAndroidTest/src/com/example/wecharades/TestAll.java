package com.example.wecharades;

import junit.framework.TestSuite;

import com.example.wecharades.model.test.ModelTest;

public class TestAll {
	public static void main(String[] args) {
		TestSuite suite= new TestSuite();
		 suite.addTest(new ModelTest());
	}
}
