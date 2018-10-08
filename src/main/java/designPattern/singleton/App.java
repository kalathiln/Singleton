package designPattern.singleton;

import java.util.LinkedList;

/**
 * Program to demonstrate a Scrabble Application!
 *
 */
public class App {
	public static void main(String[] args) {
		// How you create a new instance of Singleton
		Singleton newInstance1 = Singleton.getInstance();
		// Gets a unique ID for the instance created
		System.out.println("New Instance ID: " + System.identityHashCode(newInstance1));
		System.out.println("Total Tiles: " + newInstance1.getLetterList());
		
		// allocates player with 7 tiles from the total list of available scrabble tile
		LinkedList<String> player1Tiles = newInstance1.tilesToSend(7);
		System.out.println("First Player got:"+player1Tiles);
		System.out.println("After the initial tile distribution: " + newInstance1.getLetterList());
		// creating new instance using getInstance method
		Singleton newInstance2 = Singleton.getInstance();
		System.out.println("Second Instance ID: " + System.identityHashCode(newInstance2));
		
		LinkedList<String> player2Tiles = newInstance2.tilesToSend(6);
		System.out.println("second Player got:"+player2Tiles);
		System.out.println("After the 2nd tile distribution: " + newInstance2.getLetterList());

	}
}
