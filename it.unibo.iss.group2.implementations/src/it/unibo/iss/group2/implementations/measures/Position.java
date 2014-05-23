package it.unibo.iss.group2.implementations.measures;

import it.unibo.iss.group2.interfaces.measures.IPosition;
import it.unibo.iss.group2.interfaces.messages.IMessage;

import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.json.JSONException;
import org.json.JSONObject;

public class Position implements IPosition, IMessage {

	private GeoPosition position;
	
	public Position(GeoPosition value) {
		this.position = constraints(value);
	}
	
	@Override
	public GeoPosition getPositionAsGeoPosition() {
		return position;
	}	
	
	private GeoPosition constraints(GeoPosition position) { 
		return position;
	}

	@Override
	public String jsonify() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("latitude", position.getLatitude());
			obj.put("longitude", position.getLongitude());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj.toString();
	}

	@Override
	public Position dejsonify(String jsonString) {
		try {
			JSONObject obj = new JSONObject(jsonString);
			double receiveLatitude = obj.getDouble("latitude");
			double receiveLongitude = obj.getDouble("longitude");
			GeoPosition gp = new GeoPosition(receiveLatitude, receiveLongitude);
			return new Position(gp);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
