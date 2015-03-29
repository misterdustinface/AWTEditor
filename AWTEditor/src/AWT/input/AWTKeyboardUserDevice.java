package AWT.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import UI.input.InputEvent;
import UI.input.InputEventBuilder;
import UI.input.KeyboardUserDevice;

final public class AWTKeyboardUserDevice extends KeyboardUserDevice implements KeyListener {

	public AWTKeyboardUserDevice() {		

	}
	
	public void keyPressed(KeyEvent ke) {
		InputEvent event = makeInputEventThatDescribesKeyEvent(ke);
		InputEventBuilder.press(event);
		addEvent(event);
	}

	public void keyReleased(KeyEvent ke) {
		InputEvent event = makeInputEventThatDescribesKeyEvent(ke);
		InputEventBuilder.release(event);
		addEvent(event);
	}

	public void keyTyped(KeyEvent ke) {

	}
	
	private InputEvent makeInputEventThatDescribesKeyEvent(KeyEvent ke) {
		return InputEventBuilder.createWithDescription(Character.toString(ke.getKeyChar()),
								 						Integer.toString(ke.getKeyCode()),
								 						KeyEvent.getKeyText(ke.getKeyCode()));
	}

}