package it.unibo.iss.group2.tests;

import static org.junit.Assert.*;
import it.unibo.iss.group2.implementations.measures.Distance;
import it.unibo.iss.group2.implementations.measures.Fuel;
import it.unibo.iss.group2.implementations.measures.Position;
import it.unibo.iss.group2.implementations.measures.Speed;
import it.unibo.iss.group2.implementations.measures.Status;
import it.unibo.iss.group2.implementations.messages.*;
import it.unibo.iss.group2.interfaces.globals.Globals;
import it.unibo.iss.group2.interfaces.measures.*;
import it.unibo.iss.group2.interfaces.messages.*;

import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.junit.Test;
public class DataTypeTest {

	@Test
	public void testDistanceIstantiate() {
		try {
			assertTrue(new Distance(0) instanceof IDistance);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di Distance");
		}
	}

	@Test
	public void testFuelIstantiate() {
		try {
			assertTrue(new Fuel(0) instanceof IFuel);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di Fuel");
		}
	}

	@Test
	public void testPositionIstantiate() {
		try {
			assertTrue(new Position(new GeoPosition(0,0)) instanceof IPosition);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di Position");
		}
	}

	@Test
	public void testSpeedIstantiate() {
		try {
			assertTrue(new Speed(0) instanceof ISpeed);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di Speed");
		}
	}

	@Test
	public void testStatusIstantiate() {
		try {
			assertTrue(new Status() instanceof IStatus);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di Status");
		}
	}

	@Test
	public void testNotNullDistance() {
		Distance obj_Distance = new Distance(0);
		assertNotNull("Distance: errore di istanziazione", obj_Distance);
	}

	@Test
	public void testNotNullFuel() {
		Fuel obj_Fuel = new Fuel(0);
		assertNotNull("Fuel: errore di istanziazione", obj_Fuel);
	}

	@Test
	public void testNotNullPosition() {
		Position obj_Position = new Position(new GeoPosition(0.0,0.0));
		assertNotNull("Position: errore di istanziazione", obj_Position);
	}

	@Test
	public void testNotNullSpeed() {
		Speed obj_Speed = new Speed(0);
		assertNotNull("Speed: errore di istanziazione", obj_Speed);
	}

	@Test
	public void testNotNullStatus() {
		Status obj_Status = new Status(null,null,null,null);
		assertNotNull("Status: errore di istanziazione", obj_Status);
	}

	@Test
	public void testDistanceGetterSetter() {
		double value = 80.0f;
		Distance obj_Distance = new Distance(value);
		try {
			assertTrue(obj_Distance.getDistanceAsDouble() == value);
		} catch (Exception e) {
			fail("ERRORE!\nErrore nel setter e getter di Distance");
		}
	}


	@Test
	public void testFuelGetterSetter() {
		double value = 80.0f;
		Fuel obj_Fuel = new Fuel(value);
		try {
			assertTrue(obj_Fuel.getFuelAsDouble() == value);
		} catch (Exception e) {
			fail("ERRORE!\nErrore nel setter e getter di Fuel");
		}
	}


	@Test
	public void testPositionGetterSetter() {
		GeoPosition value = new GeoPosition(80,80);
		Position obj_Position = new Position(value);
		try {
			assertTrue(obj_Position.getPositionAsGeoPosition() == value);
		} catch (Exception e) {
			fail("ERRORE!\nErrore nel setter e getter di Position");
		}
	}


	@Test
	public void testSpeedGetterSetter() {
		double value = 80.0f;
		Speed obj_Speed = new Speed(value);
		try {
			assertTrue(obj_Speed.getSpeedAsDouble() == value);
		} catch (Exception e) {
			fail("ERRORE!\nErrore nel setter e getter di Speed");
		}
	}


	@Test
	public void testCommandIstantiate() {
		try {
			assertTrue(new Command() instanceof IMessage);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di Command");
		}
	}

	@Test
	public void testDecSpeedIstantiate() {
		try {
			assertTrue(DecSpeed.instantiate() instanceof IDecSpeed);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di DecSpeed");
		}
	}

