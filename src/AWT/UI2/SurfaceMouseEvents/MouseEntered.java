package AWT.UI2.SurfaceMouseEvents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEntered implements SurfaceMouseListenerFunction {
	
	private static final MouseEntered instance = new MouseEntered();
	private MouseEntered() {
		
	}
	
	public static SurfaceMouseListenerFunction getInstance() {
		return instance;
	}
	
	public void call(MouseListener listener, MouseEvent event) {
		listener.mouseEntered(event);
	}
	
}