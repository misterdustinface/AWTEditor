package AWT.UI;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class AWTZoomWheelListener implements MouseWheelListener {
	
	final private static float ZOOM_TICK_VIEW_SCALE_MODIFIER = 0.1f;
	final private static float MAX_ZOOM = 5.0f;
	final private static float MIN_ZOOM = 0.5f;
	
	private AWTViewport viewport;
	
	public AWTZoomWheelListener(AWTViewport VIEWPORT) {
		viewport = VIEWPORT;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {		
		if(e.getPreciseWheelRotation() > 0) {
			zoomOut();
		} else {
			zoomIn();
		}
		
		//scale();
		viewport.repaint();
	}

	public void zoomIn(){
		//position.set(mouse.getCursorX(), mouse.getCursorY());
		viewport.increaseZoom(ZOOM_TICK_VIEW_SCALE_MODIFIER);
		if(viewport.getZoom() > MAX_ZOOM){
			viewport.setZoom(MAX_ZOOM);
		}
	}
	public void zoomOut(){
		viewport.decreaseZoom(ZOOM_TICK_VIEW_SCALE_MODIFIER);
		if(viewport.getZoom() < MIN_ZOOM){
			viewport.setZoom(MIN_ZOOM);
		} else {
			//position.set(mouse.getCursorX(), mouse.getCursorY());
		}
	}
}
