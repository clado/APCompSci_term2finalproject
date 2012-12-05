
public class InitProjectiles implements Runnable {
		Thread playing;
		boolean gameover;
		int speed;
	
	//constructs thread
	public InitProjectiles(String name){
		playing = new Thread(this, name);
		gameover = false;
		speed = 10000;
	}
	
	//use this to run the thread
	public void run(){
		System.out.println("Projectiles have started");
		try {
			do {
				Thread.sleep(speed);
				
			} while(! gameover);
			
		}
		catch(InterruptedException exc){
			System.out.println("Something odd happened. Check the sleep function");
		}
		System.out.println("Projectiles have ended");
	}
}
