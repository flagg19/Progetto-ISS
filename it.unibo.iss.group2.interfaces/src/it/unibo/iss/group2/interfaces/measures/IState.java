package it.unibo.iss.group2.interfaces.measures;
public interface IState {
	IDistance getDistance();
	IFuel getFuel();
	IPosition getPosition();
	ISpeed getSpeed();
}
