package com.example.wecharades;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is a representation of the local versions of word lists that exist.
 * 	The intent of this class is to have a central database of sorts, where a
 * 	word list only appears once. The game list will later have a version control, where
 * 	unused word lists are deleted.
 * 
 * @author Anton Dahlström
 *
 */
public class Wordlists {
	//A list of the available word lists on this device, as well as the path to the actual files.
	HashMap<Long, File> wls = new HashMap<Long, File>(); 
	
	/** Check if a word list exist on the device
	 * 
	 * @param version - The version that should be checked for existance
	 * @return if the the word list exist locally
	 */
	public boolean containsList(long version){
		return wls.containsKey(version);
	}
	
	/** Get the indicated version of the word list from device storage.
	 * 
	 * @param version - The version to be returned
	 * @return The version of the word list
	 * @throws Exception Thrown if the word list doesn't exist
	 */
	public ArrayList<String> getWordlist(long version) throws Exception{
		if (!wls.containsKey(version)){
			throw new Exception("No such version");
		} else{
			//This should later be able to read the appropriate file from the device storage. Not implemented as of yet!
			return null;
		}
	}
	
}
