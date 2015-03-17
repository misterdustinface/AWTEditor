package AWT.UI;

import java.awt.Color;

import AWT.graphicdata.EditorAWTGraphicData;
import UI.MenuButton;

public class AWTMenuButton extends MenuButton {
	
	protected Color pressedColor;
	protected Color releasedColor;
	protected Color highlightColor;
	private boolean isFilled;
	
	private EditorAWTGraphicData graphicData;
	
	public AWTMenuButton() {
		super();
		graphicData = EditorAWTGraphicData.getGraphicData();
		pressedColor  = graphicData.buttonPressedColor; 
		releasedColor = graphicData.buttonColor;         
		highlightColor= graphicData.buttonHighlightColor;
		isFilled      = false;
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
	
	public Color getColor() {
		return isPressed() ? pressedColor : isHighlighted() ? highlightColor : releasedColor;
	}
	public Color getNormalColor() {
		return releasedColor;
	}
	
	public boolean isFilled() { 
		return isFilled; 
	}
	public void fill() { 
		isFilled = true; 
	}
	public void toggleFill() { 
		isFilled = !isFilled; 
	}
}
