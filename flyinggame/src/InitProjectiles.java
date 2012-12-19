
public class InitProjectiles implements Runnable {
		Thread playing;
		private LinkedListHazards HazardObjects;
		private boolean gameover;
		private int speed;

	
	//constructs thread
	public InitProjectiles(String name){
		playing = new Thread(this, name);
		HazardObjects = new LinkedListHazards();
		gameover = false;
		speed = 10000;
	}
	
	//use this to run the thread
	public void run(){
		System.out.println("Projectiles have started");
		int count = 0;
		try {
			do {
				count ++;
				Thread.sleep(speed);
				HazardObjects.incObjects();
				System.out.println("Objects incremented");
				if (count == 200) gameover = true;
			} while(! gameover);
			
		}
		catch(InterruptedException exc){
			System.out.println("Something odd happened. Check the sleep function");
		}
		System.out.println("Projectiles have ended");
	}
}
