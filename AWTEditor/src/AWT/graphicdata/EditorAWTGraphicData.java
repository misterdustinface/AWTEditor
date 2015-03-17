package AWT.graphicdata;

import file.GenericExtended.ColorPaletteFiler;
import generic.ColorData;
import generic.tags.NamedData;
import generic.tags.Singleton;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EditorAWTGraphicData extends AWTGraphicData implements Singleton, NamedData {
	
	//private final static String GRAPHIC_DATA_FILE = "graphicdata.lua";
	private static EditorAWTGraphicData graphicData = new EditorAWTGraphicData();
	
	private EditorAWTGraphicData() {
		loadColors();
		loadThicknesses();
	}
	
	public Color clear                 = new Color(0,0,0,0);
	public Color lightclear            = new Color(50,50,50,50);
	
	public Color buttonColor           = new Color(150,150,150);
	public Color buttonHighlightColor  = new Color(125,125,162);
	public Color buttonPressedColor    = new Color(175,100,175);
	public Color baseColor             = new Color(200,200,200);
	
	public Color MENU_BACKGROUND_COLOR = new Color(240,240,240);
	public Color BACKGROUND_COLOR      = new Color(240,240,240);
	public Color PLUS_SIGN_COLOR       = new Color(165,165,165);
	
	private void loadColors() {
		
	}
	
	private void loadThicknesses() {
		thicknesses.put("pointSize", 4);
		thicknesses.put("cursorStretchOutAmount", 10);
		thicknesses.put("cursorCenterGapAmount", 2);
		thicknesses.put("plusSign", 4);
	}
	
	private ArrayList<ColorData> loadColorsFromFile(File file) {
		ColorPaletteFiler filer = new ColorPaletteFiler();
		ArrayList<ColorData> colorpalette = new ArrayList<ColorData>();
		filer.setPalette(colorpalette);
		
		try {
			FileInputStream inStream = new FileInputStream(file);
			filer.load(inStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return colorpalette;
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
