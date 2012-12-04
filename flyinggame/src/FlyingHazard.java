import java.util.Random;

public class FlyingHazard {
	
	private FlyingHazard link;
	private boolean alive;
	private int pointval, xcoor, ycoor;
	private Random numgen = new Random();
	
	//creates the first Hazard
	public FlyingHazard(){
		alive = true;
		pointval = 0;
		xcoor = 0;
		ycoor = 0;
		link = null;
	}
	
	//creates a new Hazard when there already are some
	public FlyingHazard(int difficulty, FlyingHazard linkval){
		int temp = numgen.nextInt(3);
		
		//decides whether the object is dangerous
		if (temp < 2) pointval = 0;
		else {
			temp = numgen.nextInt(3) + difficulty;
			pointval = temp * 5;
		}
		
		alive = true;
		link = linkval;
	}
	
	//modify a Hazard's link.
	//used for removing expired hazards
	public void setLink(FlyingHazard newLink){
		link = newLink;
	}
	
	//modify a Hazard's alive status
	//used for expiring hazards
	public void kill(){
		alive = false;
	}
	
	//returns a Hazard's link
	public FlyingHazard getLink(){
		return link;
	}
	
	//returns a Hazard's pointvalue
	public int getPoints(){
		return pointval;
	}
	
	//return a Hazard's status
	public boolean issalive(){
		return alive;
	}
	
}
