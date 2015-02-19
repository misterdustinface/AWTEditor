package AWT.UI;

import java.awt.Graphics2D;

import AWT.rendering.AWTMenuDrawer;
import UI.ButtonMenu;
import UI.MenuBar;

public class AWTMenuBar extends MenuBar implements AWTUILayer {

	protected AWTMenuDrawer menuDrawer;
	
	public AWTMenuBar() {
		menuDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	@Override
	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		
		menuDrawer.drawMenuBox((int)boundingBox.x, (int)boundingBox.y, (int)boundingBox.width, (int)boundingBox.height);
		
		for (ButtonMenu menu : menus) {
			((AWTUILayer)menu).render(g);			
		}
	}

}
