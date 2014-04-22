package it.unibo.iss.group2.implementations.messages;

import it.unibo.iss.group2.interfaces.messages.IIncSpeed;

public class IncSpeed extends Command implements IIncSpeed {
	private IncSpeed() {
		this.curContent = IIncSpeed.content;
	}
	
	public static IncSpeed instantiate() {
		return new IncSpeed();
	}
}
