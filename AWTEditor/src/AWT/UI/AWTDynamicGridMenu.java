package AWT.UI;

import generic.structures.Grid;

import java.awt.Graphics2D;

import AWT.rendering.AWTMenuDrawer;
import UI.widgets.DynamicGridMenu;

public abstract class AWTDynamicGridMenu extends DynamicGridMenu implements AWTUILayer  {

	protected AWTMenuDrawer menuDrawer;
	
	public AWTDynamicGridMenu(Grid DISPLAYGRID) {
		super(DISPLAYGRID);
		menuDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	@Override
	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		menuDrawer.drawUIMenu(this);

		if (canFitNewEmptyEntry()) {
			menuDrawer.drawPlusOnButton(getEmptyEntry());
		}
	}
}
