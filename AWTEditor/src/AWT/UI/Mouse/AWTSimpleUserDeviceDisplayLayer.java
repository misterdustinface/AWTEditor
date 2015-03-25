package AWT.UI.Mouse;

import java.awt.Color;
import java.awt.Graphics2D;

import AWT.UI.AWTUILayer;
import AWT.rendering.AWTCursorDrawer;
import UI.input.MouseUserDevice;

public class AWTSimpleUserDeviceDisplayLayer implements AWTUILayer {
	
	private AWTCursorDrawer 	cursorDrawer;
	private AWTMouseUserDevice 	userDevice;
	
	public AWTSimpleUserDeviceDisplayLayer(AWTMouseUserDevice USER_DEVICE) {
		userDevice = USER_DEVICE;
		cursorDrawer = AWTCursorDrawer.getCursorDrawer();
	}
	
	public void render(Graphics2D g) {
		cursorDrawer.setGraphics(g);
		cursorDrawer.setColor(Color.BLACK);
		cursorDrawer.drawPointerCursor((int)userDevice.getCursorX(), (int)userDevice.getCursorY());
	}

	public void update(MouseUserDevice mouse) {
		
	}
	
}