package AWT.UI;

import java.awt.Color;

import AWT.graphicdata.AWTGraphicData;
import UI.BarSlider;

public abstract class AWTBarSlider extends BarSlider {

	private Color 	  pressedColor;
	private Color 	  releasedColor;
	private Color 	  highlightColor;
	private Color     baseColor;
	
	private AWTGraphicData graphicData;
	
	public AWTBarSlider() {
		super();	
		graphicData = AWTGraphicData.getGraphicData();
		pressedColor  = graphicData.buttonPressedColor; 
		releasedColor = graphicData.buttonColor;         
		highlightColor= graphicData.buttonHighlightColor;
		baseColor     = graphicData.baseColor;
	}
	
	public void setBaseColor(Color c) { baseColor = c; }
	
	public void setColor(Color c) {
		pressedColor = releasedColor = highlightColor = c;
	}
	
	public void setColor(Color pressed, Color released) {
		pressedColor  = pressed;
		highlightColor = releasedColor = released;
	}
	
	public void setColor(Color pressed, Color released, Color highlight) {
		pressedColor  = pressed;
		releasedColor = released;
		highlightColor = highlight;
	}
	
	public Color getBaseColor() { 
		return baseColor; 
	}
	public Color getFillColor() { 
		return isPressed() ? pressedColor : isHighlighted() ? highlightColor : releasedColor; 
	}
}
