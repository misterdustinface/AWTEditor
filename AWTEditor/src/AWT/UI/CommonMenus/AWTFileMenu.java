package AWT.UI.CommonMenus;

import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import shapes.Point;
import shapes.Polygon;
import shapes.PolygonBuilder;
import AWT.UI.AWTDropdownListMenu;
import AWT.UI.AWTFileChooser;
import AWT.UI.AWTMenuButton;
import AWT.UI.AWTStaticListMenu;
import AWT.UI.AWTUILayer;
import AWT.graphicdata.EditorAWTGraphicData;
import UI.input.MouseUserDevice;
import UI.widgets.ButtonMenu;
import UI.widgets.MenuButton;
import file.LuaScriptFiler;
import generic.ListenerPattern.Descriptive.DataModificationListener;
import generic.fp.VoidFunctionPointer;

public class AWTFileMenu implements ButtonMenu, AWTUILayer {

	private LuaScriptFiler filer;
	
	public static String SAVE_STRING = "SAVE";
	public static String LOAD_STRING = "LOAD";
	
	private AWTDropdownListMenu dropdownListMenu;
	private AWTFileChooser 		fileChooser;
	private boolean	isSaving;
	private boolean isLoading;
	
	public final VoidFunctionPointer SAVE = new VoidFunctionPointer() {
		public void call() {
			fileChooser.chooseFile();
			isSaving = true;
		}
	};
	
	public final VoidFunctionPointer LOAD = new VoidFunctionPointer() {
		public void call() {
			fileChooser.chooseFile();
			isLoading = true;
		}
	};
	
	public AWTFileMenu(LuaScriptFiler FILER) {
		filer = FILER;
		setupFileChooser();
		setupDropdownListMenu();
	}
	
	private void setupFileChooser() {
		fileChooser = new AWTFileChooser();
		
		DataModificationListener fileSelected = new DataModificationListener(){
			protected void whenMyDataIsModifiedExternally() {
				if (isSaving){
					try {
						filer.save(new FileOutputStream(fileChooser.getChosenFile()));
					} catch (FileNotFoundException fnf) {
						fnf.printStackTrace();
					}
					isSaving = false;
				}
				if (isLoading){
					try {
						filer.load(new FileInputStream(fileChooser.getChosenFile()));
					} catch (FileNotFoundException fnf) {
						fnf.printStackTrace();
					}
					isLoading = false;
				}
			}
		};
		
		fileChooser.addDataModificationListener(fileSelected);
		
		isSaving = false;
		isLoading = false;
	}
	
	private void setupDropdownListMenu() {
		
		AWTMenuButton fileButton = new AWTMenuButton();
		fileButton.textLabel.setText("FILE");
		fileButton.textLabel.center();
		EditorAWTGraphicData graphicData = EditorAWTGraphicData.getGraphicData();
		Polygon p = PolygonBuilder.makeBox(graphicData.getThicknessOf("buttonWidth"), graphicData.getThicknessOf("buttonHeight"));
		p.shift(2, 2);
		fileButton.setPolygon(p);
		
		AWTMenuButton saveButton = new AWTMenuButton();
		saveButton.textLabel.setText(SAVE_STRING);
		saveButton.textLabel.center();
		saveButton.debounceTimer.setDebounceTime_sec(1);
		saveButton.setButtonPressedFunction(SAVE);
		
		AWTMenuButton openButton = new AWTMenuButton();
		openButton.textLabel.setText(LOAD_STRING);
		openButton.textLabel.center();
		openButton.debounceTimer.setDebounceTime_sec(1);
		openButton.setButtonPressedFunction(LOAD);
		
		MenuButton[] fileMenuOptions = new MenuButton[] { saveButton, openButton };
		AWTStaticListMenu list = new AWTStaticListMenu();
		list.setButtons(fileMenuOptions);
		list.setPosition(new Point(2,2 + fileButton.getHeight()));
		list.setButtonOffset(2);
		list.setButtonDimensions((int)fileButton.getWidth() - 4, (int)fileButton.getHeight() - 4);
		
		dropdownListMenu = new AWTDropdownListMenu();
		dropdownListMenu.setRoot(fileButton);
		dropdownListMenu.setMenu(list);
	}
	
	public void update(MouseUserDevice mouse) {
		dropdownListMenu.update(mouse);
		fileChooser.update(mouse);
	}
	
	public void render(Graphics2D g) {
		((AWTDropdownListMenu)dropdownListMenu).render(g);
		((AWTFileChooser)fileChooser).render(g);
	}	

	public void refreshButton(int index) {
		dropdownListMenu.refreshButton(index);
	}
	
	public int getX() { 
		return dropdownListMenu.getX(); 
	}
	
	public int getY() { 
		return dropdownListMenu.getY(); 
	}
	
	public int getWidth() { 
		return dropdownListMenu.getWidth(); 
	}
	
	public int getHeight() { 
		return dropdownListMenu.getHeight();
	}
	
	public void setPosition(Point POSITION) {
		dropdownListMenu.setPosition(POSITION);
	}
	
	public void setButtonOffset(int BUTTON_OFFSET) { 
		dropdownListMenu.setButtonOffset(BUTTON_OFFSET);
	}
	
	public void setButtonSize(int BUTTON_SIZE)     {
		dropdownListMenu.setButtonSize(BUTTON_SIZE);
	}
	
	public void setButtonDimensions(int WIDTH, int HEIGHT) {
		dropdownListMenu.setButtonDimensions(WIDTH, HEIGHT);
	}
	
	public void setButtons(MenuButton ... BUTTONS) {
		dropdownListMenu.setButtons(BUTTONS);
	}
	
	public void setButtons(ArrayList<MenuButton> BUTTONS) {
		dropdownListMenu.setButtons(BUTTONS);
	}
	
	public void addButton(MenuButton BUTTON) {
		dropdownListMenu.addButton(BUTTON);
	}
	
	public void removeButton(MenuButton BUTTON) {
		dropdownListMenu.removeButton(BUTTON);
	}
	
	public void clearButtons() {
		dropdownListMenu.clearButtons();
	}
	
	public void refreshButtons() {
		dropdownListMenu.refreshButtons();
	}
	
	public int numberOfButtons() { 
		return dropdownListMenu.numberOfButtons(); 
	}
	
	public MenuButton getButton(int index) { 
		return dropdownListMenu.getButton(index); 
	}
	
	public boolean contains(MouseUserDevice mouse) {
		return dropdownListMenu.contains(mouse);
	}
	
}