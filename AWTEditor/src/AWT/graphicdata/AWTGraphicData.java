package AWT.graphicdata;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import file.GenericExtended.ColorPaletteFiler;
import generic.ColorData;

public class AWTGraphicData {
	
	//private final static String GRAPHIC_DATA_FILE = "graphicdata.lua";
	private static AWTGraphicData graphicData = new AWTGraphicData();
	
	private AWTGraphicData() {
		// ArrayList<ColorData> colors = loadColorsFromFile(GRAPHIC_DATA_FILE);
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
	
	public static AWTGraphicData getGraphicData() {
		return graphicData;
	}
	
	public int pointSize 						= 4;
	public int cursorStretchOutAmount 			= 10;
	public int cursorCenterGapAmount  			= 2;
	public int plusSignThickness     			= 4;
	
	public int[] POINTER_CURSOR_X = new int[] {0, 15, 8, 5};
	public int[] POINTER_CURSOR_Y = new int[] {0,  5, 8,15};
	
	public Color clear                 = new Color(0,0,0,0);
	public Color lightclear            = new Color(50,50,50,50);
	
	public Color buttonColor           = new Color(150,150,150);
	public Color buttonHighlightColor  = new Color(125,125,162);
	public Color buttonPressedColor    = new Color(175,100,175);
	public Color baseColor             = new Color(200,200,200);
	
	public Color MENU_BACKGROUND_COLOR = new Color(240,240,240);
	public Color BACKGROUND_COLOR      = new Color(240,240,240);
	public Color PLUS_SIGN_COLOR       = new Color(165,165,165);
	
}
