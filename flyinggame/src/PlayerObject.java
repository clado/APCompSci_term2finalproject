import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerObject {
	private int xcoor, ycoor;
	private final int incVert, incHorz;
	private BufferedImage playergif;
	
	public PlayerObject() throws IOException {
		xcoor = 50;
		ycoor = 150;
		incVert = 5;
		incHorz = 5;
		playergif = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/playerplane.png"));
	}
	
	//moves the playable character upwards
	public void incUp(){
		ycoor = ycoor - incVert;
		
	}
	
	//moves the playable character downwards
	public void incDown(){
		ycoor = ycoor + incVert;
	}
	
	//moves the playable character leftwards
	public void incLeft(){
		xcoor = xcoor - incHorz;
	}
	
	//moves the playable character rightwards
	public void incRight(){
		xcoor = xcoor + incHorz;
	}
	
	//redraws the object
	//public void moveObject(JLabel playerimage){
	//	playerimage.setLocation(xcoor, ycoor);
	//}
	
	public void moveObject(Graphics guigraphics){
		guigraphics.drawImage(playergif, xcoor, ycoor, null);
	}
}
