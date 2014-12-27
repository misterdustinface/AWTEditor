package AWT.UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;

import javax.swing.JComponent;

import UI.Viewport;
import UI.Zoomable;
import data.shapes.Point;

public abstract class AWTZoomableViewport extends JComponent implements Viewport, Zoomable {
	private static final long serialVersionUID = -3215062024839871611L;
	protected Point position;
	private float zoomAmount;
	private LinkedList<MouseListener>       viewportMouseListeners;
	private LinkedList<MouseMotionListener> viewportMotionListeners;
	
	public float getXPosition() { return position.x; }
	public float getYPosition() { return position.y; }
	public float getZoom() 		{ return zoomAmount; }
	
	public void setZoom(float ZOOM) 	  { zoomAmount = ZOOM; }
	public void increaseZoom(float delta) { zoomAmount += delta; }
	public void decreaseZoom(float delta) { zoomAmount -= delta; }
	
	@Override
	public void setWidth(int width) {
		super.setSize(width, getHeight());
	}

	@Override
	public void setHeight(int height) {
		super.setSize(getWidth(), height);
	}
	
	//private AffineTransform transform;
	
	public void resetToDefaultZoom(){
		zoomAmount = 1;
		repaint();
	}
	public void resetToOrigin(){
		position.set(0,0);
		repaint();
	}
	public void setPosition(float x, float y) {
		position.set(x,y);
		repaint();
	}
	
	public void translatePosition(float x, float y) {
		position.shift(x, y);
		repaint();
	}
		
	public AWTZoomableViewport() {
		resetToDefaultZoom();
		position = new Point(0, 0);
		
		viewportMouseListeners  = new LinkedList<MouseListener>();
		viewportMotionListeners = new LinkedList<MouseMotionListener>();
		
		this.addMouseMotionListener(new MouseMotionListener(){
			@Override
			public void mouseDragged(MouseEvent event) {
				event = getWorldMouseEvent(event);
				for(MouseMotionListener listener : viewportMotionListeners) {
					listener.mouseDragged(event);
				}
			}
			@Override
			public void mouseMoved(MouseEvent event) {
				event = getWorldMouseEvent(event);
				for(MouseMotionListener listener : viewportMotionListeners) {
					listener.mouseMoved(event);
				}
			}
		});
		
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent event) {
				event = getWorldMouseEvent(event);
				for(MouseListener listener : viewportMouseListeners) {
					listener.mouseClicked(event);
				}
			}
			@Override
			public void mouseEntered(MouseEvent event) {
				event = getWorldMouseEvent(event);
				for(MouseListener listener : viewportMouseListeners) {
					listener.mouseEntered(event);
				}
			}
			@Override
			public void mouseExited(MouseEvent event) {
				event = getWorldMouseEvent(event);
				for(MouseListener listener : viewportMouseListeners) {
					listener.mouseExited(event);
				}
			}
			@Override
			public void mousePressed(MouseEvent event) {
				event = getWorldMouseEvent(event);
				for(MouseListener listener : viewportMouseListeners) {
					listener.mousePressed(event);
				}
			}
			@Override
			public void mouseReleased(MouseEvent event) {
				event = getWorldMouseEvent(event);
				for(MouseListener listener : viewportMouseListeners) {
					listener.mouseReleased(event);
				}
			}
		});
	}
	
	public void addViewportMouseListener(MouseListener listener) {
		viewportMouseListeners.add(listener);
	}
	
	public void addViewportMotionListener(MouseMotionListener listener) {
		viewportMotionListeners.add(listener);
	}
	
	protected void paintComponent(Graphics g) {
		//super.paintComponent(g);
		super.paintComponents(g);
		
		AffineTransform zoom = new AffineTransform();
		zoom.scale(zoomAmount, zoomAmount);
		zoom.translate(position.x, position.y);
		((Graphics2D)g).setTransform(zoom);
	}
	
	private MouseEvent getWorldMouseEvent(MouseEvent panelEvent) {		
		 return new MouseEvent( this, 
								panelEvent.getID(), 
								panelEvent.getWhen(), 
								panelEvent.getModifiers(), 
								(int) (panelEvent.getX() / zoomAmount - position.x), 
								(int) (panelEvent.getY() / zoomAmount - position.y), 
								panelEvent.getClickCount(), 
								false, 
								panelEvent.getButton());
	}
}
