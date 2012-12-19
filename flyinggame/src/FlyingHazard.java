import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class FlyingHazard {
	
	private FlyingHazard link;
	private boolean alive;
	private int pointval, xcoor, ycoor;
	private Random numgen = new Random();
	public BufferedImage hazardpng;
	
	//creates the first Hazard
	public FlyingHazard(){
		alive = true;
		pointval = 0;
		xcoor = 0;
		ycoor = 0;
		link = null;
		hazardpng = null;
	}
	
	//creates a new Hazard when there already are some
	public FlyingHazard(int difficulty, FlyingHazard linkval) throws IOException{
		int temp = numgen.nextInt(3);
		
		//decides whether the object is dangerous
		if (temp < 2) pointval = 0;
		else {
			temp = numgen.nextInt(3) + difficulty;
			pointval = temp * 5;
		}
		
		//CHANGE XCOOR. TEMPORARY VALUE
		xcoor = 950;
		//CHANGE YCOOR. TEMPORARY VALUE
		temp = numgen.nextInt(4) + 1;
		ycoor = (temp * 100) + (25 * temp);
		
		alive = true;
		link = linkval;
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
	
	//returns a Hazard's pointvalue
	public int getPoints(){
		return pointval;
	}
	
	//return a Hazard's status
	public boolean issalive(){
		return alive;
	}
	
	//
	public void incHazard(){
		xcoor = xcoor - 10;
	}
	
}
