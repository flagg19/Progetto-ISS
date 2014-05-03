package it.unibo.iss.group2.implementations.monitor;

import java.util.ArrayList;
import java.util.List;

import it.unibo.iss.group2.interfaces.messages.MessageLabels;
import it.unibo.iss.group2.interfaces.monitor.ISyncMonitor;

/**
 * @author FF
 */
public class SyncMonitor implements ISyncMonitor {
	
	List<MessageLabels> pressedButtonQueue;
	
	static public SyncMonitor instantiate () {
		return new SyncMonitor();
	}
	
	public SyncMonitor() {
		
		pressedButtonQueue = new ArrayList<MessageLabels>();
	}
	
	public synchronized MessageLabels waitForButton() {
		while (pressedButtonQueue.size() == 0)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		MessageLabels returnButton = pressedButtonQueue.remove(0);
		return returnButton;
	}
	
	public synchronized void release(MessageLabels pressedButton) {
		pressedButtonQueue.add(pressedButton);
		this.notify();
	}
}
