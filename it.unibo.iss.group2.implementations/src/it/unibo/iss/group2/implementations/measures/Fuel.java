package it.unibo.iss.group2.implementations.measures;
import org.json.JSONException;
import org.json.JSONObject;

import it.unibo.iss.group2.interfaces.measures.IFuel;
import it.unibo.iss.group2.interfaces.messages.IMessage;

public class Fuel implements IFuel, IMessage {

	private double fuel;
	
	public Fuel(double value) {
		this.fuel = constraints(value);
	}
	
	@Override
	public Double getFuelAsDouble() {
		return fuel;
	}	
	
	private double constraints(double fuel) { 
		if (fuel < 0)
			fuel = 0;
		
		return fuel;
	}

	@Override
	public String jsonify() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("fuel", fuel);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj.toString();
	}

	@Override
	public Fuel dejsonify(String jsonString) {
		try {
			JSONObject obj = new JSONObject(jsonString);
			double receiveContent = obj.getDouble("fuel");
			return new Fuel(receiveContent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
