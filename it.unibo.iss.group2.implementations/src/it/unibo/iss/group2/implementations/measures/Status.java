package it.unibo.iss.group2.implementations.measures;
import org.json.JSONException;
import org.json.JSONObject;

import it.unibo.iss.group2.interfaces.globals.Globals;
import it.unibo.iss.group2.interfaces.measures.IDistance;
import it.unibo.iss.group2.interfaces.measures.IFuel;
import it.unibo.iss.group2.interfaces.measures.IPosition;
import it.unibo.iss.group2.interfaces.measures.ISpeed;
import it.unibo.iss.group2.interfaces.measures.IStatus;
import it.unibo.iss.group2.interfaces.messages.IMessage;

public class Status implements IStatus, IMessage {

	private IDistance distance;
	private IFuel fuel;
	private IPosition position;
	private ISpeed speed;
	
	public Status(IDistance distance, IFuel fuel, IPosition position, ISpeed speed) {
		this.distance = distance;
		this.fuel = fuel;
		this.position = position;
		this.speed = speed;
	}
	
	public Status() {
		this.distance = new Distance(0);
		this.fuel = new Fuel(0);
		this.position = new Position(null);
		this.speed = new Speed(0);
	}
	
	@Override
	public IDistance getDistance() {
		return distance;
	}

	@Override
	public IFuel getFuel() {
		return fuel;
	}

	@Override
	public IPosition getPosition() {
		return position;
	}

	@Override
	public ISpeed getSpeed() {
		return speed;
	}
	
	@Override
	public boolean stopCondition() {
		return fuel.getFuelAsDouble() <= Globals.MIN_FUEL;
	}

	@Override
	public String jsonify() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("fuel", ((Fuel)fuel).jsonify());
			obj.put("distance", ((Distance)distance).jsonify());
			obj.put("position", ((Position)position).jsonify());
			obj.put("speed", ((Speed)speed).jsonify());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj.toString();
	}

	@Override
	public Status dejsonify(String jsonString) {
		try {
			JSONObject obj = new JSONObject(jsonString);
			String receiveFuel = obj.getString("fuel");
			String receiveDistance = obj.getString("distance");
			String receivePosition = obj.getString("position");
			String receiveSpeed = obj.getString("speed");
			return new Status(
								(Distance)(((Distance)distance).dejsonify(receiveDistance)), 
								(Fuel)(((Fuel)fuel).dejsonify(receiveFuel)),
								(Position)(((Position)position).dejsonify(receivePosition)),
								(Speed)(((Speed)speed).dejsonify(receiveSpeed))
			);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
