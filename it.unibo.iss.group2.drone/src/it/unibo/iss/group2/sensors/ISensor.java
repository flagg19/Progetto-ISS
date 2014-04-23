package it.unibo.iss.group2.sensors;

import it.unibo.iss.group2.interfaces.measures.ISpeed;

public interface ISensor<T> {
	T getValue(ISpeed speed);
}
