package AWT.UI;

import java.awt.Graphics2D;

import AWT.rendering.AWTMenuDrawer;
import UI.widgets.DropdownListMenu;

public class AWTDropdownListMenu extends DropdownListMenu implements AWTUILayer {

	protected AWTMenuDrawer menuDrawer;
	
	public AWTDropdownListMenu() {
		menuDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	@Override
	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		if (isListMenuOpen()) { 
			//((AWTStaticListMenu)menu).render(g);
			menuDrawer.drawUIMenu(menu); 
		}
		menuDrawer.drawButton(root);
	}
}