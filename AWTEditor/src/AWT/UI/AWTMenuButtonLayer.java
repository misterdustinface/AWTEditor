package AWT.UI;

import java.awt.Graphics2D;

import AWT.rendering.AWTMenuDrawer;
import UI.MouseUserDevice;

public class AWTMenuButtonLayer implements AWTUILayer {

	private AWTMenuDrawer buttonDrawer;
	private AWTMenuButton button;
	
	public AWTMenuButtonLayer() {
		buttonDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	public void setButton(AWTMenuButton button) {
		this.button = button;
	}

	@Override
	public void update(MouseUserDevice mouse) {
		button.update(mouse);
	}

	@Override
	public void render(Graphics2D g) {
		buttonDrawer.drawButton(button);
	}
}
