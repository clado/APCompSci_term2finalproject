 import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

import org.pscode.xui.sound.bigclip.BigClip;

/**
 * This program was created by Annelies Odermann, Nik SOMEONE, and AYMAN SOMEONE
 * Music "Cut and Run" copyright Kevin MacLeod, usage licensed under Creative Commons Attribution 3.0 <http://incompetech.com/music/royalty-free/index.html?isrc=USUAN1100851>
 * All images used are original copyright of our team members, or are clip art, used under a Creative Commons license
 */


@SuppressWarnings("serial")
public class PlayingtheGame extends JFrame 
	implements KeyListener, ActionListener {
		
	JPanel graphicalgui;
	JButton begingamebtn;
	BufferedImage splashjpg;
	Boolean gamePaused, gamebegun, gameend;
	Container totalwindow;
	JLabel scorelabel;
	
	//private InitProjectiles ObjectsInMotionTryingToKillYou;
	private PlayerObject PlayerOne;
	
	public static void main(String[] args) throws IOException{
		
		PlayingtheGame lewindow = new PlayingtheGame();
		lewindow.setSize(1235, 760);
		lewindow.init();
		lewindow.paint();
		lewindow.setVisible(true);
		
	}
	
	public void init() throws IOException{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		totalwindow = getContentPane();
		totalwindow.setLayout(new FlowLayout());
		
		graphicalgui = new JPanel();
		graphicalgui.setLayout(null);
		graphicalgui.setLocation(10, 2);
		graphicalgui.setPreferredSize(new Dimension(1223, 725));
		
		begingamebtn = new JButton("Play");
		begingamebtn.setLocation(575, 350);
		begingamebtn.setSize(75, 30);
		begingamebtn.addActionListener(this);
		
		//scorelabel.alskdfjwoiefj;vzlxcjvowarg;
		
		PlayerOne = new PlayerObject();
		//PlayerOne.moveObject(graphicalgui.getGraphics());
		
		splashjpg = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/splashscreen.jpg"));
				
		gamePaused = false;
		gamebegun = false;
		gameend = false;
		
	}
	
	public void paint(){
		//paints welcomescreen
		if (!gamebegun && !gameend){
			graphicalgui.setBackground(Color.blue);
			graphicalgui.add(begingamebtn);
		}
		else if(gamebegun && !gameend){
		}
		else{
			
		}
		
		totalwindow.add(graphicalgui);
		graphicalgui.requestFocus();
		graphicalgui.addKeyListener(this);
	}			

		
	
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == begingamebtn){
			if (!gamebegun){
				gamebegun = true;
				beginmusic();
				//ObjectsInMotionTryingToKillYou = new InitProjectiles("stuffs");
				//ObjectsInMotionTryingToKillYou.run();
				begingamebtn.setVisible(false);
				paint();
			}
		}
	}
	
	public void keyTyped(KeyEvent evt) {
		char pauseevent = evt.getKeyChar();
		if (pauseevent == 'p' || pauseevent == 'P') {
			if (gamePaused){
				gamePaused = false;
				//ObjectsInMotionTryingToKillYou.notify();
				//remove pausescreen
				//restart game
			}
			else{
				gamePaused = true;
				//try {
					//ObjectsInMotionTryingToKillYou.wait();
				//} catch (InterruptedException e) {
				//	System.out.println("Something bad happened");
				//	e.printStackTrace();
				//}
				//stop game
				//show pausescreen
			}
		}
	}
	
	//searches for arrowkeys to move player character
	public void keyPressed(KeyEvent evt) {
		
		int key = evt.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			if (!gamePaused){
				PlayerOne.incLeft();
				graphicalgui.getGraphics().drawImage(splashjpg, 0, 0, null);
				PlayerOne.moveObject(graphicalgui.getGraphics());
			}
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			if (!gamePaused){
				PlayerOne.incRight();
				graphicalgui.getGraphics().drawImage(splashjpg, 0, 0, null);
				PlayerOne.moveObject(graphicalgui.getGraphics());
			}
		}
		
		if (key == KeyEvent.VK_DOWN) {
			if (!gamePaused){
				PlayerOne.incDown();
				graphicalgui.getGraphics().drawImage(splashjpg, 0, 0, null);
				PlayerOne.moveObject(graphicalgui.getGraphics());
			}
		}
		
		if (key == KeyEvent.VK_UP){
			if (!gamePaused){
				PlayerOne.incUp();
				graphicalgui.getGraphics().drawImage(splashjpg, 0, 0, null);
				PlayerOne.moveObject(graphicalgui.getGraphics());
			}
		}
		
	}
	
	//apparently required by KeyListener....
	public void keyReleased(KeyEvent evt){
	}

	public void beginmusic(){
		//play music
		try {
			File soundfile = new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/gamebackgroundmusic.wav");
			AudioInputStream sound = AudioSystem.getAudioInputStream(soundfile);
			BigClip cliper = new BigClip();
			cliper.open(sound);
			//there is a bug in "LOOP_CONTINUOUSLY" and we cannot use it at the moment. :(
			//looping itself may not even be operational
			cliper.loop(10);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}
