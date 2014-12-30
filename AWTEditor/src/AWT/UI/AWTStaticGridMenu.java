package AWT.UI;

import java.awt.Graphics2D;

import shapes.Grid;
import UI.StaticGridMenu;
import AWT.rendering.AWTMenuDrawer;

public class AWTStaticGridMenu extends StaticGridMenu implements AWTUILayer {

	protected AWTMenuDrawer menuDrawer;
	
	public AWTStaticGridMenu(Grid DISPLAYGRID) {
		super(DISPLAYGRID);
		menuDrawer = new AWTMenuDrawer();
	}
	
	@Override
	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		menuDrawer.drawUIMenu(this);
	}
	
}
