package AWT.UI;

import java.awt.Color;

import AWT.graphicdata.EditorAWTGraphicData;
import UI.widgets.BarSlider;

public class AWTBarSlider extends BarSlider {

	private Color 	  pressedColor;
	private Color 	  releasedColor;
	private Color 	  highlightColor;
	private Color     baseColor;
	
	private EditorAWTGraphicData graphicData;
	
	public AWTBarSlider() {
		super();	
		graphicData = EditorAWTGraphicData.getGraphicData();
		pressedColor  = graphicData.getColorOf("buttonPressed"); 
		releasedColor = graphicData.getColorOf("button");         
		highlightColor= graphicData.getColorOf("buttonHighlight");
		baseColor     = graphicData.getColorOf("base");
	}
	
	public void setBaseColor(Color c) { 
		baseColor = c; 
	}
	
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