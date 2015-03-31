package AWT.UI.CommonMenus;

import generic.fp.VoidFunctionPointer;
import shapes.Polygon;
import shapes.PolygonBuilder;
import AWT.UI.AWTDropdownListMenu;
import AWT.UI.AWTMenuButton;
import AWT.UI.AWTStaticListMenu;
import AWT.graphicdata.EditorAWTGraphicData;
import UI.Viewport;
import UI.Zoomable;
import UI.widgets.MenuButton;

public class AWTViewOptionsMenu extends AWTDropdownListMenu {

	public AWTViewOptionsMenu(final Viewport VIEWPORT, final Zoomable ZOOMER) {
		super();

		AWTMenuButton optionsButton = new AWTMenuButton();
		optionsButton.setText("OPTIONS");
		
		EditorAWTGraphicData graphicData = EditorAWTGraphicData.getGraphicData();
		Polygon p = PolygonBuilder.makeBox(graphicData.getThicknessOf("buttonWidth"), graphicData.getThicknessOf("buttonHeight"));
		p.shift(282, 2);
		optionsButton.setPolygon(p);
		
		AWTMenuButton resetZoom = new AWTMenuButton();
		resetZoom.setText("RESET ZOOM");
		resetZoom.setButtonPressedFunction(new VoidFunctionPointer() {
			public void call() {
				ZOOMER.resetToDefaultZoom();
			}
		});
		
		AWTMenuButton gotoOrigin = new AWTMenuButton();
		gotoOrigin.setText("TO ORIGIN");
		gotoOrigin.setButtonPressedFunction(new VoidFunctionPointer() {
			public void call() {
				VIEWPORT.resetToOrigin();
			}
		});
		
		MenuButton[] menuButtons = new MenuButton[] {resetZoom, gotoOrigin};
		AWTStaticListMenu list = new AWTStaticListMenu();
		list.setButtons(menuButtons);
		list.setPosition(282, 2 + optionsButton.getBoundingRectangle().height);
		list.setButtonOffset(2);
		list.setButtonDimensions((int)optionsButton.getBoundingRectangle().width - 4, (int)optionsButton.getBoundingRectangle().height - 4);
		
		setRoot(optionsButton);
		setMenu(list);
	}
	
}