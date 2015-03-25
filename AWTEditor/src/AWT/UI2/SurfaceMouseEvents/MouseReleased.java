package AWT.UI2.SurfaceMouseEvents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseReleased implements SurfaceMouseListenerFunction {
	
	private static final MouseReleased instance = new MouseReleased();
	private MouseReleased() {
		
	}
	
	public static SurfaceMouseListenerFunction getInstance() {
		return instance;
	}
	
	public void call(MouseListener listener, MouseEvent event) {
		listener.mouseReleased(event);
	}
	
}