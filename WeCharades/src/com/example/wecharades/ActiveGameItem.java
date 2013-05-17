package com.example.wecharades;

public class ActiveGameItem extends GameItem {

	public ActiveGameItem(String title, String subtitle) {
		super(title, subtitle);
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
