package AWT.rendering;

import rendering.CursorDrawer;
import AWT.graphicdata.AWTGraphicData;

final public class AWTCursorDrawer extends AWTRenderer implements CursorDrawer {
	
	private static AWTCursorDrawer cursorDrawer = new AWTCursorDrawer();
	private AWTGraphicData graphicData;
	
	private AWTCursorDrawer() {
		graphicData = AWTGraphicData.getGraphicData();
	}
	
	public static AWTCursorDrawer getCursorDrawer() {
		return cursorDrawer;
	}
	
	public void drawCrosshairCursor(int X, int Y){
		graphics.drawLine(	X - graphicData.cursorStretchOutAmount, Y, 
							X - graphicData.cursorCenterGapAmount,  Y);
		graphics.drawLine(	X + graphicData.cursorStretchOutAmount, Y, 
							X + graphicData.cursorCenterGapAmount,  Y);
		graphics.drawLine(	X, Y - graphicData.cursorStretchOutAmount, 
							X, Y - graphicData.cursorCenterGapAmount);
		graphics.drawLine(	X, Y + graphicData.cursorStretchOutAmount, 
							X, Y + graphicData.cursorCenterGapAmount);
	}

	private final static double radianThetaOfCursor = Math.PI/6;
	public void drawTriangularCrosshairCursor(int X, int Y){
		graphics.drawLine(	(int)(X - graphicData.cursorStretchOutAmount   * Math.cos(radianThetaOfCursor)), (int)(Y + graphicData.cursorStretchOutAmount * Math.sin(radianThetaOfCursor)),
							(int)(X - graphicData.cursorCenterGapAmount    * Math.cos(radianThetaOfCursor)), (int)(Y + graphicData.cursorCenterGapAmount  * Math.sin(radianThetaOfCursor)));
		graphics.drawLine(	1+(int)(X + graphicData.cursorStretchOutAmount * Math.cos(radianThetaOfCursor)), (int)(Y + graphicData.cursorStretchOutAmount * Math.sin(radianThetaOfCursor)), 
							1+(int)(X + graphicData.cursorCenterGapAmount  * Math.cos(radianThetaOfCursor)), (int)(Y + graphicData.cursorCenterGapAmount  * Math.sin(radianThetaOfCursor)));
		graphics.drawLine(	X, Y - graphicData.cursorStretchOutAmount, 
							X, Y - graphicData.cursorCenterGapAmount);
	}
	
	public void drawLargeCircleCursor(int X, int Y){
		drawO(X,Y, graphicData.cursorStretchOutAmount);
	}
	public void drawSmallCircleCursor(int X, int Y){
		drawO(X,Y, graphicData.cursorCenterGapAmount);
	}
	
	public void drawLargeXCursor(int X, int Y){
		drawX(X,Y, graphicData.cursorStretchOutAmount);
	}
	public void drawSmallXCursor(int X, int Y){
		drawX(X,Y, graphicData.cursorCenterGapAmount);
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
	
	@Override
	public void drawPointerCursor(int X, int Y) {

		int last = graphicData.POINTER_CURSOR_X.length-1;
		
		for (int i = 0; i < last; ++i) {
			graphics.drawLine(X + graphicData.POINTER_CURSOR_X[i]  , Y + graphicData.POINTER_CURSOR_Y[i]  , 
					  		  X + graphicData.POINTER_CURSOR_X[i+1], Y + graphicData.POINTER_CURSOR_Y[i+1]);
		}
		
		graphics.drawLine(X + graphicData.POINTER_CURSOR_X[0]   , Y + graphicData.POINTER_CURSOR_Y[0]   , 
		  		  		  X + graphicData.POINTER_CURSOR_X[last], Y + graphicData.POINTER_CURSOR_Y[last]);
	}
}
