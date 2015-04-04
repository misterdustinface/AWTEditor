package AWT.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import listenerpattern.Listener;
import listenerpattern.Notifier;
import UI.DiscreteGridLayer;
import UI.Discretizer;
import UI.Viewport;
import UI.Zoomable;
import UI.input.MouseUserDevice;

public class AWTDiscreteGridLayer extends AWTGridLayer implements DiscreteGridLayer {

	public Color MOUSEOVER_HIGHLIGHT_COLOR = new Color(225,225,225);
	protected int mouseX, mouseY;
	private int selectedRow, selectedCol;
	private Notifier tileSelectedNotifier;
	
	public AWTDiscreteGridLayer(Viewport VIEWPORT, Zoomable ZOOMER) {
		super(VIEWPORT, ZOOMER);
		tileSelectedNotifier = new Notifier();
	}
	
	public void addTileSelectedListener(Listener listener) {
		tileSelectedNotifier.addListener(listener);
	}
	
	public void update(MouseUserDevice mouse) {
		setMousePosition((int)mouse.getCursorX(), (int)mouse.getCursorY());
		
		if (shouldTileBeSelected(mouse)) {
			selectTile();
		}
		
		super.update(mouse);
	}
	
	public void render(Graphics2D g) {
		super.render(g);
		highlightMouseoverGridSquare(g);
	}
	
	public int getSelectedRow() {
		return selectedRow;
	}

	public int getSelectedCol() {
		return selectedCol;
	}
	
	public int getMouseoverRow() {
		return getMouseoverTileRow();
	}

	public int getMouseoverCol() {
		return getMouseoverTileCol();
	}	
	
	private void setMousePosition(int x, int y) {
		mouseX = x;
		mouseY = y;
	}
	
	private boolean shouldTileBeSelected(MouseUserDevice mouse) {
		return mouse.isPressed() || mouse.isClicked();
	}
	
	private void selectTile() {
		selectedRow = getMouseoverTileRow();
		selectedCol = getMouseoverTileCol();
		tileSelectedNotifier.notifyListeners();
	}
	
	private void highlightMouseoverGridSquare(Graphics g) {
		g.setColor(MOUSEOVER_HIGHLIGHT_COLOR);
		g.fillRect(	getMouseoverTileXPosition(), getMouseroverTileYPosition(), 
					getTileWidth(), getTileHeight());
	}
	
	private int getMouseoverTileXPosition() {
		return Discretizer.getMouseoverTileXPosition(mouseX, this);
	}
	
	private int getMouseroverTileYPosition() {
		return Discretizer.getMouseoverTileYPosition(mouseY, this);
	}
	
	private int getMouseoverTileRow() {
		return Discretizer.getRowAtYPosition(mouseY, this);
	}
	
	private int getMouseoverTileCol() {
		return Discretizer.getColAtXPosition(mouseX, this);
	}

}