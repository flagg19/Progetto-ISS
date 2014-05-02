package it.unibo.iss.group2.interfaces.messages;

public enum MessageLabels {
	NONE,
	START,
	STOP,
	INC_SPEED,
	DEC_SPEED,
	SET_SPEED;
	
	public static MessageLabels getMessageLabels(String value) {
		value = value.toUpperCase();
		if (value.equals("NONE"))
			return NONE;
		else if (value.equals("START"))
			return START;
		else if (value.equals("STOP")) 
			return STOP;
		else if (value.equals("INC_SPEED")) 
			return INC_SPEED;
		else if (value.equals("DEC_SPEED")) 
			return DEC_SPEED;
		else if (value.equals("SET_SPEED")) 
			return SET_SPEED;
		else
			return NONE;
	}

}

