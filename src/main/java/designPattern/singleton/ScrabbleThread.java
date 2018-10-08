package designPattern.singleton;

public class ScrabbleThread {
	
	public static void main(String[] args) {
		Runnable getTiles = new GetTheTiles();
		Runnable getTilesAgain = new GetTheTiles();
		
		new Thread(getTiles).start();
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
