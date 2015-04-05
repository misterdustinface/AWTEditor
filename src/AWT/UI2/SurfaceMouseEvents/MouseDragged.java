package AWT.UI2.SurfaceMouseEvents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseDragged implements SurfaceMouseMotionListenerFunction {
	
	private static final MouseDragged instance = new MouseDragged();
	private MouseDragged() {
		
	}
	
	public static SurfaceMouseMotionListenerFunction getInstance() {
		return instance;
	}
	
	public void call(MouseMotionListener listener, MouseEvent event) {
		listener.mouseDragged(event);
	}
	
}