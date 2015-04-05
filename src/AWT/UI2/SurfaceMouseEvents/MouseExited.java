package AWT.UI2.SurfaceMouseEvents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseExited implements SurfaceMouseListenerFunction {
	
	private static final MouseExited instance = new MouseExited();
	private MouseExited() {
		
	}
	
	public static SurfaceMouseListenerFunction getInstance() {
		return instance;
	}
	
	public void call(MouseListener listener, MouseEvent event) {
		listener.mouseExited(event);
	}
	
}