package it.unibo.contact.DroneSystem;

import java.util.HashMap;

import it.unibo.iss.group2.implementations.measures.Speed;
import it.unibo.iss.group2.implementations.measures.Status;
import it.unibo.iss.group2.implementations.messages.Command;
import it.unibo.iss.group2.implementations.messages.SetSpeed;
import it.unibo.iss.group2.interfaces.globals.Globals;
import it.unibo.iss.group2.interfaces.measures.*;
import it.unibo.iss.group2.interfaces.messages.MessageLabels;
import it.unibo.iss.group2.sensors.SpeedSensor;

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
	protected HashMap<String, String> initLabels() throws Exception {
		HashMap<String, String> labels = new HashMap<String, String>();
		for (MessageLabels bl : MessageLabels.values()) {
			labels.put(bl.name(), bl.name().toLowerCase());
		}
		return labels;
	}

	@Override
	protected Status hl_readStatus() throws Exception {
		ISpeed speed = (ISpeed) speedSensor.getValue(speedDrone);
		IDistance distance = (IDistance) distanceSensor.getValue(speed);
		IFuel fuel = (IFuel) fuelSensor.getValue(speed);
		IPosition position = (IPosition) positionSensor.getValue(speed);
		return new Status(distance, fuel, position, speed);
	}

	@Override
	protected void delay() throws Exception {
		Thread.sleep(Globals.DTFms);
	}

	@Override
	protected void accelerate() throws Exception {
		((SpeedSensor) speedSensor).simulateAcceleration(speedDrone);
	}

	@Override
	protected Speed hl_speedFromCommand(Command cmdSetString) throws Exception {
		return new Speed(0).dejsonify(((SetSpeed)cmdSetString).getParameter());
	}
}
