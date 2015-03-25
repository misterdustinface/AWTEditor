package AWT.UI2.SurfaceMouseEvents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMoved implements SurfaceMouseMotionListenerFunction {
	
	private static final MouseMoved instance = new MouseMoved();
	private MouseMoved() {
		
	}
	
	public static SurfaceMouseMotionListenerFunction getInstance() {
		return instance;
	}
	
	public void call(MouseMotionListener listener, MouseEvent event) {
		listener.mouseMoved(event);
	}
	
}
