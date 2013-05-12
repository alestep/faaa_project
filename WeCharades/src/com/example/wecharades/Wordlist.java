package com.example.wecharades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * A representation of a word list.
 * 
 * This class should get the latest version of the word list from the db when created.
 *  Thereafter, it should be possible to get unique words from the list.
 * 
 * @author Anton Dahlström
 *
 */
public class Wordlist {
	Random random = new Random();
	private ArrayList<String> wordlist = new ArrayList<String>();
	private HashSet<String> usedWords = new HashSet<String>();
	
	/**
	 * Retrieves the latest word list from the server when created
	 */
	public Wordlist(){
		wordlist = Database.getWordlist();
	}
	
	/**
	 * Gets a unique random word from the word list, 
	 * 	no game should have the same word twice. 
	 * @return a unique random word
	 */
	public String getWord(){
		String word;
		do{
			word = wordlist.get(random.nextInt(wordlist.size()-1));
		} while(usedWords.contains(word));
		usedWords.add(word);
		return word;
	}
}
