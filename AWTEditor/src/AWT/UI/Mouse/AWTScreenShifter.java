package AWT.UI.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import shapes.Point;
import UI.Viewport;

public class AWTScreenShifter implements MouseListener, MouseMotionListener {

	private boolean shiftingScreen;
	private Point 	lastOffset;
	
	private Viewport viewport;
	
	public AWTScreenShifter(Viewport VIEWPORT) {
		viewport = VIEWPORT;
		shiftingScreen = false;
		lastOffset     = new Point(0,0);
	}
	
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON2
		|| (e.getButton() == MouseEvent.BUTTON1 && e.isControlDown())) {
			shiftingScreen = true;
			lastOffset.set(e.getX(), e.getY());
		}
	}

	public void mouseReleased(MouseEvent e) {
		shiftingScreen = false;
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		if (shiftingScreen) {
			int newX = e.getX() - (int)lastOffset.x;
			int newY = e.getY() - (int)lastOffset.y;
			lastOffset.shift(newX, newY);
			viewport.translatePosition(newX, newY);
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		lastOffset.shift(e.getX(), e.getY());
	}
	
}