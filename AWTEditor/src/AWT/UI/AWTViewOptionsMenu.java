package AWT.UI;

import generic.VoidFunctionPointer;
import UI.MenuButton;
import UI.StaticListMenu;
import UI.Viewport;
import UI.Zoomable;
import data.shapes.Point;

public class AWTViewOptionsMenu extends AWTDropdownMenu {

	public AWTViewOptionsMenu(final Viewport VIEWPORT, final Zoomable ZOOMER) {
		super();

		AWTMenuButton optionsButton = new AWTMenuButton();
		optionsButton.textLabel.setText("OPTIONS");
		optionsButton.textLabel.center();
		optionsButton.makeSuggestedBoxRelativeToPoint(280, 0, 2, 2);
		
		AWTMenuButton resetZoom = new AWTMenuButton();
		resetZoom.textLabel.setText("RESET ZOOM");
		resetZoom.textLabel.center();
		resetZoom.setButtonPressedFunction(new VoidFunctionPointer() {
			@Override
			public void call() {
				ZOOMER.resetToDefaultZoom();
			}
		});
		
		AWTMenuButton gotoOrigin = new AWTMenuButton();
		gotoOrigin.textLabel.setText("TO ORIGIN");
		gotoOrigin.textLabel.center();
		gotoOrigin.setButtonPressedFunction(new VoidFunctionPointer() {
			@Override
			public void call() {
				VIEWPORT.resetToOrigin();
			}
		});
		
		MenuButton[] menuButtons = new MenuButton[] {resetZoom, gotoOrigin};
		StaticListMenu list = new StaticListMenu();
		list.setButtons(menuButtons);
		list.setPosition(new Point(282,2 + optionsButton.getHeight()));
		list.setButtonOffset(2);
		list.setButtonDimensions((int)optionsButton.getWidth() - 4, (int)optionsButton.getHeight() - 4);
		
		setRoot(optionsButton);
		setMenu(list);
	}
	
	
}
