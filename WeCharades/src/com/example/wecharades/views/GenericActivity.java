package com.example.wecharades.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wecharades.presenter.Presenter;

public abstract class GenericActivity extends Activity {
	
	//TODO this should prbably be referenced in the subclasses. 
	protected Presenter presenter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
		
	public void showMessage(String error) {
		getTextArea().setText(error);
	}
	
	//To be implemented.
	public abstract TextView getTextArea();

	//TODO insert spinners here? Also, could we add the spinner area in this class and have it included in the subclasses?
	
}
