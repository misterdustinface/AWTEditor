package AWT.UI;

import java.awt.Color;
import java.awt.Graphics2D;

import AWT.rendering.AWTMenuDrawer;
import UI.widgets.FileChooser;
import UI.widgets.MenuButton;

public class AWTFileChooser extends FileChooser implements AWTUILayer {
	
	private AWTMenuDrawer menuDrawer;
	
	public AWTFileChooser() {
		menuDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	public void render(Graphics2D g) {
		if (shouldDisplayAndUpdate()) {
			menuDrawer.setGraphics(g);
			menuDrawer.drawFileChooser(this);
		}
	}
	
	protected MenuButton extendedMenuButton() { 
		AWTMenuButton button = new AWTMenuButton();
		button.getTextLabel().setMaxTextWidth(20);
		button.fill();
		button.setColor(Color.DARK_GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY);
		return button; 
	}
	
}