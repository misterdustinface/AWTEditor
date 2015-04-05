package AWT.UI2.SurfaceMouseEvents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClicked implements SurfaceMouseListenerFunction {
	
	private static final MouseClicked instance = new MouseClicked();
	private MouseClicked() {
		
	}
	
	public static SurfaceMouseListenerFunction getInstance() {
		return instance;
	}
	
	public void call(MouseListener listener, MouseEvent event) {
		listener.mouseClicked(event);
	}
	
}