package it.unibo.iss.group2.implementations.measures;
import it.unibo.iss.group2.interfaces.measures.IDistance;

public class Distance implements IDistance {

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
}
