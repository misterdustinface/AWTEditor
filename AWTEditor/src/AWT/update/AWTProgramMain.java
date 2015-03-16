package AWT.update;

import UI.UILayerManager;
import UI.UIFunction;
import UI.UILayer;
import generic.TickingLoop;
import generic.VoidFunctionPointer;
import AWT.UI.AWTUILayer;
import AWT.UI.Mouse.AWTMouseUserDevice;


public class AWTProgramMain extends TickingLoop {
	
	public static TickingLoop create(UILayerManager LAYER_MANAGER, AWTMouseUserDevice MOUSE_USER_DEVICE) {
		return new AWTProgramMain(LAYER_MANAGER, MOUSE_USER_DEVICE);
	}
	
	private AWTMouseUserDevice	mouse;
	private UILayerManager		layerManager;
	private UIFunction uiUpdate = new UIFunction() {
		public void call(UILayer ui) {
			((AWTUILayer)ui).update(mouse);
		}
	};
	
	private AWTProgramMain(UILayerManager LAYER_MANAGER, AWTMouseUserDevice MOUSE_USER_DEVICE) {
		super();
		
		layerManager 	= LAYER_MANAGER;
		mouse 			= MOUSE_USER_DEVICE;
		
		super.addFunction(new VoidFunctionPointer() {
			@Override
			public void call() {
				layerManager.forAllUIPerformFunction(uiUpdate);
			}
		});
	}
		
}
