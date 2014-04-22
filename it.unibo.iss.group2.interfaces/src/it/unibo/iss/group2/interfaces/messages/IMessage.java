package it.unibo.iss.group2.interfaces.messages;

public interface IMessage {
	public String jsonify();
	public IMessage dejsonify(String jsonString);
}
