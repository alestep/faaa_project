package com.example.wecharades;

import java.util.ArrayList;
import java.util.Random;

public class Wordlist {
	Random random = new Random();
	private long version;
	private ArrayList<String> wordlist = new ArrayList<String>();
	
	public Wordlist(){
		wordlist = Database.getWordlist();
		version = Database.getWordlistVersion();
	}

	public long getVersion() {
		return version;
	}
	
	public ArrayList<String> getWordlist() {
		return wordlist;
	}
	
	public String getWord(){
		return wordlist.get(random.nextInt(wordlist.size()-1));
	}
	
}
