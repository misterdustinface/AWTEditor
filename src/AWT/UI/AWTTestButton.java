package AWT.UI;


public class AWTTestButton extends AWTMenuButton {

	protected void pressAction() {
		setText("PRESSED");
	}

	protected void releaseAction() {
		setText("RELEASED");
	}

}