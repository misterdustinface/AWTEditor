package AWT.UI.Mouse;

import java.awt.event.MouseEvent;

public class AWTDefaultMouseUserDevice extends AWTMouseUserDevice {

	public void mouseDragged(MouseEvent arg0) {
		super.mouseDragged(arg0);
		cursorPosition.set(arg0.getX(), arg0.getY());
	}
	
	public void mouseMoved(MouseEvent arg0) {
		super.mouseMoved(arg0);
		cursorPosition.set(arg0.getX(), arg0.getY());
	}
	
}