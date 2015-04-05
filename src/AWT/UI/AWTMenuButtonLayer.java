package AWT.UI;

import java.awt.Graphics2D;

import AWT.rendering.AWTMenuDrawer;
import UI.input.MouseUserDevice;

public class AWTMenuButtonLayer implements AWTUILayer {

	private AWTMenuDrawer buttonDrawer;
	private AWTMenuButton button;
	
	public AWTMenuButtonLayer() {
		buttonDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	public void setButton(AWTMenuButton button) {
		this.button = button;
	}

	public void update(MouseUserDevice mouse) {
		button.update(mouse);
	}

	public void render(Graphics2D g) {
		buttonDrawer.drawButton(button);
	}
	
}