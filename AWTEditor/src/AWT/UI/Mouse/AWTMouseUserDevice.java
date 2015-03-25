package AWT.UI.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import UI.input.MouseUserDevice;

public abstract class AWTMouseUserDevice extends MouseUserDevice implements MouseListener, MouseMotionListener {
	
	public AWTMouseUserDevice() { 
		super(); 
	}
	
	public void mouseClicked(MouseEvent e) { 
		click(); 
		recordButtonData(e); 
	}
	
	public void mousePressed(MouseEvent e) { 
		press(); 
		recordButtonData(e); 
	}
	
	public void mouseReleased(MouseEvent e) { 
		release(); 
	}
	
	public void mouseDragged(MouseEvent e) { 
		drag(); 
	}
	
	public void mouseMoved(MouseEvent e) { 
		move(); 
	}
	
	private void recordButtonData(MouseEvent arg0) {
		switch(arg0.getButton()) {
		case MouseEvent.BUTTON1: setButton(LEFT);      break;
		case MouseEvent.BUTTON2: setButton(MIDDLE);    break;
		case MouseEvent.BUTTON3: setButton(RIGHT);     break;
		default:				 setButton(NO_BUTTON); break;
		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void forceClick() {
		click();
	}
	
	public void forcePress() {
		press();
	}
	
	public void forceRelease() {
		release();
	}
	
	public void forceButton(String button) {
		setButton(button);
	}
	
	public void forcePosition(float x, float y) {
		cursorPosition.set(x, y);
	}
	
}