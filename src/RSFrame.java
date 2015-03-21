// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 


import java.awt.*;

//note of change
final class RSFrame extends Frame {

	private static final long serialVersionUID = 1L;
	
	public RSFrame(RSApplet RSApplet_, int i, int j) {
		rsApplet = RSApplet_;
		setTitle("Rune Republic");		
		setVisible(true);
		toFront();
		setSize(i + 8, j + 28);
		setResizable(client.clientSize == 0 ? false : true);
		setLocationRelativeTo(null);
	}
	
	public RSFrame(RSApplet rsapplet, int width, int height, boolean undecorative, boolean resizable) {
		rsApplet = rsapplet;
		setTitle("Rune Republic");		
		setUndecorated(undecorative);
		setBackground(Color.BLACK);
		setVisible(true);
		requestFocus();
		toFront();
		setResizable(client.clientSize == 0 ? false : true); 
		setFocusTraversalKeysEnabled(false);
		toFront();
		Insets insets = getInsets();
		setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);
		setLocationRelativeTo(null);
	}

	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		Insets insets = this.getInsets();
		g.translate(insets.left ,insets.top);
		return g;
	}
	
	public int getFrameWidth() {
		Insets insets = this.getInsets();
		return getWidth() - (insets.left + insets.right);
	}
	
	public int getFrameHeight() {
		Insets insets = this.getInsets();
		return getHeight() - (insets.top + insets.bottom);
	}

	public void update(Graphics g) {
		rsApplet.update(g);
	}

	public void paint(Graphics g) {
		rsApplet.paint(g);
	}

	private final RSApplet rsApplet;
	public Toolkit toolkit = Toolkit.getDefaultToolkit();
	public Dimension screenSize = toolkit.getScreenSize();
	public int screenWidth = (int)screenSize.getWidth();
	public int screenHeight = (int)screenSize.getHeight();
}

//final class RSFrame extends Frame {
//
//	public RSFrame(RSApplet RSApplet_, int i, int j) {
//		rsApplet = RSApplet_;
//		setTitle("Jagex");
//		setResizable(false);
//		// show(); //deprecated
//		setVisible(true);
//		toFront();
//		// resize(i + 8, j + 28); //deprecated
//		setSize(i + 8, j + 28);
//	}
//
//	public Graphics getGraphics() {
//		Graphics g = super.getGraphics();
//		g.translate(4, 24);
//		return g;
//	}
//
//	public void update(Graphics g) {
//		rsApplet.update(g);
//	}
//
//	public void paint(Graphics g) {
//		rsApplet.paint(g);
//	}
//
//	private final RSApplet rsApplet;
//}
