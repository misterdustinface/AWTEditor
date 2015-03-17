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
		colors.put("clear", new Color(0,0,0,0));
		colors.put("lightclear", new Color(50,50,50,50));
		colors.put("button", new Color(150,150,150));
		colors.put("buttonHighlight", new Color(125,125,162));
		colors.put("buttonPressed", new Color(175,100,175));
		colors.put("base", new Color(200,200,200));
		colors.put("MENU_BACKGROUND", new Color(240,240,240));
		colors.put("BACKGROUND", new Color(240,240,240));
		colors.put("PLUS_SIGN", new Color(165,165,165));
	}
	
	private void loadThicknesses() {
		thicknesses.put("pointSize", 4);
		thicknesses.put("cursorStretchOutAmount", 10);
		thicknesses.put("cursorCenterGapAmount", 2);
		thicknesses.put("plusSign", 4);
	}
	
	public static EditorAWTGraphicData getGraphicData() {
		return graphicData;
	}
	
	public void scaleThicknessOf(String name, float scaleFactor) {
		thicknesses.put("name", (int) (thicknesses.get(name) * scaleFactor));
	}
	
	public void setThicknessOf(String name, int thickness) {
		thicknesses.put(name, thickness);
	}
}
