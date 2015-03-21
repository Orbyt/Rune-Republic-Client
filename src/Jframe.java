import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.text.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.lang.reflect.*;
import java.security.*;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jvnet.substance.skin.*;

public class Jframe extends client implements ActionListener, WindowListener {

	private static JMenuItem menuItem, submenu;
	private JFrame frame;
	private boolean ircShowed = false;
	private String hosted = "runerepublic.com";
	private int ported = 6667;
	public static int port = 43594;
	private JPanel gamePanel;

	 private static Jframe INSTANCE = null;

  private Jframe() {
  	super();
		try {
			sign.signlink.startpriv(InetAddress.getByName(server));
			initUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
  }


  synchronized public static final Jframe getInstance() {
    if (INSTANCE == null) {
      AccessController.doPrivileged(new PrivilegedAction<Object>() {
        public Object run() {
          INSTANCE = new Jframe();
          return INSTANCE;
        }
      });
    }
    return INSTANCE;
  }

	public void initUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			JFrame.setDefaultLookAndFeelDecorated(true);
			JFrame.setDefaultLookAndFeelDecorated(true);
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			gamePanel = new JPanel();

			frame = new JFrame(frameTitle);
			frame.setLayout(new BorderLayout());
			frame.setResizable(true); //tag1 false to true
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gamePanel.setLayout(new BorderLayout());

			gamePanel.add(this);
			gamePanel.setPreferredSize(new Dimension(900, 600)); //tag1 765, 503 to  current

			JMenuBar menuBar = new JMenuBar();
			JMenu fileMenu = new JMenu("File");
			JMenu ClientMenu = new JMenu("Client Themes");
			JMenu SitesMenu = new JMenu("Sites");
			// JMenu GuideMenu = new JMenu("Server Guides");
			// JMenu othermenu = new JMenu("Worlds");
			JMenu accountmenu = new JMenu("Game Settings");
			// JMenu botsmenu = new JMenu("Bots");
			JButton shotMenu = new JButton("Screenshot(or INSERT key)");
			// JButton ircShow = new JButton("Show IRC");
			JCheckBox chk = new JCheckBox("Always On Top");
			// JCheckBox dchk = new JCheckBox("High Detail");
			shotMenu.setActionCommand("Screenshot");
			shotMenu.addActionListener(this);
			frame.getContentPane().setBackground(Color.black);
			gamePanel.setBackground(Color.black);
			// panel.setBackground(Color.black);
			frame.add(chk);
			chk.setActionCommand("Always On Top");
			chk.setSelected(false);
			chk.addActionListener(this);
			// frame.add(dchk);
			// dchk.setActionCommand("High Detail");
			// dchk.setSelected(false);
			// dchk.addActionListener(this);

			String[] ClientButtons = new String[] { "Red", "Blue", "Black",
					"White", "Green", "Grey" };
			String[] otherButtons = new String[] { "World 1", "World 2" };
			String[] accountButtons = new String[] {
					"New Hit Splats & x10 Damage", "HP Above Heads On/Off",
					"New HP Bar On/Off", "Player Names On/Off", "FPS",
					"Coordinates", "Save account", "Reset" };
			String[] botsButtons = new String[] { "Auto talker On",
					"Auto Talker Off" };
			String[] SitesButtons = new String[] { "Rune Republic Forums",
					"Youtube", "Server Wiki (Guides)",
					"Vote For RR", "Report a bug!", };
			String[] GuideButtons = new String[] { "Server Guides" };
			String[] mainButtons = new String[] { "Quit" };
			for (String name : mainButtons) {
				JMenuItem menuItem = new JMenuItem(name);
				if (name.equalsIgnoreCase("-"))
					fileMenu.addSeparator();
				else {
					menuItem.addActionListener(this);
					fileMenu.add(menuItem);
				}
			}
			for (String name : accountButtons) {
				JMenuItem menuItem = new JMenuItem(name);
				if (name.equalsIgnoreCase("-"))
					accountmenu.addSeparator();
				else {
					menuItem.addActionListener(this);
					accountmenu.add(menuItem);
				}
			}
			for (String name : ClientButtons) {
				JMenuItem menuItem = new JMenuItem(name);
				if (name.equalsIgnoreCase("-"))
					ClientMenu.addSeparator();
				else {
					menuItem.addActionListener(this);
					ClientMenu.add(menuItem);
				}
			}
			/*
			 * for (String name : GuideButtons){ JMenuItem menuItem = new
			 * JMenuItem(name); if (name.equalsIgnoreCase("-"))
			 * GuideMenu.addSeparator(); else {
			 * menuItem.addActionListener(this); GuideMenu.add(menuItem); } }
			 * for (String name : botsButtons) { JMenuItem menuItem = new
			 * JMenuItem(name); if (name.equalsIgnoreCase("-"))
			 * botsmenu.addSeparator(); else { menuItem.addActionListener(this);
			 * botsmenu.add(menuItem); } }
			 */
			for (String name : SitesButtons) {
				JMenuItem menuItem = new JMenuItem(name);
				if (name.equalsIgnoreCase("-"))
					SitesMenu.addSeparator();
				else {
					menuItem.addActionListener(this);
					SitesMenu.add(menuItem);
				}
			}

			menuBar.add(fileMenu);
			menuBar.add(ClientMenu);
			menuBar.add(SitesMenu);
			// menuBar.add(GuideMenu);
			// menuBar.add(othermenu);
			menuBar.add(accountmenu);
			// menuBar.add(botsmenu);
			menuBar.add(shotMenu);
			// menuBar.add(ircShow);
			menuBar.add(chk);

			/*
			 * panel = new NRIRC(hosted,ported,frame); Toolkit theKit =
			 * java.awt.Toolkit.getDefaultToolkit(); Dimension dm =
			 * theKit.getScreenSize(); panel.setBounds(dm.width/6, dm.height/6,
			 * (dm.width*5)/8, // width (dm.height*2)/3+30 // height );
			 * panel.setBackground(Color.black);
			 * frame.getContentPane().add(panel,BorderLayout.SOUTH);
			 */
	//		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
			frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			init();
			// midiPlayer("Play");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JDialog createFileChooserDialog(JFileChooser jfilechooser, String s,
			Container container) {
		JDialog jdialog = new JDialog(frame, s, true);
		jdialog.setDefaultCloseOperation(2);
		jdialog.add(jfilechooser);
		jdialog.pack();
		jdialog.setLocationRelativeTo(container);
		return jdialog;
	}

