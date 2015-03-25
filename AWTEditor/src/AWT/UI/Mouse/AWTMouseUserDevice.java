package AWT.UI.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import UI.input.MouseUserDevice;

public abstract class AWTMouseUserDevice extends MouseUserDevice implements MouseListener, MouseMotionListener {
	
	public AWTMouseUserDevice() { 
		super(); 
	}
	
	@Override
	public void mouseClicked(MouseEvent e) { 
		click(); 
		recordButtonData(e); 
	}
	
	@Override
	public void mousePressed(MouseEvent e) { 
		press(); 
		recordButtonData(e); 
	}
	
	@Override
	public void mouseReleased(MouseEvent e) { 
		release(); 
	}
	
	@Override
	public void mouseDragged(MouseEvent e) { 
		drag(); 
	}
	
	@Override
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

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}