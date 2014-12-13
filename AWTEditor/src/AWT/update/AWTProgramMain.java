package AWT.update;
import AWT.UI.AWTLayerManager;
import AWT.UI.AWTMouseUserDevice;
import AWT.UI.AWTUIFunction;
import AWT.UI.AWTUILayer;


public class AWTProgramMain implements Runnable {

	private AWTMouseUserDevice	mouse;
	private AWTLayerManager		layerManager;
	private int UPS = 60;
	
	public void setUpdatesPerSecond(int UPS) {
		this.UPS = UPS;
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
			
			layerManager.forAllUIPerformFunction(uiUpdate);
			
			try {
				Thread.sleep(5); // Fixes really strange swing thread priority bug.
			} catch (Exception e) {}
		
		}
	}
}
