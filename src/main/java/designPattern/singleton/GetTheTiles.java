package designPattern.singleton;

import java.util.LinkedList;

public class GetTheTiles implements Runnable {

	public void run() {
		Singleton newInstance = Singleton.getInstance();
		System.out.println("New Instance ID: " + System.identityHashCode(newInstance));
		System.out.println("Total Tiles: " + newInstance.getLetterList());
		LinkedList<String> player1Tiles = newInstance.tilesToSend(7);
		System.out.println("First Player got:"+player1Tiles);
		System.out.println("After the initial tile distribution: " + newInstance.getLetterList());
		Singleton newInstance2 = Singleton.getInstance();
		System.out.println("Second Instance ID: "+System.identityHashCode(newInstance2));


	}

}
