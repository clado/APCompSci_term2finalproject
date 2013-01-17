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
	implements ActionListener, KeyListener {
		
	JPanel graphicalgui;
	JButton begingamebtn;
	BufferedImage splashjpg, deadscreen, winscreen, pausescreen;
	Boolean gamePaused, gamebegun, died;
	Container totalwindow;
	JLabel scorelabel;
	Thread killyou;
	
	
	private InitProjectiles ObjectsInMotionTryingToKillYou;
	private PlayerObject PlayerOne;
	
	//private PlayerObject PlayerOne;
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
		
		//not working
		scorelabel = new JLabel("00000");
		scorelabel.setLocation(1000, 20);
		scorelabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		
		PlayerOne = new PlayerObject();
		//PlayerOne.moveObject(graphicalgui.getGraphics());
		
		//store images
		splashjpg = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/backgorundani.gif"));
		deadscreen = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/splashscreen.jpg"));
		winscreen = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/splashscreen.jpg"));
		pausescreen = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/pausescreen.png"));

		
		gamePaused = false;
		gamebegun = false;
		died = false;
		
		ObjectsInMotionTryingToKillYou = new InitProjectiles("prejectilethread");
		
	}
	
	public void paint(){
		//paints welcomescreen
		if (!gamebegun && !died){
			graphicalgui.setBackground(Color.blue);
			graphicalgui.add(begingamebtn);
		}
		//paints background and beginning screen
		else if(gamebegun && !died){
			graphicalgui.getGraphics().drawImage(splashjpg, 0, 0, null);
			PlayerOne.moveObject(graphicalgui.getGraphics());
		}
				
		totalwindow.add(graphicalgui);
		graphicalgui.requestFocus();
		graphicalgui.addKeyListener(this);
	}			

	//begins game
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == begingamebtn){
			if (!gamebegun){
				gamebegun = true;
				//beginmusic();
				//ObjectsInMotionTryingToKillYou = new InitProjectiles("stuffs");
				begingamebtn.setVisible(false);
				graphicalgui.remove(begingamebtn);
				paint();
				killyou = new Thread(ObjectsInMotionTryingToKillYou);
				killyou.start();

			}
		}
	}
	
	public void keyTyped(KeyEvent evt) {
	//	char pauseevent = evt.getKeyChar();
	//	if (pauseevent == 'p' || pauseevent == 'P') {
	//		if (!died){
	//			if (gamePaused){
	//				gamePaused = false;
	//				ObjectsInMotionTryingToKillYou.notify();
	//				graphicalgui.setFocusable(true);
	//				graphicalgui.requestFocus();
	//			}
	//			else{
	//				gamePaused = true;
	//				try {
	//					ObjectsInMotionTryingToKillYou.wait();
	//				} catch (InterruptedException e) {
	//					System.out.println("Something bad happened");
	//					e.printStackTrace();
	//				}
	//				graphicalgui.setFocusable(false);
	//				graphicalgui.getGraphics().drawImage(pausescreen, 0, 0, null);
	//			}
	//		}
	//	}
	}
	
	//searches for arrowkeys to move player character
	public void keyPressed(KeyEvent evt) {
		
		int key = evt.getKeyCode();
		
		//moves player left
		if (key == KeyEvent.VK_LEFT) {
			if (!gamePaused && !died){
				//moves player left
				PlayerOne.incLeft();
				//checks for collisions
				died = ObjectsInMotionTryingToKillYou.HazardObjects.checkCollisions(PlayerOne.getx(), PlayerOne.gety());
				//ends game if necessary
				if (died) endGame();
				if (ObjectsInMotionTryingToKillYou.timesrun == 1000) endGame();
				//repaints screen
				graphicalgui.getGraphics().drawImage(splashjpg, 0, 0, null);
				ObjectsInMotionTryingToKillYou.HazardObjects.paintObjects(graphicalgui.getGraphics());
				PlayerOne.moveObject(graphicalgui.getGraphics());
				
			}
		}
		
		//moves player right
		if (key == KeyEvent.VK_RIGHT) {
			if (!gamePaused && !died){
				//moves player right
				PlayerOne.incRight();
				//checks for collisions
				died = ObjectsInMotionTryingToKillYou.HazardObjects.checkCollisions(PlayerOne.getx(), PlayerOne.gety());
				//ends game if necessary
				if (died) endGame();
				if (ObjectsInMotionTryingToKillYou.timesrun == 1000) endGame();
				//repaints screen
				graphicalgui.getGraphics().drawImage(splashjpg, 0, 0, null);
				ObjectsInMotionTryingToKillYou.HazardObjects.paintObjects(graphicalgui.getGraphics());
				PlayerOne.moveObject(graphicalgui.getGraphics());
			
			}
		}
		
		//causes the player object to move down
		if (key == KeyEvent.VK_DOWN) {
			if (!gamePaused && !died){
				//moves down
				PlayerOne.incDown();
				//makes sure there hasn't been a collision
				died = ObjectsInMotionTryingToKillYou.HazardObjects.checkCollisions(PlayerOne.getx(), PlayerOne.gety());
				//ends the game if necesary
				if (died) endGame();
				if (ObjectsInMotionTryingToKillYou.timesrun == 1000) endGame();
				//redraws screen
				graphicalgui.getGraphics().drawImage(splashjpg, 0, 0, null);
				ObjectsInMotionTryingToKillYou.HazardObjects.paintObjects(graphicalgui.getGraphics());
				PlayerOne.moveObject(graphicalgui.getGraphics());
				
			}
		}
		
		//causes the player object to move up
		if (key == KeyEvent.VK_UP){
			if (!gamePaused && !died){
				//moves up
				PlayerOne.incUp();
				//makes sure it hasn't collided with anything
				died = ObjectsInMotionTryingToKillYou.HazardObjects.checkCollisions(PlayerOne.getx(), PlayerOne.gety());
				//ends the game if necessary
				if (died) endGame();
				if (ObjectsInMotionTryingToKillYou.timesrun == 1000) endGame();
				//redraws screen
				graphicalgui.getGraphics().drawImage(splashjpg, 0, 0, null);
				ObjectsInMotionTryingToKillYou.HazardObjects.paintObjects(graphicalgui.getGraphics());
				PlayerOne.moveObject(graphicalgui.getGraphics());
				
			}
		}
		
	}
	
	public void endGame(){
		ObjectsInMotionTryingToKillYou.gameover = true;
		//graphicalgui.setFocusable(false);
		System.out.println("You died");
		if (died) graphicalgui.getGraphics().drawImage(deadscreen, 0, 0, null);
		else graphicalgui.getGraphics().drawImage(winscreen, 0, 0, null);
		died = true;
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
		//manage exceptions/problems
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}
