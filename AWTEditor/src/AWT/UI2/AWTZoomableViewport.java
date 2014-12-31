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
	
	@Override
	public float getZoom() {
		return zoomAmount;
	}

	@Override
	public void setZoom(float ZOOM) {
		zoomAmount = ZOOM;
	}

	@Override
	public void increaseZoom(float delta) {
		zoomAmount += delta;
	}

	@Override
	public void decreaseZoom(float delta) {
		zoomAmount -= delta;
	}

	@Override
	public void resetToDefaultZoom() {
		zoomAmount = 1;
	}

	@Override
	public int translateWorldX(int worldX) {
		return (int) (worldX/getZoom() - getXPosition());
	}
	
	@Override
	public int translateWorldY(int worldY) {
		return (int) (worldY/getZoom() - getYPosition());
	}
}
