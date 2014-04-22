package it.unibo.contact.DroneSystem;

import it.unibo.iss.group2.implementations.messages.Command;

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
}
