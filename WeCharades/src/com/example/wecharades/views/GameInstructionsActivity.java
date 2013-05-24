package com.example.wecharades.views;

import android.os.Bundle;
import android.widget.TextView;

import com.example.wecharades.R;
import com.example.wecharades.presenter.SimplePresenter;

public class GameInstructionsActivity extends GenericActivity {
	
	private SimplePresenter presenter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState, new SimplePresenter(this));
		this.presenter = (SimplePresenter) super.getPresenter();
		setContentView(R.layout.gameinstructions);
	}

	@Override
	public TextView getTextArea() {
		// TODO Auto-generated method stub
		return null;
	}
}
