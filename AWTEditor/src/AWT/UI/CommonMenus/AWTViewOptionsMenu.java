package AWT.UI.CommonMenus;

import generic.fp.VoidFunctionPointer;
import shapes.Point;
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
		optionsButton.textLabel.setText("OPTIONS");
		optionsButton.textLabel.center();
		
		EditorAWTGraphicData graphicData = EditorAWTGraphicData.getGraphicData();
		Polygon p = PolygonBuilder.makeBox(graphicData.getThicknessOf("buttonWidth"), graphicData.getThicknessOf("buttonHeight"));
		p.shift(282, 2);
		optionsButton.setPolygon(p);
		
		AWTMenuButton resetZoom = new AWTMenuButton();
		resetZoom.textLabel.setText("RESET ZOOM");
		resetZoom.textLabel.center();
		resetZoom.setButtonPressedFunction(new VoidFunctionPointer() {
			public void call() {
				ZOOMER.resetToDefaultZoom();
			}
		});
		
		AWTMenuButton gotoOrigin = new AWTMenuButton();
		gotoOrigin.textLabel.setText("TO ORIGIN");
		gotoOrigin.textLabel.center();
		gotoOrigin.setButtonPressedFunction(new VoidFunctionPointer() {
			public void call() {
				VIEWPORT.resetToOrigin();
			}
		});
		
		MenuButton[] menuButtons = new MenuButton[] {resetZoom, gotoOrigin};
		AWTStaticListMenu list = new AWTStaticListMenu();
		list.setButtons(menuButtons);
		list.setPosition(new Point(282,2 + optionsButton.getHeight()));
		list.setButtonOffset(2);
		list.setButtonDimensions((int)optionsButton.getWidth() - 4, (int)optionsButton.getHeight() - 4);
		
		setRoot(optionsButton);
		setMenu(list);
	}
	
}