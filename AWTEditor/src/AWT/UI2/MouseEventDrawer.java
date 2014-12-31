package AWT.UI2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseEventDrawer implements Runnable {

	private AWTDisplay display;
	private AWTUIDrawer uiDrawer;
	
	public MouseEventDrawer(AWTDisplay DISPLAY, AWTUIDrawer UI_DRAWER) {
		display = DISPLAY;
		uiDrawer = UI_DRAWER;
	}
	
	@Override
	public void run() {
		display.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				uiDrawer.draw();
			}
			@Override
			public void mouseMoved(MouseEvent arg0) {
				uiDrawer.draw();
			}
		});
		
		display.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				uiDrawer.draw();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				uiDrawer.draw();
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				uiDrawer.draw();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				uiDrawer.draw();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				uiDrawer.draw();
			}
			
		});
		
		display.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				uiDrawer.draw();
			}
			
		});
	}

}
