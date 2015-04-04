package AWT.graphicdata;


import graphicdata.ColorGenerator;

import java.awt.Color;

import structures.ColorData;
import tags.Library;

public abstract class AWTColorGenerator implements Library {
	
	public static Color randomColor() {
		ColorData data = ColorGenerator.randomColor();
		return new Color(data.r, data.g, data.b);
	}
	
	public static Color randomPastel() {
		ColorData data = ColorGenerator.randomPastel();
		return new Color(data.r, data.g, data.b);
	}
	
	public static Color mixColor(Color mix) {
		ColorData mixData = new ColorData(mix.getRed(), mix.getGreen(), mix.getBlue(), mix.getAlpha());
		ColorData data = ColorGenerator.mixColor(mixData);
		return new Color(data.r, data.g, data.b);
	}
	
	public static Color getCompliment(Color primary) {
		ColorData primaryData = new ColorData(primary.getRed(), primary.getGreen(), primary.getBlue(), primary.getAlpha());
		ColorData data = ColorGenerator.getCompliment(primaryData);
		return new Color(data.r, data.g, data.b);
	}
	
	public static Color getIntermediateColor(Color primary, Color secondary) {
		ColorData primaryData = new ColorData(primary.getRed(), primary.getGreen(), primary.getBlue(), primary.getAlpha());
		ColorData secondaryData = new ColorData(secondary.getRed(), secondary.getGreen(), secondary.getBlue(), secondary.getAlpha());
		ColorData data = ColorGenerator.getIntermediateColor(primaryData, secondaryData);
		return new Color(data.r, data.g, data.b);
	}

}