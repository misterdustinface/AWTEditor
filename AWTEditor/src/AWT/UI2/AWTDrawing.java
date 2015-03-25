package AWT.UI2;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import AWT.graphicdata.EditorAWTGraphicData;
import AWT.rendering.AWTRenderable;

public class AWTDrawing implements AWTRenderable {

	private BufferedImage image;
	private Graphics2D imageGraphics;
	
	public AWTDrawing() {
		image = newImage(1, 1);
	}
	
	private BufferedImage newImage(int width, int height) {
		BufferedImage i = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		imageGraphics = i.createGraphics();
		return i;
	}
	
	final public void setSize(int width, int height) {
		BufferedImage newImage = newImage(width, height);
		imageGraphics.drawImage(image.getScaledInstance(width, height, BufferedImage.SCALE_FAST), 0, 0, null);
		image = newImage;
	}
	
	final public void clear() {
		//getImageGraphics().clearRect(0, 0, image.getWidth(), image.getHeight());
		getImageGraphics().setColor(EditorAWTGraphicData.getGraphicData().getColorOf("BACKGROUND"));
		getImageGraphics().fillRect(0, 0, image.getWidth(), image.getHeight());
	}
	
	/**
	 * Grab this Graphics2D and draw with it.
	 * Drawing to this Graphics2D will draw to this viewport.
	 */
	final public Graphics2D getImageGraphics() {
		return imageGraphics;
	}
	
	public void render(Graphics2D g) {
		applyDrawingToGraphicsObject(g, 0, 0);
	}
	
	final protected void applyDrawingToGraphicsObject(Graphics2D g, int xPos, int yPos) {
		g.drawImage(image, xPos, yPos, null);
	}
	
	final public int getWidth() {
		return image.getWidth();
	}
	
	final public int getHeight() {
		return image.getHeight();
	}
	
}