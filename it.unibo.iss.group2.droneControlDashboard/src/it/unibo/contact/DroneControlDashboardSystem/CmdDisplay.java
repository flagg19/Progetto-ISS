package it.unibo.contact.DroneControlDashboardSystem;

import it.unibo.iss.group2.interfaces.cmd.ButtonLabels;

import java.util.HashMap;

public class CmdDisplay extends CmdDisplaySupport {

	public CmdDisplay(String name) throws Exception {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected HashMap<String, ButtonLabels> initLabels() throws Exception {
		HashMap<String, ButtonLabels> labels = new HashMap<String, ButtonLabels>();
		for (ButtonLabels bl : ButtonLabels.values()) {
			labels.put(bl.name(), bl);
		}
		return labels;
	}

}