	@Test
	public void testIncSpeedIstantiate() {
		try {
			assertTrue(IncSpeed.instantiate() instanceof IIncSpeed);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di IncSpeed");
		}
	}

	@Test
	public void testSetSpeedIstantiate() {
		try {
			assertTrue(SetSpeed.instantiate("") instanceof ISetSpeed);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di SetSpeed");
		}
	}

	@Test
	public void testStartIstantiate() {
		try {
			assertTrue(Start.instantiate() instanceof IStart);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di Start");
		}
	}

	@Test
	public void testStopIstantiate() {
		try {
			assertTrue(Stop.instantiate() instanceof IStop);
		} catch (Exception e) {
			fail("ERRORE!!\nErrore in test istanza di Stop");
		}
	}

	@Test
	public void testNotNullCommand() {
		Command obj_Command = new Command();
		assertNotNull("Command: errore di istanziazione", obj_Command);
	}

	@Test
	public void testNotNullDecSpeed() {
		DecSpeed obj_DecSpeed = DecSpeed.instantiate();
		assertNotNull("DecSpeed: errore di istanziazione", obj_DecSpeed);
	}

	@Test
	public void testNotNullIncSpeed() {
		IncSpeed obj_IncSpeed = IncSpeed.instantiate();
		assertNotNull("IncSpeed: errore di istanziazione", obj_IncSpeed);
	}

	@Test
	public void testNotNullSetSpeed() {
		SetSpeed obj_SetSpeed = SetSpeed.instantiate("");
		assertNotNull("SetSpeed: errore di istanziazione", obj_SetSpeed);
	}

	@Test
	public void testNotNullStart() {
		Start obj_Start = Start.instantiate();
		assertNotNull("Start: errore di istanziazione", obj_Start);
	}

	@Test
	public void testNotNullStop() {
		Stop obj_Stop = Stop.instantiate();
		assertNotNull("Stop: errore di istanziazione", obj_Stop);
	}
	
	@Test
	public void testRangeAndSerializationSpeed() {
		Speed s;
		double val;

		for (int i = (int) (Globals.MIN_SPEED - 1); i < Globals.MAX_SPEED + 1; i++) {
			s = new Speed(i);
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

	@Test
	public void testRangeAndSerializationDistance() {
		Distance d;

		for (int i =  -1; i < 100; i++) {
			d = new Distance(i);
			assertEquals("Distance not equals", Math.max(0, i), d.getDistanceAsDouble(), 0);
		}
		d = new Distance(0);
		String jsonDistance = d.jsonify();
		assertEquals("Json test", d.getDistanceAsDouble(), d.dejsonify(jsonDistance).getDistanceAsDouble(), 0);
	}

	@Test
	public void testRangeAndSerializationFuel() {
		Fuel f;

		for (int i =  -1; i < 100; i++) {
			f = new Fuel(i);
			assertEquals("Fuel not equals", Math.max(0, i), f.getFuelAsDouble(), 0);
		}
		f = new Fuel(0);
		String jsonFuel = f.jsonify();
		assertEquals("Json test", f.getFuelAsDouble(), f.dejsonify(jsonFuel).getFuelAsDouble(), 0);
	}

	@Test
	public void testRangeAndSerializationPosition() {
		Position p = new Position(new GeoPosition(0, 0));
		assertEquals("Latitude not equals", 0, p.getPositionAsGeoPosition().getLatitude(), 0);
		assertEquals("Longitude not equals", 0, p.getPositionAsGeoPosition().getLongitude(), 0);
		String jsonPosition = p.jsonify();
		assertEquals("Json test 1", p.getPositionAsGeoPosition().getLatitude(), p.dejsonify(jsonPosition).getPositionAsGeoPosition().getLatitude(), 0);
		assertEquals("Json test 1", p.getPositionAsGeoPosition().getLongitude(), p.dejsonify(jsonPosition).getPositionAsGeoPosition().getLongitude(), 0);
	}
}
