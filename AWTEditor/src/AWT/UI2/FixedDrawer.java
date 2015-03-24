package AWT.UI2;

import generic.TickingLoop;
import generic.fp.VoidFunctionPointer;

public class FixedDrawer implements Runnable {
	private AWTUIDrawer uiDrawer;
	private TickingLoop thread;
	
	public FixedDrawer(AWTUIDrawer UI_DRAWER) {
		uiDrawer = UI_DRAWER;
		thread = new TickingLoop();
		thread.addFunction(new VoidFunctionPointer() {
			@Override
			public void call() {
				uiDrawer.draw();
			}
		});
		setDrawsPerSecond(60);
	}
	
	public void setDrawsPerSecond(int DPS) {
		thread.setUpdatesPerSecond(DPS);
	}
	
	@Override
	public void run() {
		thread.run();
	}
}
