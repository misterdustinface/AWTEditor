package AWT.UI;

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
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON2
		||(e.getButton() == MouseEvent.BUTTON1 && e.isControlDown())){
			shiftingScreen = true;
			lastOffset.set(e.getX(), e.getY());
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		shiftingScreen = false;
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}


	@Override
	public void mouseDragged(MouseEvent e) {
		if(shiftingScreen){
			int newX = e.getX() - (int)lastOffset.x;
			int newY = e.getY() - (int)lastOffset.y;
			lastOffset.shift(newX, newY);
			viewport.translatePosition(newX, newY);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		lastOffset.shift(e.getX(), e.getY());
	}
	
}
