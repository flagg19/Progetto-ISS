package it.unibo.contact.DroneControlDashboardSystem;

public class GaugeDisplay extends GaugeDisplaySupport{

	public GaugeDisplay(String name) throws Exception {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String cleanString(String jsonString) throws Exception {
		return jsonString.replace("'", "");
	}
}
