package it.unibo.iss.group2.implementations.measures;
import org.json.JSONException;
import org.json.JSONObject;

import it.unibo.iss.group2.interfaces.measures.IDistance;
import it.unibo.iss.group2.interfaces.messages.IMessage;

public class Distance implements IDistance, IMessage {

	private double distance;
	
	public Distance(double value) {
		this.distance = constraints(value);
	}
	
	@Override
	public Double getDistanceAsDouble() {
		return distance;
	}	
	
	private double constraints(double distance) { 
		if (distance < 0)
			distance = 0;
		
		return distance;
	}

	@Override
	public String jsonify() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("distance", distance);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj.toString();
	}

	@Override
	public Distance dejsonify(String jsonString) {
		try {
			JSONObject obj = new JSONObject(jsonString);
			double receiveContent = obj.getDouble("distance");
			return new Distance(receiveContent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
