package AWT.UI.Mouse;

import java.awt.Graphics2D;

import AWT.UI.AWTUILayer;
import AWT.graphicdata.EditorAWTGraphicData;
import AWT.rendering.AWTCursorDrawer;
import UI.input.MouseUserDevice;

final public class AWTMouseUserDeviceDisplayLayer implements AWTUILayer {
	
	private AWTCursorDrawer 	cursorDrawer;
	private AWTMouseUserDevice 	userDevice;
	private EditorAWTGraphicData graphicData;
	
	public AWTMouseUserDeviceDisplayLayer(AWTMouseUserDevice USER_DEVICE) {
		userDevice = USER_DEVICE;
		cursorDrawer = AWTCursorDrawer.getCursorDrawer();
		graphicData = EditorAWTGraphicData.getGraphicData();
	}
	
	public void render(Graphics2D g) {
		cursorDrawer.setGraphics(g);
		cursorDrawer.setColor(graphicData.getColorOf("cursor"));
		cursorDrawer.drawPointerCursor((int)userDevice.getCursorX(), (int)userDevice.getCursorY());
	}

	public void update(MouseUserDevice mouse) {
		
	}
	
}