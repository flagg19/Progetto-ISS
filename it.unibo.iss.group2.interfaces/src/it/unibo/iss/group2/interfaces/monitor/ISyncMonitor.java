package it.unibo.iss.group2.interfaces.monitor;

import it.unibo.iss.group2.interfaces.cmd.ButtonLabels;

public interface ISyncMonitor {

	public ButtonLabels waitForButton();
	public void release(ButtonLabels pressedButton);
	
}
