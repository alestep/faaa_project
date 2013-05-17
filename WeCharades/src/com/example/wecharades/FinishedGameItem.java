package com.example.wecharades;

public class FinishedGameItem extends GameItem {

	public FinishedGameItem(String title, String subtitle) {
		super(title, subtitle);
	}

	@Override
	public boolean isActive() {
		return false;
	}

}
