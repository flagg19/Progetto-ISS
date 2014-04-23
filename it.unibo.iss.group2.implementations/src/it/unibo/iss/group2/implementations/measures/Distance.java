package it.unibo.iss.group2.implementations.measures;
import org.json.JSONException;
import org.json.JSONObject;

import it.unibo.iss.group2.interfaces.measures.IDistance;
import it.unibo.iss.group2.interfaces.messages.IMessage;

public class Distance implements IDistance, IMessage {

	private double distance;
	
	public Distance(double value) {
		this.distance = checkCorrectness(value);
	}
	
	@Override
	public Double getDistanceAsDouble() {
		return distance;
	}	
	
	private double checkCorrectness(double distance) { 
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
	public IMessage dejsonify(String jsonString) {
		try {
			JSONObject obj = new JSONObject(jsonString);
			String receiveContent = obj.getString("distance");
			return new Distance(Double.parseDouble(receiveContent));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
