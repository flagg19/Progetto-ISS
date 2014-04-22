package it.unibo.iss.group2.implementations.messages;

import it.unibo.iss.group2.interfaces.messages.IStop;

public class Stop extends Command implements IStop {
	private Stop() {
		this.curContent = IStop.content;
	}
	
	public static Stop instantiate() {
		return new Stop();
	}
}
