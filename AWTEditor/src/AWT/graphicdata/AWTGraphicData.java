package AWT.graphicdata;

import generic.tags.NamedData;

import java.awt.Color;
import java.util.HashMap;

public abstract class AWTGraphicData implements NamedData {
	
	final protected HashMap<String, Color> colors;
	final protected HashMap<String, Integer> thicknesses;
	
	public AWTGraphicData() {
		colors = new HashMap<String, Color>();
		thicknesses = new HashMap<String, Integer>();
	}
	
	final public Color getColorOf(String name) {
		return colors.containsKey(name) ? colors.get(name) : Color.LIGHT_GRAY;
	}
	
	final public int getThicknessOf(String name) {
		return thicknesses.containsKey(name) ? thicknesses.get(name) : 0;
	}
	
	//private final static String GRAPHIC_DATA_FILE = "graphicdata.lua";
	
//	private ArrayList<ColorData> loadColorsFromFile(File file) {
//	ColorPaletteFiler filer = new ColorPaletteFiler();
//	ArrayList<ColorData> colorpalette = new ArrayList<ColorData>();
//	filer.setPalette(colorpalette);
//	
//	try {
//		FileInputStream inStream = new FileInputStream(file);
//		filer.load(inStream);
//	} catch (FileNotFoundException e) {
//		e.printStackTrace();
//	}
//	
//	return colorpalette;
//}
}
