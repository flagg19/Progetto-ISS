package it.unibo.iss.group2.implementations.monitor;

import it.unibo.iss.group2.interfaces.cmd.ButtonLabels;
import it.unibo.iss.group2.interfaces.monitor.ISyncMonitor;

/**
 * @author FF
 */
public class SyncMonitor implements ISyncMonitor {
	
	ButtonLabels lastPressedButton;
	
	static public SyncMonitor instantiate () {
		return new SyncMonitor();
	}
	
	public SyncMonitor() {
		
		lastPressedButton = ButtonLabels.NONE;
	}
	
	public synchronized ButtonLabels waitForButton() {
		
		while (lastPressedButton == ButtonLabels.NONE)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ButtonLabels returnButton = lastPressedButton;
		lastPressedButton = ButtonLabels.NONE;
		return returnButton;
	}
	
	public synchronized void release(ButtonLabels pressedButton) {
		
		lastPressedButton = pressedButton;
		this.notify();
	}
}
