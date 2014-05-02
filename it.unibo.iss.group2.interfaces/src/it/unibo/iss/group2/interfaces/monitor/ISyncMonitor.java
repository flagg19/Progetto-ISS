package it.unibo.iss.group2.interfaces.monitor;

import it.unibo.iss.group2.interfaces.messages.MessageLabels;

public interface ISyncMonitor {

	public MessageLabels waitForButton();
	public void release(MessageLabels pressedButton);
	
}

