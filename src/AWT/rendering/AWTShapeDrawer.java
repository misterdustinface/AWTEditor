package AWT.rendering;

import rendering.ShapeDrawer;
import shapes.Circle;
import shapes.LineSegment;
import shapes.Point;
import shapes.Polygon;
import shapes.Rectangle;
import tags.Singleton;
import AWT.graphicdata.EditorAWTGraphicData;

final public class AWTShapeDrawer extends AWTRenderer implements ShapeDrawer, Singleton {
	
	private static AWTShapeDrawer shapeDrawer = new AWTShapeDrawer();
	
	private AWTTriangleFiller 	triangleFiller;
	private EditorAWTGraphicData graphicData;
	
	private AWTShapeDrawer() {
		triangleFiller = new AWTTriangleFiller();
		graphicData = EditorAWTGraphicData.getGraphicData();
	}
	
	public static AWTShapeDrawer getShapeDrawer() {
		return shapeDrawer;
	}
	
	public void drawPoint(Point p){
		int pointSize = graphicData.getThicknessOf("pointSize");
		graphics.fillOval(	(int)((p.x-((pointSize)>>1))), 
							(int)((p.y-((pointSize)>>1))), 
							pointSize, pointSize);
	}
	
	public void drawLineSegment(LineSegment l){
		graphics.drawLine(	(int)(l.a.x), (int)(l.a.y), (int)(l.b.x), (int)(l.b.y));
	}
	
	public void drawCircle(Circle c){
		graphics.drawArc(	(int)((c.x()-c.radius())), (int)((c.y()-c.radius())), 
							(int)(c.diameter()), (int)(c.diameter()), 0, 360);
	}
	
	public void drawFilledCircle(Circle c){
		graphics.fillArc(	(int)((c.x()-c.radius())), (int)((c.y()-c.radius())), 
							(int)(c.diameter()), (int)(c.diameter()), 0, 360);
	}
	
	public void drawRectangle(Rectangle r){
		graphics.drawRect((int)r.x, (int)r.y, (int)r.width, (int)r.height);
	}
	
	public void drawFilledRectangle(Rectangle r){
		graphics.fillRect((int)r.x, (int)r.y, (int)r.width, (int)r.height);
	}
	
	public void drawPolygon(Polygon p){
		
		if (p.getNumberOfPoints() > 1) {
			
			graphics.drawLine((int)p.xpoints[0], (int)p.ypoints[0], 
							  (int)p.xpoints[p.getNumberOfPoints() - 1], (int)p.ypoints[p.getNumberOfPoints() - 1]);
			
			for (int i = 0; i < p.getNumberOfPoints() - 1; ++i) {
				graphics.drawLine(	(int)p.xpoints[i],   (int)p.ypoints[i], 
									(int)p.xpoints[i+1], (int)p.ypoints[i+1]);
			}
		
		}
	}
	
	public void drawFilledPolygon(Polygon p){
		
		if (p.getNumberOfPoints() > 2) {
			
			triangleFiller.fill((int)p.xpoints[0],   (int)p.ypoints[0], 
								(int)p.xpoints[p.getNumberOfPoints() - 1], (int)p.ypoints[p.getNumberOfPoints() - 1],
								(int)p.xpoints[p.getNumberOfPoints() - 2], (int)p.ypoints[p.getNumberOfPoints() - 2]);
			
			triangleFiller.fill((int)p.xpoints[0],   (int)p.ypoints[0],
								(int)p.xpoints[1],   (int)p.ypoints[1], 
								(int)p.xpoints[p.getNumberOfPoints() - 1], (int)p.ypoints[p.getNumberOfPoints() - 1]);
			
			for (int i = 0; i < p.getNumberOfPoints() - 2; ++i) {
				triangleFiller.fill((int)p.xpoints[i],   (int)p.ypoints[i], 
									(int)p.xpoints[i+1], (int)p.ypoints[i+1],
									(int)p.xpoints[i+2], (int)p.ypoints[i+2]);
			}
		}
		
	}
	
	class AWTTriangleFiller {
		private int[] xAr;
		private int[] yAr;
		
		AWTTriangleFiller() {
			xAr = new int[3]; 
			yAr = new int[3]; 
		}
		
		public void fill(int x1, int y1, int x2, int y2, int x3, int y3) {
			xAr[0] = x1; xAr[1] = x2; xAr[2] = x3;
			yAr[0] = y1; yAr[1] = y2; yAr[2] = y3;
			graphics.fillPolygon(xAr, yAr, 3);
		}
	}
	
}