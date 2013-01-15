import java.io.IOException;
import java.util.Random;


public class LinkedListHazards {
		
	private FlyingHazard head;
	private final int xcoordinate;
	private boolean[] isHazard;
	private Random rand;
	public int collectedpoints;

	
	//creates the list of Hazards
	public LinkedListHazards(){
		head = null;
		rand = new Random();
		collectedpoints = 0;
		xcoordinate = 1125;
		isHazard = new boolean[7];
		resetSafety();
	}
	
	//adds another Hazard
	public void addtoStart(int difficulty){
		int ycoordinate;
		
		int temp;
		//set the ycoordinate
		do{
			temp = rand.nextInt(7);
		//try until the plane doesn't collide with another
		}while(isHazard[temp]);
		
		temp ++;
		// 3 = space at top, 100 = length of pic, 9 = buffer space between objects, one added every line after the first
		ycoordinate = 3 + (temp * 100) + (9 * (temp - 1));
		
		try {
			head = new FlyingHazard(difficulty, head, ycoordinate, xcoordinate);
		} catch (IOException e) {
			System.out.println("Hazard img not found.");
			e.printStackTrace();
		}
	}
	
	/**
	 * calculates the amount of Hazards, possibly obsolete
	 * think about deleting this
	 */
	public int size(){
		int count = 0;
		FlyingHazard position = head;
		while (position != null){
			count ++;
			position = position.getLink();
		}
		return count;
	}
	
	//moves all current objects forward on the grid
	public void incObjects(){
		FlyingHazard position = head;
		while (position != null){
			position.incHazard();
			position = position.getLink();
		}
	}
	
	//resets the boolean that makes sure two hazards aren't placed in the same space
	public void resetSafety(){
		for (int count = 0; count < 7; count ++) isHazard[count] = false;
	}
	
	//checks to see if the plane has collided with any of the hazards, adding points when necessary
	//returns whether the game is over due to collision
	public boolean checkCollisions(){
		
		return false;
	}
	

}

