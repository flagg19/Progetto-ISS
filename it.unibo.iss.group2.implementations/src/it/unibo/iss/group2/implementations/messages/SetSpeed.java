package it.unibo.iss.group2.implementations.messages;

import org.json.JSONException;
import org.json.JSONObject;

import it.unibo.iss.group2.interfaces.messages.ISetSpeed;

public class SetSpeed extends Command implements ISetSpeed {
	private String parameter;
	
	private SetSpeed(String parameter) {
		this.curContent = ISetSpeed.content;
		this.parameter = parameter;
	}
	
	public static SetSpeed instantiate(String parameter) {
		return new SetSpeed(parameter);
	}
	
	@Override
	public String getParameter() {
		return parameter;
	}
	
	@Override
	public String jsonify() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("content", curContent);
			obj.put("parameter", parameter);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj.toString();
	}
}
