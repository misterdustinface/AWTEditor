package AWT.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import UI.input.InputEvent;
import UI.input.InputEventBuilder;
import UI.input.KeyboardUserDevice;

public class AWTKeyboardUserDevice extends KeyboardUserDevice implements KeyListener {
	
	public AWTKeyboardUserDevice() {
		
	}
	
	public void keyPressed(KeyEvent ke) {
		InputEvent event = new InputEvent();
		describeKeyEvent(event, ke);
		InputEventBuilder.press(event);
		createEvent(event);
	}

	public void keyReleased(KeyEvent ke) {
		InputEvent event = new InputEvent();
		describeKeyEvent(event, ke);
		InputEventBuilder.release(event);
		createEvent(event);	
	}

	public void keyTyped(KeyEvent ke) {
		
	}
	
	private void describeKeyEvent(InputEvent event, KeyEvent ke) {
		InputEventBuilder.add(event, Character.toString(ke.getKeyChar()));
		InputEventBuilder.add(event, Integer.toString(ke.getKeyCode()));
		InputEventBuilder.add(event, KeyEvent.getKeyText(ke.getKeyCode()));
	}

}