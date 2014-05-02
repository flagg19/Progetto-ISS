package it.unibo.contact.DroneControlDashboardSystem;

import it.unibo.iss.group2.interfaces.messages.MessageLabels;

import java.util.HashMap;

public class CmdDisplay extends CmdDisplaySupport {

	public CmdDisplay(String name) throws Exception {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected HashMap<String, MessageLabels> initLabels() throws Exception {
		HashMap<String, MessageLabels> labels = new HashMap<String, MessageLabels>();
		for (MessageLabels bl : MessageLabels.values()) {
			labels.put(bl.name(), bl);
		}
		return labels;
	}

}
