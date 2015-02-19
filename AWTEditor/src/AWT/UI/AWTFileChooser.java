package AWT.UI;

import java.awt.Graphics2D;

import AWT.rendering.AWTMenuDrawer;
import UI.FileChooser;
import UI.MenuButton;

public class AWTFileChooser extends FileChooser implements AWTUILayer {
	
	private AWTMenuDrawer menuDrawer;
	
	public AWTFileChooser() {
		menuDrawer = AWTMenuDrawer.getMenuDrawer();
	}
	
	@Override
	public void render(Graphics2D g) {
		if (shouldDisplayAndUpdate()) {
			menuDrawer.setGraphics(g);
			menuDrawer.drawFileChooser(this);
		}
	}
	
	@Override
	protected MenuButton extendedMenuButton() { 
		return new AWTMenuButton(); 
	}
	
}