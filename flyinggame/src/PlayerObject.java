import java.awt.*;
import javax.swing.JPanel;


public class PlayerObject {
	private int xcoor, ycoor;
	private final int incVert, incHorz;
	
	public PlayerObject() {
		xcoor = 50;
		ycoor = 150;
		incVert = 5;
		incHorz = 5;
	}
	
	//moves the playable character upwards
	public void incUp(){
		xcoor = xcoor - incVert;
		
	}
	
	//moves the playable character downwards
	public void incDown(){
		xcoor = xcoor + incVert;
	}
	
	//moves the playable character leftwards
	public void incLeft(){
		ycoor = ycoor - incHorz;
	}
	
	//moves the playable character rightwards
	public void incRight(){
		ycoor = ycoor + incHorz;
	}
	
	//redraws the object
	public void redrawObject(JPanel guiwindowerness){
		Graphics paper = guiwindowerness.getGraphics();
		paper.setColor(Color.black);
		paper.fillRect(ycoor, xcoor, 20, 20);
	}
}
