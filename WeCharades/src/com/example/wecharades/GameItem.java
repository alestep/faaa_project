package com.example.wecharades;

public abstract class GameItem implements Item{

	private final String title;
	private final String subtitle;

	public GameItem(String title, String subtitle) {
		this.title = title;
		this.subtitle = subtitle;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSubtitle() {
		return subtitle;
	}
	
	@Override
	public boolean isSection() {
		return false;
	}
	
	@Override
	public abstract boolean isActive();
	
	
}