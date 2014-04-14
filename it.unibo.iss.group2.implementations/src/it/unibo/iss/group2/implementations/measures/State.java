package it.unibo.iss.group2.implementations.measures;
import it.unibo.iss.group2.interfaces.measures.IDistance;
import it.unibo.iss.group2.interfaces.measures.IFuel;
import it.unibo.iss.group2.interfaces.measures.IPosition;
import it.unibo.iss.group2.interfaces.measures.ISpeed;
import it.unibo.iss.group2.interfaces.measures.IState;

public class State implements IState {

	private IDistance distance;
	private IFuel fuel;
	private IPosition position;
	private ISpeed speed;
	
	public State(IDistance distance, IFuel fuel, IPosition position, ISpeed speed) {
		this.distance = distance;
		this.fuel = fuel;
		this.position = position;
		this.speed = speed;
	}
	
	@Override
	public IDistance getDistance() {
		return distance;
	}

	@Override
	public IFuel getFuel() {
		return fuel;
	}

	@Override
	public IPosition getPosition() {
		return position;
	}

	@Override
	public ISpeed getSpeed() {
		return speed;
	}
}
