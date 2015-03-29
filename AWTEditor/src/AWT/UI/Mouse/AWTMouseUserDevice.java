package AWT.UI.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import UI.input.MouseUserDevice;

final public class AWTMouseUserDevice extends MouseUserDevice implements MouseListener, MouseMotionListener {
	
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
		cursorPosition.set(e.getX(), e.getY());
	}
	
	public void mouseMoved(MouseEvent e) { 
		move();
		cursorPosition.set(e.getX(), e.getY());
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
//		InputEvent event = new InputEvent();
//		InputEventBuilder.add(event, "Entered Screen");
//		createEvent(event);
	}
	
	public void mouseExited(MouseEvent e) {
//		InputEvent event = new InputEvent();
//		InputEventBuilder.add(event, "Exited Screen");
//		createEvent(event);
	}
	
}