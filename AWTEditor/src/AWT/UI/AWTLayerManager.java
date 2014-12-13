package AWT.UI;
import java.util.ArrayList;
import java.util.HashMap;

import UI.StratifiableUI;
import UI.UILayer;


public class AWTLayerManager implements StratifiableUI {

	private HashMap<UILayer, Boolean> 	shouldShow;
	private ArrayList<AWTUILayer>	  	uis;
	
	public AWTLayerManager() {
		shouldShow 	= new HashMap<UILayer, Boolean>();
		uis   		= new ArrayList<AWTUILayer>();
	}
	
	public void addLayer 	(UILayer ui) { uis.add((AWTUILayer)ui);  		shouldShow.put((AWTUILayer)ui, true); }
	public void removeLayer (UILayer ui) { uis.remove((AWTUILayer)ui); 		shouldShow.put((AWTUILayer)ui, true); }
	public void toggleLayer (UILayer ui) { shouldShow.put((AWTUILayer)ui, ! shouldShow.get((AWTUILayer)ui)); }
	private boolean shouldShow(UILayer ui) { return shouldShow.get((AWTUILayer)ui); }
	
	public void forAllUIPerformFunction(AWTUIFunction functionOnUI) {
		for(AWTUILayer ui : uis) {
			if (shouldShow(ui)) {
				functionOnUI.call(ui);
			}
		}
	}

}
