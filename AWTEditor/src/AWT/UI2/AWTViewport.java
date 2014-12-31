package AWT.UI2;

import java.awt.Graphics2D;

import shapes.Point;
import AWT.rendering.AWTRenderable;
import UI.Viewport;

public class AWTViewport extends AWTDrawing implements Viewport, AWTRenderable {

	protected Point position;
	
	public AWTViewport() {
		position = new Point(0, 0);
	}
	
	public void render(Graphics2D g) {
		applyDrawingToGraphicsObject(g, (int)position.x, (int)position.y);
	}
	
	@Override
	public float getXPosition() {
		return position.x;
	}

	@Override
	public float getYPosition() {
		return position.y;
	}

	@Override
	public void setPosition(float x, float y) {
		position.set(x,y);
	}

	@Override
	public void translatePosition(float x, float y) {
		position.shift(x, y);
	}

	@Override
	public void resetToOrigin() {
		position.set(0,0);
	}

	@Override
	public void setWidth(int width) {
		setSize(width, getHeight());
	}

	@Override
	public void setHeight(int height) {
		setSize(getWidth(), height);
	}
	
	public int translateWorldX(int worldX) {
		return (int) (worldX - getXPosition());
	}
	
	public int translateWorldY(int worldY) {
		return (int) (worldY - getYPosition());
	}
}
