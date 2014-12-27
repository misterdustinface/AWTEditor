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
import AWT.graphicdata.AWTGraphicData;

public class AWTEditorPanel extends AWTViewport {
	
	private static final long serialVersionUID = -4178489165743436644L;

	final public static Cursor INVISIBLE_CURSOR = Toolkit.getDefaultToolkit().createCustomCursor((Image)(new BufferedImage(4, 4, BufferedImage.TYPE_INT_ARGB)),new java.awt.Point(0, 0), "INVISIBLE");
	
	private UILayerManager	layerManager;
	private AWTMouseUserDevice mouse;
	
	//private SwingVKeyDriver   vKey;
	
	public AWTEditorPanel(AWTMouseUserDevice userDevice){
		setCursor(INVISIBLE_CURSOR);
		mouse 		= userDevice;
		
		addViewportMouseListener(mouse);
		addViewportMotionListener(mouse);
		setBackground(AWTGraphicData.BACKGROUND_COLOR);
		
		setDoubleBuffered(true);
	}
	
	public void setLayerManager(UILayerManager layerManager) {
		this.layerManager = layerManager;
	}
	
	private Graphics2D graphics2D;
	
	private UIFunction uiRender = new UIFunction() {
		@Override
		public void call(UILayer ui) {
			((AWTUILayer)ui).render(graphics2D);
		}
	};
	
	@Override
    protected void paintComponent(Graphics g){		
		super.paintComponent(g);
		repaint();
		graphics2D = (Graphics2D)g;
		
		layerManager.forAllUIPerformFunction(uiRender);
		
		try {
			Thread.sleep(5); // Fixes really strange swing thread priority bug.
		} catch (Exception e) {}
    }
}
