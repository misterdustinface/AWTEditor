package AWT.update;

import generic.StopwatchTimer;
import AWT.UI.AWTLayerManager;
import AWT.UI.AWTMouseUserDevice;
import AWT.UI.AWTUIFunction;
import AWT.UI.AWTUILayer;


public class AWTProgramMain implements Runnable {

	private AWTMouseUserDevice	mouse;
	private AWTLayerManager		layerManager;
	private long millisAllowedPerUpdate = 1000 / 60;
	private StopwatchTimer iterationStopwatch;
	
	public AWTProgramMain() {
		iterationStopwatch = new StopwatchTimer();
	}
	
	public void setUpdatesPerSecond(int UPS) {
		millisAllowedPerUpdate = 1000 / UPS;
	}
	
	public void setMouse(AWTMouseUserDevice mouse) {
		this.mouse = mouse;
	}
	
	public void setLayerManager(AWTLayerManager layerManager) {
		this.layerManager = layerManager;
	}
	
	private AWTUIFunction uiUpdate = new AWTUIFunction() {
		public void call(AWTUILayer ui) {
			ui.update(mouse);
		}
	};
	
	@Override
	public void run() {
		for(;;) {
			iterationStopwatch.reset();
			layerManager.forAllUIPerformFunction(uiUpdate);
			
			try {
				Thread.sleep(millisAllowedPerUpdate - iterationStopwatch.time__ms());
			} catch (Exception e) {}
		}
	}
}
