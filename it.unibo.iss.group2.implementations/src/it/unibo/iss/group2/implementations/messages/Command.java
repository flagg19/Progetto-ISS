package it.unibo.iss.group2.implementations.messages;

import org.json.JSONException;
import org.json.JSONObject;

import it.unibo.iss.group2.interfaces.messages.*;

public class Command implements IMessage {
	String curContent;
	
	public String getContent() {
		return curContent;
	}
	
	@Override
	public Command dejsonify(String jsonString) {
		try {
			JSONObject obj = new JSONObject(jsonString);
			String receiveContent = obj.getString("content");
			if (receiveContent.equals(IStart.content)) {
				return Start.instantiate();
			} 
			else if (receiveContent.equals(IStop.content)) {
				return Stop.instantiate();
			}
			else if (receiveContent.equals(IIncSpeed.content)) {
				return IncSpeed.instantiate();
			}
			else if (receiveContent.equals(IDecSpeed.content)) {
				return DecSpeed.instantiate();
			}
			else if (receiveContent.equals(ISetSpeed.content)) {
				return SetSpeed.instantiate(obj.getString("parameter"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String jsonify() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("content", curContent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj.toString();
	}
	
	public static Command instantiateFromJSON(String jsonString) {
		return new Command().dejsonify(jsonString);
	}
}
