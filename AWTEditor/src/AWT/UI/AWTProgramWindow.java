package AWT.UI;


import java.awt.Dimension;

import javax.swing.JFrame;

final public class AWTProgramWindow extends JFrame {

	private static final long serialVersionUID = -3484849588202585389L;
	final public static Dimension MIN_SIZE 	   = new Dimension(200, 200);

	public AWTProgramWindow(String title){
		super(title);
		setupSelf();
	}
	
	private void setupSelf(){
		super.setResizable(true);
		super.setMinimumSize(MIN_SIZE);
		super.setSize(620, 400);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //addWindowListener(closeWindowEvent);
	}
	
//	private WindowAdapter closeWindowEvent = new WindowAdapter() {
//        @Override
//        public void windowClosing(WindowEvent we) {
//        	setVisible(false);
//        	dispose();
//        	System.exit(0);
//        }
//	};

}
