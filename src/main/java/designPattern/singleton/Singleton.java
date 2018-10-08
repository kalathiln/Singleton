package designPattern.singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * A singleton design pattern is used when you want to eliminate the option to
 * instantiate a class more than once.
 * 
 * @author nikhil
 *
 */
public class Singleton {
	// This will hold the one and only instance of the class Singleton
	private static Singleton firstInstance = null;

	String[] scrabbleLetters = { "a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "c", "c", "d", "d", "d", "d",
			"e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h", "h", "i", "i",
			"i", "i", "i", "i", "i", "i", "i", "j", "k", "l", "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n",
			"o", "o", "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s",
			"t", "t", "t", "t", "t", "t", "u", "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z", };
	private LinkedList<String> listLetter = new LinkedList<String>(Arrays.asList(scrabbleLetters));
	static boolean firstThread = true;

	// Private in order to maintain the single instance creation
	// Created to keep users from instantiation
	private Singleton() {

	}
	// We could make getInstance a synchronized method to force
	// every thread to wait its turn. That way only one thread
	// can access a method at a time. This can really slow everything
	// down though
	// public static synchronized Singleton getInstance()

	public static Singleton getInstance() {
		// To check whether the Instance has been created only once.
		if (firstInstance == null) {

			if (firstThread) {
				firstThread = false;
				Thread.currentThread();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// We create the synchronized when the first object is created
			synchronized (Singleton.class) {
				if (firstInstance == null) {
					// Lazy instantiation: If the instance isn't needed, it will not be created
					firstInstance = new Singleton();
					Collections.shuffle(firstInstance.listLetter);
				}
			}
		}
		return firstInstance;
	}
	// gets the list of the remaining scrabble tiles
	public LinkedList<String> getLetterList() {
		return firstInstance.listLetter;
	}
	
	// Used to designate the number of tiles to a specific user
	public LinkedList<String> tilesToSend(int noOfTiles) {
		LinkedList<String> tilesToSend = new LinkedList<String>();
		for (int i = 0; i < noOfTiles; i++) {
			tilesToSend.add(firstInstance.listLetter.remove(0));
		}
		return tilesToSend;
	}

}
