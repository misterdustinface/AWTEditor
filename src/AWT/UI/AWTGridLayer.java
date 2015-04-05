package AWT.UI;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import shapes.Rectangle;
import UI.GridLayer;
import UI.Viewport;
import UI.Zoomable;
import UI.input.MouseUserDevice;

public class AWTGridLayer implements AWTUILayer, GridLayer {
	
	public Color BACKGROUND_COLOR  	= new Color(250,250,250);
	public Color MINOR_LINES_COLOR 	= new Color(225,225,225);
	public Color MAJOR_LINES_COLOR 	= new Color(180,180,180);
	public Color ORIGIN_COLOR 		= Color.RED;
	
	protected int MINOR_LINE_WIDTH_SPACING, MINOR_LINE_HEIGHT_SPACING;
	protected int MAJOR_LINE_WIDTH_SPACING, MAJOR_LINE_HEIGHT_SPACING;
	protected int 	xPos, yPos;
	protected float width, height;
	protected float zoom;
	
	protected Rectangle drawingBounds;
	protected Viewport  viewport;
	protected Zoomable  zoomer;
	
	public AWTGridLayer(Viewport VIEWPORT, Zoomable ZOOMER){
		xPos = yPos = 0;
		width = height = 0;
		zoom = 1.0f;
		drawingBounds = new Rectangle();
		viewport = VIEWPORT;
		zoomer   = ZOOMER;
		setTileSize(16);
	}
	
	public void setTileWidth(int TILE_WIDTH) {
		MINOR_LINE_WIDTH_SPACING = TILE_WIDTH;
		MAJOR_LINE_WIDTH_SPACING = MINOR_LINE_WIDTH_SPACING * 8;
	}
	
	public void setTileHeight(int TILE_HEIGHT) {
		MINOR_LINE_HEIGHT_SPACING = TILE_HEIGHT;
		MAJOR_LINE_HEIGHT_SPACING = MINOR_LINE_HEIGHT_SPACING * 8;
	}
	
	public void setTileSize(int TILE_SIZE) {
		setTileWidth(TILE_SIZE);
		setTileHeight(TILE_SIZE);
	}
	
	public int getTileWidth() { 
		return MINOR_LINE_WIDTH_SPACING; 
	}
	
	public int getTileHeight() { 
		return MINOR_LINE_HEIGHT_SPACING; 
	}
	
	public void render(Graphics2D g) {
		drawBackground(g);
		drawMinorLines(g);
		drawMajorLines(g);
		drawOriginLines(g);
	}

	public void update(MouseUserDevice mouse) {
		setCenter((int)viewport.getXPosition(), (int)viewport.getYPosition());
		setDimensions(viewport.getWidth(), viewport.getHeight());
		setZoom(zoomer.getZoom());
		calculateDrawingBounds();
	}
	
	private void setCenter(int X, int Y) { 
		xPos = X; 
		yPos = Y; 
	}
	
	private void setDimensions(float WIDTH, float HEIGHT) { 
		width = WIDTH; 
		height = HEIGHT; 
	}
	
	private void setZoom(float ZOOM) { 
		zoom = ZOOM; 
	}
	
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
		makeCrissCrossLines(g, MINOR_LINE_WIDTH_SPACING, MINOR_LINE_HEIGHT_SPACING);
	}
	
	private void drawMajorLines(Graphics g){
		g.setColor(MAJOR_LINES_COLOR);
		makeCrissCrossLines(g, MAJOR_LINE_WIDTH_SPACING, MAJOR_LINE_HEIGHT_SPACING);
	}
	
	private void makeCrissCrossLines(Graphics g, int WIDTH_SPACING, int HEIGHT_SPACING) {
		int xStart = (int)drawingBounds.x - (int)drawingBounds.x % WIDTH_SPACING;
		int yStart = (int)drawingBounds.y - (int)drawingBounds.y % HEIGHT_SPACING;
		
		for (int i = xStart; i < xStart + (int)drawingBounds.width; i+= WIDTH_SPACING)
			g.drawLine(i, (int)drawingBounds.y, i , (int)drawingBounds.y + (int)drawingBounds.height);
		for (int j = yStart; j < yStart + (int)drawingBounds.height; j+= HEIGHT_SPACING)
			g.drawLine((int)drawingBounds.x, j, (int)drawingBounds.x + (int)drawingBounds.width , j);
	}
	
	private void drawOriginLines(Graphics g){
		g.setColor(ORIGIN_COLOR);
		g.drawLine(0,(int)drawingBounds.y, 0, (int)drawingBounds.y + (int)drawingBounds.height);
		g.drawLine((int)drawingBounds.x, 0, (int)drawingBounds.x + (int)drawingBounds.width, 0);
	}
	
}