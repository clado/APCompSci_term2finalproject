
public class InitProjectiles implements Runnable {
		Thread playing;
		public LinkedListHazards HazardObjects;
		public boolean gameover;
		private int speed;
		public int timesrun;
		private int difficulty;
		
		


	
	//constructs thread
	public InitProjectiles(String name){
		playing = new Thread(this, name);
		HazardObjects = new LinkedListHazards();
		gameover = false;
		speed = 7000;
		timesrun = 0;
		difficulty = 0;

	}
	
	//use this to run the thread
	public void run(){
		try {
			do {
				timesrun ++;
				Thread.sleep(speed);
				HazardObjects.addtoStart(difficulty);
				if (difficulty > 2) HazardObjects.addtoStart(difficulty);
				if (difficulty > 5) HazardObjects.addtoStart(difficulty);
				HazardObjects.resetSafety();
				HazardObjects.incObjects();
				if (timesrun % 4 == 0) {
					difficulty ++;
					speed = speed - 500;
					HazardObjects.collectedpoints = HazardObjects.collectedpoints + 10;
				}
				if (timesrun == 1000) gameover = true;
			} while(! gameover);
			
		}
		catch(InterruptedException exc){
			System.out.println("Something odd happened. Check the sleep function");
		}
	}

}
