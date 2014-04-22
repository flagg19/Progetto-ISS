package it.unibo.iss.group2.implementations.messages;

import it.unibo.iss.group2.interfaces.messages.IStart;

public class Start extends Command implements IStart {
	private Start() {
		this.curContent = IStart.content;
	}
	
	public static Start instantiate() {
		return new Start();
	}
}
