import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.sound.sampled.DataLine.Info;
import javax.swing.*;

import org.pscode.xui.sound.bigclip.BigClip;


public class PlayingtheGame extends JFrame 
	implements KeyListener, ActionListener {
		
	JPanel graphicalgui;
	JButton begingamebtn;
	Image splashjpg;
	
	public static void main(String[] args){
		//init sound for later
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
		begingamebtn.addActionListener(this);
		graphicalgui.add(begingamebtn);
		


		
	}
	
	public void prepaint() throws IOException{
		graphicalgui.removeAll();
		graphicalgui.setBackground(Color.cyan);
		//try {
		//	splashjpg = ImageIO.read(new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/splashscreen.jpg"));
		//} catch (IOException e) {
		//	System.out.println("Splash page file not found");
		//}
		
		   try {
		         File soundfile = new File("/Users/annelies/gitrepositories/APCompSci_Term2finalproject/flyinggame/gamebackgroundmusic.wav");
		         AudioInputStream sound = AudioSystem.getAudioInputStream(soundfile);
		         BigClip clip = new BigClip();
		         //DataLine.Info info = new DataLine.Info(PlayingtheGame.class, sound.getFormat());
		         //Clip clip = (Clip) AudioSystem.getLine(info);
		         clip.open(sound);
		         clip.loop(Clip.LOOP_CONTINUOUSLY);
		      } catch (UnsupportedAudioFileException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         e.printStackTrace();
		      }
		
		//play music



		System.out.println("AUDIO SHOULDN'T BE OVER.");
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
					try {
						prepaint();
					} catch (IOException e) {
						System.out.println("Bad things happened");
					}
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
