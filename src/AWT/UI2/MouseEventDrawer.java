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
	
	public void run() {
		display.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent arg0) {
				uiDrawer.draw();
			}

			public void mouseMoved(MouseEvent arg0) {
				uiDrawer.draw();
			}
		});
		
		display.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				uiDrawer.draw();
			}

			public void mouseEntered(MouseEvent arg0) {
				uiDrawer.draw();
			}

			public void mouseExited(MouseEvent arg0) {
				uiDrawer.draw();
			}

			public void mousePressed(MouseEvent arg0) {
				uiDrawer.draw();
			}

			public void mouseReleased(MouseEvent arg0) {
				uiDrawer.draw();
			}
		});
		
		display.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				uiDrawer.draw();
			}
		});
	}

}