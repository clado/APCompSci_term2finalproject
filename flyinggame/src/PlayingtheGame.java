import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class PlayingtheGame 
	implements KeyListener, ActionListener {
	private JButton begingame;
	
	public static void main(String[] args){
		PlayingtheGame frame = new PlayingtheGame();
		frame.setSize(200, 200);
		frame.initialpaint();
		frame.setVisible(true);
		
	}
	
	//paints welcome screen
	public void initialpaint(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
		begingame = new JButton("Play");
		window.add(begingame);
		
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
	
	private void begingameActionPerformed(java.awt.event.ActionEvent evt) {
			
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
