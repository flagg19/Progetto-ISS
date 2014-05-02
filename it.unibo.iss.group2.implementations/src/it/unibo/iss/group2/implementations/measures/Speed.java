package it.unibo.iss.group2.implementations.measures;
import org.json.JSONException;
import org.json.JSONObject;

import it.unibo.iss.group2.interfaces.globals.Globals;
import it.unibo.iss.group2.interfaces.measures.ISpeed;
import it.unibo.iss.group2.interfaces.messages.IMessage;

public class Speed implements ISpeed, IMessage {

	private double speed;
	
	public Speed(double value) {
		this.speed = constraints(value);
	}
	
	@Override
	public Double getSpeedAsDouble() {
		return speed;
	}	
	
	private double constraints(double speed) { 
		if (speed < Globals.MIN_SPEED)
			speed = Globals.MIN_SPEED;
		if (speed > Globals.MAX_SPEED)
			speed = Globals.MAX_SPEED;
		return speed;
	}
	
	public Speed increaseSpeed() {
		return new Speed(speed + Globals.DS);
	}
	
	public Speed decreaseSpeed() {
		return new Speed(speed - Globals.DS);
	}

	@Override
	public String jsonify() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("speed", speed);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj.toString();
	}

	@Override
	public Speed dejsonify(String jsonString) {
		try {
			JSONObject obj = new JSONObject(jsonString);
			double receiveContent = obj.getDouble("speed");
			return new Speed(receiveContent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
