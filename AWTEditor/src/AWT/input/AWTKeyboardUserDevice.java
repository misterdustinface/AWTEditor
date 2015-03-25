package AWT.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import UI.input.KeyboardUserDevice;

public class AWTKeyboardUserDevice extends KeyboardUserDevice implements KeyListener {

	public void keyPressed(KeyEvent arg0) {
		createEvent(arg0.paramString());	
	}

	public void keyReleased(KeyEvent arg0) {
		createEvent(arg0.paramString());	
	}

	public void keyTyped(KeyEvent arg0) {
		createEvent(arg0.paramString());	
	}

}