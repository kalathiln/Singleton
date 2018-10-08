package designPattern.singleton;

public class ScrabbleThread {
	
	public static void main(String[] args) {
		Runnable getTiles = new GetTheTiles();
		Runnable getTilesAgain = new GetTheTiles();
		// Create a new Thread created using the Runnable interface
		// Execute the code in run after 10 seconds

		new Thread(getTiles).start();
		// creates a new thread after 3 seconds		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(getTilesAgain).start();
		System.out.println(Thread.activeCount());
	}

}
