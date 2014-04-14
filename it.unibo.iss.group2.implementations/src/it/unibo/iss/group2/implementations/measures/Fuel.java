package it.unibo.iss.group2.implementations.measures;
import it.unibo.iss.group2.interfaces.measures.IFuel;

public class Fuel implements IFuel {

	private double fuel;
	
	public Fuel(double value) {
		this.fuel = checkCorrectness(value);
	}
	
	@Override
	public Double getFuelAsDouble() {
		return fuel;
	}	
	
	private double checkCorrectness(double fuel) { 
		if (fuel < 0)
			fuel = 0;
		
		return fuel;
	}
}
