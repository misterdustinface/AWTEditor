package AWT.UI.Mouse;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import UI.Zoomable;

public class AWTZoomWheelListener implements MouseWheelListener {
	
	final private static float ZOOM_TICK_VIEW_SCALE_MODIFIER = 0.1f;
	final private static float MAX_ZOOM = 5.0f;
	final private static float MIN_ZOOM = 0.5f;
	
	private Zoomable zoomer;
	
	public AWTZoomWheelListener(Zoomable ZOOMER) {
		zoomer = ZOOMER;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {		
		if(e.getPreciseWheelRotation() > 0) {
			zoomOut();
		} else {
			zoomIn();
		}
	}

	public void zoomIn(){
		//position.set(mouse.getCursorX(), mouse.getCursorY());
		zoomer.increaseZoom(ZOOM_TICK_VIEW_SCALE_MODIFIER);
		if(zoomer.getZoom() > MAX_ZOOM){
			zoomer.setZoom(MAX_ZOOM);
		}
	}
	public void zoomOut(){
		zoomer.decreaseZoom(ZOOM_TICK_VIEW_SCALE_MODIFIER);
		if(zoomer.getZoom() < MIN_ZOOM){
			zoomer.setZoom(MIN_ZOOM);
		} else {
			//position.set(mouse.getCursorX(), mouse.getCursorY());
		}
	}
}
