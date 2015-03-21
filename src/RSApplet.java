// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

//note of change
public class RSApplet extends Applet implements Runnable, MouseListener,
		MouseMotionListener, FocusListener, WindowListener, KeyListener,
		MouseWheelListener {

	public boolean invSelected = true;
	public boolean isApplet;
//	
//	final void createClientFrame(int w, int h) {
//		isApplet = false;
//		myWidth = w;
//		myHeight = h;
//		gameFrame = new RSFrame(this, myWidth, myHeight, client.clientSize == 2, client.clientSize == 1);
//		gameFrame.setFocusTraversalKeysEnabled(false);
//		graphics = getGameComponent().getGraphics();
//		fullGameScreen = new RSImageProducer(myWidth, myHeight, getGameComponent());
//		startRunnable(this, 1);
//	}
//	
// old method, new method is ^	
	
	/*
	 * LOL this might not even be used. Commented out to test, but this does not occur anywhere else in the code.
	 */
	
//	final void createClientFrame(int i, int j) {
//		myWidth = j;
//		myHeight = i;
//		gameFrame = new RSFrame(this, myWidth, myHeight);
//		graphics = getGameComponent().getGraphics();
//		fullGameScreen = new RSImageProducer(myWidth, myHeight,
//				getGameComponent());
//		startRunnable(this, 1);
//	}

	public void rebuildFrame(boolean undecorated, int width, int height, boolean resizable, boolean full) {
		boolean createdByApplet = (isApplet && !full);
		myWidth = width;
		myHeight = height;
		if(gameFrame != null) {
			gameFrame.dispose();
		}
		if (!createdByApplet){
			gameFrame = new RSFrame(this, width, height, undecorated, resizable);
			gameFrame.addWindowListener(this);
		}
		graphics = (createdByApplet ? this : gameFrame).getGraphics();
		if (!createdByApplet) {
			getGameComponent().addMouseWheelListener(this);
			getGameComponent().addMouseListener(this);
			getGameComponent().addMouseMotionListener(this);
			getGameComponent().addKeyListener(this);
			getGameComponent().addFocusListener(this);
		}
	}
	
	/*
	 * Use this to get chatbox scrolling to work in FS and RS
	 */
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches = e.getWheelRotation();
		if (mouseX > 0 && mouseY > 340 && mouseX < 510 && mouseY < 500) {// Chatbox
			client.anInt1089 -= notches * 30;
		}
		if (mouseY > 210 && mouseY < 473 && mouseX > 514 && mouseX < 762) {// Invertory
			if (client.tabInterfaceIDs[client.tabID] == 638)
				RSInterface.interfaceCache[639].scrollPosition += notches * 30;
		}
		if (mouseX > 0 && mouseX < 512 && mouseY > 0 && mouseY < 334) {// Ingame
			if (client.openInterfaceID == 5292)
				RSInterface.interfaceCache[5385].scrollPosition += notches * 30;
		}
	}

