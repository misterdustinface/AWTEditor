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
	
	public float getXPosition() {
		return position.x;
	}

	public float getYPosition() {
		return position.y;
	}

	public void setPosition(float x, float y) {
		position.set(x,y);
	}

	public void translatePosition(float x, float y) {
		position.shift(x, y);
	}

	public void resetToOrigin() {
		position.set(0,0);
	}

	public void setWidth(int width) {
		setSize(width, getHeight());
	}

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