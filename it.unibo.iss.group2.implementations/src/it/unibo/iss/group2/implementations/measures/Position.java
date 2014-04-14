package it.unibo.iss.group2.implementations.measures;

import it.unibo.iss.group2.interfaces.measures.IPosition;
import org.jdesktop.swingx.mapviewer.GeoPosition;

public class Position implements IPosition {

	private GeoPosition position;
	
	public Position(GeoPosition value) {
		this.position = checkCorrectness(value);
	}
	
	@Override
	public GeoPosition getPositionAsGeoPosition() {
		return position;
	}	
	
	private GeoPosition checkCorrectness(GeoPosition position) { 
		return position;
	}
}
