// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

final class RSImageProducer implements ImageProducer, ImageObserver {

	public RSImageProducer(int canvasWidth, int canvasHeight, Component component) {
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		componentPixels = new int[canvasWidth * canvasHeight];
		componentColorModel = new DirectColorModel(32, 0xff0000, 65280, 255);
		image = component.createImage(this);
		setComponentPixels();
		component.prepareImage(image, this);
		setComponentPixels();
		component.prepareImage(image, this);
		setComponentPixels();
		component.prepareImage(image, this);
		initDrawingArea();
	}

	public void initDrawingArea() {
		DrawingArea.initDrawingArea(canvasHeight, canvasWidth, componentPixels);
	}

	public void drawGraphics(int drawY, Graphics g, int drawX) {
		setComponentPixels();
		g.drawImage(image, drawX, drawY, this);
	}

	public synchronized void addConsumer(ImageConsumer imageconsumer) {
		this.imageConsumer = imageconsumer;
		imageconsumer.setDimensions(canvasWidth, canvasHeight);
		imageconsumer.setProperties(null);
		imageconsumer.setColorModel(componentColorModel);
		imageconsumer.setHints(14);
	}

	public synchronized boolean isConsumer(ImageConsumer imageConsumer) {
		return this.imageConsumer == imageConsumer;
	}

	public synchronized void removeConsumer(ImageConsumer imageconsumer) {
		if (this.imageConsumer == imageconsumer)
			this.imageConsumer = null;
	}

	public void startProduction(ImageConsumer imageconsumer) {
		addConsumer(imageconsumer);
	}

	public void requestTopDownLeftRightResend(ImageConsumer imageconsumer) {
		System.out.println("TDLR");
	}

	private synchronized void setComponentPixels() {
		if (imageConsumer != null) {
			imageConsumer.setPixels(0, 0, canvasWidth, canvasHeight,
					componentColorModel, componentPixels, 0, canvasWidth);
			imageConsumer.imageComplete(2);
		}
	}

	public boolean imageUpdate(Image image, int infoFlags, int x, int y, int width, int height) {
		return true;
	}

	public final int[] componentPixels;
	public final int canvasWidth;
	public final int canvasHeight;
	private final ColorModel componentColorModel;
	private ImageConsumer imageConsumer;
	private final Image image;
}
