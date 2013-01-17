import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;


public class PlayerObject {
	private int xcoor, ycoor;
	private final int incVert, incHorz;
	private BufferedImage playergif;
	final int w, h;
	//NUMBER OF LIVES;
	
	public PlayerObject() throws IOException {
		xcoor = 50;
		ycoor = 150;
		incVert = 5;
		incHorz = 5;
		w = 150;
		h = 66;
		playergif = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/playerplane.png"));
	}
	
	//moves the playable character upwards
	public void incUp(){
		if (ycoor >= incVert) ycoor = ycoor - incVert;
		
	}
	
	//moves the playable character downwards
	public void incDown(){
		if (ycoor <= (725 - h - incVert))ycoor = ycoor + incVert;
	}
	
	//moves the playable character leftwards
	public void incLeft(){
		if (xcoor >= incHorz) xcoor = xcoor - incHorz;
	}
	
	//moves the playable character rightwards
	public void incRight(){
		if (xcoor <= (1223 - w - incHorz)) xcoor = xcoor + incHorz;
	}
	
	//draws the image on the background
	public void moveObject(Graphics guigraphics){
		guigraphics.drawImage(playergif, xcoor, ycoor, null);
	}
	
	public int getx(){
		return xcoor;
	}
	
	public int gety(){
		return ycoor;
	}

}
