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
		width      = 8;
		
		button.setButtonPressedFunction(new VoidFunctionPointer() {
			@Override
			public void call() {
				isDropped = ! isDropped;
				
				if(isDropped) {
					setArrowUp();
				} else {
					setArrowDown();
				}
			}
		});
	}
	
	public void setMenuBar(AWTMenuBar MENU_BAR) {
		menuBar = MENU_BAR;
		setArrowDown();
	}
	
	@Override
	public void update(MouseUserDevice mouse) {
		updateArrowButtonPosition();
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
	
	private void setArrowUp() {
		Point position = getDesiredButtonPosition();
		ArrowButton.up(button, position, 0, width);
		button.shift(0, -width);
	}
	
	private void setArrowDown() {
		Point position = getDesiredButtonPosition();
		ArrowButton.down(button, position, 0, width);
	}
	
	private Point getDesiredButtonPosition() {
		return new Point(menuBar.getPosition().x + 2*width, menuBar.getPosition().y + 2*width);
	}
	
	private void updateArrowButtonPosition() {
		button.setPosition(getDesiredButtonPosition());
	}
}
