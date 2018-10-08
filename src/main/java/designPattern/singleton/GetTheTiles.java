package designPattern.singleton;

import java.util.LinkedList;
/**
 *  This class is used to create threads in order to demonstrate 
 *  the usage of threads to instantiate the Singleton class separately.
 *  For this to work we need to synchronize the getInstance method, else
 *  it would lead to multiple instance creation, which is error prone 
 *  with regards to what we want to achieve.
 * @author nikhil
 *
 */
public class GetTheTiles implements Runnable {
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * Two threads even though execute one after the other
	 * calls the same instance which is created during the first execution.
	 */
	public void run() {
		// Uses the getInstance method to create new instance
		Singleton newInstance = Singleton.getInstance();
		System.out.println("New Instance ID: " + System.identityHashCode(newInstance));
		System.out.println("Total Tiles: " + newInstance.getLetterList());
		LinkedList<String> player1Tiles = newInstance.tilesToSend(7);
		System.out.println("First Player got:" + player1Tiles);
		System.out.println("After the initial tile distribution: " + newInstance.getLetterList());
		Singleton newInstance2 = Singleton.getInstance();
		System.out.println("Second Instance ID: " + System.identityHashCode(newInstance2));
		LinkedList<String> player2Tiles = newInstance2.tilesToSend(7);
		System.out.println("Second Player got:" + player2Tiles);

	}

}
