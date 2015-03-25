package AWT.UI2;

import generic.TickingLoop;
import generic.fp.VoidFunctionPointer;

public class FixedDrawer extends TickingLoop {
	
	private AWTUIDrawer uiDrawer;
	
	public FixedDrawer(AWTUIDrawer UI_DRAWER) {
		uiDrawer = UI_DRAWER;
		super.addFunction(new VoidFunctionPointer() {
			public void call() {
				uiDrawer.draw();
			}
		});
		setDrawsPerSecond(60);
	}
	
	public void setDrawsPerSecond(int DPS) {
		super.setUpdatesPerSecond(DPS);
	}
	
}