package it.unibo.iss.group2.sensors;

import it.unibo.iss.group2.implementations.measures.Speed;
import it.unibo.iss.group2.interfaces.measures.ISpeed;

public class SpeedSensor implements ISensor<ISpeed> {
	ISpeed curSpeed;
	
	public SpeedSensor() {
		curSpeed = new Speed(0);
	}
	
	@Override
	public ISpeed getValue(ISpeed speed) {
		return curSpeed;
	}

	public void simulateAcceleration(ISpeed speed) {
		curSpeed = speed;
	}
}
