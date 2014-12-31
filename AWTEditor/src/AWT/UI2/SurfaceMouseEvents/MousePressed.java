package AWT.UI2.SurfaceMouseEvents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePressed implements SurfaceMouseListenerFunction {
	private static final MousePressed instance = new MousePressed();
	private MousePressed() {}
	
	public static SurfaceMouseListenerFunction getInstance() {
		return instance;
	}
	
	@Override
	public void call(MouseListener listener, MouseEvent event) {
		listener.mousePressed(event);
	}
}
