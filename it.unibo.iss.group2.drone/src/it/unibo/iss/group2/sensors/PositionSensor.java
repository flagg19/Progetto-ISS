package it.unibo.iss.group2.sensors;

import org.jdesktop.swingx.mapviewer.GeoPosition;

import it.unibo.iss.group2.implementations.measures.Position;
import it.unibo.iss.group2.interfaces.measures.IPosition;
import it.unibo.iss.group2.interfaces.measures.ISpeed;
import it.unibo.iss.group2.interfaces.globals.*;

public class PositionSensor implements ISensor<IPosition> {
	IPosition curPosition;
	
	public PositionSensor() {
		curPosition = new Position(new GeoPosition(Globals.INITIAL_LATITUDE, Globals.INITIAL_LONGITUDE));
	}
	
	@Override
	public IPosition getValue(ISpeed speed) {
		Double shiftLat = -0.0005;
		Double shiftLong = 0.0005;
		GeoPosition tempPosition = curPosition.getPositionAsGeoPosition();
		curPosition = new Position(new GeoPosition(tempPosition.getLatitude() + shiftLat, tempPosition.getLongitude() + shiftLong));
		return curPosition;
	}

}
