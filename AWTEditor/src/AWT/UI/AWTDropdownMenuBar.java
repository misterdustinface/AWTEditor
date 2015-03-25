package AWT.UI;

import java.awt.Graphics2D;

import AWT.rendering.AWTMenuDrawer;
import UI.widgets.DropdownMenuBar;
import UI.widgets.MenuButton;

public class AWTDropdownMenuBar extends DropdownMenuBar implements AWTUILayer {
	
	private AWTMenuDrawer menuDrawer;

	public AWTDropdownMenuBar(AWTMenuBar MENU_BAR) {
		super(MENU_BAR);
		menuDrawer = AWTMenuDrawer.getMenuDrawer();
	}

	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		menuDrawer.drawButton(dropdownButton);
		if (isDropped()) {
			((AWTMenuBar)menuBar).render(g);
		}
	}

	protected MenuButton extendedMenuButton() {
		return new AWTMenuButton();
	}
	
}