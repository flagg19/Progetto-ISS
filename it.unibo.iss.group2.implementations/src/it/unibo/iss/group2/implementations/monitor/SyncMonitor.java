package it.unibo.iss.group2.implementations.monitor;

import it.unibo.iss.group2.interfaces.messages.MessageLabels;
import it.unibo.iss.group2.interfaces.monitor.ISyncMonitor;

/**
 * @author FF
 */
public class SyncMonitor implements ISyncMonitor {
	
	MessageLabels lastPressedButton;
	
	static public SyncMonitor instantiate () {
		return new SyncMonitor();
	}
	
	public SyncMonitor() {
		
		lastPressedButton = MessageLabels.NONE;
	}
	
	public synchronized MessageLabels waitForButton() {
		
		while (lastPressedButton == MessageLabels.NONE)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		MessageLabels returnButton = lastPressedButton;
		lastPressedButton = MessageLabels.NONE;
		return returnButton;
	}
	
	public synchronized void release(MessageLabels pressedButton) {
		
		lastPressedButton = pressedButton;
		this.notify();
	}
}
