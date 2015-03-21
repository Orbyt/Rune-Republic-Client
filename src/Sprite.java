// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

import javax.swing.ImageIcon;

import sign.signlink;

public class Sprite extends DrawingArea {
	
	
	/*
	 * Construstor for gif integration
	 */
	public Sprite () {
		
	}
	
	/*
	 * Method for gif integration
	 */
	public void autoUpdate () {
		
	}

	public Sprite(int i, int j) {
		myPixels = new int[i * j];
		myWidth = anInt1444 = i;
		myHeight = anInt1445 = j;
		anInt1442 = anInt1443 = 0;
		setTransparency(255, 0, 255);
	}

	public String location = "./Sprites/";

	public Sprite(byte abyte0[], Component component) {
		try {
			// Image image =
			// Toolkit.getDefaultToolkit().getImage(location+"mopar.jpg");
			Image image = Toolkit.getDefaultToolkit().createImage(abyte0);
			MediaTracker mediatracker = new MediaTracker(component);
			mediatracker.addImage(image, 0);
			mediatracker.waitForAll();
			myWidth = image.getWidth(component);
			myHeight = image.getHeight(component);
			anInt1444 = myWidth;
			anInt1445 = myHeight;
			anInt1442 = 0;
			anInt1443 = 0;
			myPixels = new int[myWidth * myHeight];
			PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, myWidth,
					myHeight, myPixels, 0, myWidth);
			pixelgrabber.grabPixels();
			setTransparency(255, 0, 255);
		} catch (Exception _ex) {
			System.out.println("Error converting jpg");
		}
	}

	public Sprite getSubImage(Sprite sprite, int sX, int sY, int w, int h) {
		try {
			int[] pixels = new int[w * h];
			int pixOn = 0;
			for (int i = sX; i < w; i++) {
				for (int i1 = sY; i1 < h; i1++) {
					int i2 = i - sX;
					int i3 = i1 - sY;
					pixels[i2 + i3 * w] = sprite.myPixels[i + i1
							* sprite.myWidth];
				}
			}
			sprite.myHeight = h - sY;
			sprite.myWidth = w - sX;
			sprite.myPixels = pixels;
			return sprite;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Sprite(String img, int i) {
		ImageIcon imageicon = new ImageIcon(img);
		imageicon.getIconHeight();
		imageicon.getIconWidth();
		try {
			Image image = Toolkit.getDefaultToolkit().createImage(
					FileOperations.ReadFile(img));
			myWidth = imageicon.getIconWidth();
			myHeight = imageicon.getIconHeight();
			anInt1444 = myWidth;
			anInt1445 = myHeight;
			anInt1442 = 0;
			anInt1443 = 0;
			myPixels = new int[myWidth * myHeight];
			PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, myWidth,
					myHeight, myPixels, 0, myWidth);
			pixelgrabber.grabPixels();
			image = null;
			setTransparency(255, 0, 255);
		} catch (Exception _ex) {
			System.out.println(_ex);
		}
	}

	public Sprite(byte spriteData[]) {
		try {
			Image image = Toolkit.getDefaultToolkit().createImage(spriteData);
			ImageIcon sprite = new ImageIcon(image);
			myWidth = sprite.getIconWidth();
			myHeight = sprite.getIconHeight();
			maxWidth = myWidth;
			maxHeight = myHeight;
			anInt1442 = 0;
			anInt1443 = 0;
			myPixels = new int[myWidth * myHeight];
			PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, myWidth,
					myHeight, myPixels, 0, myWidth);
			pixelgrabber.grabPixels();
			image = null;
			setTransparency(255, 0, 255); //original, no others had
		} catch (Exception _ex) {
			System.out.println(_ex);
		}
	}

	public Sprite(String img, int width, int height) {
		try {
			Image image = Toolkit.getDefaultToolkit().getImage(
					location + img + ".png");
			myWidth = width;
			myHeight = height;
			anInt1444 = myWidth;
			anInt1445 = myHeight;
			anInt1442 = 0;
			anInt1443 = 0;
			myPixels = new int[myWidth * myHeight];
			PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, myWidth,
					myHeight, myPixels, 0, myWidth);
			pixelgrabber.grabPixels();
			image = null;
			setTransparency(255, 0, 255);
		} catch (Exception _ex) {
			System.out.println(_ex);
		}
	}

	/*
	 * public Sprite(String img, int width, int height) { try { Image image =
	 * Toolkit.getDefaultToolkit().createImage(FileOperations.ReadFile(img));
	 * myWidth = width; myHeight = height; anInt1444 = myWidth; anInt1445 =
	 * myHeight; anInt1442 = 0; anInt1443 = 0; myPixels = new int[myWidth *
	 * myHeight]; PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0,
	 * myWidth, myHeight, myPixels, 0, myWidth); pixelgrabber.grabPixels();
	 * image = null; } catch(Exception _ex) { System.out.println(_ex); } }
	 */
	public Sprite(String img) {
		try {
			Image image = Toolkit.getDefaultToolkit().getImage(
					location + img + ".png");
			ImageIcon sprite = new ImageIcon(image);
			if (img.equalsIgnoreCase("chatarea")) {
				myWidth = 519;
				myHeight = 165;
			} else if (img.equalsIgnoreCase("chatbuttons")) {
				myWidth = 510;
				myHeight = 22;
			} else if (img.equalsIgnoreCase("chathover")
					|| img.equalsIgnoreCase("chatclickedh")
					|| img.equalsIgnoreCase("chatclicked")) {
				myWidth = 56;
				myHeight = 22;
			} else if (img.equalsIgnoreCase("reporthover")) {
				myWidth = 111;
				myHeight = 22;
			} else if (img.equalsIgnoreCase("tabarea")) {
				myWidth = 246;
				myHeight = 335;
			} else if (img.equalsIgnoreCase("maparea")) {
				myWidth = 246;
				myHeight = 168;
			} else if (img.equalsIgnoreCase("logiconh")
					|| img.equalsIgnoreCase("logiconc")) {
				myWidth = 22;
				myHeight = 21;
			} else if (img.equalsIgnoreCase("mapicon")) {
				myWidth = 33;
				myHeight = 33;
			} else if (img.equalsIgnoreCase("infinity")) {
				myWidth = 33;
				myHeight = 33;
			} else if (img.equalsIgnoreCase("emptyorb")) {
				myWidth = 57;
				myHeight = 34;
			} else if (img.equalsIgnoreCase("hitpointsfill")
					|| img.equalsIgnoreCase("prayerfill")) {
				myWidth = 27;
				myHeight = 27;
			} else if (img.equalsIgnoreCase("hitpointsicon")) {
				myWidth = 16;
				myHeight = 13;
			} else if (img.equalsIgnoreCase("prayericon")) {
				myWidth = 20;
				myHeight = 20;
			} else if (img.equalsIgnoreCase("PRAYERGLOW")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("150")) {
				myWidth = 200;
				myHeight = 200;
			} else if (img.equalsIgnoreCase("150a")) {
				myWidth = 200;
				myHeight = 200;
			} else if (img.equalsIgnoreCase("349")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("349a")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("350a")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("350")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7587")) {
				myWidth = 200;
				myHeight = 200;
			} else if (img.equalsIgnoreCase("7600")) {
				myWidth = 200;
				myHeight = 200;
			} else if (img.equalsIgnoreCase("7601")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7602")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7603")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7604")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7605")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7606")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7607")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7608")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7609")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("7610")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("19301")) {
				myWidth = 300;
				myHeight = 300;
			} else if (img.equalsIgnoreCase("19301a")) {
				myWidth = 300;
				myHeight = 300;
			} else if (img.equalsIgnoreCase("frame")) {
				myWidth = 519;
				myHeight = 338;
			} else if (img.equalsIgnoreCase("tabhover")
					|| img.equalsIgnoreCase("tabclicked")) {
				myWidth = 32;
				myHeight = 37;
			}
			for (int i = 0; i <= 14; i++) {
				if (img.equalsIgnoreCase("icon " + i)) {
					myWidth = 22;
					myHeight = 22;
				}
			}
			if (img.equalsIgnoreCase("Frame1")) {
				myWidth = 4;
				myHeight = 338;
			} else if (img.equalsIgnoreCase("Frame2")) {
				myWidth = 512;
				myHeight = 4;
			} else if (img.equalsIgnoreCase("Frame3")) {
				myWidth = 4;
				myHeight = 338;
			} else if (img.equalsIgnoreCase("MAGIC 1")) {
				myWidth = 22;
				myHeight = 22;
			} else if (img.equalsIgnoreCase("fag")) {
				myWidth = 22;
				myHeight = 22;
			} else if (img.equalsIgnoreCase("multi")) {
				myWidth = 100;
				myHeight = 100;
			} else if (img.equalsIgnoreCase("headhint1")) {
				myWidth = 100;
				myHeight = 100;
			}
			for (int i = 4; i <= 8; i++) {
				if (img.equalsIgnoreCase("SPRITE " + i)) {
					myWidth = 190;
					myHeight = 224;
				}
			}
			for (int i = 1; i <= 9; i++) {
				if (img.equalsIgnoreCase("CUSTOM " + i)) {
					myWidth = 519;
					myHeight = 338;
				}
			}
			for (int i = 0; i <= 10; i++) {
				if (img.equalsIgnoreCase("MOD_ICONS " + i)) {
					myWidth = 33;
					myHeight = 33;
				}
			}
			for (int i = 0; i <= 42; i++) {
				if (img.equalsIgnoreCase("SPRITE " + i)) {
					myWidth = 190;
					myHeight = 224;
				}
			}
			for (int i = 1; i <= 4; i++) {
				if (img.equalsIgnoreCase("BOX " + i)) {
					myWidth = 190;
					myHeight = 224;
				}
			}
			for (int i = 0; i <= 33; i++) {
				if (img.equalsIgnoreCase("EMOTE " + i)) {
					myWidth = 190;
					myHeight = 224;
				}
			}
			for (int i = 0; i <= 38; i++) {
				if (img.equalsIgnoreCase("LUNAROFF " + i)) {
					myWidth = 190;
					myHeight = 224;
				}
			}
			for (int i = 0; i <= 38; i++) {
				if (img.equalsIgnoreCase("LUNARON " + i)) {
					myWidth = 190;
					myHeight = 224;
				}
			}
			for (int i = 1; i <= 14; i++) {
				if (img.equalsIgnoreCase("Rune " + i)) {
					myWidth = 190;
					myHeight = 224;
				}
			}
			myWidth = sprite.getIconWidth();
			myHeight = sprite.getIconHeight();
			anInt1444 = myWidth;
			anInt1445 = myHeight;
			anInt1442 = 0;
			anInt1443 = 0;
			myPixels = new int[myWidth * myHeight];
			PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, myWidth,
					myHeight, myPixels, 0, myWidth);
			pixelgrabber.grabPixels();
			image = null;
			setTransparency(255, 0, 255);
		} catch (Exception _ex) {
			System.out.println(_ex);
		}
	}

	public Sprite(StreamLoader streamLoader, String s, int i) {
		Stream stream = new Stream(streamLoader.getDataForName(s + ".dat"));
		Stream stream_1 = new Stream(streamLoader.getDataForName("index.dat"));
		stream_1.currentOffset = stream.readUnsignedWord();
		anInt1444 = stream_1.readUnsignedWord();
		anInt1445 = stream_1.readUnsignedWord();
		int j = stream_1.readUnsignedByte();
		int ai[] = new int[j];
		for (int k = 0; k < j - 1; k++) {
			ai[k + 1] = stream_1.read3Bytes();
			if (ai[k + 1] == 0)
				ai[k + 1] = 1;
		}

		for (int l = 0; l < i; l++) {
			stream_1.currentOffset += 2;
			stream.currentOffset += stream_1.readUnsignedWord()
					* stream_1.readUnsignedWord();
			stream_1.currentOffset++;
		}

		anInt1442 = stream_1.readUnsignedByte();
		anInt1443 = stream_1.readUnsignedByte();
		myWidth = stream_1.readUnsignedWord();
		myHeight = stream_1.readUnsignedWord();
		int i1 = stream_1.readUnsignedByte();
		int j1 = myWidth * myHeight;
		myPixels = new int[j1];
		setTransparency(255, 0, 255);
		if (i1 == 0) {
			for (int k1 = 0; k1 < j1; k1++)
				myPixels[k1] = ai[stream.readUnsignedByte()];

			return;
		}
		if (i1 == 1) {
			for (int l1 = 0; l1 < myWidth; l1++) {
				for (int i2 = 0; i2 < myHeight; i2++)
					myPixels[l1 + i2 * myWidth] = ai[stream.readUnsignedByte()];

			}

		}
	}

	public void method343() {
		DrawingArea.initDrawingArea(myHeight, myWidth, myPixels);
	}

	public void method344(int i, int j, int k) {
		autoUpdate();
		for (int i1 = 0; i1 < myPixels.length; i1++) {
			int j1 = myPixels[i1];
			if (j1 != 0) {
				int k1 = j1 >> 16 & 0xff;
				k1 += i;
				if (k1 < 1)
					k1 = 1;
				else if (k1 > 255)
					k1 = 255;
				int l1 = j1 >> 8 & 0xff;
				l1 += j;
				if (l1 < 1)
					l1 = 1;
				else if (l1 > 255)
					l1 = 255;
				int i2 = j1 & 0xff;
				i2 += k;
				if (i2 < 1)
					i2 = 1;
				else if (i2 > 255)
					i2 = 255;
				myPixels[i1] = (k1 << 16) + (l1 << 8) + i2;
			}
		}

	}

	public void method345() {
		autoUpdate();
		try {
			int totalPixels[] = new int[anInt1444 * anInt1445];
			for (int h = 0; h < myHeight; h++) {
				for (int w = 0; w < myWidth; w++) {
					totalPixels[(h + anInt1443) * anInt1444 + (w + anInt1442)] = myPixels[h
							* myWidth + w];
				}
			}
			myPixels = totalPixels;
			myWidth = anInt1444;
			myHeight = anInt1445;
			anInt1442 = 0;
			anInt1443 = 0;
			return;
		} catch (RuntimeException runtimeexception) {
			signlink.reporterror("26341, " + runtimeexception.toString());
		}
		throw new RuntimeException();
	}

	public void method346(int i, int j) {
		autoUpdate();
		i += anInt1442;
		j += anInt1443;
		int l = i + j * DrawingArea.width;
		int i1 = 0;
		int j1 = myHeight;
		int k1 = myWidth;
		int l1 = DrawingArea.width - k1;
		int i2 = 0;
		if (j < DrawingArea.topY) {
			int j2 = DrawingArea.topY - j;
			j1 -= j2;
			j = DrawingArea.topY;
			i1 += j2 * k1;
			l += j2 * DrawingArea.width;
		}
		if (j + j1 > DrawingArea.bottomY)
			j1 -= (j + j1) - DrawingArea.bottomY;
		if (i < DrawingArea.topX) {
			int k2 = DrawingArea.topX - i;
			k1 -= k2;
			i = DrawingArea.topX;
			i1 += k2;
			l += k2;
			i2 += k2;
			l1 += k2;
		}
		if (i + k1 > DrawingArea.bottomX) {
			int l2 = (i + k1) - DrawingArea.bottomX;
			k1 -= l2;
			i2 += l2;
			l1 += l2;
		}
		if (k1 <= 0 || j1 <= 0) {
		} else {
			method347(l, k1, j1, i2, i1, l1, myPixels, DrawingArea.pixels);
		}
	}

	public void method347(int i, int j, int k, int l, int i1, int k1,
			int ai[], int ai1[]) {
		int l1 = -(j >> 2);
		j = -(j & 3);
		for (int i2 = -k; i2 < 0; i2++) {
			for (int j2 = l1; j2 < 0; j2++) {
				ai1[i++] = ai[i1++];
				ai1[i++] = ai[i1++];
				ai1[i++] = ai[i1++];
				ai1[i++] = ai[i1++];
			}

			for (int k2 = j; k2 < 0; k2++)
				ai1[i++] = ai[i1++];

			i += k1;
			i1 += l;
		}
	}

	public void drawSprite6(int i, int k) {
		i += anInt1442;
		k += anInt1443;
		int l = i + k * DrawingArea.width;
		int i1 = 0;
		int j1 = myHeight;
		int k1 = myWidth;
		int l1 = DrawingArea.width - k1;
		int i2 = 0;
		if (k < DrawingArea.topY) {
			int j2 = DrawingArea.topY - k;
			j1 -= j2;
			k = DrawingArea.topY;
			i1 += j2 * k1;
			l += j2 * DrawingArea.width;
		}
		if (k + j1 > DrawingArea.bottomY)
			j1 -= (k + j1) - DrawingArea.bottomY;
		if (i < DrawingArea.topX) {
			int k2 = DrawingArea.topX - i;
			k1 -= k2;
			i = DrawingArea.topX;
			i1 += k2;
			l += k2;
			i2 += k2;
			l1 += k2;
		}
		if (i + k1 > DrawingArea.bottomX) {
			int l2 = (i + k1) - DrawingArea.bottomX;
			k1 -= l2;
			i2 += l2;
			l1 += l2;
		}
		if (!(k1 <= 0 || j1 <= 0)) {
			method349(DrawingArea.pixels, myPixels, i1, l, k1, j1, l1, i2);
		}
	}

	public void drawSprite1(int i, int j) {
		autoUpdate();
		int k = 128;// was parameter
		i += anInt1442;
		j += anInt1443;
		int i1 = i + j * DrawingArea.width;
		int j1 = 0;
		int k1 = myHeight;
		int l1 = myWidth;
		int i2 = DrawingArea.width - l1;
		int j2 = 0;
		if (j < DrawingArea.topY) {
			int k2 = DrawingArea.topY - j;
			k1 -= k2;
			j = DrawingArea.topY;
			j1 += k2 * l1;
			i1 += k2 * DrawingArea.width;
		}
		if (j + k1 > DrawingArea.bottomY)
			k1 -= (j + k1) - DrawingArea.bottomY;
		if (i < DrawingArea.topX) {
			int l2 = DrawingArea.topX - i;
			l1 -= l2;
			i = DrawingArea.topX;
			j1 += l2;
			i1 += l2;
			j2 += l2;
			i2 += l2;
		}
		if (i + l1 > DrawingArea.bottomX) {
			int i3 = (i + l1) - DrawingArea.bottomX;
			l1 -= i3;
			j2 += i3;
			i2 += i3;
		}
		if (!(l1 <= 0 || k1 <= 0)) {
			method351(j1, l1, DrawingArea.pixels, myPixels, j2, k1, i2, k, i1);
		}
	}

	public void drawSprite(int drawPosX, int drawPosY) {
		autoUpdate();
		drawPosX += anInt1442;
		drawPosY += anInt1443;
		int l = drawPosX + drawPosY * DrawingArea.width;
		int i1 = 0;
		int j1 = myHeight;
		int k1 = myWidth;
		int l1 = DrawingArea.width - k1;
		int i2 = 0;
		if (drawPosY < DrawingArea.topY) {
			int j2 = DrawingArea.topY - drawPosY;
			j1 -= j2;
			drawPosY = DrawingArea.topY;
			i1 += j2 * k1;
			l += j2 * DrawingArea.width;
		}
		if (drawPosY + j1 > DrawingArea.bottomY)
			j1 -= (drawPosY + j1) - DrawingArea.bottomY;
		if (drawPosX < DrawingArea.topX) {
			int k2 = DrawingArea.topX - drawPosX;
			k1 -= k2;
			drawPosX = DrawingArea.topX;
			i1 += k2;
			l += k2;
			i2 += k2;
			l1 += k2;
		}
		if (drawPosX + k1 > DrawingArea.bottomX) {
			int l2 = (drawPosX + k1) - DrawingArea.bottomX;
			k1 -= l2;
			i2 += l2;
			l1 += l2;
		}
		if (!(k1 <= 0 || j1 <= 0)) {
			method349(DrawingArea.pixels, myPixels, i1, l, k1, j1, l1, i2);
		}
	}

	public void drawSpriteWithOpacity(int xPos, int yPos, int o) {
		int opacity = o;// was parameter
		xPos += anInt1442;
		yPos += anInt1443;
		int i1 = xPos + yPos * DrawingArea.width;
		int j1 = 0;
		int k1 = myHeight;
		int l1 = myWidth;
		int i2 = DrawingArea.width - l1;
		int j2 = 0;
		if (yPos < DrawingArea.topY) {
			int k2 = DrawingArea.topY - yPos;
			k1 -= k2;
			yPos = DrawingArea.topY;
			j1 += k2 * l1;
			i1 += k2 * DrawingArea.width;
		}
		if (yPos + k1 > DrawingArea.bottomY)
			k1 -= (yPos + k1) - DrawingArea.bottomY;
		if (xPos < DrawingArea.topX) {
			int l2 = DrawingArea.topX - xPos;
			l1 -= l2;
			xPos = DrawingArea.topX;
			j1 += l2;
			i1 += l2;
			j2 += l2;
			i2 += l2;
		}
		if (xPos + l1 > DrawingArea.bottomX) {
			int i3 = (xPos + l1) - DrawingArea.bottomX;
			l1 -= i3;
			j2 += i3;
			i2 += i3;
		}
		if (!(l1 <= 0 || k1 <= 0)) {
			method351(j1, l1, DrawingArea.pixels, myPixels, j2, k1, i2,
					opacity, i1);
		}
	}

	public void drawSpriteOpacity(int i, int j, int k) {
		i += anInt1442;
		j += anInt1443;
		int i1 = i + j * DrawingArea.width;
		int j1 = 0;
		int k1 = myHeight;
		int l1 = myWidth;
		int i2 = DrawingArea.width - l1;
		int j2 = 0;
		if (j < DrawingArea.topY) {
			int k2 = DrawingArea.topY - j;
			k1 -= k2;
			j = DrawingArea.topY;
			j1 += k2 * l1;
			i1 += k2 * DrawingArea.width;
		}
		if (j + k1 > DrawingArea.bottomY)
			k1 -= (j + k1) - DrawingArea.bottomY;
		if (i < DrawingArea.topX) {
			int l2 = DrawingArea.topX - i;
			l1 -= l2;
			i = DrawingArea.topX;
			j1 += l2;
			i1 += l2;
			j2 += l2;
			i2 += l2;
		}
		if (i + l1 > DrawingArea.bottomX) {
			int i3 = (i + l1) - DrawingArea.bottomX;
			l1 -= i3;
			j2 += i3;
			i2 += i3;
		}
		if (!(l1 <= 0 || k1 <= 0)) {
			method351(j1, l1, DrawingArea.pixels, myPixels, j2, k1, i2, k, i1);
		}
	}

	public void drawSprite2(int i, int j) {
		int k = 128;// was parameter
		i += anInt1442;
		j += anInt1443;
		int i1 = i + j * DrawingArea.width;
		int j1 = 0;
		int k1 = myHeight;
		int l1 = myWidth;
		int i2 = DrawingArea.width - l1;
		int j2 = 0;
		if (j < DrawingArea.topY) {
			int k2 = DrawingArea.topY - j;
			k1 -= k2;
			j = DrawingArea.topY;
			j1 += k2 * l1;
			i1 += k2 * DrawingArea.width;
		}
		if (j + k1 > DrawingArea.bottomY)
			k1 -= (j + k1) - DrawingArea.bottomY;
		if (i < DrawingArea.topX) {
			int l2 = DrawingArea.topX - i;
			l1 -= l2;
			i = DrawingArea.topX;
			j1 += l2;
			i1 += l2;
			j2 += l2;
			i2 += l2;
		}
		if (i + l1 > DrawingArea.bottomX) {
			int i3 = (i + l1) - DrawingArea.bottomX;
			l1 -= i3;
			j2 += i3;
			i2 += i3;
		}
		if (!(l1 <= 0 || k1 <= 0)) {
			method351(j1, l1, DrawingArea.pixels, myPixels, j2, k1, i2, k, i1);
		}
	}

	public void method349(int ai[], int ai1[], int j, int k, int l, int i1,
			int j1, int k1) {
		int i;// was parameter
		int l1 = -(l >> 2);
		l = -(l & 3);
		for (int i2 = -i1; i2 < 0; i2++) {
			for (int j2 = l1; j2 < 0; j2++) {
				i = ai1[j++];
				if (i != 0 && i != -1) {
					ai[k++] = i;
				} else {
					k++;
				}
				i = ai1[j++];
				if (i != 0 && i != -1) {
					ai[k++] = i;
				} else {
					k++;
				}
				i = ai1[j++];
				if (i != 0 && i != -1) {
					ai[k++] = i;
				} else {
					k++;
				}
				i = ai1[j++];
				if (i != 0 && i != -1) {
					ai[k++] = i;
				} else {
					k++;
				}
			}

			for (int k2 = l; k2 < 0; k2++) {
				i = ai1[j++];
				if (i != 0 && i != -1) {
					ai[k++] = i;
				} else {
					k++;
				}
			}
			k += j1;
			j += k1;
		}
	}

	public void method351(int i, int j, int ai[], int ai1[], int l, int i1,
			int j1, int k1, int l1) {
		int k;// was parameter
		int j2 = 256 - k1;
		for (int k2 = -i1; k2 < 0; k2++) {
			for (int l2 = -j; l2 < 0; l2++) {
				k = ai1[i++];
				if (k != 0) {
					int i3 = ai[l1];
					ai[l1++] = ((k & 0xff00ff) * k1 + (i3 & 0xff00ff) * j2 & 0xff00ff00)
							+ ((k & 0xff00) * k1 + (i3 & 0xff00) * j2 & 0xff0000) >> 8;
				} else {
					l1++;
				}
			}

			l1 += j1;
			i += l;
		}
	}

	public void drawSprite3(int i, int k, int color) {
		int tempWidth = myWidth + 2;
		int tempHeight = myHeight + 2;
		int[] tempArray = new int[tempWidth * tempHeight];
		for (int x = 0; x < myWidth; x++) {
			for (int y = 0; y < myHeight; y++) {
				if (myPixels[x + y * myWidth] != 0)
					tempArray[(x + 1) + (y + 1) * tempWidth] = myPixels[x + y
							* myWidth];
			}
		}
		for (int x = 0; x < tempWidth; x++) {
			for (int y = 0; y < tempHeight; y++) {
				if (tempArray[(x) + (y) * tempWidth] == 0) {
					if (x < tempWidth - 1
							&& tempArray[(x + 1) + ((y) * tempWidth)] > 0
							&& tempArray[(x + 1) + ((y) * tempWidth)] != 0xffffff) {
						tempArray[(x) + (y) * tempWidth] = color;
					}
					if (x > 0
							&& tempArray[(x - 1) + ((y) * tempWidth)] > 0
							&& tempArray[(x - 1) + ((y) * tempWidth)] != 0xffffff) {
						tempArray[(x) + (y) * tempWidth] = color;
					}
					if (y < tempHeight - 1
							&& tempArray[(x) + ((y + 1) * tempWidth)] > 0
							&& tempArray[(x) + ((y + 1) * tempWidth)] != 0xffffff) {
						tempArray[(x) + (y) * tempWidth] = color;
					}
					if (y > 0
							&& tempArray[(x) + ((y - 1) * tempWidth)] > 0
							&& tempArray[(x) + ((y - 1) * tempWidth)] != 0xffffff) {
						tempArray[(x) + (y) * tempWidth] = color;
					}
				}
			}
		}
		i--;
		k--;
		i += anInt1442;
		k += anInt1443;
		int l = i + k * DrawingArea.width;
		int i1 = 0;
		int j1 = tempHeight;
		int k1 = tempWidth;
		int l1 = DrawingArea.width - k1;
		int i2 = 0;
		if (k < DrawingArea.topY) {
			int j2 = DrawingArea.topY - k;
			j1 -= j2;
			k = DrawingArea.topY;
			i1 += j2 * k1;
			l += j2 * DrawingArea.width;
		}
		if (k + j1 > DrawingArea.bottomY) {
			j1 -= (k + j1) - DrawingArea.bottomY;
		}
		if (i < DrawingArea.topX) {
			int k2 = DrawingArea.topX - i;
			k1 -= k2;
			i = DrawingArea.topX;
			i1 += k2;
			l += k2;
			i2 += k2;
			l1 += k2;
		}
		if (i + k1 > DrawingArea.bottomX) {
			int l2 = (i + k1) - DrawingArea.bottomX;
			k1 -= l2;
			i2 += l2;
			l1 += l2;
		}
		if (!(k1 <= 0 || j1 <= 0)) {
			method349(DrawingArea.pixels, tempArray, i1, l, k1, j1, l1, i2);
		}
	}

	public void method352(int i, int j, int ai[], int k, int ai1[], int i1,
			int yPos, int xPos, int l1, int i2) {
		autoUpdate();
		try {
			int j2 = -l1 / 2;
			int k2 = -i / 2;
			int l2 = (int) (Math.sin((double) j / 326.11000000000001D) * 65536D);
			int i3 = (int) (Math.cos((double) j / 326.11000000000001D) * 65536D);
			l2 = l2 * k >> 8;
			i3 = i3 * k >> 8;
			int j3 = (i2 << 16) + (k2 * l2 + j2 * i3);
			int k3 = (i1 << 16) + (k2 * i3 - j2 * l2);
			int l3 = xPos + yPos * DrawingArea.width;
			for (yPos = 0; yPos < i; yPos++) {
				int i4 = ai1[yPos];
				int j4 = l3 + i4;
				int k4 = j3 + i3 * i4;
				int l4 = k3 - l2 * i4;
				for (xPos = -ai[yPos]; xPos < 0; xPos++) {
					DrawingArea.pixels[j4++] = myPixels[(k4 >> 16) + (l4 >> 16)
							* myWidth];
					k4 += i3;
					l4 -= l2;
				}

				j3 += l2;
				k3 += i3;
				l3 += DrawingArea.width;
			}

		} catch (Exception _ex) {
		}
	}

	public void method353(int i, double d, int l1) {
		autoUpdate();
		// all of the following were parameters
		int j = 15;
		int k = 20;
		int l = 15;
		int j1 = 256;
		int k1 = 20;
		// all of the previous were parameters
		try {
			int i2 = -k / 2;
			int j2 = -k1 / 2;
			int k2 = (int) (Math.sin(d) * 65536D);
			int l2 = (int) (Math.cos(d) * 65536D);
			k2 = k2 * j1 >> 8;
			l2 = l2 * j1 >> 8;
			int i3 = (l << 16) + (j2 * k2 + i2 * l2);
			int j3 = (j << 16) + (j2 * l2 - i2 * k2);
			int k3 = l1 + i * DrawingArea.width;
			for (i = 0; i < k1; i++) {
				int l3 = k3;
				int i4 = i3;
				int j4 = j3;
				for (l1 = -k; l1 < 0; l1++) {
					int k4 = myPixels[(i4 >> 16) + (j4 >> 16) * myWidth];
					if (k4 != 0)
						DrawingArea.pixels[l3++] = k4;
					else
						l3++;
					i4 += l2;
					j4 -= k2;
				}

				i3 += k2;
				j3 += l2;
				k3 += DrawingArea.width;
			}

		} catch (Exception _ex) {
		}
	}

	public void method354(Background background, int i, int j) {
		autoUpdate();
		j += anInt1442;
		i += anInt1443;
		int k = j + i * DrawingArea.width;
		int l = 0;
		int i1 = myHeight;
		int j1 = myWidth;
		int k1 = DrawingArea.width - j1;
		int l1 = 0;
		if (i < DrawingArea.topY) {
			int i2 = DrawingArea.topY - i;
			i1 -= i2;
			i = DrawingArea.topY;
			l += i2 * j1;
			k += i2 * DrawingArea.width;
		}
		if (i + i1 > DrawingArea.bottomY)
			i1 -= (i + i1) - DrawingArea.bottomY;
		if (j < DrawingArea.topX) {
			int j2 = DrawingArea.topX - j;
			j1 -= j2;
			j = DrawingArea.topX;
			l += j2;
			k += j2;
			l1 += j2;
			k1 += j2;
		}
		if (j + j1 > DrawingArea.bottomX) {
			int k2 = (j + j1) - DrawingArea.bottomX;
			j1 -= k2;
			l1 += k2;
			k1 += k2;
		}
		if (!(j1 <= 0 || i1 <= 0)) {
			method355(myPixels, j1, background.aByteArray1450, i1,
					DrawingArea.pixels, 0, k1, k, l1, l);
		}
	}

	public void method355(int ai[], int i, byte abyte0[], int j, int ai1[],
			int k, int l, int i1, int j1, int k1) {
		int l1 = -(i >> 2);
		i = -(i & 3);
		for (int j2 = -j; j2 < 0; j2++) {
			for (int k2 = l1; k2 < 0; k2++) {
				k = ai[k1++];
				if (k != 0 && abyte0[i1] == 0)
					ai1[i1++] = k;
				else
					i1++;
				k = ai[k1++];
				if (k != 0 && abyte0[i1] == 0)
					ai1[i1++] = k;
				else
					i1++;
				k = ai[k1++];
				if (k != 0 && abyte0[i1] == 0)
					ai1[i1++] = k;
				else
					i1++;
				k = ai[k1++];
				if (k != 0 && abyte0[i1] == 0)
					ai1[i1++] = k;
				else
					i1++;
			}

			for (int l2 = i; l2 < 0; l2++) {
				k = ai[k1++];
				if (k != 0 && abyte0[i1] == 0)
					ai1[i1++] = k;
				else
					i1++;
			}

			i1 += l;
			k1 += j1;
		}

	}

	public void setTransparency(int transRed, int transGreen, int transBlue) {
		for (int index = 0; index < myPixels.length; index++)
			if (((myPixels[index] >> 16) & 255) == transRed
					&& ((myPixels[index] >> 8) & 255) == transGreen
					&& (myPixels[index] & 255) == transBlue)
				myPixels[index] = 0;
	}

	public int myPixels[];
	public int myWidth;
	public int myHeight;
	public int anInt1442;
	public int anInt1443;
	public int anInt1444;
	public int anInt1445;
	public int maxWidth;
	public int maxHeight;
}
