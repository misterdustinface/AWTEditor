package AWT.UI;

import java.awt.Graphics2D;

import AWT.rendering.AWTMenuDrawer;
import UI.widgets.StaticListMenu;

public class AWTStaticListMenu extends StaticListMenu implements AWTUILayer {

	protected AWTMenuDrawer menuDrawer;
	
	public AWTStaticListMenu() {
		menuDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	@Override
	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		menuDrawer.drawUIMenu(this);
	}

}
