package AWT.UI2;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JComponent;

import AWT.UI.Mouse.AWTMouseUserDevice;
import AWT.UI2.SurfaceMouseEvents.MouseClicked;
import AWT.UI2.SurfaceMouseEvents.MouseDragged;
import AWT.UI2.SurfaceMouseEvents.MouseEntered;
import AWT.UI2.SurfaceMouseEvents.MouseExited;
import AWT.UI2.SurfaceMouseEvents.MouseMoved;
import AWT.UI2.SurfaceMouseEvents.MousePressed;
import AWT.UI2.SurfaceMouseEvents.MouseReleased;
import AWT.UI2.SurfaceMouseEvents.SurfaceMouseListenerFunction;
import AWT.UI2.SurfaceMouseEvents.SurfaceMouseMotionListenerFunction;
import AWT.graphicdata.AWTGraphicData;

public class AWTDisplay extends JComponent {
	private static final long serialVersionUID = 363380107229115199L;
	private static final Cursor INVISIBLE_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor((Image)(new BufferedImage(4, 4, BufferedImage.TYPE_INT_ARGB)),new java.awt.Point(0, 0), "INVISIBLE");
	
	private LinkedList<AWTViewport> 		views;
	private LinkedList<MouseListener>       surfaceMouseListeners;
	private LinkedList<MouseMotionListener> surfaceMotionListeners;
	
	public AWTDisplay() {
		views 					= new LinkedList<AWTViewport>();
		surfaceMouseListeners  	= new LinkedList<MouseListener>();
		surfaceMotionListeners 	= new LinkedList<MouseMotionListener>();
		setupJComponentEnvironment();
		setupSurfaceListeners();
	}
	
	public AWTDisplay(AWTMouseUserDevice userDevice) {
		this();
		addSurfaceMouseListener(userDevice);
		addSurfaceMotionListener(userDevice);
	}
	
	public void addView(AWTViewport view) {
		views.add(view);
	}
	
	public void removeView(AWTViewport view) {
		views.remove(view);
	}
	
	public void addSurfaceMouseListener(MouseListener listener) {
		surfaceMouseListeners.add(listener);
	}
	
	public void addSurfaceMotionListener(MouseMotionListener listener) {
		surfaceMotionListeners.add(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		repaint();
		renderViewports((Graphics2D)g);
	}
	
	private void renderViewports(Graphics2D g) {
		for (AWTViewport view : views) {
			view.render(g);
		}
	}
	
	private void setupJComponentEnvironment() {
		setCursor(INVISIBLE_CURSOR);
		setBackground(AWTGraphicData.getGraphicData().BACKGROUND_COLOR);
		setDoubleBuffered(true);
	}
	
	private void setupSurfaceListeners() {
		this.addMouseMotionListener(new MouseMotionListener(){
			@Override
			public void mouseDragged(MouseEvent event) {
				doMouseMotionListenerRoutine(event, MouseDragged.getInstance());
			}
			@Override
			public void mouseMoved(MouseEvent event) {				
				doMouseMotionListenerRoutine(event, MouseMoved.getInstance());
			}
		});
		
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent event) {
				doMouseListenerRoutine(event, MouseClicked.getInstance());
			}
			@Override
			public void mouseEntered(MouseEvent event) {
				doMouseListenerRoutine(event, MouseEntered.getInstance());
			}
			@Override
			public void mouseExited(MouseEvent event) {
				doMouseListenerRoutine(event, MouseExited.getInstance());
			}
			@Override
			public void mousePressed(MouseEvent event) {
				doMouseListenerRoutine(event, MousePressed.getInstance());
			}
			@Override
			public void mouseReleased(MouseEvent event) {
				doMouseListenerRoutine(event, MouseReleased.getInstance());
			}
		});
	}
	
	private void doMouseMotionListenerRoutine(MouseEvent event, SurfaceMouseMotionListenerFunction listenerFunction) {
		for (AWTViewport view : views) {
			event = getSurfaceEventRelativeToView(event, view);
			for (MouseMotionListener listener : surfaceMotionListeners) {
				listenerFunction.call(listener, event);
				if (event.isConsumed()) {
					return;
				}
			}
		}
	}
	
	private void doMouseListenerRoutine(MouseEvent event, SurfaceMouseListenerFunction listenerFunction) {
		for (AWTViewport view : views) {
			event = getSurfaceEventRelativeToView(event, view);
			for (MouseListener listener : surfaceMouseListeners) {
				listenerFunction.call(listener, event);
				if (event.isConsumed()) {
					return;
				}
			}
		}
	}
	
	private MouseEvent getSurfaceEventRelativeToView(MouseEvent surfaceEvent, AWTViewport view) {		
		return new MouseEvent(this, surfaceEvent.getID(),
				surfaceEvent.getWhen(), surfaceEvent.getModifiers(),
				view.translateWorldX(surfaceEvent.getX()),
				view.translateWorldY(surfaceEvent.getY()),
				surfaceEvent.getClickCount(), false, surfaceEvent.getButton());
	}
	
}
