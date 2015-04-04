package AWT.rendering;

import datastructures.Table;
import rendering.CursorDrawer;
import shapes.Point;
import shapes.Polygon;
import tags.Singleton;
import AWT.graphicdata.EditorAWTGraphicData;

final public class AWTCursorDrawer extends AWTRenderer implements CursorDrawer, Singleton {
	
	private final static AWTCursorDrawer cursorDrawer = new AWTCursorDrawer();
	private static EditorAWTGraphicData graphicData;
	private Table<CursorDrawer> drawers;
	private CursorDrawer drawer;
	
	private final static Polygon pointerCursor = new Polygon(new Point[] { 
			new Point(0, 0), 
			new Point(15, 5),
			new Point(8, 8),
			new Point(5, 15)
	});
	
	private AWTCursorDrawer() {
		graphicData = EditorAWTGraphicData.getGraphicData();
		
		drawers = new Table<CursorDrawer>();
		drawers.insert("Pointer", new CursorDrawer() {
			public void drawCursor(int x, int y) {
				drawPointerCursor(x, y);
			}
		});
		drawers.insert("Crosshair", new CursorDrawer() {
			public void drawCursor(int x, int y) {
				drawCrosshairCursor(x, y);
			}
		});
		drawers.insert("Triangle", new CursorDrawer() {
			public void drawCursor(int x, int y) {
				drawTriangularCrosshairCursor(x, y);
			}
		});
		drawers.insert("LargeCircle", new CursorDrawer() {
			public void drawCursor(int x, int y) {
				drawLargeCircleCursor(x, y);
			}
		});
		drawers.insert("SmallCircle", new CursorDrawer() {
			public void drawCursor(int x, int y) {
				drawSmallCircleCursor(x, y);
			}
		});
		drawers.insert("LargeX", new CursorDrawer() {
			public void drawCursor(int x, int y) {
				drawLargeXCursor(x, y);
			}
		});
		drawers.insert("SmallX", new CursorDrawer() {
			public void drawCursor(int x, int y) {
				drawSmallXCursor(x, y);
			}
		});
		
		setCursor("Pointer");
	}
	
	public static AWTCursorDrawer getCursorDrawer() {
		return cursorDrawer;
	}
	
	public void setCursor(String name) {
		drawer = drawers.get(name);
	}
	
	public void drawCursor(int X, int Y) {
		drawer.drawCursor(X, Y);
	}
	
	private void drawCrosshairCursor(int X, int Y){
		graphics.drawLine(	X - graphicData.getThicknessOf("cursorStretchOutAmount"), Y, 
							X - graphicData.getThicknessOf("cursorCenterGapAmount"),  Y);
		graphics.drawLine(	X + graphicData.getThicknessOf("cursorStretchOutAmount"), Y, 
							X + graphicData.getThicknessOf("cursorCenterGapAmount"),  Y);
		graphics.drawLine(	X, Y - graphicData.getThicknessOf("cursorStretchOutAmount"), 
							X, Y - graphicData.getThicknessOf("cursorCenterGapAmount"));
		graphics.drawLine(	X, Y + graphicData.getThicknessOf("cursorStretchOutAmount"), 
							X, Y + graphicData.getThicknessOf("cursorCenterGapAmount"));
	}

	private final static double radianThetaOfCursor = Math.PI/6;
	private void drawTriangularCrosshairCursor(int X, int Y){
		graphics.drawLine(	(int)(X - graphicData.getThicknessOf("cursorStretchOutAmount")   * Math.cos(radianThetaOfCursor)), (int)(Y + graphicData.getThicknessOf("cursorStretchOutAmount") * Math.sin(radianThetaOfCursor)),
							(int)(X - graphicData.getThicknessOf("cursorCenterGapAmount")    * Math.cos(radianThetaOfCursor)), (int)(Y + graphicData.getThicknessOf("cursorCenterGapAmount")  * Math.sin(radianThetaOfCursor)));
		graphics.drawLine(	1+(int)(X + graphicData.getThicknessOf("cursorStretchOutAmount") * Math.cos(radianThetaOfCursor)), (int)(Y + graphicData.getThicknessOf("cursorStretchOutAmount") * Math.sin(radianThetaOfCursor)), 
							1+(int)(X + graphicData.getThicknessOf("cursorCenterGapAmount")  * Math.cos(radianThetaOfCursor)), (int)(Y + graphicData.getThicknessOf("cursorCenterGapAmount")  * Math.sin(radianThetaOfCursor)));
		graphics.drawLine(	X, Y - graphicData.getThicknessOf("cursorStretchOutAmount"), 
							X, Y - graphicData.getThicknessOf("cursorCenterGapAmount"));
	}
	
	private void drawLargeCircleCursor(int X, int Y){
		drawO(X,Y, graphicData.getThicknessOf("cursorStretchOutAmount"));
	}
	
	private void drawSmallCircleCursor(int X, int Y){
		drawO(X,Y, graphicData.getThicknessOf("cursorCenterGapAmount"));
	}
	
	private void drawLargeXCursor(int X, int Y){
		drawX(X,Y, graphicData.getThicknessOf("cursorStretchOutAmount"));
	}
	
	private void drawSmallXCursor(int X, int Y){
		drawX(X,Y, graphicData.getThicknessOf("cursorCenterGapAmount"));
	}
	
	private void drawX(int X, int Y, int radius){
		graphics.drawLine(	X - radius, Y - radius, 
							X + radius, Y + radius);
		graphics.drawLine(	X + radius, Y - radius, 
							X - radius, Y + radius);
	}
	
	private void drawO(int X, int Y, int radius){
		graphics.drawOval(	X - radius, 
							Y - radius, 
							radius+radius, 
							radius+radius);
	}
	
	private void drawPointerCursor(int X, int Y) {

		int last = pointerCursor.xpoints.length-1;
		
		for (int i = 0; i < last; ++i) {
			graphics.drawLine(X + (int)pointerCursor.xpoints[i]  , Y + (int)pointerCursor.ypoints[i]  , 
					  		  X + (int)pointerCursor.xpoints[i+1], Y + (int)pointerCursor.ypoints[i+1]);
		}
		
		graphics.drawLine(X + (int)pointerCursor.xpoints[0]   , Y + (int)pointerCursor.ypoints[0]   , 
		  		  		  X + (int)pointerCursor.xpoints[last], Y + (int)pointerCursor.ypoints[last]);
	}
	
}