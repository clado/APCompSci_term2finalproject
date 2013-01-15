import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class FlyingHazard {
	
	private FlyingHazard link;
	private boolean alive;
	private int xcoor, ycoor;
	private Random numgen = new Random();
	public BufferedImage hazardpng;
	private final int incamount = 15;
	
	int pointval;
	
	//pretty sure I don't need this
	//public FlyingHazard(){
	//	alive = true;
	//	xcoor = 0;
	//	ycoor = 0;
	//	link = null;
	//	hazardpng = null;
	//}
	
	//creates a new Hazard when there already are some
	public FlyingHazard(int difficulty, FlyingHazard linkval, int y, int x) throws IOException{
		int temp = numgen.nextInt(3);
		
		//decides whether the object is dangerous
		if (temp < 2) pointval = 0;
		else {
			temp = numgen.nextInt(3) + difficulty;
			pointval = temp * 5;
		}
		
		xcoor = x;
		ycoor = y;
		
		alive = true;
		link = linkval;
		//sets the hazard image to a random image
		//CHANGE FOR POWERUPS
		temp = numgen.nextInt(1);
		if (temp == 1) hazardpng = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/pickaxe.png"));
		else hazardpng = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/saw.png"));
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
	
	
	//return a Hazard's status
	public boolean issalive(){
		return alive;
	}
	
	//moves a Hazard forward on the grid
	public void incHazard(){
		xcoor = xcoor - incamount;
	}
	
}
