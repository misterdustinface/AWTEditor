package AWT.UI;

import generic.structures.Grid;

import java.awt.Graphics2D;

import UI.widgets.StaticGridMenu;
import AWT.rendering.AWTMenuDrawer;

public class AWTStaticGridMenu extends StaticGridMenu implements AWTUILayer {

	protected AWTMenuDrawer menuDrawer;
	
	public AWTStaticGridMenu(Grid DISPLAYGRID) {
		super(DISPLAYGRID);
		menuDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	@Override
	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		menuDrawer.drawUIMenu(this);
	}
	
}
