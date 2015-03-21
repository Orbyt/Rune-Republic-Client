import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

import java.awt.EventQueue;
public class Launcher extends JWindow {

	/**
	 * Splash screen duration (milliseconds).
	 */
	private int splashDuration = 500;
	private String verison = "11.1.5";
	/**
	 * Splash screen image.
	 */
	public String fileName = "splash.gif";

	/**
	 * Shows splash screen in the center of desktop.
	 */
	public void showTos() {
		javax.swing.JFrame jf = new javax.swing.JFrame("tmp");
		jf.setLocation(600, 400);
		jf.setVisible(true);
		jf.setAlwaysOnTop(true);
		Jframe frame = Jframe.getInstance();
		jf.dispose();
	}

	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		Image img = new ImageIcon(fileName).getImage();
//		Image img;
/**		try {
			img = ImageIO.read(new File("splash.gif"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
*/	//	}
		int width = img.getWidth(null);
		int height = img.getHeight(null);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		JLabel label = new JLabel(new ImageIcon(fileName));
		content.setOpaque(false);
		label.setOpaque(false);
		content.add(label, BorderLayout.CENTER);
		setVisible(true);
		

		/* Plays a sound at startup? */
		// new AePlayWave("john.wav").start();

		/**
		 * Sleep can be replaced with various loadings.
		 */
		try {
			Thread.sleep(splashDuration);
		} catch (Exception e) {
		}
		setVisible(false);
	    showTos();
	    

	}

	/**
	 * Starts splash screen.
	 */
	public static void main(String[] args) {
		//Launcher splash = new Launcher();
		Launcher splash = new Launcher();
		splash.showSplash();
	}

	private boolean needUpdate() {
		return false;
	}

}