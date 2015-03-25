package AWT.UI;


public class AWTTestButton extends AWTMenuButton {

	protected void pressAction() {
		textLabel.setText("PRESSED");
	}

	protected void releaseAction() {
		textLabel.setText("RELEASED");
	}

}