//	final void initClientFrame(int w, int h) {
//		isApplet = true;
//		myWidth = w;
//		myHeight = h;
//		graphics = getGameComponent().getGraphics();
//		fullGameScreen = new RSImageProducer(myWidth, myHeight, getGameComponent());
//		startRunnable(this, 1);
//	}
//	
// old method, new method ^	
	final void initClientFrame(int width, int height) {
		myWidth = width;
		myHeight = height;
		graphics = getGameComponent().getGraphics();
		fullGameScreen = new RSImageProducer(myWidth, myHeight,
				getGameComponent());
				startRunnable(this, 1);
	}

	public void run() {
		oldClick = System.currentTimeMillis();
		getGameComponent().addMouseWheelListener(this);
		getGameComponent().addMouseListener(this);
		getGameComponent().addMouseMotionListener(this);
		getGameComponent().addKeyListener(this);
		getGameComponent().addFocusListener(this);
		if (gameFrame != null)
			gameFrame.addWindowListener(this);
		drawLoadingText(0, "Loading...");
		startUp();
		int i = 0;
		int j = 256;
		int k = 1;
		int i1 = 0;
		int j1 = 0;
		for (int k1 = 0; k1 < 10; k1++)
			aLongArray7[k1] = System.currentTimeMillis();

		long l = System.currentTimeMillis();
		while (anInt4 >= 0) {
			if (anInt4 > 0) {
				anInt4--;
				if (anInt4 == 0) {
					exit();
					return;
				}
			}
			int i2 = j;
			int j2 = k;
			j = 300;
			k = 1;
			long l1 = System.currentTimeMillis();
			if (aLongArray7[i] == 0L) {
				j = i2;
				k = j2;
			} else if (l1 > aLongArray7[i])
				j = (int) ((long) (2560 * delayTime) / (l1 - aLongArray7[i]));
			if (j < 25)
				j = 25;
			if (j > 256) {
				j = 256;
				k = (int) ((long) delayTime - (l1 - aLongArray7[i]) / 10L);
			}
			if (k > delayTime)
				k = delayTime;
			aLongArray7[i] = l1;
			i = (i + 1) % 10;
			if (k > 1) {
				for (int k2 = 0; k2 < 10; k2++)
					if (aLongArray7[k2] != 0L)
						aLongArray7[k2] += k;

			}
			if (k < minDelay)
				k = minDelay;
			try {
				Thread.sleep(k);
			} catch (InterruptedException _ex) {
				j1++;
			}
			for (; i1 < 256; i1 += j) {
				clickMode3 = clickMode1;
				saveClickX = clickX;
				saveClickY = clickY;
				aLong29 = clickTime;
				clickMode1 = 0;
				processGameLoop();
				readIndex = writeIndex;
			}

			i1 &= 0xff;
			if (delayTime > 0)
				fps = (1000 * j) / (delayTime * 256);
			processDrawing();
			if (shouldDebug) {
				System.out.println("ntime:" + l1);
				for (int l2 = 0; l2 < 10; l2++) {
					int i3 = ((i - l2 - 1) + 20) % 10;
					System.out.println("otim" + i3 + ":" + aLongArray7[i3]);
				}

				System.out.println("fps:" + fps + " ratio:" + j + " count:"
						+ i1);
				System.out.println("del:" + k + " deltime:" + delayTime
						+ " mindel:" + minDelay);
				System.out.println("intex:" + j1 + " opos:" + i);
				shouldDebug = false;
				j1 = 0;
			}
		}
		if (anInt4 == -1)
			exit();
	}

	private void exit() {
		anInt4 = -2;
		cleanUpForQuit();
		if (gameFrame != null) {
			try {
				Thread.sleep(1000L);
			} catch (Exception _ex) {
			}
			try {
				System.exit(0);
			} catch (Throwable _ex) {
			}
		}
	}

	final void method4(int i) {
		delayTime = 1000 / i;
	}

	public final void start() {
		if (anInt4 >= 0)
			anInt4 = 0;
	}

	public final void stop() {
		if (anInt4 >= 0)
			anInt4 = 4000 / delayTime;
	}

	public final void destroy() {
		anInt4 = -1;
		try {
			Thread.sleep(5000L);
		} catch (Exception _ex) {
		}
		if (anInt4 == -1)
			exit();
	}

	public final void update(Graphics g) {
		if (graphics == null)
			graphics = g;
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	public final void paint(Graphics g) {
		if (graphics == null)
			graphics = g;
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	public long oldClick;

	public final void mousePressed(MouseEvent mouseevent) {
		// if(System.currentTimeMillis() - oldClick >= 700){
		// oldClick = System.currentTimeMillis();
		int xPos = client.getClientSize() == 1 ? mouseevent.getX() : mouseevent.getX();
		int yPos = client.getClientSize() == 1 ? mouseevent.getY() : mouseevent.getY();
		if (client.getClientSize() == 2) {
			xPos -= xOffset - 6;
			yPos += yOffset;
		}
		if (gameFrame != null) {
			xPos -= 4;
			yPos -= 22;
		}
	
		idleTime = 0;
		clickX = xPos;
		clickY = yPos;
		clickTime = System.currentTimeMillis();
		if (mouseevent.isMetaDown()) {
			clickMode1 = 2;
			clickMode2 = 2;
		} else {
			clickMode1 = 1;
			clickMode2 = 1;
		}
		// }

	}

	public final void mouseReleased(MouseEvent mouseevent) {
		idleTime = 0;
		clickMode2 = 0;
	}

	public final void mouseClicked(MouseEvent mouseevent) {
	}

	public final void mouseEntered(MouseEvent mouseevent) {
	}

	public final void mouseExited(MouseEvent mouseevent) {
		idleTime = 0;
		mouseX = -1;
		mouseY = -1;
	}

	public final void mouseDragged(MouseEvent mouseevent) {
		int xPos = client.getClientSize() == 1 ? mouseevent.getX() - 3 : mouseevent.getX();
		int yPos = client.getClientSize() == 1 ? mouseevent.getY() - 7 : mouseevent.getY();
		if (client.getClientSize() == 2) {
			xPos -= xOffset - 6;
			yPos += yOffset;					
		}
		if (gameFrame != null) {
			xPos -= 4;
			yPos -= 22;
		}
		if (System.currentTimeMillis() - clickTime >= 30L){
			if(Math.abs(saveClickX - xPos) > 5 || Math.abs(saveClickY - yPos) > 5) {
				idleTime = 0;
				mouseX = xPos;
				mouseY = yPos;
			} else {
				if(invSelected){
					if(xPos > 554 && xPos < 732 && yPos > 213 && yPos < 453){
						mousePressed(mouseevent);
						//System.out.println(i + " - " + j);
					}
				}
			}
		}
		
	}

	public final void mouseMoved(MouseEvent mouseevent) {
		int xPos = client.getClientSize() == 1 ? mouseevent.getX() - 3 : mouseevent.getX();
		int yPos = client.getClientSize() == 1 ? mouseevent.getY() - 7 : mouseevent.getY();
		if (client.getClientSize() == 2) {
			xPos -= xOffset - 6;
			yPos += yOffset;
		} 
		if (gameFrame != null) {
			xPos -= 4;
			yPos -= 22;
		}
		if (System.currentTimeMillis() - clickTime >= 20L){
				idleTime = 0;
				mouseX = xPos;
				mouseY = yPos;
		}
	}

	public final void keyPressed(KeyEvent keyevent) {
		idleTime = 0;
		int i = keyevent.getKeyCode();
		int j = keyevent.getKeyChar();
		if (i == KeyEvent.VK_INSERT) {
			takeScreenshot(true);
		}
		if ((keyevent.isControlDown() && keyevent.getKeyCode() == KeyEvent.VK_V)) {
			client.inputString += client.getClipboardContents();
			client.inputTaken = true;
		}
		if ((keyevent.isControlDown() && keyevent.getKeyCode() == KeyEvent.VK_X)) {
			client.setClipboardContents(client.inputString);
			client.inputString = "";
			client.inputTaken = true;
		}
		if (i == KeyEvent.VK_ESCAPE) {
			client.needDrawTabArea = true;
			client.tabID = 0;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F1) {
			client.needDrawTabArea = true;
			invSelected = true;
			client.tabID = 3;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F2) {
			client.needDrawTabArea = true;
			client.tabID = 4;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F3) {
			client.needDrawTabArea = true;
			client.tabID = 5;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F4) {
			client.needDrawTabArea = true;
			client.tabID = 6;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F5) {
			client.needDrawTabArea = true;
			client.tabID = 0;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F6) {
			client.needDrawTabArea = true;
			client.tabID = 6;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F7) {
			client.needDrawTabArea = true;
			client.tabID = 8;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F8) {
			client.needDrawTabArea = true;
			client.tabID = 9;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F9) {
			client.needDrawTabArea = true;
			client.tabID = 10;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F10) {
			client.needDrawTabArea = true;
			client.tabID = 11;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F11) {
			client.needDrawTabArea = true;
			client.tabID = 12;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (i == KeyEvent.VK_F12) {
			client.needDrawTabArea = true;
			client.tabID = 13;
			invSelected = false;
			client.tabAreaAltered = true;
		}
		if (j < 30)
			j = 0;
		if (i == 37)
			j = 1;
		if (i == 39)
			j = 2;
		if (i == 38)
			j = 3;
		if (i == 40)
			j = 4;
		if (i == 17)
			j = 5;
		if (i == 8)
			j = 8;
		if (i == 127)
			j = 8;
		if (i == 9)
			j = 9;
		if (i == 10)
			j = 10;
		if (i >= 112 && i <= 123)
			j = (1008 + i) - 112;
		if (i == 36)
			j = 1000;
		if (i == 35)
			j = 1001;
		if (i == 33)
			j = 1002;
		if (i == 34)
			j = 1003;
		if (j > 0 && j < 128)
			keyArray[j] = 1;
		if (j > 4) {
			charQueue[writeIndex] = j;
			writeIndex = writeIndex + 1 & 0x7f;
		}
	}

	public final void keyReleased(KeyEvent keyevent) {
		idleTime = 0;
		int i = keyevent.getKeyCode();
		char c = keyevent.getKeyChar();
		if (c < '\036')
			c = '\0';
		if (i == 37)
			c = '\001';
		if (i == 39)
			c = '\002';
		if (i == 38)
			c = '\003';
		if (i == 40)
			c = '\004';
		if (i == 17)
			c = '\005';
		if (i == 8)
			c = '\b';
		if (i == 127)
			c = '\b';
		if (i == 9)
			c = '\t';
		if (i == 10)
			c = '\n';
		if (c > 0 && c < '\200')
			keyArray[c] = 0;
	}

	public final void keyTyped(KeyEvent keyevent) {
	}

	final int readChar(int dummy) {
		while (dummy >= 0) {
			for (int j = 1; j > 0; j++)
				;
		}
		int k = -1;
		if (writeIndex != readIndex) {
			k = charQueue[readIndex];
			readIndex = readIndex + 1 & 0x7f;
		}
		return k;
	}

	public final void focusGained(FocusEvent focusevent) {
		awtFocus = true;
		shouldClearScreen = true;
		raiseWelcomeScreen();
	}

	public final void focusLost(FocusEvent focusevent) {
		awtFocus = false;
		for (int i = 0; i < 128; i++)
			keyArray[i] = 0;

	}

	public final void windowActivated(WindowEvent windowevent) {
	}

	public final void windowClosed(WindowEvent windowevent) {
	}

	public final void windowClosing(WindowEvent windowevent) {
		destroy();
	}

	public final void windowDeactivated(WindowEvent windowevent) {
	}

	public final void windowDeiconified(WindowEvent windowevent) {
	}

	public final void windowIconified(WindowEvent windowevent) {
	}

	public final void windowOpened(WindowEvent windowevent) {
	}

	void startUp() {
	}

	void processGameLoop() {
	}

	void cleanUpForQuit() {
	}

	void processDrawing() {
	}

	void raiseWelcomeScreen() {
	}

	Component getGameComponent() {
		if (gameFrame != null)
			return gameFrame;
		else
			return this;
	}

	public void startRunnable(Runnable runnable, int priority) {
		Thread thread = new Thread(runnable);
		thread.start();
		thread.setPriority(priority);
	}

	void drawLoadingText(int i, String s) {
		while (graphics == null) {
			graphics = getGameComponent().getGraphics();
			try {
				getGameComponent().repaint();
			} catch (Exception _ex) {
			}
			try {
				Thread.sleep(1000L);
			} catch (Exception _ex) {
			}
		}
		Font font = new Font("Helvetica", 1, 13);
		FontMetrics fontmetrics = getGameComponent().getFontMetrics(font);
		Font font1 = new Font("Helvetica", 0, 13);
		getGameComponent().getFontMetrics(font1);
		if (shouldClearScreen) {
			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, myWidth, myHeight);
			shouldClearScreen = false;
		}
		Color color = new Color(0,0,153); //starting loading bar color, currently blue
		int j = myHeight / 2 - 18;
		graphics.setColor(color);
		graphics.drawRect(myWidth / 2 - 152, j, 304, 34);
		graphics.fillRect(myWidth / 2 - 150, j + 2, i * 3, 30);
		graphics.setColor(Color.black);
		graphics.fillRect((myWidth / 2 - 150) + i * 3, j + 2, 300 - i * 3, 30);
		graphics.setFont(font);
		graphics.setColor(Color.white);
		graphics.drawString(s, (myWidth - fontmetrics.stringWidth(s)) / 2,
				j + 22);
	}

	RSApplet() {
		delayTime = 20;
		minDelay = 1;
		aLongArray7 = new long[10];
		shouldDebug = false;
		shouldClearScreen = true;
		awtFocus = true;
		keyArray = new int[128];
		charQueue = new int[128];
	}

	/*
	 * public JDialog createFileChooserDialog(JFileChooser jfilechooser, String
	 * s, Container container) { //JDialog jdialog = new JDialog(Jframe, s,
	 * true); jdialog.setDefaultCloseOperation(2); jdialog.add(jfilechooser);
	 * jdialog.pack(); jdialog.setLocationRelativeTo(container); return jdialog;
	 * }
	 */

	public void takeScreenshot(boolean flag) {
		BufferedImage bufferedimage;
		try {
			Robot robot = new Robot();
			Point point = getLocationOnScreen();
			Rectangle rectangle = new Rectangle(point.x, point.y, getWidth(),
					getHeight());
			bufferedimage = robot.createScreenCapture(rectangle);
		} catch (Throwable throwable) {
			// JOptionPane.showMessageDialog(frame,
			// "An error occured while trying to create a screenshot!",
			// "Screenshot Error", 0);
			return;
		}
		String s = null;
		try {
			s = getNearestScreenshotFilename();
		} catch (IOException ioexception) {
			if (flag) {
				// JOptionPane.showMessageDialog(frame,
				// "A screenshot directory does not exist, and could not be created!",
				// "No Screenshot Directory", 0);
				return;
			}
		}
		if (s == null && flag) {
			// JOptionPane.showMessageDialog(frame,
			// "There are too many screenshots in the screenshot directory!\n"+"Delete some screen\n"
			// +"shots and try again." , "Screenshot Directory Full", 0);
			return;
		}
		if (!flag) {
			final JFileChooser fileChooser = new JFileChooser();
			// final JDialog fileDialog = createFileChooserDialog(fileChooser,
			// "Save Screenshot", this);
			final BufferedImage si = bufferedimage;
			JFileChooser _tmp = fileChooser;
			fileChooser.setFileSelectionMode(0);
			fileChooser.addChoosableFileFilter(new imageFileFilter());
			fileChooser.setCurrentDirectory(new File("./Screenshots/"));
			fileChooser.setSelectedFile(new File(s));
			JFileChooser _tmp1 = fileChooser;
			fileChooser.setDialogType(1);
			fileChooser.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent actionevent) {
					/*
					 * String s1 = actionevent.getActionCommand();
					 * if(s1.equals("ApproveSelection")) { File file =
					 * fileChooser.getSelectedFile(); if(file != null &&
					 * file.isFile()) { int i =
					 * 1;//JOptionPane.showConfirmDialog(frame, (new
					 * StringBuilder()).append(file.getAbsolutePath()).append(
					 * " already exists.\n"
					 * +"Do you want to replace it?").toString(),
					 * "Save Screenshot", 2); if(i != 0) { return; } } try {
					 * ImageIO.write(si, "png", file); } catch(IOException
					 * ioexception2) { //JOptionPane.showMessageDialog(frame,
					 * "An error occured while trying to save the screenshot!\n"
					 * +"Please make sure you have\n"+
					 * " write access to the screenshot directory." ,
					 * "Screenshot Error", 0); } //fileDialog.dispose(); } else
					 * if(s1.equals("CancelSelection")) {
					 * //fileDialog.dispose(); }
					 */
				}

				{
				}
			});
			// fileDialog.setVisible(true);
		} else {
			try {
				ImageIO.write(bufferedimage, "png", new File(
						(new StringBuilder()).append("./Screenshots/")
								.append(s).toString()));
			} catch (IOException ioexception1) {
				// JOptionPane.showMessageDialog(frame,
				// "An error occured while trying to save the screenshot!\n"+"Please make sure you have\n"+" write access to the screenshot directory."
				// , "Screenshot Error", 0);
			}
		}
	}

	public static String getNearestScreenshotFilename() throws IOException {
		File file = new File("./Screenshots/");
		int i = 0;
		do {
			String s = "RR .png";
			if (i < 10) {
				s = s.replaceFirst(" ", (new StringBuilder()).append(" 000")
						.append(i).toString());
			} else if (i < 100) {
				s = s.replaceFirst(" ", (new StringBuilder()).append(" 00")
						.append(i).toString());
			} else if (i < 1000) {
				s = s.replaceFirst(" ", (new StringBuilder()).append(" 0")
						.append(i).toString());
			} else if (i < 10000) {
				s = s.replaceFirst(" ", (new StringBuilder()).append(" ")
						.append(i).toString());
			}
			if ((new File(file, s)).isFile()) {
				i++;
			} else {
				return s;
			}
		} while (i < 10000);
		return null;
	}

	class imageFileFilter extends FileFilter {

		imageFileFilter() {
		}

		public boolean accept(File file) {
			String s = file.getName();
			return file.isDirectory() || s.toLowerCase().endsWith(".png")
					&& s.indexOf("$") == -1;
		}

		public void setToolTipText(String text) {
		}

		public String getDescription() {
			return "PNG (*.png)";
		}
	}

	private int anInt4;
	private int delayTime;
	int minDelay;
	private final long[] aLongArray7;
	int fps;
	boolean shouldDebug;
	int myWidth;
	int myHeight;
	Graphics graphics;
	RSImageProducer fullGameScreen;
	RSFrame gameFrame;
	private boolean shouldClearScreen;
	boolean awtFocus;
	int idleTime;
	int clickMode2;
	public int mouseX;
	public int mouseY;
	private int clickMode1;
	private int clickX;
	private int clickY;
	private long clickTime;
	int clickMode3;
	int saveClickX;
	int saveClickY;
	long aLong29;
	final int[] keyArray;
	public final int[] charQueue;
	private int readIndex;
	public int writeIndex;
	public static int anInt34;
	public int xOffset = 2;
	public int yOffset = 22;
	int clientSize = client.getClientSize();
}
