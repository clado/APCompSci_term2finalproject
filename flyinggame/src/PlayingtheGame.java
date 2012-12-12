import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class PlayingtheGame extends JFrame 
	implements KeyListener, ActionListener {
		
	JPanel graphicalgui; //totalwindow,
	JButton begingamebtn;
	
	public static void main(String[] args){
		
		PlayingtheGame lewindow = new PlayingtheGame();
		lewindow.setSize(1235, 760);
		lewindow.initialpaint();
		lewindow.setVisible(true);
		
	}
	
	//paints welcome screen
	public void initialpaint(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container totalwindow = getContentPane();
		
		totalwindow.setLayout(new FlowLayout());
		
		graphicalgui = new JPanel();
		graphicalgui.setLayout(null);
		graphicalgui.setLocation(10, 2);
		graphicalgui.setPreferredSize(new Dimension(1223, 725));
		graphicalgui.setBackground(Color.blue);
		totalwindow.add(graphicalgui);
		
		begingamebtn = new JButton("Play");
		begingamebtn.setLocation(575, 350);
		begingamebtn.setSize(75, 30);
		graphicalgui.add(begingamebtn);
		
	}
	
	public void prepaint(){
		graphicalgui.removeAll();
		graphicalgui.setBackground(Color.gray);
		paint();
	}
	
	//paints game screen
	public void paint() {
		
	}
	
	//IMPLEMENT FOR PAUSE FUNCTION! :D
	public void keyTyped(KeyEvent evt) {
		char pauseevent= evt.getKeyChar();
		if (pauseevent == 'p' || pauseevent == 'P') {
			//stuff
		}
	}
	
	public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == begingamebtn){
				prepaint();
			}
		}
	
	public void keyPressed(KeyEvent evt) {
		
		int key = evt.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			
			paint();
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			
			paint();
		}
		
		if (key == KeyEvent.VK_DOWN) {
			
			paint();
		}
		
		if (key == KeyEvent.VK_UP){
			
			paint();
		}
		
		
	}
	
	//apparently required by KeyListener....
	public void keyReleased(KeyEvent evt){
		
	}

}
