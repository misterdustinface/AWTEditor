package AWT.UI2;

import java.awt.Graphics2D;

import AWT.UI.AWTUILayer;
import UI.UIFunction;
import UI.UILayer;
import UI.UILayerManager;

public class AWTUIDrawer {

	private AWTDrawing drawing;
	private Graphics2D graphics;
	private UILayerManager layerManager;
	private UIFunction uiRender = new UIFunction() {
		@Override
		public void call(UILayer ui) {
			((AWTUILayer)ui).render(graphics);
		}
	};
	
	public AWTUIDrawer() {}
	
	public void setDrawing(AWTDrawing DRAWING) {
		drawing = DRAWING;
	}
	
	public void setLayerManager(UILayerManager LAYER_MANAGER) {
		layerManager = LAYER_MANAGER;
	}	
	
	public void draw() {
		drawing.clear();
		graphics = drawing.getImageGraphics();
		layerManager.forAllUIPerformFunctionBackToFront(uiRender);
	}
}
