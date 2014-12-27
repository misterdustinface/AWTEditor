package AWT.rendering;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import AWT.UI.AWTUILayer;
import UI.MouseUserDevice;
import UI.Viewport;
import UI.Zoomable;
import data.shapes.Rectangle;

public class AWTGridDrawer implements AWTUILayer {
	
	public Color BACKGROUND_COLOR  	= new Color(250,250,250);
	public Color MINOR_LINES_COLOR 	= new Color(225,225,225);
	public Color MAJOR_LINES_COLOR 	= new Color(180,180,180);
	public Color ORIGIN_COLOR 		= Color.RED;
	public Color MOUSEOVER_HIGHLIGHT_COLOR = new Color(225,225,225);
	public int 	MINOR_LINE_SPACING 	= 16;
	public int 	MAJOR_LINE_SPACING 	= MINOR_LINE_SPACING * 8;
	
	private int 	xPos, yPos;
	private float   width, height;
	private float 	zoom;
	
	private Rectangle drawingBounds;
	private Viewport  viewport;
	private Zoomable  zoomer;
	
	private int mouseX, mouseY;
	
	public AWTGridDrawer(Viewport VIEWPORT, Zoomable ZOOMER){
		xPos = yPos = 0;
		width = height = 0;
		zoom = 1.0f;
		drawingBounds = new Rectangle();
		viewport = VIEWPORT;
		zoomer   = ZOOMER;
	}
	
	@Override
	public void render(Graphics2D g) {
		drawBackground(g);
		drawMinorLines(g);
		drawMajorLines(g);
		drawOriginLines(g);
		
		highlightMouseoverGridSquare(g);
	}
	@Override
	public void update(MouseUserDevice mouse) {
		setCenter((int)viewport.getXPosition(), (int)viewport.getYPosition());
		setDimensions(viewport.getWidth(), viewport.getHeight());
		setZoom(zoomer.getZoom());
		calculateDrawingBounds();
		mouseX = (int)mouse.getCursorX();
		mouseY = (int)mouse.getCursorY();
	}
	
	private void setCenter(int X, int Y) { xPos = X; yPos = Y; }
	private void setDimensions(float WIDTH, float HEIGHT) { width = WIDTH; height = HEIGHT; }
	private void setZoom(float ZOOM) { zoom = ZOOM; }
	
	private void calculateDrawingBounds(){
		drawingBounds.x 	 = -(int)(width/zoom)-xPos;
		drawingBounds.y 	 = -(int)(height/zoom)-yPos;
		drawingBounds.width  = 2*(int)(width/zoom);
		drawingBounds.height = 2*(int)(height/zoom);
	}
	private void drawBackground(Graphics g){
		g.setColor(BACKGROUND_COLOR);
		g.fillRect((int)drawingBounds.x, (int)drawingBounds.y, (int)drawingBounds.width, (int)drawingBounds.height);
	}
	private void drawMinorLines(Graphics g){
		g.setColor(MINOR_LINES_COLOR);
		makeCrissCrossLines(g, MINOR_LINE_SPACING);
	}
	private void drawMajorLines(Graphics g){
		g.setColor(MAJOR_LINES_COLOR);
		makeCrissCrossLines(g, MAJOR_LINE_SPACING);
	}
	
	private void makeCrissCrossLines(Graphics g, int SPACING) {
		for(int i = 0; i < width;  i+= SPACING)
			g.drawLine(i, (int)drawingBounds.y, i , (int)drawingBounds.height);
		for(int j = 0; j < height; j+= SPACING)
			g.drawLine((int)drawingBounds.x, j, (int)drawingBounds.width , j);
		for(int i = 0; i > -width; i-= SPACING)
			g.drawLine(i, (int)drawingBounds.y, i , (int)drawingBounds.height);
		for(int j = 0; j > -height;j-= SPACING)
			g.drawLine((int)drawingBounds.x, j, (int)drawingBounds.width , j);
	}
	
	private void drawOriginLines(Graphics g){
		g.setColor(ORIGIN_COLOR);
		g.drawLine(0,(int)drawingBounds.y,0,(int)drawingBounds.height);
		g.drawLine((int)drawingBounds.x, 0, (int)drawingBounds.width, 0);
	}
	
	private void highlightMouseoverGridSquare(Graphics g) {
		g.setColor(MOUSEOVER_HIGHLIGHT_COLOR);
		int x = mouseX - (mouseX % MINOR_LINE_SPACING);
		int y = mouseY - (mouseY % MINOR_LINE_SPACING);
		if(mouseX < 0) { x -= MINOR_LINE_SPACING; }
		if(mouseY < 0) { y -= MINOR_LINE_SPACING; }
		g.fillRect(x, y, MINOR_LINE_SPACING, MINOR_LINE_SPACING);
	}
	
}
