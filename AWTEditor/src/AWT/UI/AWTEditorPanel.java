package AWT.UI;


import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import UI.UILayerManager;
import UI.UIFunction;
import UI.UILayer;
import AWT.UI.Mouse.AWTMouseUserDevice;
import AWT.graphicdata.EditorAWTGraphicData;

public class AWTEditorPanel extends AWTZoomableViewport {
	
	private static final long serialVersionUID = -4178489165743436644L;

	final public static Cursor INVISIBLE_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor((Image)(new BufferedImage(4, 4, BufferedImage.TYPE_INT_ARGB)),new java.awt.Point(0, 0), "INVISIBLE");
	
	private UILayerManager layerManager;
	private Graphics2D graphics2D;
	private UIFunction uiRender = new UIFunction() {
		@Override
		public void call(UILayer ui) {
			((AWTUILayer)ui).render(graphics2D);
		}
	};
	
	public AWTEditorPanel() {
		setCursor(INVISIBLE_CURSOR);
		setBackground(EditorAWTGraphicData.getGraphicData().BACKGROUND_COLOR);
		setDoubleBuffered(true);
	}
	
	public AWTEditorPanel(AWTMouseUserDevice userDevice){
		this();
		addViewportMouseListener(userDevice);
		addViewportMotionListener(userDevice);
	}
	
	public void setLayerManager(UILayerManager layerManager) {
		this.layerManager = layerManager;
	}	
	
	@Override
    protected void paintComponent(Graphics g){		
		super.paintComponent(g);
		repaint();
		graphics2D = (Graphics2D)g;
		layerManager.forAllUIPerformFunction(uiRender);
    }
}
