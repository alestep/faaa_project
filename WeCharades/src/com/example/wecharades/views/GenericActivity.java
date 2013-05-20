package com.example.wecharades.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public abstract class GenericActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	public void showMessage(String error) {
		getTextArea().setText(error);
	}
	
	//To be implemented
	public abstract TextView getTextArea();
	
}
