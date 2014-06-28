package it.unibo.iss.group2.sensors;

import it.unibo.iss.group2.implementations.measures.Distance;
import it.unibo.iss.group2.interfaces.measures.IDistance;
import it.unibo.iss.group2.interfaces.measures.ISpeed;
import it.unibo.iss.group2.interfaces.globals.*;

public class DistanceSensor implements ISensor<IDistance> {
	Distance curDistance;
	
	public DistanceSensor() {
		curDistance = new Distance(0);
	}
	
	@Override
	public IDistance getValue(ISpeed speed) {
		Double shift = speed.getSpeedAsDouble() * Globals.DTF / 3600;
		curDistance = new Distance(curDistance.getDistanceAsDouble() + shift);
		return curDistance;
	}

}
