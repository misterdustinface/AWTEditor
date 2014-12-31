package AWT.UI2;

public class FixedDrawer implements Runnable {
	private long MILLISECONDS_WAIT_TIME;
	private AWTUIDrawer uiDrawer;
	
	public FixedDrawer(AWTUIDrawer UI_DRAWER) {
		uiDrawer = UI_DRAWER;
		setDrawsPerSecond(60);
	}
	
	public void setDrawsPerSecond(int DPS) {
		MILLISECONDS_WAIT_TIME = 1000/DPS;
	}
	
	@Override
	public void run() {
		for(;;) {
			
			uiDrawer.draw();
			
			try {
				Thread.sleep(MILLISECONDS_WAIT_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
