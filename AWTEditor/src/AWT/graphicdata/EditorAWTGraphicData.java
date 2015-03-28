package AWT.graphicdata;

import generic.tags.NamedData;
import generic.tags.Singleton;

import java.awt.Color;

public class EditorAWTGraphicData extends AWTGraphicData implements Singleton, NamedData {
	
	private static EditorAWTGraphicData graphicData = new EditorAWTGraphicData();
	
	private EditorAWTGraphicData() {
		loadColors();
		loadThicknesses();
	}
	
	private void loadColors() {
		colors.insert("clear", new Color(0,0,0,0));
		colors.insert("lightclear", new Color(50,50,50,50));
		colors.insert("button", new Color(150,150,150));
		colors.insert("buttonHighlight", new Color(125,125,162));
		colors.insert("buttonPressed", new Color(175,100,175));
		colors.insert("base", new Color(200,200,200));
		colors.insert("MENU_BACKGROUND", new Color(240,240,240));
		colors.insert("BACKGROUND", new Color(240,240,240));
		colors.insert("PLUS_SIGN", new Color(165,165,165));
	}
	
	private void loadThicknesses() {
		thicknesses.insert("pointSize", 4);
		thicknesses.insert("cursorStretchOutAmount", 10);
		thicknesses.insert("cursorCenterGapAmount", 2);
		thicknesses.insert("plusSign", 4);
		thicknesses.insert("buttonWidth", 100);
		thicknesses.insert("buttonHeight", 40);
	}
	
	public static EditorAWTGraphicData getGraphicData() {
		return graphicData;
	}
	
	public void scaleThicknessOf(String name, float scaleFactor) {
		thicknesses.insert("name", (int) (thicknesses.get(name) * scaleFactor));
	}
	
	public void setThicknessOf(String name, int thickness) {
		thicknesses.insert(name, thickness);
	}

}