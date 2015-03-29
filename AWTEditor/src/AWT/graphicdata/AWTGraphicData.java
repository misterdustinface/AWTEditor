package AWT.graphicdata;

import generic.datastructures.Property;
import generic.tags.NamedData;
import graphicdata.GraphicData;

import java.awt.Color;

public abstract class AWTGraphicData extends GraphicData implements NamedData {
	
	public AWTGraphicData() {		
		Property<Color> colorProp = new Property<Color>();
		colorProp.setDefaultValue(Color.LIGHT_GRAY);
		addProperty("color", colorProp);
		
		Property<Integer> thicknessProp = new Property<Integer>();
		thicknessProp.setDefaultValue(0);
		addProperty("thickness", thicknessProp);
	}
	
	final public Color getColorOf(String name) {
		return (Color) getProperty("color").of(name);
	}
	
	final public int getThicknessOf(String name) {
		return (int) getProperty("thickness").of(name);
	}

}