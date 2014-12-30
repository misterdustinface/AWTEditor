package AWT.UI;

import generic.VoidFunctionPointer;

import java.awt.Graphics2D;

import shapes.Point;
import AWT.rendering.AWTMenuDrawer;
import UI.ArrowButton;
import UI.MouseUserDevice;

public class AWTDropdownMenuBar implements AWTUILayer {
	
	private AWTMenuButton 	button;
	private AWTMenuBar 		menuBar;
	private AWTMenuDrawer 	menuDrawer;
	private boolean 		isDropped;
	
	private int width;
	
	public AWTDropdownMenuBar() {
		menuDrawer = new AWTMenuDrawer();
		isDropped  = false;
		button 	   = new AWTMenuButton();
		
		width = 8;
		
		ArrowButton.up(button, new Point(width, 0), 0, width);
		
		button.setButtonPressedFunction(new VoidFunctionPointer() {
			@Override
			public void call() {
				isDropped = ! isDropped;
				
				Point position = new Point(menuBar.getPosition().x + 2*width, menuBar.getPosition().y + 2*width);
				
				if(isDropped) {
					position.shift(0, -width);
					ArrowButton.up(button, position, 0, width);
				} else {
					ArrowButton.down(button, position, 0, width);
				}
			}
		});
	}
	
	public void setMenuBar(AWTMenuBar MENU_BAR) {
		menuBar = MENU_BAR;
	}

	private void moveButtonPosition() {
		
		Point position = new Point(menuBar.getPosition().x + 2*width, menuBar.getPosition().y + 2*width);
		
		if(isDropped) {
			position.shift(0, -width);
			ArrowButton.up(button, position, 0, width);
		} else {
			ArrowButton.down(button, position, 0, width);
		}
		
		// TODO use polygon set position functions when it works.
	}
	
	@Override
	public void update(MouseUserDevice mouse) {
		moveButtonPosition();
		button.update(mouse);
		
		if(isDropped) {
			menuBar.update(mouse);
		}
	}

	@Override
	public void render(Graphics2D g) {
		menuDrawer.setGraphics(g);
		menuDrawer.drawButton(button);
		if(isDropped) {
			menuBar.render(g);
		}
	}
}
