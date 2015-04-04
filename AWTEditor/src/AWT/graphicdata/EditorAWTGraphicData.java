package AWT.graphicdata;

import java.awt.Color;

import tags.NamedData;
import tags.Singleton;
import datastructures.Property;

public class EditorAWTGraphicData extends AWTGraphicData implements Singleton, NamedData {
	
	private static EditorAWTGraphicData graphicData = new EditorAWTGraphicData();
	
	private EditorAWTGraphicData() {
		loadColors();
		loadThicknesses();
	}
	
	private void loadColors() {
		@SuppressWarnings("unchecked")
		Property<Color> colorProp = getProperty("color");
		colorProp.add("clear", new Color(0,0,0,0));
		colorProp.add("lightclear", new Color(50,50,50,50));
		colorProp.add("button", new Color(150,150,150));
		colorProp.add("buttonHighlight", new Color(125,125,162));
		colorProp.add("buttonPressed", new Color(175,100,175));
		colorProp.add("base", new Color(200,200,200));
		colorProp.add("MENU_BACKGROUND", new Color(240,240,240));
		colorProp.add("BACKGROUND", new Color(240,240,240));
		colorProp.add("PLUS_SIGN", new Color(165,165,165));
		colorProp.add("cursor", new Color(0,0,0));
	}
	
	private void loadThicknesses() {
		@SuppressWarnings("unchecked")
		Property<Integer> thicknessProp = getProperty("thickness");
		thicknessProp.add("pointSize", 4);
		thicknessProp.add("cursorStretchOutAmount", 10);
		thicknessProp.add("cursorCenterGapAmount", 2);
		thicknessProp.add("plusSign", 4);
		thicknessProp.add("buttonWidth", 100);
		thicknessProp.add("buttonHeight", 40);
	}
	
	public static EditorAWTGraphicData getGraphicData() {
		return graphicData;
	}

	@SuppressWarnings("unchecked")
	public void scaleThicknessOf(String name, float scaleFactor) {
		getProperty("thickness").add(name, getThicknessOf(name) * scaleFactor);
	}
	
	@SuppressWarnings("unchecked")
	public void setThicknessOf(String name, int thickness) {
		getProperty("thickness").add(name, thickness);
	}

}