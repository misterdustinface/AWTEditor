package AWT.UI;

import java.awt.Graphics2D;

import shapes.Grid;
import AWT.rendering.AWTMenuDrawer;
import UI.DynamicGridMenu;

public abstract class AWTDynamicGridMenu extends DynamicGridMenu implements AWTUILayer  {

	protected AWTMenuDrawer menuDrawer;
	
	public AWTDynamicGridMenu(Grid DISPLAYGRID) {
		super(DISPLAYGRID);
		menuDrawer = new AWTMenuDrawer();
	}
	
	@Override
	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		menuDrawer.drawUIMenu(this);

		if(canFitNewEmptyEntry()) {
			menuDrawer.drawPlusOnButton(getEmptyEntry());
		}
	}
}
