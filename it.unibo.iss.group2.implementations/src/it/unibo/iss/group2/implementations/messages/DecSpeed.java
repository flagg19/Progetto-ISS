package it.unibo.iss.group2.implementations.messages;

import it.unibo.iss.group2.interfaces.messages.IDecSpeed;

public class DecSpeed extends Command implements IDecSpeed {
	private DecSpeed() {
		this.curContent = IDecSpeed.content;
	}
	
	public static DecSpeed instantiate() {
		return new DecSpeed();
	}
}
