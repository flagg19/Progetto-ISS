package it.unibo.contact.SmartDeviceSystem;

import it.unibo.android.SmartDeviceSystem.BaseActivity;
import it.unibo.iss.group2.implementations.measures.Status;

public class SmartGaugeDisplay extends SmartGaugeDisplaySupport {

	BaseActivity ba = null;
	
	public SmartGaugeDisplay(String name, BaseActivity ba) throws Exception {
		super(name);
		this.ba = ba;
	}
	
	public SmartGaugeDisplay(String name) throws Exception {
		super(name);
	}

	@Override
	protected String cleanString(String s) throws Exception {
		String tmp = s.replaceAll("_quote_token_", "\"");
		return tmp.replace("'", "");
	}
	
	public void showMsg( String msg){
 		ba.showMsg(msg);
	}

	@Override
	protected void formatOutput(String jsonString) throws Exception {
		Status status = new Status();
		status = status.dejsonify(jsonString);
		ba.showMsg("Distance: " + status.getDistance().getDistanceAsDouble() + "Km");
		ba.showMsg("Fuel: " + status.getFuel().getFuelAsDouble() + "l");
		ba.showMsg("Position (lat): " + ((org.jdesktop.swingx.mapviewer.GeoPosition)status.getPosition().getPositionAsGeoPosition()).getLatitude());
		ba.showMsg("Position (lon): " + ((org.jdesktop.swingx.mapviewer.GeoPosition)status.getPosition().getPositionAsGeoPosition()).getLongitude());
		ba.showMsg("Speed: " + status.getSpeed().getSpeedAsDouble() + "Km/h");
		ba.showMsg("");
	}
}
