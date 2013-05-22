package com.example.wecharades.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wecharades.presenter.Presenter;

public abstract class GenericActivity extends Activity {
	
	//TODO this should prbably be referenced in the subclasses. 
	protected Presenter presenter;
	
	public void onCreate(Bundle savedInstanceState, Presenter presenter) {
		super.onCreate(savedInstanceState);
		this.presenter = presenter;
	}
		
	public void showMessage(String error) {
		getTextArea().setText(error);
	}
	
	//To be implemented.
	public abstract TextView getTextArea();
	
	@Override
	protected void onStop(){
		super.onStop();
		presenter.saveState();
	}
	
	protected Presenter getPresenter(){
		return presenter;
	}

	//TODO insert spinners here? Also, could we add the spinner area in this class and have it included in the subclasses?
	
}
