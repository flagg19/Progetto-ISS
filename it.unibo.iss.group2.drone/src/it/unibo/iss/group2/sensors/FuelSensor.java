package it.unibo.iss.group2.sensors;

import it.unibo.iss.group2.implementations.measures.Fuel;
import it.unibo.iss.group2.interfaces.measures.IFuel;
import it.unibo.iss.group2.interfaces.measures.ISpeed;
import it.unibo.iss.group2.interfaces.globals.*;

public class FuelSensor implements ISensor<IFuel> {
	Fuel curFuel;
	
	public FuelSensor() {
		curFuel = new Fuel(Globals.MAX_FUEL);
	}
	
	@Override
	public IFuel getValue(ISpeed speed) {
		// consumo = (speed * 30) l/h
		Double consumption = speed.getSpeedAsDouble() * Globals.CONSUMPTION_PARAM / 3600 * Globals.DTF;
		curFuel = new Fuel(curFuel.getFuelAsDouble() - consumption);
		return curFuel;
	}

}
