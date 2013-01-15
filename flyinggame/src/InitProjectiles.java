import java.util.Random;

public class InitProjectiles implements Runnable {
		Thread playing;
		private LinkedListHazards HazardObjects;
		public boolean gameover;
		private int speed;
		public int timesrun;
		private int difficulty;

	
	//constructs thread
	public InitProjectiles(String name){
		playing = new Thread(this, name);
		HazardObjects = new LinkedListHazards();
		gameover = false;
		speed = 10000;
		timesrun = 0;
		difficulty = 0;
	}
	
	//use this to run the thread
	public void run(){
		System.out.println("Projectiles have started");
		try {
			do {
				timesrun ++;
				Thread.sleep(speed);
				HazardObjects.incObjects();
				System.out.println("Objects incremented");
				if (timesrun == 1000) gameover = true;
			} while(! gameover);
			
		}
		catch(InterruptedException exc){
			System.out.println("Something odd happened. Check the sleep function");
		}
		System.out.println("Projectiles have ended");
	}
}
