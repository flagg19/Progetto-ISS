package it.unibo.iss.group2.tests;

import static org.junit.Assert.*;
import it.unibo.iss.group2.implementations.measures.Distance;
import it.unibo.iss.group2.implementations.measures.Fuel;
import it.unibo.iss.group2.implementations.measures.Position;
import it.unibo.iss.group2.implementations.measures.Speed;
import it.unibo.iss.group2.interfaces.globals.Globals;
import it.unibo.iss.group2.interfaces.measures.ISpeed;

import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.junit.Test;

public class DataTypeTest {
	
	@Test
	public void test() {
		testSpeed();
		testDistance();
		testFuel();
		testPosition();
	}

	private void testSpeed() {
		Speed s;
		double val;
		
		for (int i = (int) (Globals.MIN_SPEED - 1); i < Globals.MAX_SPEED + 1; i++) {
			s = new Speed(i);
			assertNotNull("Speed null", s);
			assertEquals("Speed not equals", Math.max(Globals.MIN_SPEED, Math.min(i, Globals.MAX_SPEED)), s.getSpeedAsDouble(), 0);
		}
		s = new Speed(Globals.MIN_SPEED);
		val = s.getSpeedAsDouble();
		assertEquals("Inc Speed", Math.min(Globals.MAX_SPEED, val + Globals.DS), s.increaseSpeed().getSpeedAsDouble(), 0);
		s = new Speed(Globals.MAX_SPEED);
		val = s.getSpeedAsDouble();
		assertEquals("Dec Speed", Math.max(Globals.MIN_SPEED, val - Globals.DS), s.decreaseSpeed().getSpeedAsDouble(), 0);
		String jsonSpeed = s.jsonify();
		assertEquals("Json test", s.getSpeedAsDouble(), s.dejsonify(jsonSpeed).getSpeedAsDouble(), 0);
	}
	
	private void testDistance() {
		Distance d;
		
		for (int i =  -1; i < 100; i++) {
			d = new Distance(i);
			assertNotNull("Distance null", d);
			assertEquals("Distance not equals", Math.max(0, i), d.getDistanceAsDouble(), 0);
		}
		d = new Distance(0);
		String jsonDistance = d.jsonify();
		assertEquals("Json test", d.getDistanceAsDouble(), d.dejsonify(jsonDistance).getDistanceAsDouble(), 0);
	}
	
	private void testFuel() {
		Fuel f;
		
		for (int i =  -1; i < 100; i++) {
			f = new Fuel(i);
			assertNotNull("Fuel null", f);
			assertEquals("Fuel not equals", Math.max(0, i), f.getFuelAsDouble(), 0);
		}
		f = new Fuel(0);
		String jsonFuel = f.jsonify();
		assertEquals("Json test", f.getFuelAsDouble(), f.dejsonify(jsonFuel).getFuelAsDouble(), 0);
	}
	
	private void testPosition() {
		Position p = new Position(new GeoPosition(0, 0));
		assertNotNull("Position null", p);
		assertEquals("Latitude not equals", 0, p.getPositionAsGeoPosition().getLatitude(), 0);
		assertEquals("Longitude not equals", 0, p.getPositionAsGeoPosition().getLongitude(), 0);
		String jsonPosition = p.jsonify();
		assertEquals("Json test 1", p.getPositionAsGeoPosition().getLatitude(), p.dejsonify(jsonPosition).getPositionAsGeoPosition().getLatitude(), 0);
		assertEquals("Json test 1", p.getPositionAsGeoPosition().getLongitude(), p.dejsonify(jsonPosition).getPositionAsGeoPosition().getLongitude(), 0);
	}
}
