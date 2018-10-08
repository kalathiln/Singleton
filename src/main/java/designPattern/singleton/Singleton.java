package designPattern.singleton;

import java.util.Arrays;
import java.util.Collection;
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
	private Singleton() {

	}

	public static synchronized Singleton getInstance() {

		if (firstInstance == null) {
			
			if(firstThread) {
				firstThread = false;
				Thread.currentThread();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			// Lazy instantiation: If the instance isn't needed, it will not be created
			firstInstance = new Singleton();
			Collections.shuffle(firstInstance.listLetter);
		}
		return firstInstance;
	}
	
	public LinkedList<String> getLetterList(){
		return firstInstance.listLetter;
	}
	
	public LinkedList<String> tilesToSend(int noOfTiles){
		LinkedList<String> tilesToSend = new LinkedList<String>();
		for(int i =0; i<noOfTiles;i++) {
			tilesToSend.add(firstInstance.listLetter.remove(0));
		}
		return tilesToSend;
	}

}