	public void takeScreenshot(boolean flag) {
		BufferedImage bufferedimage;
		try {
			Robot robot = new Robot();
			Point point = getLocationOnScreen();
			Rectangle rectangle = new Rectangle(point.x, point.y, getWidth(),
					getHeight());
			bufferedimage = robot.createScreenCapture(rectangle);
		} catch (Throwable throwable) {
			JOptionPane.showMessageDialog(frame,
					"An error occured while trying to create a screenshot!",
					"Screenshot Error", 0);
			return;
		}
		String s = null;
		try {
			s = getNearestScreenshotFilename();
		} catch (IOException ioexception) {
			if (flag) {
				JOptionPane
						.showMessageDialog(
								frame,
								"A screenshot directory does not exist, and could not be created!",
								"No Screenshot Directory", 0);
				return;
			}
		}
		if (s == null && flag) {
			JOptionPane.showMessageDialog(frame,
					"There are too many screenshots in the screenshot directory!\n"
							+ "Delete some screen\n" + "shots and try again.",
					"Screenshot Directory Full", 0);
			return;
		}
		if (!flag) {
			final JFileChooser fileChooser = new JFileChooser();
			final JDialog fileDialog = createFileChooserDialog(fileChooser,
					"Save Screenshot", this);
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
					String s1 = actionevent.getActionCommand();
					if (s1.equals("ApproveSelection")) {
						File file = fileChooser.getSelectedFile();
						if (file != null && file.isFile()) {
							int i = JOptionPane
									.showConfirmDialog(
											frame,
											(new StringBuilder())
													.append(
															file
																	.getAbsolutePath())
													.append(
															" already exists.\n"
																	+ "Do you want to replace it?")
													.toString(),
											"Save Screenshot", 2);
							if (i != 0) {
								return;
							}
						}
						try {
							ImageIO.write(si, "png", file);
							//takingSS = false;
						} catch (IOException ioexception2) {
							JOptionPane
									.showMessageDialog(
											frame,
											"An error occured while trying to save the screenshot!\n"
													+ "Please make sure you have\n"
													+ " write access to the screenshot directory.",
											"Screenshot Error", 0);
						}
						fileDialog.dispose();
					} else if (s1.equals("CancelSelection")) {
						fileDialog.dispose();
					}
				}

				{
				}
			});
			fileDialog.setVisible(true);
		} else {
			try {
				ImageIO.write(bufferedimage, "png", new File(
						(new StringBuilder()).append("./Screenshots/")
								.append(s).toString()));
			} catch (IOException ioexception1) {
				JOptionPane.showMessageDialog(frame,
						"An error occured while trying to save the screenshot!\n"
								+ "Please make sure you have\n"
								+ " write access to the screenshot directory.",
						"Screenshot Error", 0);
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

	public URL getCodeBase() {
		try {
			return new URL("http://" + server + "/cache");
		} catch (Exception e) {
			return super.getCodeBase();
		}
	}

	public URL getDocumentBase() {
		return getCodeBase();
	}

	public void loadError(String s) {
		System.out.println("loadError: " + s);
	}

	public String getParameter(String key) {
		return "";
	}

	/*
	 * private static void openUpWebSite(String url) { Desktop d =
	 * Desktop.getDesktop(); try { d.browse(new URI(url)); } catch (Exception e)
	 * { } }
	 */

	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();
		if (cmd != null) {
			if (cmd.equalsIgnoreCase("Quit")) {
				int i1;
				if ((i1 = JOptionPane.showConfirmDialog(this,
						"Are you sure you want to close the Client?")) == 0)
					System.exit(0);
				return;
			}
			if (cmd.equals("Red")) {
				try {
					UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceFindingNemoLookAndFeel");
				} catch (Exception exception) {
					System.out.println("These buttons are currently not operational");
				}
			}
			if (cmd.equals("Blue")) {
				try { 
					UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceChallengerDeepLookAndFeel");
				} catch (Exception exception) {
					System.out.println("These buttons are currently not operational");
				}
				
			}

			if (cmd.equals("Black")) {
				try { 
					UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");
				} catch (Exception exception) {
					System.out.println("These buttons are currently not operational");
				}
			}
			if (cmd.equals("Green")) {
				try { 
					UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel");
				} catch (Exception exception) {
					System.out.println("These buttons are currently not operational");
				}
			}
			if (cmd.equals("White")) {
				try { 
					UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceCremeLookAndFeel");
				} catch (Exception exception) {
					System.out.println("These buttons are currently not operational");
				}
			}
			if (cmd.equals("Grey")) {
				try { 
					UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceMistSilverLookAndFeel");
				} catch (Exception exception) {
					System.out.println("These buttons are currently not operational");
				}
						 
					 }
			
			}

	//		if (cmd.equals("Black")) {
				// try{UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");}catch(Exception
				// exception){}
	//		}
			/*
			 * if(cmd.equals("Blue")) {try{UIManager.setLookAndFeel(
			 * "org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel"
			 * );}catch(Exception exception){} } if(cmd.equals("Red")) {
			 * try{UIManager
			 * .setLookAndFeel("org.jvnet.substance.skin.SubstanceMagmaLookAndFeel"
			 * );}catch(Exception exception){} } if(cmd.equals("Green")) {
			 * try{UIManager.setLookAndFeel(
			 * "org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel"
			 * );}catch(Exception exception){} } if(cmd.equals("Grey")) {
			 * try{UIManager.setLookAndFeel(
			 * "org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel"
			 * );}catch(Exception exception){} } if(cmd.equals("White")) {
			 * try{UIManager
			 * .setLookAndFeel("org.jvnet.substance.skin.SubstanceCremeLookAndFeel"
			 * );}catch(Exception exception){} }
			 */
			if (cmd.equals("Rune Republic Forums")) {
				launchURL("www.runerepublic.com");
			}
			if (cmd.equals("Youtube")) {
				launchURL("www.youtube.com");
			}
			if (cmd.equals("Report a bug!")) {
				/*
				 * BugReport window = new BugReport();
				 * window.setTitle("Rune Republic Bug Report Form");
				 * window.pack(); window.show(); window.setAlwaysOnTop(true);
				 */}
			if (cmd.equals("Server Wiki (Guides)")) {
				launchURL("www.runerepublic.com");
			}
			if (cmd.equals("Vote For RR")) {
				launchURL("www.runerepublic.com");
			}
			if (cmd.equalsIgnoreCase("Save Settings")) {
	//			UserLoader.saveuser();
				System.out.println("Saving file");

			}
			if (cmd.equalsIgnoreCase("Close Client")) {
				int i1;
				if ((i1 = JOptionPane
						.showConfirmDialog(this,
								"Are you sure you want to close the client?")) == 0)
					System.exit(0);
				return;
			}

			if (cmd.equalsIgnoreCase("off")) {
				autochat(0, null);
			}
			if (cmd.equals("FPS")) {
				fpsOn = !fpsOn;
			}
			if (cmd.equals("Coordinates")) {
				coordinates = !coordinates;
			}
			if (cmd.equals("High Detail")) {

			}
			if (cmd.equals("Always On Top")) {
				if (onTop) {
					frame.setAlwaysOnTop(false);
					onTop = false;
				} else {
					frame.setAlwaysOnTop(true);
					onTop = true;
				}

			}
			if (cmd.equalsIgnoreCase("auto talker on")) {

				settalk = JOptionPane.showInputDialog(null, "Enter Your text",
						"Enter what you want say", 1);
				if (settalk != null && settalk != "") {

					loop = JOptionPane.showInputDialog(null, "Enter a Number",
							"How many times you want loop", 1);
					if (loop != null && loop != "") {

						String h = loop;
						int theloop = Integer.parseInt(h);

						autochat(theloop, settalk);
						autochat = true;

					}
				}
			}

			if (cmd.equalsIgnoreCase("Reset")) {
//				UserLoader.userName = "";
//				UserLoader.password = "";
//				UserLoader.saveuser();
				Setcolour(1, 0x000000, "Name colour reset", "@cr3@");
				Setcolour(2, 0x0000FF, "chat colour reset", "@cr3@");
				setchat(0);
				seteffect(0);
			}

			if (cmd.equalsIgnoreCase("HP Above Heads On/Off")) {
				hpH = !hpH;
				if (hpH) {
					setHpAboveHeads(1);
				} else {
					setHpAboveHeads(0);
				}
		//		UserLoader.saveuser();
			}
			if (cmd.equalsIgnoreCase("New Hit Splats & x10 Damage")) {
				newHits = !newHits;
				if (newHits) {
					setNewHits(1);
				} else {
					setNewHits(0);
				}
	//			UserLoader.saveuser();
			}
			if (cmd.equalsIgnoreCase("New HP Bar On/Off")) {
				newHpBar = !newHpBar;
				if (newHpBar) {
					setNewHpBar(1);
				} else {
					setNewHpBar(0);
				}
	//			UserLoader.saveuser();
			}
			if (cmd.equalsIgnoreCase("Player Names On/Off")) {
				names = !names;
			}
			if (cmd.equalsIgnoreCase("World 1")) {
				port = 43594;
				frameTitle = "Rune Republic Client v7.0.3 - World 1";
				frame.setTitle(frameTitle);
			}
			if (cmd.equalsIgnoreCase("World 2")) {
				port = 43594;
				frameTitle = "Rune Republic Client v7.0.3 - World 2";
				frame.setTitle(frameTitle);
			}
			if (cmd.equalsIgnoreCase("Name color")) {

				setname = JOptionPane.showInputDialog(null,
						"Choose name color ", "Enter a color", 1);
				if (setname != null && setname != "") {
					if (setname.startsWith("red")) {
						Setcolour(1, 0xff0000, "Colour set to red", "@cr3@");
						setname = null;
					} else

					if (setname.startsWith("green")) {
						Setcolour(1, 0x99FF00, "Colour set to green", "@cr3@");
						setname = null;
					} else

					if (setname.startsWith("yellow")) {
						Setcolour(1, 0xFFFF00, "Colour set to yellow", "@cr3@");
						setname = null;
					} else

					if (setname.startsWith("black")) {
						Setcolour(1, 0x000000, "Colour set to black", "@cr3@");
						setname = null;
					} else

					if (setname.startsWith("blue")) {
						Setcolour(1, 0x0000FF, "Colour set to blue", "@cr3@");
						setname = null;
					} else

					if (setname.startsWith("white")) {
						Setcolour(1, 0xFFFFFF, "Colour set to white", "@cr3@");
						setname = null;
					} else

					if (setname.startsWith("pink")) {
						Setcolour(1, 0xFF00FF, "Colour set to pink", "@cr3@");
						setname = null;
					}

				}
			}
			if (cmd.equalsIgnoreCase("chat color")) {
				setchat = JOptionPane.showInputDialog(null,
						"Choose a chat color ", "Enter a color", 1);
				if (setchat != null && setchat != "") {
					if (setchat.startsWith("red")) {
						Setcolour(2, 0xff0000, "Color set to red", "@cr3@");
						setchat = null;
					} else

					if (setchat.startsWith("green")) {
						Setcolour(2, 0x99FF00, "Color set to green", "@cr3@");
						setchat = null;
					} else

					if (setchat.startsWith("yellow")) {
						Setcolour(2, 0xFFFF00, "Color set to yellow", "@cr3@");
						setchat = null;
					} else

					if (setchat.startsWith("black")) {
						Setcolour(2, 0x000000, "Color set to black", "@cr3@");
						setchat = null;
					} else

					if (setchat.startsWith("blue")) {
						Setcolour(2, 0x0000FF, "Color set to blue", "@cr3@");
						setchat = null;
					} else

					if (setchat.startsWith("white")) {
						Setcolour(2, 0xFFFFFF, "Color set to white", "@cr3@");
						setchat = null;
					} else

					if (setchat.startsWith("pink")) {
						Setcolour(2, 0xFF00FF, "Color set to pink", "@cr3@");
						setchat = null;
					}
				}
			}
			if (cmd.equalsIgnoreCase("Chat effects")) {
				setchateffects = JOptionPane.showInputDialog(null,
						"Choose chat effect ", "Enter your effect", 1);
				if (setchateffects != null && setchateffects != "") {

					if (setchateffects.startsWith("yellow")) {
						setchat(0);
						setchateffects = null;
					} else if (setchateffects.startsWith("red")) {
						setchat(1);
						setchateffects = null;
					} else if (setchateffects.startsWith("green")) {
						setchat(2);
						setchateffects = null;
					} else if (setchateffects.startsWith("cyan")) {
						setchat(3);
						setchateffects = null;
					} else if (setchateffects.startsWith("purple")) {
						setchat(4);
						setchateffects = null;
					} else if (setchateffects.startsWith("white")) {
						setchat(5);
						setchateffects = null;
					} else if (setchateffects.startsWith("flash1")) {
						setchat(6);
						setchateffects = null;
					} else if (setchateffects.startsWith("flash2")) {
						setchat(7);
						setchateffects = null;
					} else if (setchateffects.startsWith("flash3")) {
						setchat(8);
						setchateffects = null;
					} else if (setchateffects.startsWith("glow1")) {
						setchat(9);
						setchateffects = null;
					} else if (setchateffects.startsWith("glow2")) {
						setchat(10);
						setchateffects = null;
					} else if (setchateffects.startsWith("glow3")) {
						setchat(11);
						setchateffects = null;
					} else if (setchateffects.startsWith("wave1")) {
						seteffect(1);
						setchateffects = null;
					} else if (setchateffects.startsWith("wave2")) {
						seteffect(2);
						setchateffects = null;
					} else if (setchateffects.startsWith("shake")) {
						seteffect(3);
						setchateffects = null;
					} else if (setchateffects.startsWith("scroll")) {
						seteffect(4);
						setchateffects = null;
					} else if (setchateffects.startsWith("slide")) {
						seteffect(5);
						setchateffects = null;
					} else if (setchateffects.startsWith("reset")) {
						setchat(0);
						seteffect(0);
						setchateffects = null;
					}

				}
			}
			if (cmd.equalsIgnoreCase("Chat Colors Help")) {
				JOptionPane
						.showMessageDialog(
								null,
								"You can use the following colours \nred , yellow , blue , green , pink , white ,black   \nYou can set your  text above your head to the following colurs and effects  \nyellow ,red ,green , cyan , purple , white , flash1 , flash2 , flash3 , glow 1, glow2 , glow3 , wave1, wave2, shake , scroll ,slide and reset");
			}
			if (cmd.equals("Screenshot")) {
				takingSS = true;
				try {
				Thread.sleep(500); // sleep for 1/2 sec
					} catch (Exception _ex) {
				}
				takeScreenshot(true);
				pushMessage("You take a screenshot.", 5, "");
				takingSS = false;
			}
			if (cmd.equals("irc")) {
				/*
				 * if(ircShowed){ panel.setVisible(false); panel.closeAll();
				 * ircShowed = false; } else {
				 * 
				 * panel.setVisible(true); ircShowed = true;
				 * panel.connectStartRegister(); }
				 */
				launchURL("http://www.runerepublic.com");

			}
		}
	//}

	public void launchURL(String s) {
		String s1 = System.getProperty("os.name");
		try {
			if (s1.startsWith("Windows")) {
				Runtime.getRuntime().exec(
						(new StringBuilder()).append(
								"rundll32 url.dll,FileProtocolHandler ")
								.append(s).toString());
			} else {
				String as[] = { "firefox", "opera", "konqueror", "epiphany",
						"mozilla", "netscape", "safari" };
				String s2 = null;
				for (int i = 0; i < as.length && s2 == null; i++)
					if (Runtime.getRuntime().exec(
							new String[] { "which", as[i] }).waitFor() == 0)
						s2 = as[i];

				if (s2 == null)
					throw new Exception("Could not find web browser");
				Runtime.getRuntime().exec(new String[] { s2, s });
			}
		} catch (Exception exception) {
			System.out
					.println("An error occured while trying to open the web browser!\n");
		}
	}

	public static String detail = null;
	int world = 1;
	public static String loop = null;
	public static String settalk = null;
	public static String setchateffects = null;
	public static String setname = null;
	public static String setchat = null;
	public static String Serverip;
	public static double version = 13.0;
	public boolean onTop = false;
	private String frameTitle = "Rune Republic V1";

}

class GlassPane extends JPanel {
	private Point[] points = new Point[4];
	private int index = 0;
	public GlassPane(){
		setSize(900, 600); //tag1 765,503 to current
	}
	public boolean drawRect(Graphics g){
		if(index == 4){
			int width = (points[3].x - points[0].x);
			int height = (points[3].y - points[0].y);
			g.drawRect(points[0].x, points[0].y, width, height);
			return true;
		}
		return false;
	}
	public boolean setPoint(Point p){
		if(index > points.length)
			return false;
		points[index] = p;
		index++;
		repaint();
		System.out.println("drawing");
		return true;
	}
	@Override
	protected void paintComponent(Graphics g) {
	    if (points[0] != null) {
	        g.setColor(Color.red);
	        Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.3f));
            for(Point p : points){
            	if(p == null)
            		continue;
            		g.fillOval(p.x - 10, p.y - 10, 20, 20);
            		System.out.println(p.x + " - " + p.y);
	    	}
            drawRect(g);
	    }
	}
}
	