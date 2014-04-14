package it.unibo.iss.group2.implementations.measures;
import it.unibo.iss.group2.interfaces.measures.ISpeed;

public class Speed implements ISpeed {

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
}
