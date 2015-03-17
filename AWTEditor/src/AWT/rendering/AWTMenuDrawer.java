package AWT.rendering;

import generic.tags.Singleton;
import rendering.MenuDrawer;
import shapes.Point;
import AWT.UI.AWTBarSlider;
import AWT.UI.AWTMenuButton;
import AWT.graphicdata.EditorAWTGraphicData;
import UI.BarSlider;
import UI.FileChooser;
import UI.MenuButton;
import UI.TextLabel;
import UI.UIMenu;

final public class AWTMenuDrawer extends AWTRenderer implements MenuDrawer, Singleton {

	private static AWTMenuDrawer menuDrawer = new AWTMenuDrawer();
	
	private AWTShapeDrawer shapeDrawer;
	private EditorAWTGraphicData graphicData;
	
	private AWTMenuDrawer() {
		shapeDrawer = AWTShapeDrawer.getShapeDrawer();
		graphicData = EditorAWTGraphicData.getGraphicData();
	}
	
	public static AWTMenuDrawer getMenuDrawer() {
		return menuDrawer;
	}
	
	public void drawTextLabel( TextLabel tl) {
		if (tl.hasText()) {
			graphics.drawString(tl.getText(), tl.getPosition().x, tl.getPosition().y);
		}
	}
	
	public void drawButton( MenuButton b) {
		if (((AWTMenuButton)b).isFilled()) {
			drawFilledButton((AWTMenuButton)b);
		} else {
			drawButton((AWTMenuButton)b);
		}
	}
	
	private void drawButton( AWTMenuButton b ) {
		shapeDrawer.setGraphics(graphics);
		shapeDrawer.setColor(((AWTMenuButton)b).getColor());
		shapeDrawer.drawPolygon(b.polygon);
		drawTextLabel(b.textLabel);
	}
	
	private void drawFilledButton( AWTMenuButton b ) {
		shapeDrawer.setGraphics(graphics);
		shapeDrawer.setColor(((AWTMenuButton)b).getNormalColor());
		shapeDrawer.drawFilledPolygon(b.polygon);
		shapeDrawer.setColor(((AWTMenuButton)b).getColor());
		shapeDrawer.drawFilledPolygon(b.polygon);
		drawTextLabel(b.textLabel);
	}
	
	public void drawPlusOnButton( MenuButton b ) {
		
		int centerX    = (int) b.getCenterX();
		int centerY    = (int) b.getCenterY();
		int plusWidth  = (int) b.getWidth() >>1;
		int plusHeight = (int) b.getHeight()>>1;
		plusWidth  = plusWidth < plusHeight ? plusWidth : plusHeight;
		plusHeight = graphicData.getThicknessOf("plusSign");
		
		shapeDrawer.setGraphics(graphics);
		shapeDrawer.setColor(graphicData.getColorOf("PLUS_SIGN"));
		graphics.fillRect(centerX - (plusWidth >>1), centerY - (plusHeight>>1), plusWidth,  plusHeight);
		graphics.fillRect(centerX - (plusHeight>>1), centerY - (plusWidth >>1), plusHeight, plusWidth);
	}
	
	public void drawSlider( BarSlider s ) {
		shapeDrawer.setGraphics(graphics);
		shapeDrawer.setColor(((AWTBarSlider)s).getBaseColor());
		shapeDrawer.drawFilledRectangle(s.getBase());
		shapeDrawer.setColor(((AWTBarSlider)s).getFillColor());
		shapeDrawer.drawFilledRectangle(s.getFill());
	}
	
	public void drawSelectorArrow( MenuButton b, int x, int size ) {
		int y = (int) b.polygon.getBoundingRectangle().getCenterY();
		graphics.setColor(((AWTMenuButton)b).getColor());
		graphics.drawLine(x,        y,        x - size, y + size);
		graphics.drawLine(x,        y,        x - size, y - size);
		graphics.drawLine(x - size, y - size, x - size, y + size);
	}
	
	public void drawMenuBox( Point topLeft, int width, int height) {
		drawMenuBox((int)topLeft.x, (int)topLeft.y, width, height);
	}
	
	public void drawMenuBox( int X, int Y, int width, int height) {
		graphics.setColor(graphicData.getColorOf("MENU_BACKGROUND"));
		graphics.fillRect(X, Y, width, height);
		graphics.setColor(graphicData.getColorOf("button"));
		graphics.drawRect(X, Y, width, height);
	}
	
	public void drawUIMenu( UIMenu menu ) {
		drawMenuBox(menu.getX(), menu.getY(), menu.getWidth(), menu.getHeight());
		for (int i = 0; i < menu.numberOfButtons(); ++i) {
			drawButton(menu.getButton(i));
		}
	}

	@Override
	public void drawFileChooser(FileChooser fileChooser) {
		if (fileChooser.shouldDisplayAndUpdate()){
			drawUIMenu(fileChooser.getFileListing());
			drawButton(fileChooser.getUpButton());
			drawButton(fileChooser.getExitButton());
		}
	}
	
}
