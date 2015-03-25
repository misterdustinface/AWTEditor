package AWT.UI2;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import AWT.rendering.AWTRenderable;
import UI.Zoomable;

public class AWTZoomableViewport extends AWTViewport implements Zoomable, AWTRenderable {

	private float zoomAmount;
	private AffineTransform transform;
	
	public AWTZoomableViewport() {
		super();
		transform = new AffineTransform();
		resetToDefaultZoom();
	}
	
	public void render(Graphics2D g) {
		transform.setToIdentity();
		transform.scale(zoomAmount, zoomAmount);
		g.setTransform(transform);
		super.render(g);
	}
	
	public float getZoom() {
		return zoomAmount;
	}

	public void setZoom(float ZOOM) {
		zoomAmount = ZOOM;
	}

	public void increaseZoom(float delta) {
		zoomAmount += delta;
	}

	public void decreaseZoom(float delta) {
		zoomAmount -= delta;
	}

	public void resetToDefaultZoom() {
		zoomAmount = 1;
	}

	public int translateWorldX(int worldX) {
		return (int) (worldX/getZoom() - getXPosition());
	}
	
	public int translateWorldY(int worldY) {
		return (int) (worldY/getZoom() - getYPosition());
	}
	
}