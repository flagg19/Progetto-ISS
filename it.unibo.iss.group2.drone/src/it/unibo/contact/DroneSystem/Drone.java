package it.unibo.contact.DroneSystem;

import java.util.HashMap;

import it.unibo.iss.group2.implementations.messages.Command;
import it.unibo.iss.group2.interfaces.cmd.ButtonLabels;
import it.unibo.iss.group2.interfaces.measures.IState;

public class Drone extends DroneSupport {

	public Drone(String name) throws Exception {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Command hl_commandFromJSON(String jsonString) throws Exception {
		return new Command().dejsonify(jsonString);
	}

	@Override
	protected String cleanString(String jsonString) throws Exception {
		return jsonString.replace("'", "");
	}

	@Override
	protected HashMap<String, ButtonLabels> initLabels() throws Exception {
		HashMap<String, ButtonLabels> labels = new HashMap<String, ButtonLabels>();
		for (ButtonLabels bl : ButtonLabels.values()) {
			labels.put(bl.name(), bl);
		}
		return labels;
	}

	@Override
	protected IState hl_readStatus() throws Exception {
		
		return null;
	}
}
