package AWT.UI;

import generic.VoidFunctionPointer;
import UI.LayerManager;
import UI.MenuButton;
import UI.StaticListMenu;
import data.shapes.Point;

public class AWTToggleLayersMenu extends AWTDropdownMenu {

	private LayerManager layerManager;
	
	public AWTToggleLayersMenu(LayerManager LAYER_MANAGER) {
		super();
		layerManager = LAYER_MANAGER;
		setup();
	}
	
	public void addMenuItemToggleUI(String title, final AWTUILayer ui) {
		AWTMenuButton toggleButton = new AWTMenuButton();
		toggleButton.textLabel.setText(title);
		toggleButton.textLabel.center();
		toggleButton.debounceTimer.setDebounceTime_sec(1);
		toggleButton.setButtonPressedFunction(new VoidFunctionPointer(){
			@Override
			public void call() {
				layerManager.toggleLayer(ui);
			}
		});
		menu.addButton(toggleButton);
	}
	
	private void setup() {

		AWTMenuButton optionsButton = new AWTMenuButton();
		optionsButton.textLabel.setText("TOGGLE");
		optionsButton.textLabel.center();
		optionsButton.makeSuggestedBoxRelativeToPoint(140, 0, 2, 2);
		
		MenuButton[] menuButtons = new MenuButton[] { };
		StaticListMenu list = new StaticListMenu();
		list.setButtons(menuButtons);
		list.setPostition(new Point(142,2 + optionsButton.getHeight()));
		list.setButtonOffset(2);
		list.setButtonDimensions((int)optionsButton.getWidth() - 4, (int)optionsButton.getHeight() - 4);
		
		setRoot(optionsButton);
		setMenu(list);
	}

}
