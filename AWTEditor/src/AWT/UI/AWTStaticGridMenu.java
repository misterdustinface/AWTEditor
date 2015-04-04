package AWT.UI;

import java.awt.Graphics2D;

import structures.Grid;
import AWT.rendering.AWTMenuDrawer;
import UI.widgets.StaticGridMenu;

public class AWTStaticGridMenu extends StaticGridMenu implements AWTUILayer {

	protected AWTMenuDrawer menuDrawer;
	
	public AWTStaticGridMenu(Grid DISPLAYGRID) {
		super(DISPLAYGRID);
		menuDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		menuDrawer.drawUIMenu(this);
	}
	
}