package it.unibo.iss.group2.implementations.measures;
import org.json.JSONException;
import org.json.JSONObject;

import it.unibo.iss.group2.interfaces.measures.ISpeed;
import it.unibo.iss.group2.interfaces.messages.IMessage;

public class Speed implements ISpeed, IMessage {

	private double speed;
	
	public Speed(double value) {
		this.speed = checkCorrectness(value);
	}
	
	@Override
	public Double getSpeedAsDouble() {
		return speed;
	}	
	
	private double checkCorrectness(double speed) { 
		if (speed < 0)
			speed = 0;
		return speed;
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
	public IMessage dejsonify(String jsonString) {
		try {
			JSONObject obj = new JSONObject(jsonString);
			String receiveContent = obj.getString("speed");
			return new Speed(Double.parseDouble(receiveContent));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
