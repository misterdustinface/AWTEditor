package AWT.graphicdata;

import generic.datastructures.Table;
import generic.tags.NamedData;

import java.awt.Color;

public abstract class AWTGraphicData implements NamedData {
	
	final protected Table<Color> colors;
	final protected Table<Integer> thicknesses;
	
	public AWTGraphicData() {
		colors = new Table<Color>();
		thicknesses = new Table<Integer>();
	}
	
	final public Color getColorOf(String name) {
		return colors.contains(name) ? colors.get(name) : Color.LIGHT_GRAY;
	}
	
	final public int getThicknessOf(String name) {
		return thicknesses.contains(name) ? thicknesses.get(name) : 0;
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
